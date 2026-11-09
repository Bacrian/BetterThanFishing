package imbacrian.btf.api;

import imbacrian.btf.items.ItemsList;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public final class FishGroups {
	public static final String RAW_FISH = "btf:raw_fish";
	public static final String COOKED_FISH = "btf:cooked_fish";

	private FishGroups() {}

	public static void init() {
		List<Object> raw = new ArrayList<>();
		List<Object> cooked = new ArrayList<>();
		for (FishRegistry.FishDef def : FishRegistry.all()) {
			if (!def.inGroups()) continue;
			raw.add(def.raw);
			if (def.cooked != null) cooked.add(def.cooked);
		}
		Registries.ITEM_GROUPS.register(RAW_FISH, fishView(false));
		Registries.ITEM_GROUPS.register(COOKED_FISH, fishView(true));

		Registries.ITEM_GROUPS.register("btf:algae", Registries.stackListOf(
			ItemsList.SEA_ALGAE, ItemsList.RED_ALGAE, ItemsList.WHITE_ALGAE));
		Registries.ITEM_GROUPS.register("btf:dry_algae", Registries.stackListOf(
			ItemsList.FOOD_SEA_ALGAE_DRY, ItemsList.FOOD_RED_ALGAE_DRY, ItemsList.FOOD_WHITE_ALGAE_DRY));
	}

	private static List<ItemStack> fishView(boolean cooked) {
		return new AbstractList<>() {
			private List<Item> items() {
				List<Item> list = new ArrayList<>();
				for (FishRegistry.FishDef def : FishRegistry.all()) {
					if (!def.inGroups()) continue;
					if (cooked) {
						if (def.cooked != null) list.add(def.cooked);
					} else {
						list.add(def.raw);
					}
				}
				return list;
			}

			@Override
			public ItemStack get(int index) {
				return new ItemStack(items().get(index), 1);
			}

			@Override
			public int size() {
				return items().size();
			}
		};
	}

	private static void add(String group, Item item) {
		List<ItemStack> list = Registries.ITEM_GROUPS.getItem(group);
		if (list != null) {
			list.add(new ItemStack(item));
		}
	}
}
