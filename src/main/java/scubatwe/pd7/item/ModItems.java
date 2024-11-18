package scubatwe.pd7.item;

import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.component.InsideItemStorageComponent;
import scubatwe.pd7.component.ModDataComponentTypes;
import scubatwe.pd7.item.custom.*;

import java.util.function.Function;

public class ModItems {

    /*                  */
    //      Armor       //
    /*                  */

    /*  // Copper // */

    /* Boots */
    public static final Item COPPER_BOOTS = registerItem("copper_boots", (settings) ->
            new ModArmorItem(ModArmorMaterials.COPPER, EquipmentType.BOOTS, settings
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(50))));

    /* Leggings */
    public static final Item COPPER_LEGGINGS = registerItem("copper_leggings", (settings) ->
            new ModArmorItem(ModArmorMaterials.COPPER, EquipmentType.LEGGINGS, settings
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(50))));

    /* Chestplate */
    public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate", (settings) ->
            new ModArmorItem(ModArmorMaterials.COPPER, EquipmentType.CHESTPLATE, settings
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(50))));

    /* Helmet */
    public static final Item COPPER_HELMET = registerItem("copper_helmet", (settings) ->
            new ArmorItem(ModArmorMaterials.COPPER, EquipmentType.HELMET, settings
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(50))));

    /*                  */
    //      Items       //
    /*                  */

    /* Containers */
    public static final Item CLAY_BOWL = registerItem("clay_bowl",
            Item::new, new Item.Settings()
                    .maxCount(1));

    public static final Item LINSEED_OIL = registerItem("linseed_oil",
            ContainerItem::new, new Item.Settings()
                    .maxCount(1));

    /* Ext. */
    public static final Item DIM_DATA = registerItem("dim_data",
            Item::new, new Item.Settings());

    public static final Item SANDPAPER = registerItem("sandpaper",
            SandpaperItem::new, new Item.Settings()
                    .maxDamage(3));

    public static final Item SENEGAL_GUM = registerItem("senegal_gum",
            Item::new, new Item.Settings());

    public static final Item SHARPENED_FLINT = registerItem("sharpened_flint",
            Item::new, new Item.Settings());

    public static final Item SHAVED_STICK = registerItem("shaved_stick",
            Item::new, new Item.Settings());

    public static final Item SMALL_STICK = registerItem("small_stick",
            Item::new, new Item.Settings());

    public static final Item SMALL_SHAVED_STICK = registerItem("small_shaved_stick",
            Item::new, new Item.Settings());

    public static final Item SMALL_STONE = registerItem("small_stone",
            MalletItem::new, new Item.Settings());

    public static final Item SMALL_DIRT_PILE = registerItem("small_dirt_pile",
            ForageItem::new, new Item.Settings());

    public static final Item SMALL_SAND_PILE = registerItem("small_sand_pile",
            Item::new, new Item.Settings());

    public static final Item TINY_STONE = registerItem("tiny_stone",
            Item::new, new Item.Settings());

    public static final Item TINY_DIRT_PILE = registerItem("tiny_dirt_pile",
            Item::new, new Item.Settings());

    public static final Item TINY_SAND_PILE = registerItem("tiny_sand_pile",
            Item::new, new Item.Settings());

    public static final Item WOOD_SCRAPS = registerItem("wood_scraps",
            Item::new, new Item.Settings());

    public static final Item ACACIA_WOOD_CHUNK = registerItem("acacia_wood_chunk",
            Item::new, new Item.Settings());

    public static final Item ACACIA_WOOD_CHUNK_GUMMED = registerItem("acacia_wood_chunk_gummed",
            Item::new, new Item.Settings());

    public static final Item OAK_WOOD_CHUNK = registerItem("oak_wood_chunk",
            Item::new, new Item.Settings());

    public static final Item OAK_WOOD_PLANK = registerItem("oak_wood_plank",
            Item::new, new Item.Settings());

    /* Flowers */
    public static final Item FLAX_FLOWER = registerItem("flax_flower",
            Item::new, new Item.Settings());

    /* Food */
    public static final Item FISH_FILET = registerItem("fish_filet",
            Item::new, new Item.Settings()
                    .food(ModFoodComponent.FISH_FILET));

    /* Resource */
    public static final Item FLAX_SEEDS = registerItem("flax_seeds",
            Item::new, new Item.Settings());

    public static final Item FLAX_BUNDLE = registerItem("flax_bundle",
            Item::new, new Item.Settings());

    public static final Item FLAX_STALKS = registerItem("flax_stalks",
            Item::new, new Item.Settings());

    /*                  */
    //      Tools       //
    /*                  */

    /*  // Copper // */

    /* Axe */
    public static final Item COPPER_AXE = registerItem("copper_axe", (settings) ->
            new AxeItem(ModToolMaterial.COPPER, 6.0F, -3.1F, settings));

    /* Hammer */
    public static final Item COPPER_HAMMER = registerItem("copper_hammer",
            Item::new, new Item.Settings()
                    .maxCount(1));

    /* Hoe */
    public static final Item COPPER_HOE = registerItem("copper_hoe", (settings) ->
            new HoeItem(ModToolMaterial.COPPER, -2.0F, -1.0F, settings));

    /* Knife */
    public static final Item COPPER_KNIFE = registerItem("copper_knife", (settings) ->
            new KnifeItem(ModToolMaterial.COPPER, 1.0F, -2.0F, settings));

    /* Pickaxe */
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe", (settings) ->
            new PickaxeItem(ModToolMaterial.COPPER, 1.0F, -2.8F, settings));

    /* Shovel */
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel", (settings) ->
            new ShovelItem(ModToolMaterial.COPPER, 1.5F, 3.0F, settings));

    /* Sword */
    public static final Item COPPER_SWORD = registerItem("copper_sword", (settings) ->
            new SwordItem(ModToolMaterial.COPPER, 3.0F, -2.4F, settings));

    /*  // Flint // */

    /* Knife */
    public static final Item FLINT_KNIFE = registerItem("flint_knife", (settings) ->
            new KnifeItem(ModToolMaterial.FLINT, 1.0F, -2.0F, settings));

    /* Pickaxe */
    public static final Item FLINT_PICKAXE = registerItem("flint_pickaxe", (settings) ->
            new PickaxeItem(ModToolMaterial.FLINT, 1.0F, -2.8F, settings));

    /* Saw */
    public static final Item FLINT_SAW = registerItem("flint_saw",
            SawItem::new, new Item.Settings()
                    .maxCount(1));

    /*  // Wood // */

    /* Mallet */
    public static final Item WOODEN_MALLET = registerItem("wooden_mallet",
            Item::new, new Item.Settings()
                    .maxCount(1));

    /* Mortar & Pestle */
    public static final Item WOODEN_MORTAR_PESTLE = registerItem("wooden_mortar_pestle", (settings) ->
            new MortarPestleItem(settings
                    .component(ModDataComponentTypes.TOOL_STORAGE, InsideItemStorageComponent.DEFAULT)
                    .maxCount(1)));

    /*                  */
    //    Tool Parts    //
    /*                  */

    /* Tool Handle */
    public static final Item TOOL_HANDLE = registerItem("tool_handle",
            Item::new, new Item.Settings()
                    .maxCount(1));

    /* Wooden Mortar */
    public static final Item WOODEN_MORTAR = registerItem("wooden_mortar",
            Item::new, new Item.Settings()
                    .maxCount(1));

    /* Wooden Pestle */
    public static final Item WOODEN_PESTLE = registerItem("wooden_pestle",
            Item::new, new Item.Settings()
                    .maxCount(1));

    /* Wooden Mallet Head */
    public static final Item WOODEN_MALLET_HEAD = registerItem("wooden_mallet_head",
            Item::new, new Item.Settings()
                    .maxCount(1));

    /*                  */
    //     Helpers      //
    /*                  */

    private static Item registerItem(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Projectd7.MOD_ID, name));
        return Items.register(registryKey, factory, settings);
    }

    private static Item registerItem(String name, Function<Item.Settings, Item> factory) {
        return registerItem(name, factory, new Item.Settings());
    }

    public static void registerModItems() {
        Projectd7.LOGGER.info("Registering items for " + Projectd7.MOD_ID);
    }
}
