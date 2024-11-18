package scubatwe.pd7.recipe.handcrafting;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeFinder;
import net.minecraft.recipe.input.RecipeInput;

import java.util.ArrayList;
import java.util.List;

public class HandcraftingRecipeInput implements RecipeInput {
    public static HandcraftingRecipeInput EMPTY = new HandcraftingRecipeInput(List.of());
    private final List<ItemStack> stacks;
    private final RecipeFinder matcher = new RecipeFinder();
    private final int count;

    private HandcraftingRecipeInput(List<ItemStack> stacks) {
        this.stacks = stacks;
        int i = 0;

        for (ItemStack itemStack : stacks) {
            if (!itemStack.isEmpty()) {
                ++i;
                this.matcher.addInput(itemStack, 1);
            }
        }

        this.count = i;
    }

    public static HandcraftingRecipeInput create(List<ItemStack> stacks, ItemStack stack) {
        return new HandcraftingRecipeInput(refineList(stacks, stack));
    }

    public static HandcraftingRecipeInput create(ItemStack stack, ItemStack handcraftable) {
        return create(List.of(stack.copyWithCount(1)), handcraftable.copyWithCount(1));
    }

    public static HandcraftingRecipeInput create(ItemStack stack) {
        return create(ItemStack.EMPTY, stack);
    }

    public RecipeFinder getRecipeMatcher() {
        return this.matcher;
    }

    public int getCount() {
        return count;
    }

    private static List<ItemStack> refineList(List<ItemStack> stacks, ItemStack stack) {
        List<ItemStack> list = new ArrayList<>();
        for(ItemStack s : stacks) {
            for(int i = 0; i < s.getCount(); i++) {
                list.add(s.copyWithCount(1));
            }
        }

        list.addLast(stack);
        return list;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return this.stacks.get(slot);
    }

    @Override
    public int size() {
        return this.stacks.size();
    }
}
