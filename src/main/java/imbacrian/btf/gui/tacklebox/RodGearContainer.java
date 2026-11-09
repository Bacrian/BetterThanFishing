package imbacrian.btf.gui.tacklebox;

import imbacrian.btf.api.RodGear;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.container.Container;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RodGearContainer implements Container {
	public static final int BAIT = 0, HOOK = 1, BOBBER = 2;
	private static final String[] KEYS = { RodGear.BAIT, RodGear.HOOK, RodGear.BOBBER };

	private final TileEntityTackleBox box;

	private ItemStack cachedRod;
	private final ItemStack[] cache = new ItemStack[3];
	private final int[] sigs = new int[3];

	public RodGearContainer(TileEntityTackleBox box) {
		this.box = box;
	}

	private ItemStack rod() {
		return box.getItem(TileEntityTackleBox.SLOT_ROD_ACTIVE);
	}

	private static int sig(@Nullable ItemStack s) {
		return s == null ? -1 : (s.itemID * 31 + s.getMetadata()) * 131 + s.stackSize;
	}

	private void pullExternalChanges() {
		if (cachedRod == null) return;
		for (int i = 0; i < cache.length; i++) {
			if (sig(cache[i]) != sigs[i]) continue;
			ItemStack fresh = RodGear.get(cachedRod, KEYS[i]);
			int freshSig = sig(fresh);
			if (freshSig != sigs[i]) {
				cache[i] = fresh;
				sigs[i] = freshSig;
			}
		}
	}

	private void begin() {
		refresh();
		flush();
		pullExternalChanges();
	}

	private void refresh() {
		ItemStack rod = rod();
		if (rod == cachedRod) return;
		flush();
		cachedRod = rod;
		for (int i = 0; i < cache.length; i++) {
			cache[i] = rod == null ? null : RodGear.get(rod, KEYS[i]);
			sigs[i] = sig(cache[i]);
		}
	}

	public void flush() {
		if (cachedRod == null) return;
		for (int i = 0; i < cache.length; i++) {
			if (cache[i] != null && cache[i].stackSize <= 0) {
				cache[i] = null;
			}
			int now = sig(cache[i]);
			if (now != sigs[i]) {
				RodGear.set(cachedRod, KEYS[i], cache[i]);
				sigs[i] = now;
			}
		}
	}

	@Override public int getContainerSize() { return 3; }

	@Nullable @Override
	public ItemStack getItem(int slot) {
		begin();
		return cache[slot];
	}

	@Nullable @Override
	public ItemStack removeItem(int slot, int amount) {
		begin();
		ItemStack stack = cache[slot];
		if (stack == null) return null;
		ItemStack result;
		if (stack.stackSize <= amount) {
			cache[slot] = null;
			result = stack;
		} else {
			result = stack.splitStack(amount);
		}
		flush();
		return result;
	}

	@Override
	public void setItem(int slot, @Nullable ItemStack stack) {
		begin();
		if (cachedRod == null) return;
		cache[slot] = stack;
		flush();
	}

	@NotNull @Override public String getNameTranslationKey() { return "container.btf.tackle_box"; }
	@Override public int getMaxStackSize() { return 64; }

	@Override
	public void setChanged() {
		flush();
		box.setChanged();
	}

	@Override public boolean stillValid(@NotNull Player player) { return box.stillValid(player); }
	@Override public void sort() {}
	@Override public boolean locked(int slot) { return rod() == null; }
}
