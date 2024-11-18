package scubatwe.pd7.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.block.ModBlocks;
import scubatwe.pd7.item.ModItems;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output,
                             CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup,
                                                 RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            @Override
            public void generate() {

                /*                  */
                //      Blocks      //
                /*                  */

                /* Small Stone -> Cobblestone */
                this.createShaped(RecipeCategory.MISC, Blocks.COBBLESTONE)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModItems.SMALL_STONE)
                        .criterion(hasItem(ModItems.SMALL_STONE), this.conditionsFromItem(ModItems.SMALL_STONE))
                        .criterion(hasItem(Blocks.COBBLESTONE), this.conditionsFromItem(Blocks.COBBLESTONE))
                        .offerTo(recipeExporter, "small_stone_to_cobblestone");

                /* Small Dirt Pile -> Dirt Block */
                this.createShaped(RecipeCategory.MISC, Blocks.DIRT)
                        .pattern("DD")
                        .pattern("DD")
                        .input('D', ModItems.SMALL_DIRT_PILE)
                        .criterion(hasItem(ModItems.SMALL_DIRT_PILE), this.conditionsFromItem(ModItems.SMALL_DIRT_PILE))
                        .criterion(hasItem(Blocks.DIRT), this.conditionsFromItem(Blocks.DIRT))
                        .offerTo(recipeExporter, "small_dirt_pile_to_dirt");

                /* Small Sand Pile -> Sand Block */
                this.createShaped(RecipeCategory.MISC, Blocks.SAND)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModItems.SMALL_SAND_PILE)
                        .criterion(hasItem(ModItems.SMALL_SAND_PILE), this.conditionsFromItem(ModItems.SMALL_SAND_PILE))
                        .criterion(hasItem(Blocks.SAND), this.conditionsFromItem(Blocks.SAND))
                        .offerTo(recipeExporter, "small_sand_pile_to_sand");

                /*                  */
                //       Ext.       //
                /*                  */

                /* Stick -> Short Sticks */
                this.createShapeless(RecipeCategory.MISC, ModItems.SMALL_STICK, 2)
                        .input(Items.STICK)
                        .criterion(hasItem(Items.STICK), this.conditionsFromItem(Items.STICK))
                        .offerTo(recipeExporter, "stick_to_short_sticks");

                /* Shaved Stick -> Short Shaved Sticks */
                this.createShapeless(RecipeCategory.MISC, ModItems.SMALL_SHAVED_STICK, 2)
                        .input(ModItems.SHAVED_STICK)
                        .criterion(hasItem(ModItems.SHAVED_STICK), this.conditionsFromItem(ModItems.SHAVED_STICK))
                        .criterion(hasItem(ModItems.SMALL_STICK), this.conditionsFromItem(ModItems.SMALL_STICK))
                        .offerTo(recipeExporter, "shaved_stick_to_short_shaved_sticks");

                /*                  */
                //     Resource     //
                /*                  */

                /* Tiny Stone -> Small Stone */
                this.createShaped(RecipeCategory.MISC, ModItems.SMALL_STONE)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModItems.TINY_STONE)
                        .criterion(hasItem(ModItems.TINY_STONE), this.conditionsFromItem(ModItems.TINY_STONE))
                        .criterion(hasItem(ModItems.SMALL_STONE), this.conditionsFromItem(ModItems.SMALL_STONE))
                        .offerTo(recipeExporter, "tiny_stone_to_small_stone");

                /* Tiny Dirt Pile -> Small Dirt Pile */
                this.createShaped(RecipeCategory.MISC, ModItems.SMALL_DIRT_PILE)
                        .pattern("DD")
                        .pattern("DD")
                        .input('D', ModItems.TINY_DIRT_PILE)
                        .criterion(hasItem(ModItems.TINY_DIRT_PILE), this.conditionsFromItem(ModItems.TINY_DIRT_PILE))
                        .criterion(hasItem(ModItems.SMALL_DIRT_PILE), this.conditionsFromItem(ModItems.SMALL_DIRT_PILE))
                        .offerTo(recipeExporter, "tiny_dirt_pile_to_small_dirt_pile");

                /* Tiny Sand Pile -> Small Sand Pile */
                this.createShaped(RecipeCategory.MISC, ModItems.SMALL_SAND_PILE)
                        .pattern("SS")
                        .pattern("SS")
                        .input('S', ModItems.TINY_SAND_PILE)
                        .criterion(hasItem(ModItems.TINY_SAND_PILE), this.conditionsFromItem(ModItems.TINY_SAND_PILE))
                        .criterion(hasItem(ModItems.SMALL_SAND_PILE), this.conditionsFromItem(ModItems.SMALL_SAND_PILE))
                        .offerTo(recipeExporter, "tiny_sand_pile_to_small_sand_pile");

                /* Acacia Wood Chunk -> Acacia Wood Log */
                this.createShaped(RecipeCategory.MISC, Blocks.ACACIA_LOG)
                        .pattern("WW")
                        .pattern("WW")
                        .input('W', ModItems.ACACIA_WOOD_CHUNK)
                        .criterion(hasItem(ModItems.ACACIA_WOOD_CHUNK),
                                this.conditionsFromItem(ModItems.ACACIA_WOOD_CHUNK))
                        .criterion(hasItem(Blocks.ACACIA_LOG),
                                this.conditionsFromItem(Blocks.ACACIA_LOG))
                        .offerTo(recipeExporter, "acacia_wood_chunk_to_acacia_log");

                /* Oak Wood Chunk -> Oak Wood Log */
                this.createShaped(RecipeCategory.MISC, Blocks.OAK_LOG)
                        .pattern("WW")
                        .pattern("WW")
                        .input('W', ModItems.OAK_WOOD_CHUNK)
                        .criterion(hasItem(ModItems.OAK_WOOD_CHUNK),
                                this.conditionsFromItem(ModItems.OAK_WOOD_CHUNK))
                        .criterion(hasItem(Blocks.OAK_LOG),
                                this.conditionsFromItem(Blocks.OAK_LOG))
                        .offerTo(recipeExporter, "oak_wood_chunk_to_oak_log");

                /* Oak Wood Chunk -> Oak Wood Log */
                this.createShaped(RecipeCategory.MISC, Blocks.OAK_PLANKS, 2)
                        .pattern("PP")
                        .pattern("PP")
                        .input('P', ModItems.OAK_WOOD_PLANK)
                        .criterion(hasItem(ModItems.OAK_WOOD_PLANK),
                                this.conditionsFromItem(ModItems.OAK_WOOD_PLANK))
                        .offerTo(recipeExporter, "oak_wood_plank_to_oak_planks");

                /*                  */
                //      Tools       //
                /*                  */

                /* Sandpaper */
                this.createShaped(RecipeCategory.MISC, ModItems.SANDPAPER)
                        .pattern("SP")
                        .pattern("GS")
                        .input('S', ModItems.SMALL_SAND_PILE)
                        .input('P', Items.PAPER)
                        .input('G', ModItems.SENEGAL_GUM)
                        .criterion(hasItem(ModItems.SMALL_SAND_PILE), this.conditionsFromItem(ModItems.SMALL_SAND_PILE))
                        .criterion(hasItem(Items.PAPER), this.conditionsFromItem(Items.PAPER))
                        .criterion(hasItem(ModItems.SENEGAL_GUM), this.conditionsFromItem(ModItems.SENEGAL_GUM))
                        .offerTo(recipeExporter, "sandpaper");

                /* Tool Handle */
                this.createShaped(RecipeCategory.MISC, ModItems.TOOL_HANDLE)
                        .pattern("OS")
                        .pattern("#L")
                        .input('S', ModItems.SANDPAPER)
                        .input('O', ModItems.LINSEED_OIL)
                        .input('#', ModItems.SHAVED_STICK)
                        .input('L', Items.LEATHER)
                        .criterion(hasItem(ModItems.SANDPAPER), this.conditionsFromItem(ModItems.SANDPAPER))
                        .criterion(hasItem(ModItems.LINSEED_OIL), this.conditionsFromItem(ModItems.LINSEED_OIL))
                        .criterion(hasItem(ModItems.SHAVED_STICK), this.conditionsFromItem(ModItems.SHAVED_STICK))
                        .criterion(hasItem(Items.LEATHER), this.conditionsFromItem(Items.LEATHER))
                        .offerTo(recipeExporter, "tool_handle");

                /* Flint Knife */
                this.createShaped(RecipeCategory.MISC, ModItems.FLINT_KNIFE)
                        .pattern(" F")
                        .pattern("S#")
                        .input('F', ModItems.SHARPENED_FLINT)
                        .input('S', ModItems.SMALL_STICK)
                        .input('#', Items.STRING)
                        .criterion(hasItem(Items.FLINT), this.conditionsFromItem(Items.FLINT))
                        .offerTo(recipeExporter, "flint_knife");

                /* Flint Pickaxe */
                this.createShaped(RecipeCategory.MISC, ModItems.FLINT_PICKAXE)
                        .pattern("F#")
                        .pattern("SF")
                        .input('F', ModItems.SHARPENED_FLINT)
                        .input('S', Items.STICK)
                        .input('#', Items.STRING)
                        .criterion(hasItem(Items.FLINT), this.conditionsFromItem(Items.FLINT))
                        .offerTo(recipeExporter, "flint_pickaxe");

                /* Flint Saw */
                this.createShaped(RecipeCategory.MISC, ModItems.FLINT_SAW)
                        .pattern("FF")
                        .pattern("S#")
                        .input('F', ModItems.SHARPENED_FLINT)
                        .input('S', Items.STICK)
                        .input('#', Items.STRING)
                        .criterion(hasItem(Items.FLINT), this.conditionsFromItem(Items.FLINT))
                        .offerTo(recipeExporter, "flint_saw");

                /* Wooden Mortar & Pestle */
                this.createShapeless(RecipeCategory.MISC, ModItems.WOODEN_MORTAR_PESTLE)
                        .input(ModItems.WOODEN_MORTAR)
                        .input(ModItems.WOODEN_PESTLE)
                        .criterion(hasItem(ModItems.WOODEN_MORTAR), this.conditionsFromItem(ModItems.WOODEN_MORTAR))
                        .criterion(hasItem(ModItems.WOODEN_PESTLE), this.conditionsFromItem(ModItems.WOODEN_PESTLE))
                        .offerTo(recipeExporter, "mortar_pestle_to_mortar_and_pestle");

                /* Wooden Mallet */
                this.createShapeless(RecipeCategory.MISC, ModItems.WOODEN_MALLET)
                        .input(ModItems.SHAVED_STICK)
                        .input(ModItems.WOODEN_MALLET_HEAD)
                        .criterion(hasItem(ModItems.SHAVED_STICK), this.conditionsFromItem(ModItems.SHAVED_STICK))
                        .offerTo(recipeExporter, "shaved_stick_and_head_to_wooden_mallet");
            }
        };
    }

    @Override
    public String getName() {
        return "ProjectDim7 Base Recipes";
    }
}
