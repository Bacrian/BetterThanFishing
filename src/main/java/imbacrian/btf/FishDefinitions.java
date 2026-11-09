package imbacrian.btf;

import imbacrian.btf.api.FishRegistry;
import imbacrian.btf.items.FishCategory;
import imbacrian.btf.items.ItemsList;
import net.minecraft.core.item.Items;

public final class FishDefinitions {
	private FishDefinitions() {}

	public static void init() {
		FishRegistry.fish("fish", Items.FOOD_FISH_RAW, Items.FOOD_FISH_COOKED).weight(8).noCookRecipe();
		FishRegistry.fish("anchovy", ItemsList.FOOD_ANCHOVY_RAW, ItemsList.FOOD_ANCHOVY_COOKED).weight(4);
		FishRegistry.fish("golden_carp", ItemsList.FOOD_GOLDEN_CARP_RAW, ItemsList.FOOD_GOLDEN_CARP_COOKED).weight(3);
		FishRegistry.fish("knifefish", ItemsList.FOOD_KNIFEFISH_RAW, ItemsList.FOOD_KNIFEFISH_COOKED).weight(4).fillets(2);
		FishRegistry.fish("sardine", ItemsList.FOOD_SARDINE_RAW, ItemsList.FOOD_SARDINE_COOKED).weight(4);
		FishRegistry.fish("sunfish", ItemsList.FOOD_SUNFISH_RAW, ItemsList.FOOD_SUNFISH_COOKED).weight(4).fillets(2);
		FishRegistry.fish("tuna", ItemsList.FOOD_TUNA_RAW, ItemsList.FOOD_TUNA_COOKED).weight(4).fillets(2);
		FishRegistry.fish("catfish", ItemsList.FOOD_CATFISH_RAW, ItemsList.FOOD_CATFISH_COOKED).weight(4).fillets(2);
		FishRegistry.fish("bootfish", ItemsList.FOOD_BOOTFISH_RAW, ItemsList.FOOD_BOOTFISH_COOKED).weight(4);
		FishRegistry.fish("red_mullet", ItemsList.FOOD_RED_MULLET_RAW, ItemsList.FOOD_RED_MULLET_COOKED).weight(5);
		FishRegistry.fish("herring", ItemsList.FOOD_HERRING_RAW, ItemsList.FOOD_HERRING_COOKED).weight(3);
		FishRegistry.fish("halibut", ItemsList.FOOD_HALIBUT_RAW, ItemsList.FOOD_HALIBUT_COOKED).weight(6).fillets(2);
		FishRegistry.fish("sea_bass", ItemsList.FOOD_SEA_BASS_RAW, ItemsList.FOOD_SEA_BASS_COOKED).weight(6);
		FishRegistry.fish("perch", ItemsList.FOOD_PERCH_RAW, ItemsList.FOOD_PERCH_COOKED).weight(6).fillets(2);
		FishRegistry.fish("trout", ItemsList.FOOD_TROUT_RAW, ItemsList.FOOD_TROUT_COOKED).weight(4);
		FishRegistry.fish("eel", ItemsList.FOOD_EEL_RAW, ItemsList.FOOD_EEL_COOKED).weight(5)
			.category(FishCategory.NON_FISH)
			.fillet(ItemsList.FOOD_EEL_FILLET_RAW, ItemsList.FOOD_EEL_FILLET_COOKED);
	}
}
