package scubatwe.pd7.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import scubatwe.pd7.item.ModItems;

public class ContainerItem extends Item {
    public ContainerItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        return ModItems.CLAY_BOWL.getDefaultStack();
    }
}
