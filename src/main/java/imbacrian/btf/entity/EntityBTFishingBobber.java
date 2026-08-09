package imbacrian.btf.entity;

import imbacrian.btf.items.FishingRodItem;
import net.minecraft.core.entity.EntityFishingBobber;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class EntityBTFishingBobber extends EntityFishingBobber {

	public EntityBTFishingBobber(World world, Player owner) {
		super(world, owner);
	}

	@Override
	public void tick() {
		super.tick();

		if (!this.world.isClientSide) {
			ItemStack heldPlayerItem = this.owner.getCurrentEquippedItem();

			if (this.owner.removed
				|| !this.owner.isAlive()
				|| heldPlayerItem == null
				|| !(heldPlayerItem.getItem() instanceof FishingRodItem)
				|| this.distanceToSqr(this.owner) > 1024.0) {

				this.remove();
				this.owner.bobberEntity = null;
			}
		}
	}
}
