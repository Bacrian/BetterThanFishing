package imbacrian.btf;

import imbacrian.btf.api.*;
import imbacrian.btf.blocks.BlocksList;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import imbacrian.btf.compat.stardew.StardewCompat;
import imbacrian.btf.items.FishCategory;
import imbacrian.btf.items.ItemsList;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.entity.TileEntityDispatcher;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.EnvironmentHelper;
import turniplabs.halplibe.helper.TextureHelper;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderBlastFurnace;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderFurnace;
import turniplabs.halplibe.util.dependency.Key;

import java.util.Map;

import static net.minecraft.core.data.registry.Registries.NAMESPACES;

public class BetterThanFishing implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("btf", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.AFTER_ITEM_INIT.listen(Key.of(MOD_ID), this::afterItemInit);
		CommonEvents.AFTER_GAME_START.listen(Key.of(MOD_ID), this::afterGameStart);
		LOGGER.info("Better Than Fishing initialized.");
	}

	public void beforeGameStart() {
		if (!EnvironmentHelper.isMultiplayerServer()) {
			TextureHelper.initializeAllFiles(MOD_ID, TextureRegistry.artAtlas, true);
		}
		BTFConfig.init();
		NAMESPACES.register(MOD_ID, MOD_ID);
		BTFPaintings.InitPaintings();
		BlocksList.Init();
		ItemsList.Init();

		TileEntityDispatcher.addMapping(TileEntityChoppingBoard.class, NamespaceID.fromPool(MOD_ID, "cutting_table"));
		TileEntityDispatcher.addMapping(TileEntityTackleBox.class, NamespaceID.fromPool(MOD_ID, "tackle_box"));


	}

	public void afterItemInit() {
		FishGroups.init();
		StardewCompat.defineFish();
		FishDefinitions.init();
	}

	public void afterGameStart() {
		registerChoppingRecipes();
		registerFishingBobbers();
		registerFishingBait();
		registerWormBait(ItemsList.WORM);
		registerFurnaceRecipes();

		StardewCompat.init();
	}

	private void registerChoppingRecipes() {
		FishRegistry.registerChopping();
		ChoppingRegistry.register(ItemsList.FOOD_FISH_FILLET_RAW, ItemsList.FOOD_FISH_CHUNKS_RAW, 2);
		ChoppingRegistry.register(ItemsList.FOOD_FISH_FILLET_COOKED, ItemsList.FOOD_FISH_CHUNKS_COOKED,2);
	}

	private void registerFishingBait() {
		BaitRegistry.register(ItemsList.FOOD_FISH_CHUNKS_RAW)
			.biteTime(0.7)
			.category(FishCategory.JUNK, 0.6)
			.item(ItemsList.FOOD_EEL_RAW, 3.0);
		BaitRegistry.register(ItemsList.FOOD_SHRIMP_RAW)
			.biteTime(0.8)
			.item(ItemsList.FOOD_SHRIMP_RAW, 1.5)
			.item(ItemsList.FOOD_CLAM, 2.0)
			.item(ItemsList.FOOD_CRAB, 2.0)
			.item(ItemsList.FOOD_EEL_RAW, 1.5);
		BaitRegistry.register(ItemsList.WINGED_BAIT)
			.biteTime(0.65)
			.category(FishCategory.FISH,1.2)
			.category(FishCategory.NON_FISH,0.8);
		BaitRegistry.register(ItemsList.FOOD_CLAM)
			.biteTime(0.9)
			.category(FishCategory.TREASURE, 1.2);
		BaitRegistry.register(ItemsList.FOOD_CRAB)
			.biteTime(0.85)
			.category(FishCategory.NON_FISH, 1.5)
			.category(FishCategory.JUNK, 0.8);
	}

	public static void registerWormBait(Item worm) {
		BaitRegistry.register(worm)
			.biteTime(0.7)
			.category(FishCategory.FISH, 1.2)
			.category(FishCategory.NON_FISH, 1.4)
			.category(FishCategory.JUNK, 0.6);
	}

	private void registerFishingBobbers() {
		BobberRegistry.register(ItemsList.BOBBER_IRIDESCENT, "btf:particle/bobber/bobber_iridescent_float");
		BobberRegistry.register(ItemsList.BOBBER_GOLD, "btf:particle/bobber/bobber_gold_float",
			Map.of(FishCategory.TREASURE, 2.0));
		BobberRegistry.register(ItemsList.BOBBER_OLD, "btf:particle/bobber/bobber_old_float",
			Map.of(FishCategory.JUNK, 2.5));
		BobberRegistry.register(ItemsList.BOBBER_CORK, "btf:particle/bobber/bobber_cork_float")
			.catchWindow(1.5);
		BobberRegistry.register(ItemsList.BOBBER_PLAIN, "minecraft:particle/bobber");
		BobberRegistry.register(ItemsList.BOBBER_DYED, "btf:particle/bobber/bobber_float_").dyed();
	}

	private void registerFurnaceRecipes() {
		FishRegistry.registerCooking(MOD_ID);
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
			.setInput(ItemsList.SEA_ALGAE)
			.create("drying_sea_algae", ItemsList.FOOD_SEA_ALGAE_DRY.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.RED_ALGAE)
			.create("drying_red_algae", ItemsList.FOOD_RED_ALGAE_DRY.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.WHITE_ALGAE)
			.create("drying_white_algae", ItemsList.FOOD_WHITE_ALGAE_DRY.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_FISH_CHUNKS_RAW)
			.create("fish_chunks_cooked", ItemsList.FOOD_FISH_CHUNKS_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_EEL_FILLET_RAW)
			.create("eel_fillet_cooked", ItemsList.FOOD_EEL_FILLET_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_SHRIMP_RAW)
			.create("shrimp_cooked", ItemsList.FOOD_SHRIMP_COOKED.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.RICE)
			.create("rice_cracker", ItemsList.FOOD_RICE_CRACKER.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_RAW_TEMPURA)
			.create("tempura", ItemsList.FOOD_TEMPURA.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_SEA_ALGAE_DRY)
			.create("sea_algae_chips", ItemsList.FOOD_SEA_ALGAE_CHIPS.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_RED_ALGAE_DRY)
			.create("red_algae_chips", ItemsList.FOOD_RED_ALGAE_CHIPS.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_WHITE_ALGAE_DRY)
			.create("white_algae_chips", ItemsList.FOOD_WHITE_ALGAE_CHIPS.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(Items.FOOD_PORKCHOP_COOKED)
			.create("not_fish_jerky", ItemsList.FOOD_JERKY.getDefaultStack());
		new RecipeBuilderFurnace(MOD_ID)
			.setInput(ItemsList.FOOD_FISH_FILLET_COOKED)
			.create("fish_jerky", ItemsList.FOOD_FISH_JERKY.getDefaultStack());
	}


}
