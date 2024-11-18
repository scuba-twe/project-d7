package scubatwe.pd7.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipData;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import org.apache.commons.lang3.math.Fraction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// FIX PACKET ISSUE
public final class InsideItemStorageComponent implements TooltipData {
    public static final InsideItemStorageComponent DEFAULT = new InsideItemStorageComponent(List.of());
    public static final Codec<InsideItemStorageComponent> CODEC;
    public static final PacketCodec<RegistryByteBuf, InsideItemStorageComponent> PACKET_CODEC;
    private static final Fraction NEST_PLACE;
    final List<ItemStack> stacks;
    final Fraction place;
    final int index;

    InsideItemStorageComponent(List<ItemStack> stacks, Fraction place, int index) {
        this.stacks = stacks;
        this.place = place;
        this.index = index;
    }

    public InsideItemStorageComponent(List<ItemStack> stacks) {
        this(stacks, calcPlace(stacks), -1);
    }

    private static DataResult<InsideItemStorageComponent> validatePlace(List<ItemStack> stacks) {
        try {
            Fraction fraction = calcPlace(stacks);
            return DataResult.success(new InsideItemStorageComponent(stacks, fraction, -1));
        } catch (ArithmeticException var2) {
            return DataResult.error(() -> "Excessive items!");
        }
    }

    private static Fraction calcPlace(List<ItemStack> stacks) {
        Fraction fraction = Fraction.ZERO;
        ItemStack itemStack;
        for(Iterator<ItemStack> var2 = stacks.iterator(); var2.hasNext();
            fraction = fraction.add(getPlace(itemStack).multiplyBy
                    (Fraction.getFraction(itemStack.getCount(), 1)))) {
            itemStack = var2.next();
        }
        return fraction;
    }

    static Fraction getPlace(ItemStack stack) {
        InsideItemStorageComponent toolStorage = stack.get(ModDataComponentTypes.TOOL_STORAGE);
        if (toolStorage != null) {
            return NEST_PLACE.add(toolStorage.getPlace());
        } else {
            List<BeehiveBlockEntity.BeeData> list = stack.getOrDefault(DataComponentTypes.BEES, List.of());
            return !list.isEmpty() ? Fraction.ONE : Fraction.getFraction(1, stack.getMaxCount());
        }
    }

    @NotNull
    public List<ItemStack> getStacks() {
        return this.stacks;
    }

    public Fraction getPlace() {
        return this.place;
    }

    static {
        CODEC = ItemStack.CODEC.listOf().flatXmap(InsideItemStorageComponent::validatePlace,
                (component) -> DataResult.success(component.stacks));
        PACKET_CODEC = ItemStack.PACKET_CODEC.collect(PacketCodecs.toList()).xmap(InsideItemStorageComponent::new,
                (component) -> component.stacks);
        NEST_PLACE = Fraction.getFraction(1, 16);
    }

    public static class Builder {
        private final List<ItemStack> stacks;
        private Fraction place;
        private int index;

        public Builder(InsideItemStorageComponent base) {
            this.stacks = new ArrayList<>(base.stacks);
            this.place = base.place;
            this.index = base.index;
        }

        public Builder clear() {
            this.stacks.clear();
            this.place = Fraction.ZERO;
            this.index = -1;
            return this;
        }

        private int getIndex(ItemStack stack) {
            if (stack.isStackable()) {
                for (int i = 0; i < this.stacks.size(); ++i) {
                    if (ItemStack.areItemsAndComponentsEqual(this.stacks.get(i), stack)) {
                        return i;
                    }
                }
            }
            return -1;
        }

        private int getMax(ItemStack stack) {
            Fraction fraction = Fraction.ONE.subtract(this.place);
            return Math.max(fraction.divideBy(InsideItemStorageComponent.getPlace(stack)).intValue(), 0);
        }

        public int add(ItemStack stack) {
            int i = Math.min(stack.getCount(), this.getMax(stack));
            if (i == 0) {
                return 0;
            } else {
                this.place = this.place.add
                        (InsideItemStorageComponent.getPlace(stack)
                                .multiplyBy(Fraction.getFraction(i, 1)));
                int j = this.getIndex(stack);
                if (j != -1) {
                    ItemStack itemStack = this.stacks.remove(j);
                    ItemStack itemStack2 = itemStack.copyWithCount(itemStack.getCount() + i);
                    stack.decrement(i);
                    this.stacks.addFirst(itemStack2);
                } else {
                    this.stacks.addFirst(stack.split(i));
                }

                return i;
            }
        }

        public void setIndex(int index) {
            this.index = this.index != index && index < this.stacks.size() ? index : -1;
        }

        @Nullable
        public ItemStack removeSelected() {
            if (this.stacks.isEmpty()) {
                return null;
            } else {
                int i = this.index != -1 && this.index < this.stacks.size() ? this.index : 0;
                ItemStack itemStack = (this.stacks.remove(i)).copy();
                this.place = this.place.subtract
                        (InsideItemStorageComponent.getPlace(itemStack)
                                .multiplyBy(Fraction.getFraction(itemStack.getCount(), 1)));
                this.setIndex(-1);
                return itemStack;
            }
        }

        public InsideItemStorageComponent build() {
            return new InsideItemStorageComponent(List.copyOf(this.stacks), this.place, this.index);
        }
    }
}
