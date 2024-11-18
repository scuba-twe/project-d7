package scubatwe.pd7.component;

import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import scubatwe.pd7.Projectd7;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    /* Tool Item Storage */
    public static final ComponentType<InsideItemStorageComponent>
            TOOL_STORAGE = register("inside_item_storage", (builder) ->
            builder.codec(InsideItemStorageComponent.CODEC)
                    .packetCodec(InsideItemStorageComponent.PACKET_CODEC).cache());

    /*                  */
    //     Helpers      //
    /*                  */

    private static <T>ComponentType<T>
    register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Projectd7.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        Projectd7.LOGGER.info("Registering data for " + Projectd7.MOD_ID);
    }
}