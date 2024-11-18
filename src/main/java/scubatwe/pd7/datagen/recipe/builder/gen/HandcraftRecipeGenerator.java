package scubatwe.pd7.datagen.recipe.builder.gen;

import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import scubatwe.pd7.datagen.recipe.builder.HandcraftRecipeJsonBuilder;

public abstract class HandcraftRecipeGenerator extends RecipeGenerator {
    private final RegistryEntryLookup<Item> itemLookup;

    protected HandcraftRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
        this.itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
    }

    public HandcraftRecipeJsonBuilder createHandcraftRecipe(RecipeCategory category,
                                                            ItemConvertible result, int count) {
        return HandcraftRecipeJsonBuilder.create(this.itemLookup, category, result, count);
    }
}
