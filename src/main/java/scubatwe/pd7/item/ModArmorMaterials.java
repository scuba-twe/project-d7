package scubatwe.pd7.item;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.ArmorMaterials;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;
import scubatwe.pd7.util.ModTags;

import java.util.EnumMap;

public interface ModArmorMaterials extends ArmorMaterials {

    /* Copper Armor */
    ArmorMaterial COPPER = new ArmorMaterial
                    (13, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                        map.put(EquipmentType.BOOTS, 1);
                        map.put(EquipmentType.LEGGINGS, 4);
                        map.put(EquipmentType.CHESTPLATE, 5);
                        map.put(EquipmentType.HELMET, 2);
                        map.put(EquipmentType.BODY, 4);
                    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F, 0.0F,
                            ModTags.Items.REPAIRS_COPPER_ARMOR, ModEquipmentModels.COPPER);

}
