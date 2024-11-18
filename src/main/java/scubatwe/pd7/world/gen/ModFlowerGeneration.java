package scubatwe.pd7.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import scubatwe.pd7.world.gen.feature.ModPlacedFeatures;

public class ModFlowerGeneration {
    public static void generateFlowers() {

        /* Flax Plant */
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FLAX_PLANT_PATCH_PLACED_KEY);
    }
}
