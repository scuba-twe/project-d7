package scubatwe.pd7.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.block.ModBlocks;
import scubatwe.pd7.item.ModEquipmentModels;
import scubatwe.pd7.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    /*                  */
    //   Block Models   //
    /*                  */

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        /*                  */
        //     Building     //
        /*                  */



        /*                  */
        //    Functional    //
        /*                  */



        /*                  */
        //    Generation    //
        /*                  */



        /*                  */
        //     Resource     //
        /*                  */

        /* Flowers */
        blockStateModelGenerator.registerTintableCross
                (ModBlocks.FLAX_PLANT, BlockStateModelGenerator.TintType.TINTED);

        /* Ore */


    }

    /*                  */
    //    Item Models   //
    /*                  */

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        /*                  */
        //      Armor       //
        /*                  */

        // Dim Data
        itemModelGenerator.registerArmor(ModItems.COPPER_BOOTS,
                ModEquipmentModels.COPPER,
                generateEquipmentModel("copper"),
                EquipmentSlot.FEET);
        itemModelGenerator.registerArmor(ModItems.COPPER_LEGGINGS,
                ModEquipmentModels.COPPER,
                generateEquipmentModel("copper"),
                EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.COPPER_CHESTPLATE,
                ModEquipmentModels.COPPER,
                generateEquipmentModel("copper"),
                EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.COPPER_HELMET,
                ModEquipmentModels.COPPER,
                generateEquipmentModel("copper"),
                EquipmentSlot.HEAD);

        /*                  */
        //    Containers    //
        /*                  */

        itemModelGenerator.register(ModItems.CLAY_BOWL, Models.GENERATED);

        /*                  */
        //       Ext.       //
        /*                  */

        itemModelGenerator.register(ModItems.DIM_DATA, Models.GENERATED);
        itemModelGenerator.register(ModItems.LINSEED_OIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.SANDPAPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SENEGAL_GUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHARPENED_FLINT, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMALL_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SHAVED_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SMALL_SHAVED_STICK, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SMALL_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMALL_DIRT_PILE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SMALL_SAND_PILE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TINY_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TINY_DIRT_PILE, Models.GENERATED);
        itemModelGenerator.register(ModItems.TINY_SAND_PILE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACACIA_WOOD_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ACACIA_WOOD_CHUNK_GUMMED, Models.GENERATED);
        itemModelGenerator.register(ModItems.OAK_WOOD_CHUNK, Models.GENERATED);
        itemModelGenerator.register(ModItems.OAK_WOOD_PLANK, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOOD_SCRAPS, Models.GENERATED);

        /*                  */
        //      Flowers     //
        /*                  */

        itemModelGenerator.register(ModItems.FLAX_FLOWER, Models.GENERATED);

        /*                  */
        //       Food       //
        /*                  */

        itemModelGenerator.register(ModItems.FISH_FILET, Models.GENERATED);

        /*                  */
        //     Resource     //
        /*                  */

        itemModelGenerator.register(ModItems.FLAX_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLAX_BUNDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLAX_STALKS, Models.GENERATED);

        /*                  */
        //      Tools       //
        /*                  */

        /* Copper */
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);

        /* Flint */
        itemModelGenerator.register(ModItems.FLINT_KNIFE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLINT_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.FLINT_SAW, Models.HANDHELD);

        /* Wood */
        itemModelGenerator.register(ModItems.WOODEN_MALLET, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WOODEN_MORTAR_PESTLE, Models.GENERATED);

        /*                  */
        //    Tool Parts    //
        /*                  */

        itemModelGenerator.register(ModItems.TOOL_HANDLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WOODEN_MORTAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.WOODEN_PESTLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WOODEN_MALLET_HEAD, Models.HANDHELD);


    }

    public EquipmentModel generateEquipmentModel(String name) {
        return EquipmentModel.builder()
                .addHumanoidLayers(Identifier.of(Projectd7.MOD_ID, name), false)
                .build();
    }
}
