package imbacrian.btf.api;

import imbacrian.btf.items.FishCategory;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaitRegistry {
	public static class BaitData {
		private double biteTimeMultiplier = 1.0;
		private final Map<FishCategory, Double> categoryWeights = new HashMap<>();
		private final Map<Item, Double> itemWeights = new HashMap<>();

		/** Less than 1 means faster bite. */
		public BaitData biteTime(double multiplier) {
			this.biteTimeMultiplier = multiplier;
			return this;
		}

		public BaitData category(@NotNull FishCategory category, double weight) {
			this.categoryWeights.put(category, weight);
			return this;
		}

		/** Multiplies chances of a certain item from the fishing loot table. */
		public BaitData item(@NotNull Item item, double weight) {
			this.itemWeights.put(item, weight);
			return this;
		}

		public double biteTimeMultiplier() { return biteTimeMultiplier; }
		public double weightFor(FishCategory category) { return categoryWeights.getOrDefault(category, 1.0); }
		public double weightFor(Item item) { return itemWeights.getOrDefault(item, 1.0); }
	}

	private static final Map<Item, BaitData> BAITS = new LinkedHashMap<>();

	public static BaitData register(@NotNull Item item) {
		BaitData data = new BaitData();
		BAITS.put(item, data);
		return data;
	}

	public static BaitData register(@NotNull Item item, double biteTimeMultiplier, @NotNull Map<FishCategory, Double> categoryWeights) {
		BaitData data = register(item).biteTime(biteTimeMultiplier);
		categoryWeights.forEach(data::category);
		return data;
	}

	public static boolean isBait(@Nullable Item item) {
		return item != null && BAITS.containsKey(item);
	}

	@Nullable
	public static BaitData getEquipped(@Nullable ItemStack rod) {
		ItemStack bait = RodGear.get(rod, RodGear.BAIT);
		return bait == null ? null : BAITS.get(bait.getItem());
	}

	public static void consumeOne(@Nullable ItemStack rod) {
		ItemStack bait = RodGear.get(rod, RodGear.BAIT);
		if (bait == null) return;
		bait.stackSize--;
		RodGear.set(rod, RodGear.BAIT, bait.stackSize > 0 ? bait : null);
	}
}
