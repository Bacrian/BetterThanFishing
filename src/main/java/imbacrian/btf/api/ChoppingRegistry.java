package imbacrian.btf.api;

import net.minecraft.core.item.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ChoppingRegistry {
	public record ChopResult(@NotNull Item output, int count) {
	}

	public record ChopRecipe(@NotNull Item input, @NotNull ChopResult result) {
	}

	public record ChopGroup(@NotNull List<Item> inputs, @NotNull ChopResult result) {
	}

	// LinkedHashMap preserves registration order, so the guidebook has stable pages, because this fucker likes to crash the game.
	private static final Map<Item, ChopResult> RECIPES = new LinkedHashMap<>();

	public static void register(@NotNull Item input, @NotNull Item output, int count) {
		RECIPES.put(input, new ChopResult(output, count));
	}

	public static boolean isChoppable(@Nullable Item item) {
		return item != null && RECIPES.containsKey(item);
	}

	@Nullable
	public static ChopResult getResult(@Nullable Item item) {
		return item == null ? null : RECIPES.get(item);
	}

	@NotNull
	public static List<ChopRecipe> getRecipes() {
		List<ChopRecipe> recipes = new ArrayList<>();
		for (Map.Entry<Item, ChopResult> entry : RECIPES.entrySet()) {
			recipes.add(new ChopRecipe(entry.getKey(), entry.getValue()));
		}
		return Collections.unmodifiableList(recipes);
	}

	@NotNull
	public static List<ChopGroup> getGroupedRecipes() {
		Map<ChopResult, List<Item>> groups = new LinkedHashMap<>();
		for (Map.Entry<Item, ChopResult> entry : RECIPES.entrySet()) {
			groups.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
		}
		List<ChopGroup> list = new ArrayList<>();
		for (Map.Entry<ChopResult, List<Item>> entry : groups.entrySet()) {
			list.add(new ChopGroup(entry.getValue(), entry.getKey()));
		}
		return Collections.unmodifiableList(list);
	}
}
