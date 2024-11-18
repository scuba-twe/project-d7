package scubatwe.pd7.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponent {
    public static final FoodComponent FISH_FILET = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .build();
}
