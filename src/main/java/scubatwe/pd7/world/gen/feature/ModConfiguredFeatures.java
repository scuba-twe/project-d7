package scubatwe.pd7.world.gen.feature;

import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.block.ModBlocks;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>>
            FLAX_PLANT_KEY = registryKey("flax_plant");
    public static final RegistryKey<ConfiguredFeature<?, ?>>
            FLAX_PLANT_PATCH_KEY = registryKey("flax_plant_patch");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);

        register(context, FLAX_PLANT_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(ModBlocks.FLAX_PLANT)));

        register(context, FLAX_PLANT_PATCH_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(64, 10, 4,
                placedFeatureRegistryEntryLookup.getOrThrow(ModPlacedFeatures.FLAX_PLANT_PLACED_KEY)));
    }

    private static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Projectd7.MOD_ID, name));
    }

    public static void register(Registerable<ConfiguredFeature<?, ?>> context,
                                RegistryKey<ConfiguredFeature<?, ?>> key,
                                Feature<DefaultFeatureConfig> feature) {
        register(context, key, feature, FeatureConfig.DEFAULT);
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void
    register(Registerable<ConfiguredFeature<?, ?>> context,
             RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }

    public static void registerConfiguredFeatures() {
        Projectd7.LOGGER.info("Registering configured features for " + Projectd7.MOD_ID);
    }
}
