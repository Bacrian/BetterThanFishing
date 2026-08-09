package imbacrian.btf;

import imbacrian.btf.api.BTFAchievementPage;
import imbacrian.btf.api.ChoppingRegistry;
import imbacrian.btf.blocks.BlocksList;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import imbacrian.btf.items.ItemsList;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.entity.TileEntityDispatcher;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBlastFurnace;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderFurnace;
import turniplabs.halplibe.util.dependency.Key;

import static net.minecraft.core.data.registry.Registries.NAMESPACES;

public class BetterThanFishing implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("btf", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.AFTER_GAME_START.listen(Key.of(MOD_ID), this::afterGameStart);
		LOGGER.info("Better Than Fishing initialized.");
	}

	public void beforeGameStart() {
		NAMESPACES.register(MOD_ID, MOD_ID);
		BlocksList.Init();
		ItemsList.Init();

		TileEntityDispatcher.addMapping(TileEntityChoppingBoard.class, NamespaceID.fromPool(MOD_ID, "cutting_table"));


	}

	public void afterGameStart() {
		registerChoppingRecipes();
		registerFurnaceRecipes();
		BTFAchievementPage.init();
	}

	private void registerChoppingRecipes() {
		ChoppingRegistry.register(Items.FOOD_FISH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_ANCHOVY_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_GOLDEN_CARP_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_KNIFEFISH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 2);
		ChoppingRegistry.register(ItemsList.FOOD_SARDINE_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_SUNFISH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 2);
		ChoppingRegistry.register(ItemsList.FOOD_TUNA_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 2);
		ChoppingRegistry.register(ItemsList.FOOD_CATFISH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 2);
		ChoppingRegistry.register(ItemsList.FOOD_BOOTFISH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_RED_MULLET_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_HERRING_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_HALIBUT_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 2);
		ChoppingRegistry.register(ItemsList.FOOD_SEA_BASS_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_PERCH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 2);
		ChoppingRegistry.register(ItemsList.FOOD_TROUT_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_EEL_RAW, ItemsList.FOOD_EEL_FILLET_RAW, 1);

		ChoppingRegistry.register(Items.FOOD_FISH_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);
		ChoppingRegistry.register(ItemsList.FOOD_ANCHOVY_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);
		ChoppingRegistry.register(ItemsList.FOOD_GOLDEN_CARP_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);
		ChoppingRegistry.register(ItemsList.FOOD_KNIFEFISH_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 2);
		ChoppingRegistry.register(ItemsList.FOOD_SARDINE_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);
		ChoppingRegistry.register(ItemsList.FOOD_SUNFISH_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 2);
		ChoppingRegistry.register(ItemsList.FOOD_TUNA_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 2);
		ChoppingRegistry.register(ItemsList.FOOD_CATFISH_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 2);
		ChoppingRegistry.register(ItemsList.FOOD_BOOTFISH_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);
		ChoppingRegistry.register(ItemsList.FOOD_RED_MULLET_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);
		ChoppingRegistry.register(ItemsList.FOOD_HERRING_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);
		ChoppingRegistry.register(ItemsList.FOOD_HALIBUT_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 2);
		ChoppingRegistry.register(ItemsList.FOOD_SEA_BASS_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);
		ChoppingRegistry.register(ItemsList.FOOD_PERCH_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 2);
		ChoppingRegistry.register(ItemsList.FOOD_TROUT_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);
		ChoppingRegistry.register(ItemsList.FOOD_EEL_COOKED, ItemsList.FOOD_EEL_FILLET_COOKED, 1);

		ChoppingRegistry.register(ItemsList.FOOD_FISH_FILLET_RAW, ItemsList.FOOD_FISH_CHUNKS_RAW, 2);
	}

	private void registerFurnaceRecipes() {
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.create("fish_fillet_cooked", ItemsList.FOOD_FISH_FILLET_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.BROKEN_CAN)
			.create("can_to_iron", Items.INGOT_IRON.getDefaultStack());
		new RecipeBuilderBlastFurnace(MOD_ID)
			.setInput(ItemsList.BROKEN_CAN)
			.create("blast_can_to_iron", Items.INGOT_IRON.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.IRIDESCENT_SCALE)
			.create("iridescent_scale_to_clump", ItemsList.IRIDESCENT_CLUMP.getDefaultStack());
		new RecipeBuilderBlastFurnace(MOD_ID)
			.setInput(ItemsList.STEEL_BROKEN_CAN)
			.create("steel_broken_can_to_steel", Items.INGOT_STEEL_CRUDE.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.GOLD_BROKEN_CAN)
			.create("can_to_gold", Items.INGOT_GOLD.getDefaultStack());
		new RecipeBuilderBlastFurnace(MOD_ID)
			.setInput(ItemsList.GOLD_BROKEN_CAN)
			.create("blast_can_to_gold", Items.INGOT_GOLD.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_ANCHOVY_RAW)
			.create("cooked_anchovy", ItemsList.FOOD_ANCHOVY_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_BOOTFISH_RAW)
			.create("cooked_bootfish", ItemsList.FOOD_BOOTFISH_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_CATFISH_RAW)
			.create("cooked_catfish", ItemsList.FOOD_CATFISH_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_EEL_RAW)
			.create("cooked_eel", ItemsList.FOOD_EEL_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_GOLDEN_CARP_RAW)
			.create("cooked_golden_carp", ItemsList.FOOD_GOLDEN_CARP_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_HALIBUT_RAW)
			.create("cooked_halibut", ItemsList.FOOD_HALIBUT_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_HERRING_RAW)
			.create("cooked_herring", ItemsList.FOOD_HERRING_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_KNIFEFISH_RAW)
			.create("cooked_herring", ItemsList.FOOD_KNIFEFISH_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_PERCH_RAW)
			.create("cooked_herring", ItemsList.FOOD_PERCH_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_RED_MULLET_RAW)
			.create("cooked_herring", ItemsList.FOOD_RED_MULLET_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_SARDINE_RAW)
			.create("cooked_herring", ItemsList.FOOD_SARDINE_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_SEA_BASS_RAW)
			.create("cooked_herring", ItemsList.FOOD_SEA_BASS_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_SUNFISH_RAW)
			.create("cooked_herring", ItemsList.FOOD_SUNFISH_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_TROUT_RAW)
			.create("cooked_herring", ItemsList.FOOD_TROUT_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_TUNA_RAW)
			.create("cooked_herring", ItemsList.FOOD_TUNA_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.SEA_ALGAE)
			.create("drying_sea_algae", ItemsList.FOOD_SEA_ALGAE_DRY.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.RED_ALGAE)
			.create("drying_red_algae", ItemsList.FOOD_RED_ALGAE_DRY.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.WHITE_ALGAE)
			.create("drying_white_algae", ItemsList.FOOD_WHITE_ALGAE_DRY.getDefaultStack());
	}


}
