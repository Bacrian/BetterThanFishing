package imbacrian.btf.api;

import imbacrian.btf.items.FishCategory;
import imbacrian.btf.items.ItemBobberDyed;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BobberRegistry {
	public static class BobberData {
		private final String floatTexture;
		private double catchWindowMultiplier = 1.0;
		private final Map<FishCategory, Double> categoryWeights = new HashMap<>();
		private final Map<Item, Double> itemWeights = new HashMap<>();
		private boolean dyed = false;

		public boolean hasEffects() {
			return catchWindowMultiplier != 1.0 || !categoryWeights.isEmpty() || !itemWeights.isEmpty();
		}

		private BobberData(String floatTexture) {
			this.floatTexture = floatTexture;
		}

		public BobberData dyed() {
			this.dyed = true;
			return this;
		}

		public String floatTextureFor(@Nullable ItemStack stack) {
			if (dyed && stack != null) {
				DyeColor color = DyeColor.colorFromItemMeta(stack.getMetadata());
				if (!ItemBobberDyed.isAvailable(color)) {
					return "minecraft:particle/bobber";
				}
				return floatTexture + color.colorID;
			}
			return floatTexture;
		}

		/** Greater than 1 = more time to catch when a fish bites. */
		public BobberData catchWindow(double multiplier) {
			this.catchWindowMultiplier = multiplier;
			return this;
		}

		public BobberData category(@NotNull FishCategory category, double weight) {
			this.categoryWeights.put(category, weight);
			return this;
		}

		public BobberData item(@NotNull Item item, double weight) {
			this.itemWeights.put(item, weight);
			return this;
		}

		public String floatTexture() { return floatTexture; }
		public double catchWindowMultiplier() { return catchWindowMultiplier; }
		public double weightFor(FishCategory category) { return categoryWeights.getOrDefault(category, 1.0); }
		public double weightFor(Item item) { return itemWeights.getOrDefault(item, 1.0); }
	}

	private static final Map<Item, BobberData> BOBBERS = new LinkedHashMap<>();

	// Cosmetic item: just changes the sprite used. Chains .category(...), .item(...) or .catchWindow(...) to give effects
	public static BobberData register(@NotNull Item item, @NotNull String floatTexture) {
		BobberData data = new BobberData(floatTexture);
		BOBBERS.put(item, data);
		return data;
	}

	public static BobberData register(@NotNull Item item, @NotNull String floatTexture, @NotNull Map<FishCategory, Double> categoryWeights) {
		BobberData data = register(item, floatTexture);
		categoryWeights.forEach(data::category);
		return data;
	}

	public static boolean isBobber(@Nullable Item item) {
		return item != null && BOBBERS.containsKey(item);
	}

	@Nullable
	public static BobberData getEquipped(@Nullable ItemStack rod) {
		ItemStack bobber = RodGear.get(rod, RodGear.BOBBER);
		return bobber == null ? null : BOBBERS.get(bobber.getItem());
	}

	@Nullable
	public static BobberData get(@Nullable Item item) {
		return item == null ? null : BOBBERS.get(item);
	}
}
