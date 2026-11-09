package imbacrian.btf.models;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.blocks.BlocksList;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import imbacrian.btf.items.ItemsList;
import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.entity.EntityFishingBobber;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;
import org.useless.dragonfly.data.entity.mojang.EntityGeometryMojangData;

import java.io.InputStream;

import static net.minecraft.client.render.item.model.ItemModelDispatcher.*;

public class CommonRenderer {
	public static final String MOD_ID = BetterThanFishing.MOD_ID;

	private CommonRenderer(){}

	private static void loadGeo(String path) {
		try (InputStream in = CommonRenderer.class.getResourceAsStream(path)) {
			if (in != null) {
				EntityGeometryMojangData.Cache.loadModelsFromResource(in);
			} else {
				BetterThanFishing.LOGGER.error("Geo resource not found: {}", path);
			}
		} catch (Exception e) {
			BetterThanFishing.LOGGER.error("Failed to load geo: {}", path, e);
		}
	}

	public static void loadBwbGeoModels() {
		loadGeo("/assets/btf/models/entity/chopping.board.geo.json");
		loadGeo("/assets/btf/models/entity/trophy.display.geo.json");
		loadGeo("/assets/btf/models/entity/tackle_box.geo.json");
	}


	public static void initBlockModels(final BlockModelDispatcher dispatcher) {
		dispatcher.addDispatch(BlocksList.CHOPPING_BOARD, new BlockModelChoppingBoard<>(BlocksList.CHOPPING_BOARD));
		dispatcher.addDispatch(BlocksList.DYED_CHOPPING_BOARD, new BlockModelChoppingBoard<>(BlocksList.DYED_CHOPPING_BOARD));
		dispatcher.addDispatch(BlocksList.CROPS_RICE, new BlockModelGenericCropsRice<>(BlocksList.CROPS_RICE));
		dispatcher.addDispatch(BlocksList.TACKLE_BOX, new BlockModelTackleBox<>(BlocksList.TACKLE_BOX));
		dispatcher.addDispatch(BlocksList.DYED_TACKLE_BOX, new BlockModelTackleBox<>(BlocksList.DYED_TACKLE_BOX));
	}

	public static void initItemModels(final ItemModelDispatcher dispatcher) {
		dispatcher.addDispatch(makeHoldRod(ItemsList.IRON_FISHING_ROD, "iron_fishing_rod", "iron_fishing_rod_cast"));
		dispatcher.addDispatch(makeHoldRod(ItemsList.GOLD_FISHING_ROD, "gold_fishing_rod", "gold_fishing_rod_cast"));
		dispatcher.addDispatch(makeHoldRod(ItemsList.DIAMOND_FISHING_ROD, "diamond_fishing_rod", "diamond_fishing_rod_cast"));
		dispatcher.addDispatch(makeHoldRod(ItemsList.STEEL_FISHING_ROD, "steel_fishing_rod", "steel_fishing_rod_cast"));
		dispatcher.addDispatch(makeHoldRod(ItemsList.IRIDESCITE_FISHING_ROD, "iridescite_fishing_rod", "iridescite_fishing_rod_cast"));

		dispatcher.addDispatch(makeHoldModel(ItemsList.FLINT_FILLET_KNIFE, "tool_knife_flint"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.WOOD_FILLET_KNIFE, "tool_knife_wood"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.STONE_FILLET_KNIFE, "tool_knife_stone"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.IRON_FILLET_KNIFE, "tool_knife_iron"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.GOLD_FILLET_KNIFE, "tool_knife_gold"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.DIAMOND_FILLET_KNIFE, "tool_knife_diamond"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.STEEL_FILLET_KNIFE, "tool_knife_steel"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.IRIDESCITE_FILLET_KNIFE, "tool_knife_iridescite"));

		dispatcher.addDispatch(makeHoldModel(ItemsList.IRIDESCITE_SWORD, "tool_sword_iridescite"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.IRIDESCITE_PICKAXE, "tool_pickaxe_iridescite"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.IRIDESCITE_AXE, "tool_axe_iridescite"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.IRIDESCITE_SHOVEL, "tool_shovel_iridescite"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.IRIDESCITE_HOE, "tool_hoe_iridescite"));

		dispatcher.addDispatch(makeModel(ItemsList.IRIDESCITE_HELMET, "armor_helmet_iridescite"));
		dispatcher.addDispatch(makeModel(ItemsList.IRIDESCITE_CHESTPLATE, "armor_chestplate_iridescite"));
		dispatcher.addDispatch(makeModel(ItemsList.IRIDESCITE_LEGGINGS, "armor_leggings_iridescite"));
		dispatcher.addDispatch(makeModel(ItemsList.IRIDESCITE_BOOTS, "armor_boots_iridescite"));

		dispatcher.addDispatch(new ItemModelDye(ItemsList.ITEM_DYED_CHOPPING_BOARD, MOD_ID + ":item/chopping_board/chopping_board_"));
		dispatcher.addDispatch(new ItemModelDye(ItemsList.ITEM_DYED_TACKLE_BOX, MOD_ID + ":item/tackle_box/item_tackle_box_"));
		dispatcher.addDispatch(makeModel(ItemsList.INGOT_IRIDESCITE, "ingot_iridescite"));
		dispatcher.addDispatch(makeModel(ItemsList.IRIDESCENT_SCALE, "iridescent_scale"));
		dispatcher.addDispatch(makeModel(ItemsList.IRIDESCENT_CLUMP, "iridescent_clump"));
		dispatcher.addDispatch(makeModel(ItemsList.BROKEN_CAN, "broken_can"));
		dispatcher.addDispatch(makeModel(ItemsList.GOLD_BROKEN_CAN, "gold_broken_can"));
		dispatcher.addDispatch(makeModel(ItemsList.STEEL_BROKEN_CAN, "steel_broken_can"));

		dispatcher.addDispatch(makeModel(ItemsList.FOOD_ANCHOVY_RAW, "food_anchovy_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_ANCHOVY_COOKED, "food_anchovy_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_GOLDEN_CARP_RAW, "food_golden_carp_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_GOLDEN_CARP_COOKED, "food_golden_carp_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_KNIFEFISH_RAW, "food_knifefish_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_KNIFEFISH_COOKED, "food_knifefish_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SARDINE_RAW, "food_sardine_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SARDINE_COOKED, "food_sardine_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SUNFISH_RAW, "food_sunfish_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SUNFISH_COOKED, "food_sunfish_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_TUNA_RAW, "food_tuna_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_TUNA_COOKED, "food_tuna_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_ROCKFISH, "food_rockfish"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_CATFISH_RAW, "food_catfish_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_CATFISH_COOKED, "food_catfish_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_BOOTFISH_RAW, "food_bootfish_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_BOOTFISH_COOKED, "food_bootfish_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_RED_MULLET_RAW, "food_red_mullet_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_RED_MULLET_COOKED, "food_red_mullet_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_HERRING_RAW, "food_herring_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_HERRING_COOKED, "food_herring_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_HALIBUT_RAW, "food_halibut_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_HALIBUT_COOKED, "food_halibut_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SEA_BASS_RAW, "food_sea_bass_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SEA_BASS_COOKED, "food_sea_bass_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_PERCH_RAW, "food_perch_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_PERCH_COOKED, "food_perch_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_TROUT_RAW, "food_trout_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_TROUT_COOKED, "food_trout_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_EEL_RAW, "food_eel_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_EEL_COOKED, "food_eel_cooked"));

		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISH_FILLET_RAW, "food_fish_fillet_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISH_FILLET_COOKED, "food_fish_fillet_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISH_CHUNKS_RAW, "food_fish_chunks_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISH_CHUNKS_COOKED, "food_fish_chunks_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_EEL_FILLET_RAW, "food_eel_fillet_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_EEL_FILLET_COOKED, "food_eel_fillet_cooked"));

		dispatcher.addDispatch(makeModel(ItemsList.FOOD_CLAM, "food_clam"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_CRAB, "food_crab"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SHRIMP_RAW, "food_shrimp_raw"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SHRIMP_COOKED, "food_shrimp_cooked"));
		dispatcher.addDispatch(makeModel(ItemsList.SEA_ALGAE, "sea_algae"));
		dispatcher.addDispatch(makeModel(ItemsList.RED_ALGAE, "red_algae"));
		dispatcher.addDispatch(makeModel(ItemsList.WHITE_ALGAE, "white_algae"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SEA_ALGAE_DRY, "food_sea_algae_dry"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_RED_ALGAE_DRY, "food_red_algae_dry"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_WHITE_ALGAE_DRY, "food_white_algae_dry"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_CRAB_STEW, "food_stew_crab"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SEAFOOD_SALAD, "food_seafood_salad"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.FOOD_SEAFOOD_SKEWER, "food_seafood_skewer"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_CRAB_PIE, "food_crab_pie"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_BREAD_SEAROLL, "food_bread_searoll"));
		dispatcher.addDispatch(makeModel(ItemsList.RICE, "rice"));
		dispatcher.addDispatch(makeModel(ItemsList.RICE_SEEDS, "rice_seeds"));
		dispatcher.addDispatch(makeModel(ItemsList.RICE_BALL, "food_rice_ball"));
		dispatcher.addDispatch(makeModel(ItemsList.ONIGIRI, "food_onigiri"));

		dispatcher.addDispatch(makeModel(ItemsList.ITEM_CHOPPING_BOARD, "chopping_board/chopping_board"));
		dispatcher.addDispatch(makeModel(ItemsList.ITEM_TACKLE_BOX, "tackle_box/item_tackle_box"));
		dispatcher.addDispatch(makeModel(ItemsList.DIAMOND_FISHING_HOOK, "fishing_hook_diamond"));
		dispatcher.addDispatch(makeModel(ItemsList.BOBBER_IRIDESCENT, "bobber/bobber_iridescent"));
		dispatcher.addDispatch(makeModel(ItemsList.WORM, "worm"));
		dispatcher.addDispatch(makeModel(ItemsList.BOBBER_GOLD, "bobber/bobber_gold"));
		dispatcher.addDispatch(makeModel(ItemsList.BOBBER_OLD, "bobber/bobber_old"));
		dispatcher.addDispatch(makeModel(ItemsList.GOLD_FISHING_HOOK, "fishing_hook_gold"));
		dispatcher.addDispatch(makeModel(ItemsList.IRON_FISHING_HOOK, "fishing_hook_iron"));
		dispatcher.addDispatch(makeModel(ItemsList.IRIDESCITE_FISHING_HOOK, "fishing_hook_iridescite"));
		dispatcher.addDispatch(makeModel(ItemsList.BOBBER_CORK,"bobber/bobber_cork"));
		dispatcher.addDispatch(makeModel(ItemsList.CLOVER_FISHING_HOOK, "fishing_hook_clover"));
		dispatcher.addDispatch(makeModel(ItemsList.WINGED_BAIT, "winged_bait"));
		dispatcher.addDispatch(makeModel(ItemsList.IRIDESCITE_SHARD, "iridescite_shard"));
		dispatcher.addDispatch(makeModel(ItemsList.IRON_CAN,"iron_can"));
		dispatcher.addDispatch(makeModel(ItemsList.GOLD_CAN,"gold_can"));
		dispatcher.addDispatch(makeModel(ItemsList.BOBBER_PLAIN,"bobber/bobber_plain"));

		ItemModelDye bobberDyed = new ItemModelDye(ItemsList.BOBBER_DYED, MOD_ID + ":item/bobber/bobber_dyed_");
		bobberDyed.setIcon(DyeColor.RED.itemMeta, MOD_ID + ":item/bobber/bobber_plain");
		dispatcher.addDispatch(bobberDyed);

		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SUSHI_ROLL, "food_sushi_roll"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISH_STICK, "food_fish_stick"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_RICE_CRACKER, "food_rice_cracker"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_RAW_TEMPURA, "food_raw_tempura"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_TEMPURA, "food_tempura"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SEA_ALGAE_CHIPS, "food_sea_algae_chips"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_RED_ALGAE_CHIPS, "food_red_algae_chips"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_WHITE_ALGAE_CHIPS, "food_white_algae_chips"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_JERKY, "food_jerky"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISH_JERKY, "food_fish_jerky"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_CANNED_FISH, "food_canned_fish"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_RICE_BOWL, "food_rice_bowl"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_DONBURI, "food_donburi"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SEAFOOD_FRIED_RICE, "food_seafood_fried_rice"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_ALGAE_RICE_PORRIDGE, "food_algae_rice_porridge"));
		dispatcher.addDispatch(makeHoldModel(ItemsList.FOOD_GRILLED_EEL_SKEWER, "food_grilled_eel_skewer"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISH_STEW, "food_fish_stew"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SPICY_CRAB_STEW, "food_spicy_crab_stew"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_CLAM_CHOWDER, "food_clam_chowder"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_STUFFED_HALIBUT, "food_stuffed_halibut"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_SEAFOOD_GUMBO, "food_seafood_gumbo"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISH_AND_FRIES, "food_fish_and_fries"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISH_PIE, "food_fish_pie"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_FISHBURGER, "food_fishburger"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_CANNED_CLAMS, "food_canned_clams"));
		dispatcher.addDispatch(makeModel(ItemsList.FOOD_GOURMET_CANNED_FISH, "food_gourmet_canned_fish"));
	}

	public static void initTileEntityModels(final TileEntityRenderDispatcher dispatcher) {
		dispatcher.assignRenderer(TileEntityChoppingBoard.class, new TileEntityRendererChoppingBoard());
		dispatcher.assignRenderer(TileEntityTackleBox.class, new TileEntityRendererTackleBox());
	}

	public static void initEntityModels(final EntityRendererDispatcher dispatcher) {
		loadBwbGeoModels();
		dispatcher.assignRenderer(EntityFishingBobber.class, new EntityRendererBTFishingBobber());
	}

	public static void initBlockColors(final BlockColorDispatcher dispatcher) {
	}

	public static @NotNull ItemModelStandard makeModel(@NotNull final Item item, @NotNull final String textureValue) {
		return setIcon(new ItemModelStandard(item, false), NamespaceID.fromPool(MOD_ID, "item/" + textureValue));
	}

	public static @NotNull ItemModelStandard makeHoldModel(@NotNull final Item item, @NotNull final String textureValue) {
		return setIcon(new ItemModelStandard(item, false), NamespaceID.fromPool(MOD_ID, "item/" + textureValue))
			.setDisplayPos("firstperson_righthand", HANDHELD_FIRST_PERSON_RIGHT_HAND)
			.setDisplayPos("firstperson_lefthand", HANDHELD_FIRST_PERSON_LEFT_HAND)
			.setDisplayPos("thirdperson_righthand", HANDHELD_THIRD_PERSON_RIGHT_HAND)
			.setDisplayPos("thirdperson_lefthand", HANDHELD_THIRD_PERSON_LEFT_HAND);
	}

	public static @NotNull ItemModelCustomFishingRod makeHoldRod(@NotNull final Item item, @NotNull final String textureValue, @NotNull final String castTextureValue) {
		ItemModelCustomFishingRod rodModel = new ItemModelCustomFishingRod(item, false, MOD_ID + ":item/" + castTextureValue);
		rodModel.setIcon(MOD_ID + ":item/" + textureValue);
		rodModel.setDisplayPos("firstperson_righthand", HANDHELD_ROD_FIRST_PERSON_RIGHT_HAND);
		rodModel.setDisplayPos("firstperson_lefthand", HANDHELD_ROD_FIRST_PERSON_LEFT_HAND);
		rodModel.setDisplayPos("thirdperson_righthand", HANDHELD_ROD_THIRD_PERSON_RIGHT_HAND);
		rodModel.setDisplayPos("thirdperson_lefthand", HANDHELD_ROD_THIRD_PERSON_LEFT_HAND);
		return rodModel;
	}

	public static <T extends ItemModelStandard> @NotNull T setIcon(@NotNull final T model, @NotNull final String texture) {
		model.icon = TextureRegistry.getTexture(texture);
		return model;
	}

	public static <T extends ItemModelStandard> @NotNull T setIcon(@NotNull final T model, @NotNull final NamespaceID texture) {
		model.icon = TextureRegistry.getTexture(texture);
		return model;
	}
}
