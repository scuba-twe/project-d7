package scubatwe.pd7.recipe;

import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;

public class ModRecipeBookCategory {
    public static final RecipeBookCategory HANDCRAFTING = register("handcrafting");

    private static RecipeBookCategory register(String name) {
        return Registry.register(Registries.RECIPE_BOOK_CATEGORY, Identifier.of(Projectd7.MOD_ID, name),
                new RecipeBookCategory());
    }

    public static void registerModRecipeBookCategories() {
        Projectd7.LOGGER.info("Registering recipe book categories for " + Projectd7.MOD_ID);
    }
}
