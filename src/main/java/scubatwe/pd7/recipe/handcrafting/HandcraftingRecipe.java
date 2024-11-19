package scubatwe.pd7.recipe.handcrafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.recipe.ModRecipe;
import scubatwe.pd7.recipe.ModRecipeBookCategory;
import scubatwe.pd7.recipe.ModRecipeSerializer;
import scubatwe.pd7.recipe.ModRecipeType;

import java.util.ArrayList;
import java.util.List;

// FIX PACKET ISSUE
public class HandcraftingRecipe implements ModRecipe<HandcraftingRecipeInput> {
    final String group;
    final List<Ingredient> ingredients;
    final List<ItemStack> byproducts;
    final ItemStack result;
    @Nullable
    private IngredientPlacement ingredientPlacement;

    public HandcraftingRecipe(String group, List<Ingredient> ingredients,
                              List<ItemStack> byproducts, ItemStack result) {
        this.group = group;
        this.ingredients = ingredients;
        this.byproducts = byproducts;
        this.result = result;
    }

    public boolean matches(HandcraftingRecipeInput input, World world) {
        if (input.getCount() != this.ingredients.size()) {
            return false;
        } else {
            return input.size() == 1 && this.ingredients.size()
                    == 1 ? this.ingredients.getFirst().test(input.getStackInSlot(0))
                    : input.getRecipeMatcher().isCraftable(this, null);
        }
    }

    public RecipeType<HandcraftingRecipe> getType() {
        return ModRecipeType.HANDCRAFTING;
    }

    public RecipeSerializer<HandcraftingRecipe> getSerializer() {
        return ModRecipeSerializer.HANDCRAFTING;
    }

    public RecipeBookCategory getRecipeBookCategory() {
        return ModRecipeBookCategory.HANDCRAFTING;
    }

    public String getGroup() {
        return this.group;
    }

    public ItemStack craft(HandcraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        return this.result.copy();
    }

    public List<ItemStack> byproduce(HandcraftingRecipeInput input, RegistryWrapper.WrapperLookup registries) {
        Projectd7.LOGGER.info("Byproducts debug:  {}", this.byproducts);
        return new ArrayList<>(this.byproducts);
    }

    public IngredientPlacement getIngredientPlacement() {
        if (this.ingredientPlacement == null) {
            this.ingredientPlacement = IngredientPlacement.forShapeless(this.ingredients);
        }
        return this.ingredientPlacement;
    }

    @FunctionalInterface
    public interface RecipeFactory<T extends HandcraftingRecipe> {
        T create(String group, List<Ingredient> ingredients, List<ItemStack> byproducts, ItemStack result);
    }

    public static class Serializer<T extends HandcraftingRecipe> implements RecipeSerializer<T> {
        private final MapCodec<T> codec;
        private final PacketCodec<RegistryByteBuf, T> packetCodec;

        public Serializer(HandcraftingRecipe.RecipeFactory<T> recipeFactory) {
            this.codec = RecordCodecBuilder.mapCodec(
                    instance -> instance.group(
                            Codec.STRING.optionalFieldOf("group", "")
                                    .forGetter((recipe) -> recipe.group),
                            Ingredient.CODEC.listOf(1, 9).fieldOf("ingredients")
                                    .forGetter((recipe) -> recipe.ingredients),
                            ItemStack.VALIDATED_CODEC.listOf(0, 16).fieldOf("byproducts")
                                    .forGetter((recipe) -> recipe.byproducts),
                            ItemStack.VALIDATED_CODEC.fieldOf("result")
                                    .forGetter((recipe) -> recipe.result)
                    ).apply(instance, recipeFactory::create)
            );
            this.packetCodec = PacketCodec.tuple(
                    PacketCodecs.STRING, (recipe) -> recipe.group,
                    Ingredient.PACKET_CODEC.collect(PacketCodecs.toList()), (recipe) -> recipe.ingredients,
                    ItemStack.PACKET_CODEC.collect(PacketCodecs.toList()), (recipe) -> recipe.byproducts,
                    ItemStack.PACKET_CODEC, (recipe) -> recipe.result,
                    recipeFactory::create
            );
        }

        @Override
        public MapCodec<T> codec() {
            return this.codec;
        }

        @Override
        public PacketCodec<RegistryByteBuf, T> packetCodec() {
            return this.packetCodec;
        }
    }
}
