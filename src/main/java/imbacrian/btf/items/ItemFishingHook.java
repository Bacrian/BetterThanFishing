package imbacrian.btf.items;

import net.minecraft.core.item.Item;

public class ItemFishingHook extends Item {
	public final boolean grantsMultiCatch;
	public final double extraCatchChanceBonus; // only if rod is already multicatch
	public final int extraMaxCatches;          // idem

	public int extraTreasureRerolls = 0;
	public int junkRerolls = 0;
	public double catchWindowMultiplier = 1.0;
	public double baitSaveChance = 0.0;

	public ItemFishingHook(String translationKey, String namespaceId, int itemId,
	                       boolean grantsMultiCatch, double extraCatchChanceBonus, int extraMaxCatches) {
		super(translationKey, namespaceId, itemId);
		this.grantsMultiCatch = grantsMultiCatch;
		this.extraCatchChanceBonus = extraCatchChanceBonus;
		this.extraMaxCatches = extraMaxCatches;
		this.setMaxStackSize(1);
	}

	public ItemFishingHook treasureRerolls(int rerolls) { this.extraTreasureRerolls = rerolls; return this; }
	public ItemFishingHook junkRerolls(int rerolls) { this.junkRerolls = rerolls; return this; }
	public ItemFishingHook catchWindow(double multiplier) { this.catchWindowMultiplier = multiplier; return this; }
	/** Chances (0 to 1) that a catch doesn't consume the bait. */
	public ItemFishingHook baitSaveChance(double chance) { this.baitSaveChance = chance; return this; }
}
