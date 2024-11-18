package scubatwe.pd7.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ClickType;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import scubatwe.pd7.Projectd7;
import scubatwe.pd7.component.InsideItemStorageComponent;
import scubatwe.pd7.component.ModDataComponentTypes;
import scubatwe.pd7.event.HandcraftUsageEvent;
import java.util.List;

public class MortarPestleItem extends Item {
    private final HandcraftUsageEvent handcraft = new HandcraftUsageEvent();

    public MortarPestleItem(Settings settings) {
        super(settings);
    }

    public static void setIndex(ItemStack stack, int index) {
        InsideItemStorageComponent toolStorage = (stack.get(ModDataComponentTypes.TOOL_STORAGE));
        if (toolStorage != null) {
            InsideItemStorageComponent.Builder builder = new InsideItemStorageComponent.Builder(toolStorage);
            builder.setIndex(index);
            stack.set(ModDataComponentTypes.TOOL_STORAGE, builder.build());
        }
    }
    
    private void onContentChanged(PlayerEntity player) {
        ScreenHandler screenHandler = player.currentScreenHandler;
        if (screenHandler != null) {
            screenHandler.onContentChanged(player.getInventory());
        }
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack,
                             Slot slot, ClickType clickType, PlayerEntity player,
                             StackReference cursorStackReference) {
        if(clickType == ClickType.LEFT && otherStack.isEmpty()) {
            setIndex(stack, -1);
            return false;
        } else {
            InsideItemStorageComponent insideItemStorageComponent = stack.get(ModDataComponentTypes.TOOL_STORAGE);
            if(insideItemStorageComponent == null) {
                return false;
            } else {
                InsideItemStorageComponent.Builder builder = new InsideItemStorageComponent.Builder(insideItemStorageComponent);
                if (clickType == ClickType.LEFT && !otherStack.isEmpty() && otherStack.isIn
                        (TagKey.of(RegistryKeys.ITEM, Identifier.of(Projectd7.MOD_ID, "pressables")))
                        && slot.canTakePartial(player) && builder.add(otherStack.split(1)) > 0) {
                    stack.set(ModDataComponentTypes.TOOL_STORAGE, builder.build());
                    this.onContentChanged(player);
                    return true;
                } else if (clickType == ClickType.RIGHT && otherStack.isEmpty()
                        && !insideItemStorageComponent.getStacks().isEmpty()) {
                    if (slot.canTakePartial(player)) {
                        ItemStack itemStack = builder.removeSelected();
                        if (itemStack != null) {
                            cursorStackReference.set(itemStack);
                        }
                    }
                    stack.set(ModDataComponentTypes.TOOL_STORAGE, builder.build());
                    this.onContentChanged(player);
                    return true;
                } else {
                    setIndex(stack, -1);
                    return false;
                }
            }
        }
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient() && world.getServer() != null) {
            return handcraft.craft(world, player);
        } else return null;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (stack.contains(ModDataComponentTypes.TOOL_STORAGE)) {
            if(Screen.hasShiftDown()) {
                InsideItemStorageComponent insideItemStorageComponent = stack.get(ModDataComponentTypes.TOOL_STORAGE);
                tooltip.add(Text.translatable("tooltip.pd7.mortar_pestle.shift_down"));
                if(insideItemStorageComponent != null) {
                    tooltip.add(Text.literal("Inside:  "));
                    for (int i = 0; i < insideItemStorageComponent.getStacks().size(); i++) {
                        tooltip.add(Text.literal(insideItemStorageComponent.getStacks().get(i).toString()));
                    }
                }
            } else {
                tooltip.add(Text.translatable("tooltip.pd7.mortar_pestle"));
            }
        }
        super.appendTooltip(stack, context, tooltip, type);
    }
}

