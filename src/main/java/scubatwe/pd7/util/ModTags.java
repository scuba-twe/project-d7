package scubatwe.pd7.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;

public class ModTags {

    /*                  */
    //      Blocks      //
    /*                  */

    public static class Blocks {

        /*                  */
        //      Tools       //
        /*                  */

        /* Copper */
        public static final TagKey<Block>
                INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");

        /* Flint */
        public static final TagKey<Block>
                INCORRECT_FOR_FLINT_TOOL = createTag("incorrect_for_flint_tool");

        /*                  */
        //      Helper      //
        /*                  */

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Projectd7.MOD_ID, name));
        }
    }

    /*                  */
    //      Items       //
    /*                  */

    public static class Items {

        /*                  */
        //    Containers    //
        /*                  */

        /* Mortar and Pestle Container */
        public static final TagKey<Item>
                MORTAR_PESTLE_CONTAINERS = createTag("mortar_pestle_containers");

        /*                  */
        //       Ext.       //
        /*                  */

        public static final TagKey<Item> FORAGEABLES = createTag("forageables");
        public static final TagKey<Item> HANDCRAFTABLES = createTag("handcraftables");
        public static final TagKey<Item> PRESSABLES = createTag("pressables");

        /*                  */
        //     Materials    //
        /*                  */

        /* Copper */
        public static final TagKey<Item>
                REPAIRS_COPPER_ARMOR = createTag("repairs_copper_armor");

        public static final TagKey<Item>
                COPPER_TOOL_MATERIALS = createTag("copper_tool_materials");

        /* Flint */
        public static final TagKey<Item>
                FLINT_TOOL_MATERIALS = createTag("flint_tool_materials");

        /*                  */
        //     Resource     //
        /*                  */

        public static final TagKey<Item>
                WOOD_CHUNKS = createTag("wood_chunks");

        /*                  */
        //      Tools       //
        /*                  */

        /* Hammers */
        public static final TagKey<Item>
                HAMMERS = createTag("hammers");

        /* Knives */
        public static final TagKey<Item>
                KNIVES = createTag("knives");

        /* Mallets */
        public static final TagKey<Item>
                MALLETS = createTag("mallets");

        /* Mortar and Pestles */
        public static final TagKey<Item>
                MORTAR_PESTLES = createTag("mortar_pestles");

        /* Saws */
        public static final TagKey<Item>
                SAWS = createTag("saws");

        /*                  */
        //      Types       //
        /*                  */

        public static final TagKey<Item>
                DIRT_TYPE = createTag("dirt_type");

        /*                  */
        //      Helper      //
        /*                  */

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Projectd7.MOD_ID, name));
        }
    }
}
