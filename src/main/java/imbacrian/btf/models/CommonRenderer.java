package imbacrian.btf.models;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.blocks.BlocksList;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import imbacrian.btf.items.ItemsList;
import net.minecraft.client.render.EntityRendererDispatcher;
import net.minecraft.client.render.TileEntityRenderDispatcher;
import net.minecraft.client.render.block.color.BlockColorDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.item.model.ItemModelStandard;
import org.useless.dragonfly.data.entity.mojang.EntityGeometryMojangData;
import turniplabs.halplibe.util.ModelEntrypoint;

import java.io.InputStream;

public class CommonRenderer implements ModelEntrypoint {

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
	}

	@Override
	public void initBlockModels(BlockModelDispatcher dispatcher) {
		dispatcher.addDispatch(BlocksList.CHOPPING_BOARD, new BlockModelChoppingBoard<>(BlocksList.CHOPPING_BOARD));
	}

	@Override
	public void initItemModels(ItemModelDispatcher dispatcher) {
		dispatcher.addDispatch(
			new ItemModelCustomFishingRod(
				ItemsList.IRON_FISHING_ROD,
				false,
				"btf:item/iron_fishing_rod_cast" // Cast texture
			)	.setIcon("btf:item/iron_fishing_rod") // normal texture
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_LEFT_HAND)
			);
		dispatcher.addDispatch(
			new ItemModelCustomFishingRod(
				ItemsList.GOLD_FISHING_ROD,
				false,
				"btf:item/gold_fishing_rod_cast" // Cast texture
			).setIcon("btf:item/gold_fishing_rod") // normal texture
			.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_RIGHT_HAND)
			.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_LEFT_HAND)
			.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_RIGHT_HAND)
			.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(
			new ItemModelCustomFishingRod(
				ItemsList.DIAMOND_FISHING_ROD,
				false,
				"btf:item/diamond_fishing_rod_cast" // Cast texture
				).setIcon("btf:item/diamond_fishing_rod") // normal texture
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(
			new ItemModelCustomFishingRod(
				ItemsList.STEEL_FISHING_ROD,
				false,
				"btf:item/steel_fishing_rod_cast" // Cast texture
				).setIcon("btf:item/steel_fishing_rod") // normal texture
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(
			new ItemModelCustomFishingRod(
				ItemsList.IRIDESCITE_FISHING_ROD,
				false,
				"btf:item/iridescite_fishing_rod_cast"
				).setIcon("btf:item/iridescite_fishing_rod")
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_ROD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCITE_HELMET,false)
			.setIcon("btf:item/armor_helmet_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCITE_CHESTPLATE,false)
			.setIcon("btf:item/armor_chestplate_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCITE_LEGGINGS,false)
			.setIcon("btf:item/armor_leggings_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCITE_BOOTS,false)
			.setIcon("btf:item/armor_boots_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.INGOT_IRIDESCITE,false)
			.setIcon("btf:item/ingot_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCENT_SCALE,false)
			.setIcon("btf:item/iridescent_scale"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCENT_CLUMP,false)
			.setIcon("btf:item/iridescent_clump"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.BROKEN_CAN,false)
			.setIcon("btf:item/broken_can"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_ANCHOVY_RAW,false)
			.setIcon("btf:item/food_anchovy_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_GOLDEN_CARP_RAW,false)
			.setIcon("btf:item/food_golden_carp_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_KNIFEFISH_RAW,false)
			.setIcon("btf:item/food_knifefish_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SARDINE_RAW,false)
			.setIcon("btf:item/food_sardine_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SUNFISH_RAW,false)
			.setIcon("btf:item/food_sunfish_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_TUNA_RAW,false)
			.setIcon("btf:item/food_tuna_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_ROCKFISH,false)
			.setIcon("btf:item/food_rockfish"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_CATFISH_RAW,false)
			.setIcon("btf:item/food_catfish_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_BOOTFISH_RAW,false)
			.setIcon("btf:item/food_bootfish_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_RED_MULLET_RAW,false)
			.setIcon("btf:item/food_red_mullet_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_HERRING_RAW,false)
			.setIcon("btf:item/food_herring_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_HALIBUT_RAW,false)
			.setIcon("btf:item/food_halibut_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SEA_BASS_RAW,false)
			.setIcon("btf:item/food_sea_bass_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_PERCH_RAW,false)
			.setIcon("btf:item/food_perch_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_TROUT_RAW,false)
			.setIcon("btf:item/food_trout_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_EEL_RAW,false)
			.setIcon("btf:item/food_eel_raw"));
		dispatcher.addDispatch(
			new ItemModelStandard(
				ItemsList.WOOD_FILLET_KNIFE,
				false
			).setIcon("btf:item/tool_knife_wood")
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(
			new ItemModelStandard(
				ItemsList.STONE_FILLET_KNIFE,
				false
			).setIcon("btf:item/tool_knife_stone")
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(
			new ItemModelStandard(
				ItemsList.IRON_FILLET_KNIFE,
				false
			).setIcon("btf:item/tool_knife_iron")
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(
			new ItemModelStandard(
				ItemsList.GOLD_FILLET_KNIFE,
				false
			).setIcon("btf:item/tool_knife_gold")
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(
			new ItemModelStandard(
				ItemsList.DIAMOND_FILLET_KNIFE,
				false
			).setIcon("btf:item/tool_knife_diamond")
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(
			new ItemModelStandard(
				ItemsList.STEEL_FILLET_KNIFE,
				false
			).setIcon("btf:item/tool_knife_steel")
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(
			new ItemModelStandard(
				ItemsList.IRIDESCITE_FILLET_KNIFE,
				false
			).setIcon("btf:item/tool_knife_iridescite")
				.setDisplayPos("firstperson_righthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_RIGHT_HAND)
				.setDisplayPos("firstperson_lefthand", ItemModelDispatcher.HANDHELD_FIRST_PERSON_LEFT_HAND)
				.setDisplayPos("thirdperson_righthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_RIGHT_HAND)
				.setDisplayPos("thirdperson_lefthand", ItemModelDispatcher.HANDHELD_THIRD_PERSON_LEFT_HAND)
		);
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_FISH_FILLET_RAW,false)
			.setIcon("btf:item/food_fish_fillet_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_FISH_FILLET_COOKED,false)
			.setIcon("btf:item/food_fish_fillet_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_FISH_CHUNKS_RAW,false)
			.setIcon("btf:item/food_fish_chunks_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_EEL_FILLET_RAW,false)
			.setIcon("btf:item/food_eel_fillet_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.ITEM_CHOPPING_BOARD,false)
			.setIcon("btf:item/chopping_board/chopping_board"));
		dispatcher.addDispatch(
			new ItemModelDye(
				ItemsList.ITEM_DYED_CHOPPING_BOARD,
				"btf:item/chopping_board/chopping_board_"
			)
		);
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_ANCHOVY_COOKED,false)
			.setIcon("btf:item/food_anchovy_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_GOLDEN_CARP_COOKED,false)
			.setIcon("btf:item/food_golden_carp_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_KNIFEFISH_COOKED,false)
			.setIcon("btf:item/food_knifefish_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SARDINE_COOKED,false)
			.setIcon("btf:item/food_sardine_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SUNFISH_COOKED,false)
			.setIcon("btf:item/food_sunfish_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_TUNA_COOKED,false)
			.setIcon("btf:item/food_tuna_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_CATFISH_COOKED,false)
			.setIcon("btf:item/food_catfish_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_BOOTFISH_COOKED,false)
			.setIcon("btf:item/food_bootfish_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_RED_MULLET_COOKED,false)
			.setIcon("btf:item/food_red_mullet_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_HERRING_COOKED,false)
			.setIcon("btf:item/food_herring_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_HALIBUT_COOKED,false)
			.setIcon("btf:item/food_halibut_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SEA_BASS_COOKED,false)
			.setIcon("btf:item/food_sea_bass_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_PERCH_COOKED,false)
			.setIcon("btf:item/food_perch_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_TROUT_COOKED,false)
			.setIcon("btf:item/food_trout_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_EEL_COOKED,false)
			.setIcon("btf:item/food_eel_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_EEL_FILLET_COOKED,false)
			.setIcon("btf:item/food_eel_fillet_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_FISH_CHUNKS_COOKED,false)
			.setIcon("btf:item/food_fish_chunks_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCITE_SWORD, false)
			.setIcon("btf:item/tool_sword_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCITE_PICKAXE, false)
			.setIcon("btf:item/tool_pickaxe_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCITE_AXE, false)
			.setIcon("btf:item/tool_axe_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCITE_SHOVEL, false)
			.setIcon("btf:item/tool_shovel_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.IRIDESCITE_HOE, false)
			.setIcon("btf:item/tool_hoe_iridescite"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.GOLD_BROKEN_CAN, false)
			.setIcon("btf:item/gold_broken_can"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.STEEL_BROKEN_CAN, false)
			.setIcon("btf:item/steel_broken_can"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_CLAM, false)
			.setIcon("btf:item/food_clam"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_CRAB, false)
			.setIcon("btf:item/food_crab"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SHRIMP_RAW, false)
			.setIcon("btf:item/food_shrimp_raw"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SHRIMP_COOKED, false)
			.setIcon("btf:item/food_shrimp_cooked"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.SEA_ALGAE, false)
			.setIcon("btf:item/sea_algae"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.RED_ALGAE, false)
			.setIcon("btf:item/red_algae"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.WHITE_ALGAE, false)
			.setIcon("btf:item/white_algae"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SEA_ALGAE_DRY, false)
			.setIcon("btf:item/food_sea_algae_dry"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_RED_ALGAE_DRY, false)
			.setIcon("btf:item/food_red_algae_dry"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_WHITE_ALGAE_DRY, false)
			.setIcon("btf:item/food_white_algae_dry"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_CRAB_STEW, false)
			.setIcon("btf:item/food_stew_crab"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SEAFOOD_SALAD, false)
			.setIcon("btf:item/food_seafood_salad"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_SEAFOOD_SKEWER, false)
			.setIcon("btf:item/food_seafood_skewer"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_CRAB_PIE, false)
			.setIcon("btf:item/food_crab_pie"));
		dispatcher.addDispatch(new ItemModelStandard(ItemsList.FOOD_BREAD_SEAROLL, false)
			.setIcon("btf:item/food_bread_searoll"));
	}

	@Override
	public void initTileEntityModels(TileEntityRenderDispatcher dispatcher) {
		dispatcher.assignRenderer(TileEntityChoppingBoard.class, new TileEntityRendererChoppingBoard());
	}

	@Override
	public void initEntityModels(EntityRendererDispatcher dispatcher) {
		loadBwbGeoModels();
	}

	@Override
	public void initBlockColors(BlockColorDispatcher dispatcher) {
	}
}
