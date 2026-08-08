package imbacrian.btf;

import imbacrian.btf.api.BTFAchievementPage;
import imbacrian.btf.api.ChoppingRegistry;
import imbacrian.btf.blocks.BlocksList;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import imbacrian.btf.items.ItemsList;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.block.entity.TileEntityDispatcher;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderFurnace;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShapeless;
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
		ChoppingRegistry.register(ItemsList.FOOD_KNIFEFISH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_SARDINE_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_SUNFISH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_TUNA_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 2);
		ChoppingRegistry.register(ItemsList.FOOD_CATFISH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_BOOTFISH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_RED_MULLET_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_HERRING_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_HALIBUT_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 2);
		ChoppingRegistry.register(ItemsList.FOOD_SEA_BASS_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_PERCH_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_TROUT_RAW, ItemsList.FOOD_FISH_FILLET_RAW, 1);
		ChoppingRegistry.register(ItemsList.FOOD_EEL_RAW, ItemsList.FOOD_EEL_FILLET_RAW, 1);

		ChoppingRegistry.register(Items.FOOD_FISH_COOKED, ItemsList.FOOD_FISH_FILLET_COOKED, 1);

		ChoppingRegistry.register(ItemsList.FOOD_FISH_FILLET_RAW, ItemsList.FOOD_FISH_CHUNKS_RAW, 2);
	}

	private void registerFurnaceRecipes() {
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.create("fish_fillet_cooked", ItemsList.FOOD_FISH_FILLET_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.BROKEN_CAN)
			.create("can_to_iron", Items.INGOT_IRON.getDefaultStack());
	}


}
