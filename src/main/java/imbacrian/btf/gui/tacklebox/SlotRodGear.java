package imbacrian.btf.gui.tacklebox;

import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.player.inventory.slot.Slot;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class SlotRodGear extends Slot {
	private final Predicate<ItemStack> filter;

	public SlotRodGear(Container container, int index, int x, int y, Predicate<ItemStack> filter) {
		super(container, index, x, y);
		this.filter = filter;
	}

	@Override
	public boolean mayPlace(@Nullable ItemStack stack) {
		if (!super.mayPlace(stack)) return false;
		return stack == null || filter.test(stack);
	}
}
