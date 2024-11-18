package scubatwe.pd7.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.block.ModBlocks;
import scubatwe.pd7.item.ModItems;
import scubatwe.pd7.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        /* Armor */
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.COPPER_BOOTS)
                .add(ModItems.COPPER_LEGGINGS)
                .add(ModItems.COPPER_CHESTPLATE)
                .add(ModItems.COPPER_HELMET);

        /* Containers */
        getOrCreateTagBuilder(ModTags.Items.MORTAR_PESTLE_CONTAINERS)
                .add(ModItems.CLAY_BOWL);

        /* Items */
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.FLAX_PLANT.asItem());

        getOrCreateTagBuilder(ModTags.Items.FORAGEABLES)
                .add(ModItems.SMALL_DIRT_PILE);

        getOrCreateTagBuilder(ModTags.Items.HANDCRAFTABLES)
                .add(ModItems.SMALL_STONE)
                .addTag(TagKey.of(RegistryKeys.ITEM, Identifier.of(Projectd7.MOD_ID, "knives")))
                .addTag(TagKey.of(RegistryKeys.ITEM, Identifier.of(Projectd7.MOD_ID, "hammers")))
                .addTag(TagKey.of(RegistryKeys.ITEM, Identifier.of(Projectd7.MOD_ID, "mortar_pestles")))
                .addTag(TagKey.of(RegistryKeys.ITEM, Identifier.of(Projectd7.MOD_ID, "saws")));

        getOrCreateTagBuilder(ModTags.Items.PRESSABLES)
                .add(ModItems.FLAX_SEEDS);

        /* Repair */
        getOrCreateTagBuilder(ModTags.Items.FLINT_TOOL_MATERIALS)
                .add(Items.FLINT);

        getOrCreateTagBuilder(ModTags.Items.COPPER_TOOL_MATERIALS)
                .add(Items.COPPER_INGOT);

        /* Resource */
        getOrCreateTagBuilder(ModTags.Items.WOOD_CHUNKS)
                .add(ModItems.OAK_WOOD_CHUNK)
                .add(ModItems.ACACIA_WOOD_CHUNK);

        /* Tools */
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.COPPER_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.COPPER_HOE);

        getOrCreateTagBuilder(ModTags.Items.KNIVES)
                .add(ModItems.COPPER_KNIFE)
                .add(ModItems.FLINT_KNIFE);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE)
                .add(ModItems.FLINT_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD);

        /* Tools Ext. */
        getOrCreateTagBuilder(ModTags.Items.HAMMERS)
                .add(ModItems.COPPER_HAMMER);

        getOrCreateTagBuilder(ModTags.Items.MALLETS)
                .add(ModItems.WOODEN_MALLET);

        getOrCreateTagBuilder(ModTags.Items.MORTAR_PESTLES)
                .add(ModItems.WOODEN_MORTAR_PESTLE);

        getOrCreateTagBuilder(ModTags.Items.SAWS)
                .add(ModItems.FLINT_SAW);

        /* Types */
        getOrCreateTagBuilder(ModTags.Items.DIRT_TYPE)
                .add(ModItems.SMALL_DIRT_PILE);
    }
}
