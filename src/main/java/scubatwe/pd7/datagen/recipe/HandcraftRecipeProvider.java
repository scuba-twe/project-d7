package scubatwe.pd7.datagen.recipe;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.datagen.recipe.builder.gen.HandcraftRecipeGenerator;
import scubatwe.pd7.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class HandcraftRecipeProvider extends FabricRecipeProvider {
    public HandcraftRecipeProvider(FabricDataOutput output,
                                   CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup,
                                                 RecipeExporter recipeExporter) {
        return new HandcraftRecipeGenerator(wrapperLookup, recipeExporter) {

            @Override
            public void generate() {

                /* Flax Seeds -> Linseed Oil */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.LINSEED_OIL, 1)
                        .group("mortar_pestles")
                        .input(ModItems.FLAX_SEEDS, 4)
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "mortar_pestle_containers")))
                        .criterion(hasItem(ModItems.FLAX_SEEDS), this.conditionsFromItem(ModItems.FLAX_SEEDS))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                        Identifier.of(Projectd7.MOD_ID, "flax_seeds_to_linseed_oil")));

                /* Flint -> Sharpened Flint */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.SHARPENED_FLINT, 1)
                        .group("handcraftables")
                        .input(Items.FLINT)
                        .input(ModItems.SMALL_STONE)
                        .criterion(hasItem(Items.FLINT), this.conditionsFromItem(Items.FLINT))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(Projectd7.MOD_ID, "flint_to_sharpened_flint")));

                /* Flax Bundle -> Flax Stalks */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.FLAX_STALKS, 1)
                        .group("knives")
                        .input(ModItems.FLAX_BUNDLE)
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "knives")))
                        .byproduct(ModItems.FLAX_SEEDS, 2)
                        .criterion(hasItem(ModItems.FLAX_BUNDLE), this.conditionsFromItem(ModItems.FLAX_BUNDLE))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(Projectd7.MOD_ID, "flax_bundle_to_flax_stalks")));

                /* Stick -> Shaved Stick */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.SHAVED_STICK, 1)
                        .group("knives")
                        .input(Items.STICK)
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "knives")))
                        .byproduct(ModItems.WOOD_SCRAPS, 2)
                        .criterion(hasItem(Items.STICK), this.conditionsFromItem(Items.STICK))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(Projectd7.MOD_ID, "stick_to_shaved_stick")));

                /* Small Stick -> Small Shaved Stick */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.SMALL_SHAVED_STICK, 1)
                        .group("knives")
                        .input(ModItems.SMALL_STICK)
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "knives")))
                        .byproduct(ModItems.WOOD_SCRAPS, 1)
                        .criterion(hasItem(ModItems.SMALL_STICK), this.conditionsFromItem(ModItems.SMALL_STICK))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(Projectd7.MOD_ID, "small_stick_to_small_shaved_stick")));

                /* Small Stick -> Wooden Pestle */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.WOODEN_PESTLE, 1)
                        .group("knives")
                        .input(ModItems.SMALL_STICK)
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "knives")))
                        .byproduct(ModItems.WOOD_SCRAPS, 1)
                        .criterion(hasItem(ModItems.SMALL_STICK), this.conditionsFromItem(ModItems.SMALL_STICK))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(Projectd7.MOD_ID, "small_stick_to_wooden_pestle")));

                /* Wood Chunk -> Wooden Mortar */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.WOODEN_MORTAR, 1)
                        .group("knives")
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "wood_chunks")))
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "knives")))
                        .byproduct(ModItems.WOOD_SCRAPS, 2)
                        .criterion(hasItem(ModItems.OAK_WOOD_CHUNK),
                                this.conditionsFromItem(ModItems.OAK_WOOD_CHUNK))
                        .criterion(hasItem(ModItems.ACACIA_WOOD_CHUNK),
                                this.conditionsFromItem(ModItems.ACACIA_WOOD_CHUNK))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(Projectd7.MOD_ID, "wood_chunk_to_wooden_mortar")));

                /* Wood Chunk -> Wooden Mallet Head */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.WOODEN_MALLET_HEAD, 1)
                        .group("knives")
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "wood_chunks")))
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "knives")))
                        .byproduct(ModItems.WOOD_SCRAPS, 2)
                        .criterion(hasItem(ModItems.OAK_WOOD_CHUNK),
                                this.conditionsFromItem(ModItems.OAK_WOOD_CHUNK))
                        .criterion(hasItem(ModItems.ACACIA_WOOD_CHUNK),
                                this.conditionsFromItem(ModItems.ACACIA_WOOD_CHUNK))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(Projectd7.MOD_ID, "wood_chunk_to_wooden_mallet_head")));

                /* Acacia Wood Chunk Gummed -> Acacia Wood Chunk & Senegal Gum */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.SENEGAL_GUM, 1)
                        .group("knives")
                        .input(ModItems.ACACIA_WOOD_CHUNK_GUMMED)
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "knives")))
                        .byproduct(ModItems.ACACIA_WOOD_CHUNK, 1)
                        .criterion(hasItem(ModItems.ACACIA_WOOD_CHUNK_GUMMED),
                                this.conditionsFromItem(ModItems.ACACIA_WOOD_CHUNK_GUMMED))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(Projectd7.MOD_ID, "acacia_wood_chunk_gummed_extract")));

                /* Oak Wood Chunk -> Oak Wood Plank */
                this.createHandcraftRecipe(RecipeCategory.MISC, ModItems.OAK_WOOD_PLANK, 4)
                        .group("saws")
                        .input(ModItems.OAK_WOOD_CHUNK)
                        .input(TagKey.of(RegistryKeys.ITEM,
                                Identifier.of(Projectd7.MOD_ID, "saws")))
                        .byproduct(ModItems.WOOD_SCRAPS, 2)
                        .criterion(hasItem(ModItems.OAK_WOOD_CHUNK),
                                this.conditionsFromItem(ModItems.OAK_WOOD_CHUNK))
                        .offerTo(recipeExporter, RegistryKey.of(RegistryKeys.RECIPE,
                                Identifier.of(Projectd7.MOD_ID, "oak_chunk_to_oak_planks")));
            }
        };
    }

    @Override
    public String getName() {
        return "ProjectDim7 Handcraft Recipes";
    }
}
