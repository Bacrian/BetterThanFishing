package imbacrian.btf.api;

import imbacrian.btf.items.FishCategory;
import imbacrian.btf.items.ItemFishingHook;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public final class GearEffects {
	public static final GearEffects NONE = new GearEffects(null, null, null);

	private final BaitRegistry.BaitData bait;
	private final BobberRegistry.BobberData bobber;
	private final ItemFishingHook hook;

	private GearEffects(BaitRegistry.BaitData bait, BobberRegistry.BobberData bobber, ItemFishingHook hook) {
		this.bait = bait;
		this.bobber = bobber;
		this.hook = hook;
	}

	public static GearEffects of(@Nullable ItemStack rod) {
		if (rod == null) return NONE;
		return new GearEffects(BaitRegistry.getEquipped(rod), BobberRegistry.getEquipped(rod), RodGear.getHook(rod));
	}

	@Nullable
	public ItemFishingHook hook() { return hook; }

	public double biteTimeMultiplier() {
		return bait == null ? 1.0 : bait.biteTimeMultiplier();
	}

	public double catchWindowMultiplier() {
		double m = 1.0;
		if (bobber != null) m *= bobber.catchWindowMultiplier();
		if (hook != null) m *= hook.catchWindowMultiplier;
		return m;
	}

	public int extraTreasureRerolls() { return hook == null ? 0 : hook.extraTreasureRerolls; }
	public int junkRerolls() { return hook == null ? 0 : hook.junkRerolls; }
	public double baitSaveChance() { return hook == null ? 0.0 : hook.baitSaveChance; }

	public double weightMultiplier(FishCategory category, Item item) {
		double m = 1.0;
		if (bait != null) m *= bait.weightFor(category) * bait.weightFor(item);
		if (bobber != null) m *= bobber.weightFor(category) * bobber.weightFor(item);
		return m;
	}

	public boolean affectsCatch() {
		return bait != null || hook != null || (bobber != null && bobber.hasEffects());
	}
}
