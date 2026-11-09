package imbacrian.btf.gui.tacklebox;

import imbacrian.btf.api.ICustomFishingRod;
import net.minecraft.core.item.ItemFishingRod;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.player.inventory.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class SlotFishingRod extends Slot {

	public SlotFishingRod(Container container, int index, int x, int y) {
		super(container, index, x, y);
	}

	@Override
	public boolean mayPlace(@Nullable ItemStack itemStack) {
		if (!super.mayPlace(itemStack)) {
			return false;
		}
		if (itemStack == null) {
			return true;
		}
		return itemStack.getItem() instanceof ICustomFishingRod || itemStack.getItem() instanceof ItemFishingRod;
	}
}
