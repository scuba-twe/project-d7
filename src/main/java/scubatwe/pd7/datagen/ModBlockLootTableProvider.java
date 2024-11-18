package scubatwe.pd7.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import scubatwe.pd7.block.ModBlocks;
import scubatwe.pd7.item.ModItems;
import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(Blocks.STONE,
                multipleBlockDrops(Blocks.STONE, ModItems.SMALL_STONE, 1, 3));

        addDrop(Blocks.GRASS_BLOCK,
                multipleBlockDrops(Blocks.DIRT, ModItems.SMALL_DIRT_PILE, 1, 3));
        addDrop(Blocks.DIRT,
                multipleBlockDrops(Blocks.DIRT, ModItems.SMALL_DIRT_PILE, 1, 3));

        addDrop(Blocks.SAND,
                multipleBlockDrops(Blocks.SAND, ModItems.SMALL_SAND_PILE, 1, 3));

        addDrop(Blocks.OAK_LOG,
                multipleBlockDrops(Blocks.OAK_LOG, ModItems.OAK_WOOD_CHUNK, 1, 3));
        addDrop(Blocks.ACACIA_LOG,
                logBlockDrops(Blocks.ACACIA_LOG, ModItems.ACACIA_WOOD_CHUNK, 1, 3,
                        ModItems.ACACIA_WOOD_CHUNK_GUMMED));

        addDrop(ModBlocks.FLAX_PLANT,
                flowerBlockDrops(ModBlocks.FLAX_PLANT, ModItems.FLAX_BUNDLE, ModItems.FLAX_FLOWER));
    }

    public LootTable.Builder nullifyDrops() {
        return dropsNothing();
    }

    public LootTable.Builder flowerBlockDrops(Block block, Item product, Item flower) {
        return this.dropsWithShears
                        (block, ((LeafEntry.Builder<?>) this.applyExplosionDecay(block, ItemEntry.builder(product)))
                                .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                                .conditionally(RandomChanceLootCondition.builder(0.65F)))
                .pool(LootPool.builder()
                        .with(ItemEntry.builder(flower)
                                .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                                .conditionally(RandomChanceLootCondition.builder(0.25F))));
    }

    public LootTable.Builder logBlockDrops(Block block, Item product, float minDrops, float maxDrops, Item drop) {
        return this.dropsWithSilkTouch
                (block, ((LeafEntry.Builder<?>) this.applyExplosionDecay(block, ItemEntry.builder(product)))
                        .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .pool(LootPool.builder()
                        .with(ItemEntry.builder(drop)
                                .conditionally(this.createWithoutShearsOrSilkTouchCondition())
                                .conditionally(RandomChanceLootCondition.builder(0.30F))));
    }

    public LootTable.Builder multipleBlockDrops(Block block, Item item, float minDrops, float maxDrops) {
        return this.dropsWithSilkTouch
                (block, this.applyExplosionDecay(block, ItemEntry.builder(item))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))));
    }

    public LootTable.Builder multipleOreDrops(Block block, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch
                (block, ((LeafEntry.Builder<?>) this.applyExplosionDecay(block, ItemEntry.builder(item))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                        .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE))));
    }
}
