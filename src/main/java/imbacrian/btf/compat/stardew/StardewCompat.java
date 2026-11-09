package imbacrian.btf.compat.stardew;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.api.ChoppingRegistry;
import imbacrian.btf.api.FishGroups;
import imbacrian.btf.api.FishRegistry;
import imbacrian.btf.items.FishCategory;
import imbacrian.btf.items.ItemsList;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import turniplabs.halplibe.helper.RecipeBuilder;

public final class StardewCompat {
	public static final String MOD_ID = "stardew";
	private static final boolean LOADED = FabricLoader.getInstance().isModLoaded(MOD_ID);
	private static final String[] FISH = {"salmon", "bass", "snapper"};

	private StardewCompat() {}

	public static boolean isLoaded() {
		return LOADED;
	}

	@Nullable
	public static Item item(@NotNull String name) {
		if (!LOADED) return null;
		return Item.itemsMap.get(NamespaceID.fromPool(MOD_ID, "item/" + name));
	}

	@NotNull
	public static Item wormOr(@NotNull Item fallback) {
		Item worm = item("worm");
		return worm != null ? worm : fallback;
	}

	public static void init() {
		if (!LOADED) return;

		Item worm = item("worm");
		if (worm != null) {
			BetterThanFishing.registerWormBait(worm);
		} else {
			BetterThanFishing.LOGGER.warn("Stardew detected but 'worm' item not found; skipping bait compat");
		}
	}

	public static void defineFish() {
		if (!LOADED) return;
		define("salmon", 2);
		define("bass", 1);
		define("snapper", 1);
	}

	private static void define(String name, int fillets) {
		FishRegistry.fish(name, item("food_" + name + "_raw"), item("food_" + name + "_cooked"))
			.weight(4).fillets(fillets).noCookRecipe();
	}

	public static void registerRecipes(String modId) {
		if (!LOADED) return;

		Item potato = item("food_potato");
		Item tomato = item("food_tomato");
		Item cheese = item("food_cheese");

		if (potato != null) {
			RecipeBuilder.Shapeless(modId)
				.addInput(FishGroups.COOKED_FISH)
				.addInput(potato).addInput(potato)
				.create("fish_and_fries", new ItemStack(ItemsList.FOOD_FISH_AND_FRIES, 1));

			RecipeBuilder.Shapeless(modId)
				.addInput(Items.DOUGH).addInput(Items.DOUGH)
				.addInput(FishGroups.COOKED_FISH)
				.addInput(potato)
				.create("fish_pie", new ItemStack(ItemsList.FOOD_FISH_PIE, 2));
		} else {
			BetterThanFishing.LOGGER.warn("Stardew potato not found; skipping Fish and Fries / Fish Pie");
		}

		if (tomato != null && cheese != null) {
			RecipeBuilder.Shapeless(modId)
				.addInput(Items.FOOD_BREAD)
				.addInput(ItemsList.FOOD_FISH_FILLET_COOKED)
				.addInput(tomato).addInput(cheese)
				.create("fishburger", new ItemStack(ItemsList.FOOD_FISHBURGER, 1));
		} else {
			BetterThanFishing.LOGGER.warn("Stardew tomato/cheese not found; skipping Fishburger");
		}
	}
}
