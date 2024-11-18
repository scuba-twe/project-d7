package scubatwe.pd7.item;

import net.minecraft.item.ToolMaterial;
import scubatwe.pd7.util.ModTags;

public record ModToolMaterial() {
    public static final ToolMaterial FLINT;
    public static final ToolMaterial COPPER;

    static {
        FLINT = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL,
                31, 0.6F, 0.0F, 1,
                ModTags.Items.FLINT_TOOL_MATERIALS);
        COPPER = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
                131, 2.0F, 1.0F, 9,
                ModTags.Items.COPPER_TOOL_MATERIALS);
    }
}
