package scubatwe.pd7.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SandpaperItem extends Item {
    public SandpaperItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack getRecipeRemainder(ItemStack stack) {
        if (stack.getDamage() < stack.getMaxDamage() - 1) {
            ItemStack moreDamaged = stack.copy();
            moreDamaged.setCount(1);
            moreDamaged.setDamage(stack.getDamage() + 1);
            return moreDamaged;
        }
        return ItemStack.EMPTY;
    }
}
