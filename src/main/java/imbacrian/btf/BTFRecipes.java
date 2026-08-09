package imbacrian.btf;

import imbacrian.btf.items.ItemsList;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class BTFRecipes implements RecipeEntrypoint {

	@Override
	public void onRecipesReady() {
		String modId = BetterThanFishing.MOD_ID;

		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_ROCKFISH)
			.create("rocks_from_fish", Items.AMMO_PEBBLE.getDefaultStack());
		RecipeBuilder.Shaped(modId, " C ","CIC"," C ")
			.addInput('C', ItemsList.IRIDESCENT_CLUMP)
			.addInput('I', Items.INGOT_IRON)
			.create("iridescent_ingot", new ItemStack(ItemsList.INGOT_IRIDESCITE, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.INGOT_IRIDESCITE)
			.addInput(ItemsList.INGOT_IRIDESCITE)
			.addInput(Items.ARMOR_BOOTS_IRON)
			.create("iridescite_boots", ItemsList.IRIDESCITE_BOOTS.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.INGOT_IRIDESCITE)
			.addInput(ItemsList.INGOT_IRIDESCITE)
			.addInput(Items.ARMOR_LEGGINGS_IRON)
			.create("iridescite_leggings", ItemsList.IRIDESCITE_LEGGINGS.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.INGOT_IRIDESCITE)
			.addInput(ItemsList.INGOT_IRIDESCITE)
			.addInput(Items.ARMOR_CHESTPLATE_IRON)
			.create("iridescite_chestplate", ItemsList.IRIDESCITE_CHESTPLATE.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.INGOT_IRIDESCITE)
			.addInput(ItemsList.INGOT_IRIDESCITE)
			.addInput(Items.ARMOR_HELMET_IRON)
			.create("iridescite_helmet", ItemsList.IRIDESCITE_HELMET.getDefaultStack());
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_OAK)
			.create("chop_board", new ItemStack(ItemsList.ITEM_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,0)
			.create("white_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,0));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,16)
			.create("orange_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,32)
			.create("magenta_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,2));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,48)
			.create("lightblue_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,3));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,64)
			.create("yellow_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,4));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,80)
			.create("lime_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,5));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,96)
			.create("pink_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,6));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,112)
			.create("gray_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,7));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,128)
			.create("silver_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,8));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,144)
			.create("cyan_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,9));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,160)
			.create("purple_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,10));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,176)
			.create("blue_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,11));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,192)
			.create("brown_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,12));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,208)
			.create("green_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,13));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,224)
			.create("red_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,14));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,240)
			.create("black_chop_board", new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1,15));
		RecipeBuilder.Shaped(modId,"  I"," RS","I S")
			.addInput('R', Items.STICK)
			.addInput('I', Items.INGOT_IRON)
			.addInput('S', Items.STRING)
			.create("iron_fishing_rod", new ItemStack(ItemsList.IRON_FISHING_ROD,1));
		RecipeBuilder.Shaped(modId,"  I"," RS","I S")
			.addInput('R', Items.STICK)
			.addInput('I', Items.INGOT_GOLD)
			.addInput('S', Items.STRING)
			.create("gold_fishing_rod", new ItemStack(ItemsList.GOLD_FISHING_ROD,1));
		RecipeBuilder.Shaped(modId,"  I"," RS","I S")
			.addInput('R', Items.STICK)
			.addInput('I', Items.DIAMOND)
			.addInput('S', Items.STRING)
			.create("diamond_fishing_rod", new ItemStack(ItemsList.DIAMOND_FISHING_ROD,1));
		RecipeBuilder.Shaped(modId,"  I"," RS","I S")
			.addInput('R', Items.STICK)
			.addInput('I', Items.INGOT_STEEL)
			.addInput('S', Items.STRING)
			.create("steel_fishing_rod", new ItemStack(ItemsList.STEEL_FISHING_ROD,1));
		RecipeBuilder.Shaped(modId,"  I"," RS","I S")
			.addInput('R', Items.STICK)
			.addInput('I', ItemsList.INGOT_IRIDESCITE)
			.addInput('S', Items.STRING)
			.create("iridescite_fishing_rod", new ItemStack(ItemsList.IRIDESCITE_FISHING_ROD,1));
		RecipeBuilder.Shaped(modId,""," I ","R  ")
			.addInput('R', Items.STICK)
			.addInput('I', Blocks.PLANKS_OAK)
			.create("wood_knife", new ItemStack(ItemsList.WOOD_FILLET_KNIFE,1));
		RecipeBuilder.Shaped(modId,""," I ","R  ")
			.addInput('R', Items.STICK)
			.addInput('I', Blocks.COBBLE_STONE)
			.create("stone_knife", new ItemStack(ItemsList.STONE_FILLET_KNIFE,1));
		RecipeBuilder.Shaped(modId,""," I ","R  ")
			.addInput('R', Items.STICK)
			.addInput('I', Items.INGOT_IRON)
			.create("iron_knife", new ItemStack(ItemsList.IRON_FILLET_KNIFE,1));
		RecipeBuilder.Shaped(modId,""," I ","R  ")
			.addInput('R', Items.STICK)
			.addInput('I', Items.INGOT_GOLD)
			.create("gold_knife", new ItemStack(ItemsList.GOLD_FILLET_KNIFE,1));
		RecipeBuilder.Shaped(modId,""," I ","R  ")
			.addInput('R', Items.STICK)
			.addInput('I', Items.DIAMOND)
			.create("diamond_knife", new ItemStack(ItemsList.DIAMOND_FILLET_KNIFE,1));
		RecipeBuilder.Shaped(modId,""," I ","R  ")
			.addInput('R', Items.STICK)
			.addInput('I', Items.INGOT_STEEL)
			.create("steel_knife", new ItemStack(ItemsList.STEEL_FILLET_KNIFE,1));
		RecipeBuilder.Shaped(modId,""," I ","R  ")
			.addInput('R', Items.STICK)
			.addInput('I', ItemsList.INGOT_IRIDESCITE)
			.create("iridescite_knife", new ItemStack(ItemsList.IRIDESCITE_FILLET_KNIFE,1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_FISH_CHUNKS_COOKED)
			.addInput(ItemsList.FOOD_SHRIMP_COOKED)
			.addInput(Items.STICK)
			.create("seafood_skewer", ItemsList.FOOD_SEAFOOD_SKEWER.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.addInput(ItemsList.FOOD_SHRIMP_COOKED)
			.addInput(ItemsList.SEA_ALGAE)
			.addInput(Items.BOWL)
			.create("seafood_salad", ItemsList.FOOD_SEAFOOD_SALAD.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.addInput(ItemsList.FOOD_SHRIMP_COOKED)
			.addInput(ItemsList.RED_ALGAE)
			.addInput(Items.BOWL)
			.create("seafood_salad_red", ItemsList.FOOD_SEAFOOD_SALAD.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.addInput(ItemsList.FOOD_SHRIMP_COOKED)
			.addInput(ItemsList.WHITE_ALGAE)
			.addInput(Items.BOWL)
			.create("seafood_salad_white", ItemsList.FOOD_SEAFOOD_SALAD.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_CRAB)
			.addInput(ItemsList.WHITE_ALGAE)
			.addInput(Items.BOWL)
			.create("crab_stew", ItemsList.FOOD_CRAB_STEW.getDefaultStack());
		RecipeBuilder.Shaped(modId, " D ","DCD"," D ")
			.addInput('C',ItemsList.FOOD_CRAB)
			.addInput('D',Items.DOUGH)
			.create("crab_pie", new ItemStack(ItemsList.FOOD_CRAB_PIE,4));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.FOOD_BREAD)
			.addInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.addInput(ItemsList.SEA_ALGAE)
			.create("bread_searoll", ItemsList.FOOD_BREAD_SEAROLL.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.FOOD_BREAD)
			.addInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.addInput(ItemsList.RED_ALGAE)
			.create("bread_searoll_red", ItemsList.FOOD_BREAD_SEAROLL.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.FOOD_BREAD)
			.addInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.addInput(ItemsList.WHITE_ALGAE)
			.create("bread_searoll_white", ItemsList.FOOD_BREAD_SEAROLL.getDefaultStack());
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(BetterThanFishing.MOD_ID);
	}
}
