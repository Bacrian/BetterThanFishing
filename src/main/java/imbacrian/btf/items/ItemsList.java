package imbacrian.btf.items;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.blocks.BlocksList;
import net.minecraft.core.enums.HumanArmorShape;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.*;
import net.minecraft.core.util.helper.DyeColor;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

import java.util.ArrayList;
import java.util.List;

public class ItemsList {
	public static int initialID = 29500;
	private static final String MOD_ID = BetterThanFishing.MOD_ID;
	public static int newItemID(){
		return initialID++;
	}
	// Fishing Rods
	public static Item IRON_FISHING_ROD;
	public static Item GOLD_FISHING_ROD;
	public static Item DIAMOND_FISHING_ROD;
	public static Item STEEL_FISHING_ROD;
	public static Item IRIDESCITE_FISHING_ROD;

	// Iridescite Items
	public static Item INGOT_IRIDESCITE;
	public static Item IRIDESCITE_HELMET;
	public static Item IRIDESCITE_CHESTPLATE;
	public static Item IRIDESCITE_LEGGINGS;
	public static Item IRIDESCITE_BOOTS;
	public static Item IRIDESCENT_SCALE;
	public static Item IRIDESCENT_CLUMP;
	public static Item IRIDESCITE_SWORD;
	public static Item IRIDESCITE_PICKAXE;
	public static Item IRIDESCITE_AXE;
	public static Item IRIDESCITE_HOE;
	public static Item IRIDESCITE_SHOVEL;

	// Other Items
	public static Item BROKEN_CAN;
	public static Item GOLD_BROKEN_CAN;
	public static Item STEEL_BROKEN_CAN;

	// Raw Fish
	public static Item FOOD_ANCHOVY_RAW;
	public static Item FOOD_GOLDEN_CARP_RAW;
	public static Item FOOD_KNIFEFISH_RAW;
	public static Item FOOD_SARDINE_RAW;
	public static Item FOOD_SUNFISH_RAW;
	public static Item FOOD_TUNA_RAW;
	public static Item FOOD_CATFISH_RAW;
	public static Item FOOD_BOOTFISH_RAW;
	public static Item FOOD_RED_MULLET_RAW;
	public static Item FOOD_HERRING_RAW;
	public static Item FOOD_HALIBUT_RAW;
	public static Item FOOD_SEA_BASS_RAW;
	public static Item FOOD_PERCH_RAW;
	public static Item FOOD_TROUT_RAW;
	public static Item FOOD_EEL_RAW;

	// Fish but not food
	public static Item GUNFISH;
	public static Item FOOD_ROCKFISH;

	// Cooked Fish
	public static Item FOOD_ANCHOVY_COOKED;
	public static Item FOOD_GOLDEN_CARP_COOKED;
	public static Item FOOD_KNIFEFISH_COOKED;
	public static Item FOOD_SARDINE_COOKED;
	public static Item FOOD_SUNFISH_COOKED;
	public static Item FOOD_TUNA_COOKED;
	public static Item FOOD_CATFISH_COOKED;
	public static Item FOOD_BOOTFISH_COOKED;
	public static Item FOOD_RED_MULLET_COOKED;
	public static Item FOOD_HERRING_COOKED;
	public static Item FOOD_HALIBUT_COOKED;
	public static Item FOOD_SEA_BASS_COOKED;
	public static Item FOOD_PERCH_COOKED;
	public static Item FOOD_TROUT_COOKED;
	public static Item FOOD_EEL_COOKED;

	// Other Food
	public static Item SEA_ALGAE;
	public static Item FOOD_SEA_ALGAE_DRY;
	public static Item WHITE_ALGAE;
	public static Item FOOD_WHITE_ALGAE_DRY;
	public static Item RED_ALGAE;
	public static Item FOOD_RED_ALGAE_DRY;
	public static Item FOOD_CRAB;
	public static Item FOOD_SHRIMP_RAW;
	public static Item FOOD_SHRIMP_COOKED;
	public static Item FOOD_CLAM;

	// Fillet Knives
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
	public static Item FOOD_FISH_CHUNKS_COOKED;
	public static Item FOOD_EEL_FILLET_RAW;
	public static Item FOOD_EEL_FILLET_COOKED;

	// Chopping Boards: una lisa (oak) + una pintada, el color vive en la
	// metadata (0-15, DyeColor) en vez de un item ID separado por color.
	public static Item ITEM_CHOPPING_BOARD;
	public static Item ITEM_DYED_CHOPPING_BOARD;

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
		// Fishing Rods
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
		// Iridescite Items
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
		// Other Items
		BROKEN_CAN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("broken.can",itemNSID("broken_can"),newItemID()));
		// Raw Fish
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
		// Fillet Knives
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
		// Food Fillet
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
		// Chopping Boards
		ITEM_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"chopping_board",
				itemNSID("item_chopping_board"),
				newItemID(),
				BlocksList.CHOPPING_BOARD
			));
		ITEM_DYED_CHOPPING_BOARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(
				new CreativeInventoryPlacement.Category(
					CreativeInventoryCategory.MISC_TOOLS
				)
					.setCustomSupplier(() -> {
						List<ItemStack> variants = new ArrayList<>();

						for (DyeColor color : DyeColor.itemOrderedColors()) {
							variants.add(
								new ItemStack(
									ITEM_DYED_CHOPPING_BOARD,
									1,
									color.itemMeta
								)
							);
						}

						return variants;
					})
			)
			.build(
				new ItemPlaceableDye(
					"dyed_chopping_board",
					itemNSID("item_dyed_chopping_board"),
					newItemID(),
					BlocksList.DYED_CHOPPING_BOARD
				)
			);
		// Cooked Fish
		FOOD_ANCHOVY_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.anchovy_cooked",
				itemNSID("food_anchovy_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_GOLDEN_CARP_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.golden_carp_cooked",
				itemNSID("food_golden_carp_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_KNIFEFISH_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.knifefish_cooked",
				itemNSID("food_knifefish_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_SARDINE_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.sardine_cooked",
				itemNSID("food_sardine_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_SUNFISH_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.sunfish_cooked",
				itemNSID("food_sunfish_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_TUNA_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.tuna_cooked",
				itemNSID("food_tuna_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_CATFISH_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.catfish_cooked",
				itemNSID("food_catfish_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_BOOTFISH_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.bootfish_cooked",
				itemNSID("food_bootfish_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_RED_MULLET_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.red_mullet_cooked",
				itemNSID("food_red_mullet_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_HERRING_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.herring_cooked",
				itemNSID("food_herring_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_HALIBUT_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.halibut_cooked",
				itemNSID("food_halibut_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_SEA_BASS_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.sea_bass_cooked",
				itemNSID("food_sea_bass_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_PERCH_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.perch_cooked",
				itemNSID("food_perch_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_TROUT_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.trout_cooked",
				itemNSID("food_trout_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_EEL_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.eel_cooked",
				itemNSID("food_eel_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		FOOD_EEL_FILLET_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.eel_fillet_cooked",
				itemNSID("food_eel_fillet_cooked"),
				newItemID(),
				5,
				5,
				false,
				16));
		FOOD_FISH_CHUNKS_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.fish_chunks_cooked",
				itemNSID("food_fish_chunks_cooked"),
				newItemID(),
				3,
				5,
				false,
				16));
		IRIDESCITE_SWORD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolSword("tool.sword_iridescite",itemNSID("sword_iridescite"),newItemID(), ItemMaterials.iridesciteItem));
		IRIDESCITE_PICKAXE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolPickaxe("tool.pickaxe_iridescite",itemNSID("pickaxe_iridescite"),newItemID(), ItemMaterials.iridesciteItem));
		IRIDESCITE_AXE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolAxe("tool.axe_iridescite",itemNSID("axe_iridescite"),newItemID(), ItemMaterials.iridesciteItem));
		IRIDESCITE_SHOVEL = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolShovel("tool.shovel_iridescite",itemNSID("shovel_iridescite"),newItemID(), ItemMaterials.iridesciteItem));
		IRIDESCITE_HOE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolHoe("tool.hoe_iridescite",itemNSID("hoe_iridescite"),newItemID(), ItemMaterials.iridesciteItem));
		GOLD_BROKEN_CAN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("gold.broken.can",itemNSID("gold_broken_can"),newItemID()));
		STEEL_BROKEN_CAN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("steel.broken.can",itemNSID("steel_broken_can"),newItemID()));
		FOOD_CLAM = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.clam",
				itemNSID("food_clam"),
				newItemID(),
				2,
				5,
				false,
				4));
		FOOD_CRAB = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.crab",
				itemNSID("food_crab"),
				newItemID(),
				2,
				5,
				false,
				4));
		FOOD_SHRIMP_RAW = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.shrimp.raw",
				itemNSID("food_shrimp_raw"),
				newItemID(),
				2,
				5,
				false,
				8));
		FOOD_SHRIMP_COOKED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.shrimp.cooked",
				itemNSID("food_shrimp_cooked"),
				newItemID(),
				5,
				5,
				false,
				8));
		SEA_ALGAE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.sea.algae",
				itemNSID("food_sea_algae"),
				newItemID(),
				1,
				5,
				false,
				8));
		RED_ALGAE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.red.algae",
				itemNSID("food_red_algae"),
				newItemID(),
				1,
				5,
				false,
				8));
		WHITE_ALGAE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(
				"food.white.algae",
				itemNSID("food_white_algae"),
				newItemID(),
				1,
				5,
				false,
				8));
	}
}
