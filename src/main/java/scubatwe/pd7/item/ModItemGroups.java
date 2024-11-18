package scubatwe.pd7.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.block.ModBlocks;

public class ModItemGroups {

    /*                  */
    //      Blocks      //
    /*                  */

    public static final ItemGroup PD7_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Projectd7.MOD_ID, "pd7_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.FLAX_PLANT))
                    .displayName(Text.translatable("itemgroup.pd7.pd7_blocks"))
                    .entries((displayContext, entries) -> {

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
                        entries.add(ModBlocks.FLAX_PLANT);

                        /* Ore */


                    }).build());

    /*                  */
    //      Items       //
    /*                  */

    public static final ItemGroup PD7_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Projectd7.MOD_ID, "pd7_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.DIM_DATA))
                    .displayName(Text.translatable("itemgroup.pd7.pd7_items"))
                    .entries((displayContext, entries) -> {

                        /*                  */
                        //       Armor      //
                        /*                  */

                        /* Copper */
                        entries.add(ModItems.COPPER_BOOTS);
                        entries.add(ModItems.COPPER_LEGGINGS);
                        entries.add(ModItems.COPPER_CHESTPLATE);
                        entries.add(ModItems.COPPER_HELMET);

                        /*                  */
                        //    Containers    //
                        /*                  */

                        entries.add(ModItems.CLAY_BOWL);

                        /*                  */
                        //       Ext.       //
                        /*                  */

                        entries.add(ModItems.DIM_DATA);
                        entries.add(ModItems.LINSEED_OIL);
                        entries.add(ModItems.SANDPAPER);
                        entries.add(ModItems.SENEGAL_GUM);
                        entries.add(ModItems.SHARPENED_FLINT);
                        entries.add(ModItems.SMALL_STICK);
                        entries.add(ModItems.SHAVED_STICK);
                        entries.add(ModItems.SMALL_SHAVED_STICK);
                        entries.add(ModItems.SMALL_STONE);
                        entries.add(ModItems.SMALL_DIRT_PILE);
                        entries.add(ModItems.SMALL_SAND_PILE);
                        entries.add(ModItems.TINY_STONE);
                        entries.add(ModItems.TINY_DIRT_PILE);
                        entries.add(ModItems.TINY_SAND_PILE);
                        entries.add(ModItems.WOOD_SCRAPS);
                        entries.add(ModItems.ACACIA_WOOD_CHUNK);
                        entries.add(ModItems.ACACIA_WOOD_CHUNK_GUMMED);
                        entries.add(ModItems.OAK_WOOD_CHUNK);
                        entries.add(ModItems.OAK_WOOD_PLANK);

                        /*                  */
                        //      Flowers     //
                        /*                  */

                        entries.add(ModItems.FLAX_FLOWER);

                        /*                  */
                        //       Food       //
                        /*                  */

                        entries.add(ModItems.FISH_FILET);

                        /*                  */
                        //     Resource     //
                        /*                  */

                        entries.add(ModItems.FLAX_SEEDS);
                        entries.add(ModItems.FLAX_BUNDLE);
                        entries.add(ModItems.FLAX_STALKS);

                        /*                  */
                        //      Tools       //
                        /*                  */

                        /* Copper */
                        entries.add(ModItems.COPPER_AXE);
                        entries.add(ModItems.COPPER_HAMMER);
                        entries.add(ModItems.COPPER_HOE);
                        entries.add(ModItems.COPPER_KNIFE);
                        entries.add(ModItems.COPPER_PICKAXE);
                        entries.add(ModItems.COPPER_SHOVEL);
                        entries.add(ModItems.COPPER_SWORD);

                        /* Flint */
                        entries.add(ModItems.FLINT_KNIFE);
                        entries.add(ModItems.FLINT_PICKAXE);
                        entries.add(ModItems.FLINT_SAW);

                        /* Wood */
                        entries.add(ModItems.WOODEN_MALLET);
                        entries.add(ModItems.WOODEN_MORTAR_PESTLE);

                        /*                  */
                        //    Tool Parts    //
                        /*                  */

                        entries.add(ModItems.TOOL_HANDLE);
                        entries.add(ModItems.WOODEN_MORTAR);
                        entries.add(ModItems.WOODEN_PESTLE);
                        entries.add(ModItems.WOODEN_MALLET_HEAD);

                    }).build());

    /*                  */
    //      Helper      //
    /*                  */

    public static void registerModItemGroups() {
        Projectd7.LOGGER.info("Registering item groups for " + Projectd7.MOD_ID);
    }
}
