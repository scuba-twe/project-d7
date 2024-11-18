package scubatwe.pd7;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import scubatwe.pd7.block.ModBlocks;
import scubatwe.pd7.util.ModModelPredicates;

public class Projectd7Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLAX_PLANT, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();
    }
}
