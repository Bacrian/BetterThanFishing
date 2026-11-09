package imbacrian.btf.gui.tacklebox;

import imbacrian.btf.api.BaitRegistry;
import imbacrian.btf.api.BobberRegistry;
import imbacrian.btf.items.ItemFishingHook;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFishingRod;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.player.inventory.slot.Slot;
import org.jetbrains.annotations.Nullable;

public class SlotRodAccessory extends Slot {

	public static boolean accepts(@Nullable ItemStack stack) {
		if (stack == null) return false;
		Item item = stack.getItem();
		return item instanceof ItemFishingRod
			|| item instanceof ItemFishingHook
			|| BaitRegistry.isBait(item)
			|| BobberRegistry.isBobber(item);
	}

	public SlotRodAccessory(Container container, int index, int x, int y) {
		super(container, index, x, y);
	}

	@Override
	public boolean mayPlace(@Nullable ItemStack stack) {
		return super.mayPlace(stack) && (stack == null || accepts(stack));
	}
}
