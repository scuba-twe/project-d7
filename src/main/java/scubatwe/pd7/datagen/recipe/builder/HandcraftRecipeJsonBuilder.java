package scubatwe.pd7.datagen.recipe.builder;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.TagKey;
import org.jetbrains.annotations.Nullable;
import scubatwe.pd7.recipe.handcrafting.HandcraftingRecipe;

import java.util.*;

public class HandcraftRecipeJsonBuilder {
    private final RegistryEntryLookup<Item> registryLookup;
    private final HandcraftingRecipe.RecipeFactory<?> recipeFactory;
    private final RecipeCategory category;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final List<ItemStack> byproducts = new ArrayList<>();
    private final ItemStack result;
    private final Map<String, AdvancementCriterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    private String group;

    public HandcraftRecipeJsonBuilder(RegistryEntryLookup<Item> registryLookup,
                                      HandcraftingRecipe.RecipeFactory<?> recipeFactory,
                                      RecipeCategory category, ItemStack result) {
        this.registryLookup = registryLookup;
        this.recipeFactory = recipeFactory;
        this.category = category;
        this.result = result;
    }

    public static HandcraftRecipeJsonBuilder create(RegistryEntryLookup<Item> registryLookup,
                                                    RecipeCategory category, ItemConvertible result, int count) {
        return new HandcraftRecipeJsonBuilder(registryLookup, HandcraftingRecipe::new, category,
                result.asItem().getDefaultStack().copyWithCount(count));
    }

    public HandcraftRecipeJsonBuilder input(ItemConvertible item) {
        return this.input(item, 1);
    }

    public HandcraftRecipeJsonBuilder input(ItemConvertible item, int amount) {
        for(int i = 0; i < amount; ++i) {
            this.input(Ingredient.ofItem(item));
        }

        return this;
    }

    public HandcraftRecipeJsonBuilder input(Ingredient ingredient) {
        return this.input(ingredient, 1);
    }

    public HandcraftRecipeJsonBuilder input(Ingredient ingredient, int amount) {
        for(int i = 0; i < amount; ++i) {
            this.ingredients.add(ingredient);
        }
        return this;
    }

    public HandcraftRecipeJsonBuilder input(TagKey<Item> tag) {
        return this.input(Ingredient.fromTag(this.registryLookup.getOrThrow(tag)));
    }

    public HandcraftRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    public HandcraftRecipeJsonBuilder byproduct(ItemConvertible item, int amount) {
        this.byproducts.add(item.asItem().getDefaultStack().copyWithCount(amount));
        return this;
    }

    public HandcraftRecipeJsonBuilder group(@Nullable String group) {
        this.group = group;
        return this;
    }

    public void offerTo(RecipeExporter exporter, RegistryKey<Recipe<?>> recipeKey) {
        this.validate(recipeKey);
        Advancement.Builder builder = exporter.getAdvancementBuilder()
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeKey))
                .rewards(AdvancementRewards.Builder.recipe(recipeKey))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.criteria.forEach(builder::criterion);
        HandcraftingRecipe handcraftingRecipe = this.recipeFactory
                .create(Objects.requireNonNullElse(this.group, ""), this.ingredients,
                        this.byproducts, this.result);
        exporter.accept(recipeKey, handcraftingRecipe,
                builder.build(recipeKey.getValue().withPrefixedPath("recipe/" + this.category.getName() + "/")));
    }

    private void validate(RegistryKey<Recipe<?>> recipeKey) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("Can't get recipe: " + recipeKey.getValue());
        }
    }
}
