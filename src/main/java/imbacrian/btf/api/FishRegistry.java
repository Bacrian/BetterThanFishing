package imbacrian.btf.api;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.items.FishCategory;
import imbacrian.btf.items.ItemsList;
import net.minecraft.core.item.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderFurnace;

import java.util.ArrayList;
import java.util.List;

public class FishRegistry {

	public static class FishDef {
		public final String id;
		public final Item raw;
		@Nullable public final Item cooked;
		private int weight = 4;
		private FishCategory category = FishCategory.FISH;
		private int fillets = 1;
		private Item filletRaw = ItemsList.FOOD_FISH_FILLET_RAW;
		private Item filletCooked = ItemsList.FOOD_FISH_FILLET_COOKED;
		private boolean cookRecipe = true;
		private boolean inGroups = true;

		private FishDef(String id, Item raw, @Nullable Item cooked) {
			this.id = id;
			this.raw = raw;
			this.cooked = cooked;
		}

		public FishDef weight(int weight) { this.weight = weight; return this; }
		public FishDef category(@NotNull FishCategory category) { this.category = category; return this; }
		/** amount of fillets it gives */
		public FishDef fillets(int fillets) { this.fillets = fillets; return this; }
		/** If it gives another type of fillet (like eels). */
		public FishDef fillet(@NotNull Item raw, @NotNull Item cooked) { this.filletRaw = raw; this.filletCooked = cooked; return this; }
		/** For fish that gets cooked in some other way (like vanilla, and other mods). */
		public FishDef noCookRecipe() { this.cookRecipe = false; return this; }
		public FishDef noGroups() { this.inGroups = false; return this; }

		public boolean inGroups() { return inGroups; }
	}

	private static final List<FishDef> DEFS = new ArrayList<>();
	private static final List<FishData> EXTRAS = new ArrayList<>();

	public static FishDef fish(@NotNull String id, @Nullable Item raw, @Nullable Item cooked) {
		FishDef def = new FishDef(id, raw, cooked);
		if (raw == null) {
			BetterThanFishing.LOGGER.warn("Fish '{}' skipped: raw item not found", id);
		} else {
			DEFS.add(def);
		}
		return def;
	}

	public static List<FishDef> all() {
		return DEFS;
	}

	public static List<FishData> tableEntries() {
		List<FishData> list = new ArrayList<>();
		for (FishDef d : DEFS) {
			list.add(new FishData(d.raw, d.weight, false, d.category));
		}
		return list;
	}

	public static void registerChopping() {
		for (FishDef d : DEFS) {
			ChoppingRegistry.register(d.raw, d.filletRaw, d.fillets);
			if (d.cooked != null) {
				ChoppingRegistry.register(d.cooked, d.filletCooked, d.fillets);
			}
		}
	}

	public static void registerCooking(String modId) {
		for (FishDef d : DEFS) {
			if (d.cookRecipe && d.cooked != null) {
				new RecipeBuilderFurnace(modId)
					.setInput(d.raw)
					.create("cooked_" + d.id, d.cooked.getDefaultStack());
			}
		}
	}

	// Other mods can add their stuff here, go on, it won't break anything I swear.
	public static void register(@NotNull Item item, int weight, @NotNull FishCategory category) {
		EXTRAS.add(new FishData(item, weight, false, category));
	}

	public static List<FishData> extras() {
		return EXTRAS;
	}
}
