package scubatwe.pd7;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import scubatwe.pd7.datagen.*;
import scubatwe.pd7.datagen.recipe.HandcraftRecipeProvider;
import scubatwe.pd7.world.gen.feature.ModConfiguredFeatures;
import scubatwe.pd7.world.gen.feature.ModPlacedFeatures;

public class Projectd7DataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModItemTagProvider::new);

		pack.addProvider(ModBlockLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);

		pack.addProvider(ModWorldGenProvider::new);

		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(HandcraftRecipeProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::boostrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
