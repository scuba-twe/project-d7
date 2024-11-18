package scubatwe.pd7.item;

import net.minecraft.item.equipment.EquipmentModel;
import net.minecraft.item.equipment.EquipmentModels;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;

import java.util.function.BiConsumer;

public interface ModEquipmentModels extends EquipmentModels {
    Identifier COPPER = Identifier.of(Projectd7.MOD_ID, "copper");

    static void accept(BiConsumer<Identifier, EquipmentModel> equipmentModelBiConsumer) {
        equipmentModelBiConsumer.accept(COPPER, buildHumanoid("copper"));
    }

    private static EquipmentModel buildHumanoid(String name) {
        return EquipmentModel.builder()
                .addHumanoidLayers(Identifier.of(Projectd7.MOD_ID, name))
                .build();
    }
}
