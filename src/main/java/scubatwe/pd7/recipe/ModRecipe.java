package scubatwe.pd7.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;

public interface ModRecipe<T extends RecipeInput> extends Recipe<T> {
    List<ItemStack> byproduce(T input, RegistryWrapper.WrapperLookup registries);
}
