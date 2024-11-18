package scubatwe.pd7.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.recipe.handcrafting.HandcraftingRecipe;

public class ModRecipeType {
    public static final RecipeType<HandcraftingRecipe> HANDCRAFTING = register("handcrafting");

    private static <T extends Recipe<?>> RecipeType<T> register(String name) {
        return Registry.register(Registries.RECIPE_TYPE, Identifier.of(Projectd7.MOD_ID, name), new RecipeType<T>() {
            public String toString() {
                return name;
            }
        });
    }

    public static void registerModRecipeTypes() {
        Projectd7.LOGGER.info("Registering recipe types for " + Projectd7.MOD_ID);
    }
}
