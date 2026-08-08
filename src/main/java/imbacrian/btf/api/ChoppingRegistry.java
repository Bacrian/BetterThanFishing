package imbacrian.btf.api;

import net.minecraft.core.item.Item;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ChoppingRegistry {
	public record ChopResult(@NotNull Item output, int count) {
	}

	private static final Map<Item, ChopResult> RECIPES = new HashMap<>();

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
}
