package scubatwe.pd7.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.context.LootWorldContext;
import net.minecraft.recipe.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.component.InsideItemStorageComponent;
import scubatwe.pd7.component.ModDataComponentTypes;
import scubatwe.pd7.recipe.handcrafting.HandcraftingRecipeInput;
import scubatwe.pd7.recipe.handcrafting.HandcraftingRecipe;
import scubatwe.pd7.recipe.ModRecipeType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HandcraftUsageEvent {
    private final List<RecipeEntry<HandcraftingRecipe>> matchingRecipes = new ArrayList<>();
    private final List<ItemStack> byproducts = new ArrayList<>();
    private RecipeEntry<HandcraftingRecipe> currentRecipe = null;
    private RegistryEntry<Item> saved = null;
    private int index = 0;

    public ActionResult craft(World world, PlayerEntity player) {
        ItemStack main = player.getMainHandStack();
        ItemStack off = player.getOffHandStack();
        if (main.isIn(TagKey.of(RegistryKeys.ITEM,
                Identifier.of(Projectd7.MOD_ID, "handcraftables")))) {
            ItemStack recipe = this.determineRecipe((ServerWorld) world, player, main, off);
            if (currentRecipe != null) {
                if (recipe != ItemStack.EMPTY
                        && recipe.isItemEnabled(world.getEnabledFeatures())){
                    off.decrement(1);
                    if (!off.isEmpty()) { player.giveOrDropStack(recipe); }
                    else player.setStackInHand(Hand.valueOf("OFF_HAND"), recipe);
                    if (!byproducts.isEmpty()) {
                        for (ItemStack byproduct : byproducts) { player.giveOrDropStack(byproduct); }
                    }
                    return ActionResult.SUCCESS_SERVER;
                } else return null;
            } else return null;
        } else if (main.isIn(TagKey.of(RegistryKeys.ITEM,
                Identifier.of(Projectd7.MOD_ID, "forageables")))) {
            for (ItemStack itemStack : getForageLoot((ServerWorld) world, player, main)) {
                player.giveOrDropStack(itemStack);
                main.decrement(1);
            }
            return ActionResult.SUCCESS_SERVER;
        } else return null;
    }

    public ActionResult changeRecipe(PlayerEntity player) {
        if (player.getOffHandStack().getRegistryEntry() != this.saved) {
            matchingRecipes.clear();
            return null;
        } else {
            if (this.matchingRecipes.size() <= 1 && this.currentRecipe != null) {
                player.sendMessage(Text.literal("1 or less recipes!"), false);
                this.currentRecipe = this.matchingRecipes.getFirst();
                this.index = 0;
                return ActionResult.PASS;
            } else if (this.matchingRecipes.size() > 1 && this.currentRecipe != null) {
                if (this.index >= 0 && this.index + 1 < this.matchingRecipes.size()) { this.index = index + 1; }
                else { this.index = 0; }
                this.currentRecipe = this.matchingRecipes.get(index);
                player.sendMessage(Text.literal("New recipe: " + currentRecipe), false);
                return ActionResult.PASS;
            } else {
                return null;
            }
        }
    }

    private ItemStack determineRecipe(ServerWorld world, PlayerEntity player, ItemStack main, ItemStack off) {
        HandcraftingRecipeInput input = HandcraftingRecipeInput.EMPTY;
        if (!world.isClient()) {
            if (main.isIn(TagKey.of(RegistryKeys.ITEM,
                    Identifier.of(Projectd7.MOD_ID, "mortar_pestles")))
                    && main.contains(ModDataComponentTypes.TOOL_STORAGE)) {
                InsideItemStorageComponent insideItemStorageComponent = main.get(ModDataComponentTypes.TOOL_STORAGE);
                if (insideItemStorageComponent == null || insideItemStorageComponent.getStacks().isEmpty()) {
                    return ItemStack.EMPTY;
                } else {
                    if (off.isIn(TagKey.of(RegistryKeys.ITEM,
                            Identifier.of(Projectd7.MOD_ID, "mortar_pestle_containers")))) {
                        InsideItemStorageComponent.Builder builder = new InsideItemStorageComponent.Builder(insideItemStorageComponent);
                        input = HandcraftingRecipeInput.create(insideItemStorageComponent.getStacks(), off);
                        main.set(ModDataComponentTypes.TOOL_STORAGE, builder.clear().build());
                    }
                }
            } else input = HandcraftingRecipeInput.create(off, main);
            player.sendMessage(Text.literal("Key: " + off.getRegistryEntry()), false);
            if (matchingRecipes.isEmpty() && this.saved == null
                    || this.saved != off.getRegistryEntry()) {
                this.matchingRecipes.clear();
                this.saved = off.getRegistryEntry();
                for (RecipeEntry<HandcraftingRecipe> entry : getHandcraftingRecipes(world)) {
                    if (entry.value().matches(input, world)) {
                        matchingRecipes.add(entry);
                        player.sendMessage(Text.literal("Got match!"), false);
                        player.sendMessage(Text.literal("Size: " + matchingRecipes.size()), false);
                    }
                }
                player.sendMessage(Text.literal("Recipes set up!"), false);
                return ItemStack.EMPTY;
            }
            if (!matchingRecipes.isEmpty()) { this.currentRecipe = matchingRecipes.get(index); }
            else { this.currentRecipe = null; }
            player.sendMessage(Text.literal("Current recipe: " + currentRecipe), false);
            Optional<RecipeEntry<HandcraftingRecipe>> optional = world.getRecipeManager()
                            .getFirstMatch(ModRecipeType.HANDCRAFTING, input, world, currentRecipe);
            if (optional.isPresent()) {
                RecipeEntry<HandcraftingRecipe> entry = optional.get();
                HandcraftingRecipe recipe = entry.value();
                //this.matchingRecipes.clear();
                this.byproducts.addAll(recipe.byproduce(input, world.getRegistryManager()));
                player.sendMessage(Text.literal("Byproducts: " + this.byproducts), false);
                return recipe.craft(input, world.getRegistryManager());
            } else return ItemStack.EMPTY;
        } else return ItemStack.EMPTY;
    }

    private static List<RecipeEntry<HandcraftingRecipe>> getHandcraftingRecipes(ServerWorld server) {
            return PreparedRecipes.of(server.getRecipeManager()
                    .values()).getAll(ModRecipeType.HANDCRAFTING).stream().toList();
    }

    private static List<ItemStack> getForageLoot(ServerWorld world, PlayerEntity player, ItemStack hand) {
        List<TagKey<Item>> tags = hand.streamTags().toList();
        LootWorldContext lootWorldContext = (new LootWorldContext.Builder(world))
                .add(LootContextParameters.ORIGIN, player.getPos())
                .add(LootContextParameters.TOOL, hand)
                .add(LootContextParameters.THIS_ENTITY, player)
                .luck(player.getLuck())
                .build(LootContextTypes.FISHING);
        LootTable lootTable = null;
        for (TagKey<Item> tag : tags) {
            lootTable = world.getServer().getReloadableRegistries()
                    .getLootTable(RegistryKey.of(RegistryKeys.LOOT_TABLE,
                            Identifier.of(Projectd7.MOD_ID, "byproduct/" + tag.id().getPath() + "_result")));
        }
        if (lootTable != null) { return lootTable.generateLoot(lootWorldContext); }
        else { return List.of(); }
    }
}


