package imbacrian.btf;

import imbacrian.btf.items.ItemsList;
import net.minecraft.core.block.Blocks;
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
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_OAK)
			.create("chop_board", new ItemStack(ItemsList.ITEM_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,0)
			.create("white_chop_board", new ItemStack(ItemsList.ITEM_WHITE_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,1)
			.create("orange_chop_board", new ItemStack(ItemsList.ITEM_ORANGE_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,2)
			.create("magenta_chop_board", new ItemStack(ItemsList.ITEM_MAGENTA_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,3)
			.create("lightblue_chop_board", new ItemStack(ItemsList.ITEM_LIGHTBLUE_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,4)
			.create("yellow_chop_board", new ItemStack(ItemsList.ITEM_YELLOW_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,5)
			.create("lime_chop_board", new ItemStack(ItemsList.ITEM_LIME_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,6)
			.create("pink_chop_board", new ItemStack(ItemsList.ITEM_PINK_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,7)
			.create("gray_chop_board", new ItemStack(ItemsList.ITEM_GRAY_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,8)
			.create("silver_chop_board", new ItemStack(ItemsList.ITEM_SILVER_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,9)
			.create("cyan_chop_board", new ItemStack(ItemsList.ITEM_CYAN_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,10)
			.create("purple_chop_board", new ItemStack(ItemsList.ITEM_PURPLE_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,11)
			.create("blue_chop_board", new ItemStack(ItemsList.ITEM_BLUE_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,12)
			.create("brown_chop_board", new ItemStack(ItemsList.ITEM_BROWN_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,13)
			.create("green_chop_board", new ItemStack(ItemsList.ITEM_GREEN_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,14)
			.create("red_chop_board", new ItemStack(ItemsList.ITEM_RED_CHOPPING_BOARD, 1));
		RecipeBuilder.Shaped(modId, "", "", "SSS")
			.addInput('S', Blocks.SLAB_PLANKS_PAINTED,15)
			.create("black_chop_board", new ItemStack(ItemsList.ITEM_BLACK_CHOPPING_BOARD, 1));

	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(BetterThanFishing.MOD_ID);
	}
}
