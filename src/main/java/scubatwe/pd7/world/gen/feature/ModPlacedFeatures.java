package scubatwe.pd7.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import scubatwe.pd7.Projectd7;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature>
            FLAX_PLANT_PLACED_KEY = registryKey("flax_plant_placed");
    public static final RegistryKey<PlacedFeature>
            FLAX_PLANT_PATCH_PLACED_KEY = registryKey("flax_plant_patch_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, FLAX_PLANT_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FLAX_PLANT_KEY), List.of(
                        BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));

        register(context, FLAX_PLANT_PATCH_PLACED_KEY, configuredFeatureRegistryEntryLookup
                .getOrThrow(ModConfiguredFeatures.FLAX_PLANT_PATCH_KEY), List.of(
                        RarityFilterPlacementModifier.of(64),
                        SquarePlacementModifier.of(),
                        PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                        BiomePlacementModifier.of()));
    }

    public static RegistryKey<PlacedFeature> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Projectd7.MOD_ID, name));
    }

    public static void register(Registerable<PlacedFeature> featureRegisterable,
                                RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> feature,
                                List<PlacementModifier> modifiers) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }

    public static void register(Registerable<PlacedFeature> featureRegisterable,
                                RegistryKey<PlacedFeature> key,
                                RegistryEntry<ConfiguredFeature<?, ?>> feature,
                                PlacementModifier... modifiers) {
        register(featureRegisterable, key, feature, List.of(modifiers));
    }
}
