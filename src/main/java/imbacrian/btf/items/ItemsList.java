package imbacrian.btf.items;

import imbacrian.btf.BTFConfig;
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
	private static final String MOD_ID = BetterThanFishing.MOD_ID;

	public static int initialID = 29500;

	public static int newItemID() {
		return initialID++;
	}

	// Fishing Rods
	public static Item IRON_FISHING_ROD;
	public static Item GOLD_FISHING_ROD;
	public static Item DIAMOND_FISHING_ROD;
	public static Item STEEL_FISHING_ROD;
	public static Item IRIDESCITE_FISHING_ROD;

	// Fishing Hooks
	public static Item DIAMOND_FISHING_HOOK;
	public static Item CLOVER_FISHING_HOOK;
	public static Item IRON_FISHING_HOOK;
	public static Item GOLD_FISHING_HOOK;
	public static Item IRIDESCITE_FISHING_HOOK;

	// Bobbers
	public static Item BOBBER_IRIDESCENT;
	public static Item BOBBER_GOLD;
	public static Item BOBBER_OLD;
	public static Item BOBBER_CORK;
	public static Item BOBBER_PLAIN;
	public static Item BOBBER_DYED;

	// Fishing Bait
	public static Item WORM;
	public static Item WINGED_BAIT;

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
	public static Item IRIDESCITE_SHARD;

	// Other Items
	public static Item BROKEN_CAN;
	public static Item GOLD_BROKEN_CAN;
	public static Item STEEL_BROKEN_CAN;
	public static Item IRON_CAN;
	public static Item GOLD_CAN;

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
	public static Item FLINT_FILLET_KNIFE;
	public static Item FOOD_FISH_FILLET_RAW;
	public static Item FOOD_FISH_FILLET_COOKED;
	public static Item FOOD_FISH_CHUNKS_RAW;
	public static Item FOOD_FISH_CHUNKS_COOKED;
	public static Item FOOD_EEL_FILLET_RAW;
	public static Item FOOD_EEL_FILLET_COOKED;

	// Craftable Food
	public static Item FOOD_CRAB_STEW;
	public static Item FOOD_SEAFOOD_SALAD;
	public static Item FOOD_SEAFOOD_SKEWER;
	public static Item FOOD_CRAB_PIE;
	public static Item FOOD_BREAD_SEAROLL;
	public static Item FOOD_FISH_AND_FRIES;
	public static Item FOOD_SUSHI_ROLL;
	public static Item FOOD_FISH_STEW;
	public static Item FOOD_CLAM_CHOWDER;
	public static Item FOOD_GRILLED_EEL_SKEWER;
	public static Item FOOD_SEA_ALGAE_CHIPS;
	public static Item FOOD_RED_ALGAE_CHIPS;
	public static Item FOOD_WHITE_ALGAE_CHIPS;
	public static Item FOOD_JERKY;
	public static Item FOOD_CANNED_FISH;
	public static Item FOOD_FISH_STICK;
	public static Item FOOD_DONBURI;
	public static Item FOOD_SEAFOOD_FRIED_RICE;
	public static Item FOOD_SEAFOOD_GUMBO;
	public static Item FOOD_ALGAE_RICE_PORRIDGE;
	public static Item FOOD_FISHBURGER;
	public static Item FOOD_RICE_CRACKER;
	public static Item FOOD_STUFFED_HALIBUT;
	public static Item FOOD_FISH_PIE;
	public static Item FOOD_SPICY_CRAB_STEW;
	public static Item FOOD_RAW_TEMPURA;
	public static Item FOOD_TEMPURA;
	public static Item FOOD_RICE_BOWL;
	public static Item FOOD_FISH_JERKY;
	public static Item FOOD_CANNED_CLAMS;
	public static Item FOOD_GOURMET_CANNED_FISH;
	// ik that's a lot of stuff

	// Chopping Boards
	public static Item ITEM_CHOPPING_BOARD;
	public static Item ITEM_DYED_CHOPPING_BOARD;

	// Tackle Boxes
	public static Item ITEM_TACKLE_BOX;
	public static Item ITEM_DYED_TACKLE_BOX;

	// Rice
	public static Item RICE_SEEDS;
	public static Item RICE;
	public static Item RICE_BALL;
	public static Item ONIGIRI;

	private static boolean hasInit = false;

	public static void Init() {
		if (!hasInit) {
			hasInit = true;
			initialID = BTFConfig.itemStart;
			initItems();
		}
	}

	private static Item food(String key, String name, int heal, int stack) {
		return new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemFood(key, itemNSID(name), newItemID(), heal, 5, false, stack));
	}

	private static Item soup(String key, String name, int heal) {
		return new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemSoup(key, itemNSID(name), newItemID(), heal, 5));
	}

	private static Item skewer(String key, String name, int heal, int stack) {
		return new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemSkewer(key, itemNSID(name), newItemID(), heal, 5, false, stack));
	}

	private static Item canned(String key, String name, int heal, int stack, Item emptyCan) {
		return new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemCannedFood(key, itemNSID(name), newItemID(), heal, stack, emptyCan));
	}

	public static String itemNSID(String string) {
		return MOD_ID + ":item/" + string;
	}

	public static void initItems() {
		// Fishing Rods
		IRON_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.iron_fishing_rod", itemNSID("iron_fishing_rod"), newItemID(), ToolMaterial.iron));
		GOLD_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.gold_fishing_rod", itemNSID("gold_fishing_rod"), newItemID(), ToolMaterial.gold));
		DIAMOND_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.diamond_fishing_rod", itemNSID("diamond_fishing_rod"), newItemID(), ToolMaterial.diamond));
		STEEL_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.steel_fishing_rod", itemNSID("steel_fishing_rod"), newItemID(), ToolMaterial.steel));
		IRIDESCITE_FISHING_ROD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new FishingRodItem("tool.iridescite_fishing_rod", itemNSID("iridescite_fishing_rod"), newItemID(), ItemMaterials.iridesciteItem));
		// Iridescite Items
		IRIDESCITE_HELMET = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ARMOR))
			.build(new ItemArmor("armor.helmet.iridescite", itemNSID("armor_helmet_iridescite"), newItemID(), ItemMaterials.IRIDESCITE, HumanArmorShape.HEAD));
		IRIDESCITE_CHESTPLATE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ARMOR))
			.build(new ItemArmor("armor.chestplate.iridescite", itemNSID("armor_chestplate_iridescite"), newItemID(), ItemMaterials.IRIDESCITE, HumanArmorShape.CHEST));
		IRIDESCITE_LEGGINGS = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ARMOR))
			.build(new ItemArmor("armor.leggings.iridescite", itemNSID("armor_leggings_iridescite"), newItemID(), ItemMaterials.IRIDESCITE, HumanArmorShape.LEGS));
		IRIDESCITE_BOOTS = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ARMOR))
			.build(new ItemArmor("armor.boots.iridescite", itemNSID("armor_boots_iridescite"), newItemID(), ItemMaterials.IRIDESCITE, HumanArmorShape.BOOTS));
		INGOT_IRIDESCITE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ORE_PRODUCTS))
			.build(new Item("ingot.iridescite", itemNSID("ingot_iridescite"), newItemID()));
		IRIDESCENT_SCALE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("iridescent.scale", itemNSID("iridescent_scale"), newItemID()));
		IRIDESCENT_CLUMP = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.ORE_PRODUCTS))
			.build(new Item("iridescent.clump", itemNSID("iridescent_clump"), newItemID()));
		// Other Items
		BROKEN_CAN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("broken.can", itemNSID("broken_can"), newItemID()));
		// Raw Fish
		FOOD_ANCHOVY_RAW = food("food.anchovy_raw", "food_anchovy_raw", 2, 8);
		FOOD_GOLDEN_CARP_RAW = food("food.golden_carp_raw", "food_golden_carp_raw", 2, 8);
		FOOD_KNIFEFISH_RAW = food("food.knifefish_raw", "food_knifefish_raw", 2, 8);
		FOOD_SARDINE_RAW = food("food.sardine_raw", "food_sardine_raw", 2, 8);
		FOOD_SUNFISH_RAW = food("food.sunfish_raw", "food_sunfish_raw", 2, 8);
		FOOD_TUNA_RAW = food("food.tuna_raw", "food_tuna_raw", 2, 8);
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
		FOOD_CATFISH_RAW = food("food.catfish_raw", "food_catfish_raw", 2, 8);
		FOOD_BOOTFISH_RAW = food("food.bootfish_raw", "food_bootfish_raw", 2, 8);
		FOOD_RED_MULLET_RAW = food("food.red_mullet_raw", "food_red_mullet_raw", 2, 8);
		FOOD_HERRING_RAW = food("food.herring_raw", "food_herring_raw", 2, 8);
		FOOD_HALIBUT_RAW = food("food.halibut_raw", "food_halibut_raw", 2, 8);
		FOOD_SEA_BASS_RAW = food("food.sea_bass_raw", "food_sea_bass_raw", 2, 8);
		FOOD_PERCH_RAW = food("food.perch_raw", "food_perch_raw", 2, 8);
		FOOD_TROUT_RAW = food("food.trout_raw", "food_trout_raw", 2, 8);
		FOOD_EEL_RAW = food("food.eel_raw", "food_eel_raw", 2, 8);
		// Fillet Knives
		WOOD_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_wood", itemNSID("knife_wood"), newItemID(), ToolMaterial.wood));
		STONE_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_stone", itemNSID("knife_stone"), newItemID(), ToolMaterial.stone));
		IRON_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_iron", itemNSID("knife_iron"), newItemID(), ToolMaterial.iron));
		GOLD_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_gold", itemNSID("knife_gold"), newItemID(), ToolMaterial.gold));
		DIAMOND_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_diamond", itemNSID("knife_diamond"), newItemID(), ToolMaterial.diamond));
		STEEL_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_steel", itemNSID("knife_steel"), newItemID(), ToolMaterial.steel));
		IRIDESCITE_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife_iridescite", itemNSID("knife_iridescite"), newItemID(), ItemMaterials.iridesciteItem));
		// Food Fillet
		FOOD_FISH_FILLET_RAW = food("food.fish_fillet_raw", "food_fish_fillet_raw", 2, 16);
		FOOD_FISH_FILLET_COOKED = food("food.fish_fillet_cooked", "food_fish_fillet_cooked", 5, 16);
		FOOD_FISH_CHUNKS_RAW = food("food.fish_chunks_raw", "food_fish_chunks_raw", 1, 16);
		FOOD_EEL_FILLET_RAW = food("food.eel_fillet_raw", "food_eel_fillet_raw", 1, 16);
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
		//Tackle boxes
		ITEM_TACKLE_BOX = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemPlaceable(
				"tackle_box",
				itemNSID("item_tackle_box"),
				newItemID(),
				BlocksList.TACKLE_BOX
			));
		ITEM_DYED_TACKLE_BOX = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(
				new CreativeInventoryPlacement.Category(
					CreativeInventoryCategory.MISC_TOOLS
				)
					.setCustomSupplier(() -> {
						List<ItemStack> variants = new ArrayList<>();

						for (DyeColor color : DyeColor.itemOrderedColors()) {
							variants.add(
								new ItemStack(
									ITEM_DYED_TACKLE_BOX,
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
					"dyed_tackle_box",
					itemNSID("item_dyed_tackle_box"),
					newItemID(),
					BlocksList.DYED_TACKLE_BOX
				)
			);
		// Cooked fish
		FOOD_ANCHOVY_COOKED = food("food.anchovy_cooked", "food_anchovy_cooked", 5, 8);
		FOOD_GOLDEN_CARP_COOKED = food("food.golden_carp_cooked", "food_golden_carp_cooked", 5, 8);
		FOOD_KNIFEFISH_COOKED = food("food.knifefish_cooked", "food_knifefish_cooked", 5, 8);
		FOOD_SARDINE_COOKED = food("food.sardine_cooked", "food_sardine_cooked", 5, 8);
		FOOD_SUNFISH_COOKED = food("food.sunfish_cooked", "food_sunfish_cooked", 5, 8);
		FOOD_TUNA_COOKED = food("food.tuna_cooked", "food_tuna_cooked", 5, 8);
		FOOD_CATFISH_COOKED = food("food.catfish_cooked", "food_catfish_cooked", 5, 8);
		FOOD_BOOTFISH_COOKED = food("food.bootfish_cooked", "food_bootfish_cooked", 5, 8);
		FOOD_RED_MULLET_COOKED = food("food.red_mullet_cooked", "food_red_mullet_cooked", 5, 8);
		FOOD_HERRING_COOKED = food("food.herring_cooked", "food_herring_cooked", 5, 8);
		FOOD_HALIBUT_COOKED = food("food.halibut_cooked", "food_halibut_cooked", 5, 8);
		FOOD_SEA_BASS_COOKED = food("food.sea_bass_cooked", "food_sea_bass_cooked", 5, 8);
		FOOD_PERCH_COOKED = food("food.perch_cooked", "food_perch_cooked", 5, 8);
		FOOD_TROUT_COOKED = food("food.trout_cooked", "food_trout_cooked", 5, 8);
		FOOD_EEL_COOKED = food("food.eel_cooked", "food_eel_cooked", 5, 8);
		FOOD_EEL_FILLET_COOKED = food("food.eel_fillet_cooked", "food_eel_fillet_cooked", 5, 16);
		FOOD_FISH_CHUNKS_COOKED = food("food.fish_chunks_cooked", "food_fish_chunks_cooked", 3, 16);
		// Iridescite tools
		IRIDESCITE_SWORD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolSword("tool.sword_iridescite", itemNSID("sword_iridescite"), newItemID(), ItemMaterials.iridesciteItem));
		IRIDESCITE_PICKAXE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolPickaxe("tool.pickaxe_iridescite", itemNSID("pickaxe_iridescite"), newItemID(), ItemMaterials.iridesciteItem));
		IRIDESCITE_AXE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolAxe("tool.axe_iridescite", itemNSID("axe_iridescite"), newItemID(), ItemMaterials.iridesciteItem));
		IRIDESCITE_SHOVEL = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolShovel("tool.shovel_iridescite", itemNSID("shovel_iridescite"), newItemID(), ItemMaterials.iridesciteItem));
		IRIDESCITE_HOE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.TOOLS))
			.build(new ItemToolHoe("tool.hoe_iridescite", itemNSID("hoe_iridescite"), newItemID(), ItemMaterials.iridesciteItem));
		GOLD_BROKEN_CAN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("gold.broken.can", itemNSID("gold_broken_can"), newItemID()));
		STEEL_BROKEN_CAN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("steel.broken.can", itemNSID("steel_broken_can"), newItemID()));
		//Other food and stuff
		FOOD_CLAM = food("food.clam", "food_clam", 2, 4);
		FOOD_CRAB = food("food.crab", "food_crab", 2, 4);
		FOOD_SHRIMP_RAW = food("food.shrimp.raw", "food_shrimp_raw", 2, 8);
		FOOD_SHRIMP_COOKED = food("food.shrimp.cooked", "food_shrimp_cooked", 5, 8);
		SEA_ALGAE = food("food.sea.algae", "food_sea_algae", 1, 8);
		RED_ALGAE = food("food.red.algae", "food_red_algae", 1, 8);
		WHITE_ALGAE = food("food.white.algae", "food_white_algae", 1, 8);
		FOOD_SEA_ALGAE_DRY = food("food.sea.algae.dry", "food_sea_algae_dry", 3, 8);
		FOOD_RED_ALGAE_DRY = food("food.red.algae.dry", "food_red_algae_dry", 3, 8);
		FOOD_WHITE_ALGAE_DRY = food("food.white.algae.dry", "food_white_algae_dry", 3, 8);
		FOOD_CRAB_STEW = soup("food.crab.stew", "food_crab_stew", 8);
		FOOD_SEAFOOD_SALAD = soup("food.seafood.salad", "food_seafood_salad", 10);
		FOOD_SEAFOOD_SKEWER = skewer("food.seafood.skewer", "food_seafood_skewer", 6, 4);
		FOOD_CRAB_PIE = soup("food.crab.pie", "food_crab_pie", 8);
		FOOD_BREAD_SEAROLL = food("food.bread.searoll", "food_bread_searoll", 8, 4);
		RICE_SEEDS = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new ItemSeeds("rice.seeds", itemNSID("rice_seeds"), newItemID(), BlocksList.CROPS_RICE));

		RICE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.FOOD))
			.build(new Item("food.rice", itemNSID("rice"), newItemID()));
		RICE_BALL = food("food.rice.ball", "food_rice_ball", 2, 16);
		ONIGIRI = food("food.onigiri", "food_onigiri", 6, 8);
		// Why is the knife here?
		FLINT_FILLET_KNIFE = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemToolKnife("tool.knife.flint", itemNSID("flint_stone"), newItemID(), ItemMaterials.flint));
		// This is a mess
		DIAMOND_FISHING_HOOK = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemFishingHook("fishing_hook.diamond", itemNSID("fishing_hook_diamond"), newItemID(), true, 0.15, 1));
		BOBBER_IRIDESCENT = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new Item("bobber.iridescent", itemNSID("bobber_iridescent"), newItemID()).setMaxStackSize(1));
		WORM = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("bait.worm", itemNSID("worm"), newItemID()));
		BOBBER_GOLD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new Item("bobber.gold", itemNSID("bobber_gold"), newItemID()).setMaxStackSize(1));
		BOBBER_OLD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("bobber.old", itemNSID("bobber_old"), newItemID()).setMaxStackSize(1));
		GOLD_FISHING_HOOK = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemFishingHook("fishing_hook.gold", itemNSID("fishing_hook_gold"), newItemID(), false, 0, 0)
				.treasureRerolls(1)
				.baitSaveChance(0.1));
		CLOVER_FISHING_HOOK = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemFishingHook("fishing_hook.clover", itemNSID("fishing_hook_clover"), newItemID(), false, 0, 0)
				.junkRerolls(1)
				.baitSaveChance(0.25));
		BOBBER_CORK = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new Item("bobber.cork", itemNSID("bobber_cork"), newItemID()).setMaxStackSize(1));
		IRON_FISHING_HOOK = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemFishingHook("fishing_hook.iron", itemNSID("fishing_hook_iron"), newItemID(), false, 0, 0)
				.catchWindow(1.15));
		IRIDESCITE_FISHING_HOOK = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new ItemFishingHook("fishing_hook.iridescite", itemNSID("fishing_hook_iridescite"), newItemID(), true, 0.15, 1)
				.junkRerolls(1)
				.treasureRerolls(1)
				.baitSaveChance(0.15));
		WINGED_BAIT = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("bait.winged", itemNSID("winged_bait"), newItemID()));
		IRIDESCITE_SHARD = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.DROPS))
			.build(new Item("shard.iridescite", itemNSID("iridescite_shard"), newItemID()));
		IRON_CAN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
			.build(new Item("can.iron", itemNSID("iron_can"), newItemID()));
		GOLD_CAN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISCELLANEOUS))
			.build(new Item("can.gold", itemNSID("gold_can"), newItemID()));
		BOBBER_PLAIN = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS))
			.build(new Item("bobber.plain", itemNSID("bobber_plain"), newItemID()).setMaxStackSize(1));

		BOBBER_DYED = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(
				new CreativeInventoryPlacement.Category(CreativeInventoryCategory.MISC_TOOLS)
					.setCustomSupplier(() -> {
						List<ItemStack> variants = new ArrayList<>();
						for (DyeColor color : DyeColor.itemOrderedColors()) {
							if (!ItemBobberDyed.isAvailable(color)) continue;
							variants.add(new ItemStack(BOBBER_DYED, 1, color.itemMeta));
						}
						return variants;
					}))
			.build(new ItemBobberDyed("bobber.dyed", itemNSID("bobber_dyed"), newItemID()));
		// More food
		FOOD_SUSHI_ROLL = food("food.sushi.roll", "food_sushi_roll", 8, 8);
		FOOD_FISH_STICK = food("food.fish.stick", "food_fish_stick", 4, 16);
		FOOD_RICE_CRACKER = food("food.rice.cracker", "food_rice_cracker", 3, 16);
		FOOD_RAW_TEMPURA = food("food.raw.tempura",  "food_raw_tempura", 2, 16);
		FOOD_TEMPURA = food("food.tempura", "food_tempura", 7, 8);
		FOOD_SEA_ALGAE_CHIPS = food("food.sea.algae.chips", "food_sea_algae_chips", 4, 16);
		FOOD_RED_ALGAE_CHIPS = food("food.red.algae.chips", "food_red_algae_chips", 4, 16);
		FOOD_WHITE_ALGAE_CHIPS = food("food.white.algae.chips", "food_white_algae_chips", 4, 16);
		FOOD_JERKY = food("food.jerky", "food_jerky", 5, 32);
		FOOD_FISH_JERKY = food("food.fish.jerky", "food_fish_jerky", 3, 32);
		FOOD_CANNED_FISH =  canned("food.canned.fish", "food_canned_fish", 7,  16, BROKEN_CAN);
		FOOD_RICE_BOWL = soup("food.rice.bowl", "food_rice_bowl", 5);
		FOOD_DONBURI = soup("food.donburi", "food_donburi", 10);
		FOOD_SEAFOOD_FRIED_RICE = soup("food.seafood.fried.rice", "food_seafood_fried_rice", 10);
		FOOD_ALGAE_RICE_PORRIDGE = soup("food.algae.rice.porridge", "food_algae_rice_porridge", 7);
		FOOD_GRILLED_EEL_SKEWER = skewer("food.grilled.eel.skewer", "food_grilled_eel_skewer", 7, 4);
		FOOD_FISH_STEW = soup("food.fish.stew", "food_fish_stew", 8);
		FOOD_SPICY_CRAB_STEW = soup("food.spicy.crab.stew", "food_spicy_crab_stew", 10);
		FOOD_CLAM_CHOWDER = soup("food.clam.chowder", "food_clam_chowder", 9);
		FOOD_STUFFED_HALIBUT = food("food.stuffed.halibut", "food_stuffed_halibut", 10, 8);
		FOOD_SEAFOOD_GUMBO = soup("food.seafood.gumbo", "food_seafood_gumbo", 12);
		FOOD_FISH_AND_FRIES = food("food.fish.and.fries", "food_fish_and_fries", 10, 8);
		FOOD_FISH_PIE = food("food.fish.pie", "food_fish_pie", 8, 4);
		FOOD_FISHBURGER = food("food.fishburger", "food_fishburger", 11, 4);
		FOOD_CANNED_CLAMS = canned("food.canned.clams", "food_canned_clams", 6,  16, BROKEN_CAN);
		FOOD_GOURMET_CANNED_FISH = canned("food.gourmet.canned.fish", "food_gourmet_canned_fish", 10, 16, GOLD_BROKEN_CAN);
	}
}
