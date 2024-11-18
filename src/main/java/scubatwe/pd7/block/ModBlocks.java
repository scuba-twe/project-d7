package scubatwe.pd7.block;

import net.minecraft.block.*;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import scubatwe.pd7.Projectd7;

import java.util.function.Function;

public class ModBlocks {

    /*                  */
    //     Building     //
    /*                  */



    /*                  */
    //    Functional    //
    /*                  */



    /*                  */
    //    Generation    //
    /*                  */



    /*                  */
    //     Resource     //
    /*                  */

    /* Flowers */
    public static final Block FLAX_PLANT = registerBlock("flax_plant",
            ShortPlantBlock::new, AbstractBlock.Settings.copy(Blocks.SHORT_GRASS)
                    .nonOpaque()
            );

    /* Ore */


    /*                  */
    //      Helper      //
    /*                  */

    private static Block registerBlock(String name,
                                       Function<AbstractBlock.Settings, Block> factory,
                                       AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(Projectd7.MOD_ID, name);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);
        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);
        return block;
    }

    public static void registerModBlocks() {
        Projectd7.LOGGER.info("Registering blocks for " + Projectd7.MOD_ID);
    }
}
