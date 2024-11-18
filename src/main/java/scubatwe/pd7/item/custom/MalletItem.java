package scubatwe.pd7.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import scubatwe.pd7.event.HandcraftUsageEvent;

public class MalletItem extends Item {
    private final HandcraftUsageEvent handcraft = new HandcraftUsageEvent();

    public MalletItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient() && world.getServer() != null) {
            return handcraft.craft(world, player);
        } else return null;
    }
}
