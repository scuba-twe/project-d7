package scubatwe.pd7.recipe;

import com.mojang.serialization.MapCodec;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.recipe.handcrafting.HandcraftingRecipe;

public class ModRecipeSerializer {
    public static final RecipeSerializer<HandcraftingRecipe> HANDCRAFTING = register("handcrafting",
            new HandcraftingRecipe.Serializer<>(HandcraftingRecipe::new));

    private static <S extends RecipeSerializer<T>, T extends ModRecipe<?>> S register(String name, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(Projectd7.MOD_ID, name), serializer);
    }

    public static void registerModRecipeSerializer() {
        Projectd7.LOGGER.info("Registering recipe serializers for " + Projectd7.MOD_ID);
    }
}
