package imbacrian.btf.items;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.blocks.BlocksList;
import net.minecraft.core.enums.HumanArmorShape;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemArmor;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemPlaceable;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.item.tool.ItemToolSword;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

public class ItemsList {
	public static int initialID = 29500;
	private static final String MOD_ID = BetterThanFishing.MOD_ID;
	public static int newItemID(){
		return initialID++;
	}
	public static Item IRON_FISHING_ROD;
	public static Item GOLD_FISHING_ROD;
	public static Item DIAMOND_FISHING_ROD;
	public static Item STEEL_FISHING_ROD;
	public static Item INGOT_IRIDESCITE;
	public static Item IRIDESCITE_FISHING_ROD;
	public static Item IRIDESCITE_HELMET;
	public static Item IRIDESCITE_CHESTPLATE;
	public static Item IRIDESCITE_LEGGINGS;
	public static Item IRIDESCITE_BOOTS;
	public static Item IRIDESCENT_SCALE;
	public static Item IRIDESCENT_CLUMP;
	public static Item BROKEN_CAN;
	public static Item FOOD_ANCHOVY_RAW;
	public static Item FOOD_GOLDEN_CARP_RAW;
	public static Item FOOD_KNIFEFISH_RAW;
	public static Item FOOD_SARDINE_RAW;
	public static Item FOOD_SUNFISH_RAW;
	public static Item FOOD_TUNA_RAW;
	public static Item FOOD_ROCKFISH;
	public static Item FOOD_CATFISH_RAW;
	public static Item FOOD_BOOTFISH_RAW;
	public static Item FOOD_RED_MULLET_RAW;
	public static Item FOOD_HERRING_RAW;
	public static Item FOOD_HALIBUT_RAW;
	public static Item FOOD_SEA_BASS_RAW;
	public static Item FOOD_PERCH_RAW;
	public static Item FOOD_TROUT_RAW;
	public static Item FOOD_EEL_RAW;
	public static Item GUNFISH;
	public static Item WOOD_FILLET_KNIFE;
	public static Item STONE_FILLET_KNIFE;
	public static Item IRON_FILLET_KNIFE;
	public static Item GOLD_FILLET_KNIFE;
	public static Item DIAMOND_FILLET_KNIFE;
	public static Item STEEL_FILLET_KNIFE;
	public static Item IRIDESCITE_FILLET_KNIFE;
	public static Item FOOD_FISH_FILLET_RAW;
	public static Item FOOD_FISH_FILLET_COOKED;
	public static Item FOOD_FISH_CHUNKS_RAW;
	public static Item FOOD_EEL_FILLET_RAW;
	// Chopping Boards
	public static Item ITEM_CHOPPING_BOARD;
	public static Item ITEM_BLACK_CHOPPING_BOARD;
	public static Item ITEM_BLUE_CHOPPING_BOARD;
	public static Item ITEM_BROWN_CHOPPING_BOARD;
	public static Item ITEM_CYAN_CHOPPING_BOARD;
	public static Item ITEM_GRAY_CHOPPING_BOARD;
	public static Item ITEM_GREEN_CHOPPING_BOARD;
	public static Item ITEM_LIGHTBLUE_CHOPPING_BOARD;
	public static Item ITEM_LIME_CHOPPING_BOARD;
	public static Item ITEM_MAGENTA_CHOPPING_BOARD;
	public static Item ITEM_ORANGE_CHOPPING_BOARD;
	public static Item ITEM_PINK_CHOPPING_BOARD;
	public static Item ITEM_PURPLE_CHOPPING_BOARD;
	public static Item ITEM_RED_CHOPPING_BOARD;
	public static Item ITEM_SILVER_CHOPPING_BOARD;
	public static Item ITEM_WHITE_CHOPPING_BOARD;
	public static Item ITEM_YELLOW_CHOPPING_BOARD;

	private static boolean hasInit = false;
	public static void Init(){
		if (!hasInit) {
			hasInit = true;
			initItems();
		}
	}

	public static String itemNSID(String string) {
		return MOD_ID + ":item/" + string;
	}

	public static void initItems(){
		IRON_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.iron_fishing_rod",itemNSID("iron_fishing_rod"),newItemID(), ToolMaterial.iron));
		GOLD_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.gold_fishing_rod",itemNSID("gold_fishing_rod"),newItemID(), ToolMaterial.gold));
		DIAMOND_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.diamond_fishing_rod",itemNSID("diamond_fishing_rod"),newItemID(), ToolMaterial.diamond));
		STEEL_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.steel_fishing_rod",itemNSID("steel_fishing_rod"),newItemID(), ToolMaterial.steel));
		IRIDESCITE_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.iridescite_fishing_rod",itemNSID("iridescite_fishing_rod"),newItemID(), ItemMaterials.iridesciteItem));
		IRIDESCITE_HELMET = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ARMOR))
			.build(new ItemArmor("armor.helmet.iridescite",itemNSID("armor_helmet_iridescite"),newItemID(), ItemMaterials.IRIDESCITE, HumanArmorShape.HEAD));
		IRIDESCITE_CHESTPLATE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ARMOR))
			.build(new ItemArmor("armor.chestplate.iridescite",itemNSID("armor_chestplate_iridescite"),newItemID(), ItemMaterials.IRIDESCITE, HumanArmorShape.CHEST));
		IRIDESCITE_LEGGINGS = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ARMOR))
			.build(new ItemArmor("armor.leggings.iridescite",itemNSID("armor_leggings_iridescite"),newItemID(), ItemMaterials.IRIDESCITE, HumanArmorShape.LEGS));
		IRIDESCITE_BOOTS = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ARMOR))
			.build(new ItemArmor("armor.boots.iridescite",itemNSID("armor_boots_iridescite"),newItemID(), ItemMaterials.IRIDESCITE, HumanArmorShape.BOOTS));
		INGOT_IRIDESCITE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ORE_PRODUCTS))
			.build(new Item("ingot.iridescite",itemNSID("ingot_iridescite"),newItemID()));
		IRIDESCENT_SCALE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("iridescent.scale",itemNSID("iridescent_scale"),newItemID()));
		IRIDESCENT_CLUMP = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ORE_PRODUCTS))
			.build(new Item("iridescent.clump",itemNSID("iridescent_clump"),newItemID()));
		BROKEN_CAN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("broken.can",itemNSID("broken_can"),newItemID()));
		FOOD_ANCHOVY_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.anchovy_raw",
				itemNSID("food_anchovy_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_GOLDEN_CARP_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.golden_carp_raw",
				itemNSID("food_golden_carp_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_KNIFEFISH_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.knifefish_raw",
				itemNSID("food_knifefish_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_SARDINE_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.sardine_raw",
				itemNSID("food_sardine_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_SUNFISH_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.sunfish_raw",
				itemNSID("food_sunfish_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_TUNA_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.tuna_raw",
				itemNSID("food_tuna_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_ROCKFISH = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new HarmfulFood(
				"food.rockfish",
				itemNSID("food_rockfish"),
				newItemID(),
				0,
				20,
				false,
				8,
				4));
		FOOD_CATFISH_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.catfish_raw",
				itemNSID("food_catfish_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_BOOTFISH_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.bootfish_raw",
				itemNSID("food_bootfish_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_RED_MULLET_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.red_mullet_raw",
				itemNSID("food_red_mullet_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_HERRING_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.herring_raw",
				itemNSID("food_herring_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_HALIBUT_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.halibut_raw",
				itemNSID("food_halibut_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_SEA_BASS_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.sea_bass_raw",
				itemNSID("food_sea_bass_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_PERCH_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.perch_raw",
				itemNSID("food_perch_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_TROUT_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.trout_raw",
				itemNSID("food_trout_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_EEL_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.eel_raw",
				itemNSID("food_eel_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		WOOD_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_wood",itemNSID("knife_wood"),newItemID(), ToolMaterial.wood));
		STONE_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_stone",itemNSID("knife_stone"),newItemID(), ToolMaterial.stone));
		IRON_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_iron",itemNSID("knife_iron"),newItemID(), ToolMaterial.iron));
		GOLD_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_gold",itemNSID("knife_gold"),newItemID(), ToolMaterial.gold));
		DIAMOND_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_diamond",itemNSID("knife_diamond"),newItemID(), ToolMaterial.diamond));
		STEEL_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_steel",itemNSID("knife_steel"),newItemID(), ToolMaterial.steel));
		IRIDESCITE_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_iridescite",itemNSID("knife_iridescite"),newItemID(), ItemMaterials.iridesciteItem));
		FOOD_FISH_FILLET_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.fish_fillet_raw",
				itemNSID("food_fish_fillet_raw"),
				newItemID(),
				2,
				5,
				false,
				16));
		FOOD_FISH_FILLET_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.fish_fillet_cooked",
				itemNSID("food_fish_fillet_cooked"),
				newItemID(),
				5,
				5,
				false,
				16));
		FOOD_FISH_CHUNKS_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.fish_chunks_raw",
				itemNSID("food_fish_chunks_raw"),
				newItemID(),
				1,
				5,
				false,
				16));
		FOOD_EEL_FILLET_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.eel_fillet_raw",
				itemNSID("food_eel_fillet_raw"),
				newItemID(),
				1,
				5,
				false,
				16));
		ITEM_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
				.build(new ItemPlaceable(
					"item.chopping_board",
					itemNSID("item_chopping_board"),
					newItemID(),
					BlocksList.CHOPPING_BOARD
				));
		ITEM_BLACK_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.black.chopping_board",
				itemNSID("item_black_chopping_board"),
				newItemID(),
				BlocksList.BLACK_CHOPPING_BOARD
			));
		ITEM_BLUE_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.blue.chopping_board",
				itemNSID("item_blue_chopping_board"),
				newItemID(),
				BlocksList.BLUE_CHOPPING_BOARD
			));
		ITEM_BROWN_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.brown.chopping_board",
				itemNSID("item_brown_chopping_board"),
				newItemID(),
				BlocksList.BROWN_CHOPPING_BOARD
			));
		ITEM_CYAN_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.cyan.chopping_board",
				itemNSID("item_cyan_chopping_board"),
				newItemID(),
				BlocksList.CYAN_CHOPPING_BOARD
			));
		ITEM_GRAY_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.gray.chopping_board",
				itemNSID("item_gray_chopping_board"),
				newItemID(),
				BlocksList.GRAY_CHOPPING_BOARD
			));
		ITEM_GREEN_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.green.chopping_board",
				itemNSID("item_green_chopping_board"),
				newItemID(),
				BlocksList.GREEN_CHOPPING_BOARD
			));
		ITEM_LIGHTBLUE_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.lightblue.chopping_board",
				itemNSID("item_lightblue_chopping_board"),
				newItemID(),
				BlocksList.LIGHTBLUE_CHOPPING_BOARD
			));
		ITEM_LIME_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.lime.chopping_board",
				itemNSID("item_lime_chopping_board"),
				newItemID(),
				BlocksList.LIME_CHOPPING_BOARD
			));
		ITEM_MAGENTA_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.magenta.chopping_board",
				itemNSID("item_magenta_chopping_board"),
				newItemID(),
				BlocksList.MAGENTA_CHOPPING_BOARD
			));
		ITEM_ORANGE_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.orange.chopping_board",
				itemNSID("item_orange_chopping_board"),
				newItemID(),
				BlocksList.ORANGE_CHOPPING_BOARD
			));
		ITEM_PINK_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.pink.chopping_board",
				itemNSID("item_pink_chopping_board"),
				newItemID(),
				BlocksList.PINK_CHOPPING_BOARD
			));
		ITEM_PURPLE_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.purple.chopping_board",
				itemNSID("item_purple_chopping_board"),
				newItemID(),
				BlocksList.PURPLE_CHOPPING_BOARD
			));
		ITEM_RED_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.red.chopping_board",
				itemNSID("item_red_chopping_board"),
				newItemID(),
				BlocksList.RED_CHOPPING_BOARD
			));
		ITEM_SILVER_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.silver.chopping_board",
				itemNSID("item_silver_chopping_board"),
				newItemID(),
				BlocksList.SILVER_CHOPPING_BOARD
			));
		ITEM_WHITE_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.white.chopping_board",
				itemNSID("item_white_chopping_board"),
				newItemID(),
				BlocksList.WHITE_CHOPPING_BOARD
			));
		ITEM_YELLOW_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"item.yellow.chopping_board",
				itemNSID("item_yellow_chopping_board"),
				newItemID(),
				BlocksList.YELLOW_CHOPPING_BOARD
			));
	}
}
