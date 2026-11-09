package imbacrian.btf;

import imbacrian.btf.api.FishGroups;
import imbacrian.btf.compat.stardew.StardewCompat;
import imbacrian.btf.items.ItemBobberDyed;
import imbacrian.btf.items.ItemsList;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.DyeColor;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.*;

// YES, I'M GOING TO CHANGE THE RECIPE ENTRYPOINT FOR THE NEW ONE LATER SHUT UP, YOU PEOPLE
public class BTFRecipes implements RecipeEntrypoint {

	@SuppressWarnings("unchecked")
	private static void consolidateByOutput(String group, Item... outputs) {
		Set<Item> wanted = new HashSet<>(Arrays.asList(outputs));
		int count = 0;
		for (RecipeEntryCrafting<?, ?> recipe : Registries.RECIPES.getAllCraftingRecipes()) {
			ItemStack output = (ItemStack) recipe.getOutput();
			if (output != null && wanted.contains(output.getItem())) {
				recipe.consolidationGroup = group;
				count++;
			}
		}
		if (count < 2) {
			BetterThanFishing.LOGGER.warn("consolidate: group '{}' matched only {} recipe(s)", group, count);
		}
	}

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
		for (DyeColor color : DyeColor.values()) {
			String id = color.colorID + "_chop_board";
			RecipeBuilder.Shaped(modId, "", "", "SSS")
				.addInput('S', Blocks.SLAB_PLANKS_PAINTED, color.blockMeta << 4)
				.create(id, new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1, color.itemMeta));
		}
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
			.addInput("btf:algae")
			.addInput(Items.BOWL)
			.create("seafood_salad", ItemsList.FOOD_SEAFOOD_SALAD.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.FOOD_BREAD)
			.addInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.addInput("btf:algae")
			.create("bread_searoll", ItemsList.FOOD_BREAD_SEAROLL.getDefaultStack());
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_CRAB)
			.addInput(ItemsList.WHITE_ALGAE)
			.addInput(Items.BOWL)
			.create("crab_stew", ItemsList.FOOD_CRAB_STEW.getDefaultStack());
		RecipeBuilder.Shaped(modId, " D ","DCD"," D ")
			.addInput('C',ItemsList.FOOD_CRAB)
			.addInput('D',Items.DOUGH)
			.create("crab_pie", new ItemStack(ItemsList.FOOD_CRAB_PIE,4));
		// Ts is a bunch of bs tbh

		// Iridescite tools
		RecipeBuilder.Shaped(modId, "III", " S ", " S ")
			.addInput('I', ItemsList.INGOT_IRIDESCITE)
			.addInput('S', Items.STICK)
			.create("iridescite_pickaxe", new ItemStack(ItemsList.IRIDESCITE_PICKAXE, 1));
		RecipeBuilder.Shaped(modId, "II ", "IS ", " S ")
			.addInput('I', ItemsList.INGOT_IRIDESCITE)
			.addInput('S', Items.STICK)
			.create("iridescite_axe", new ItemStack(ItemsList.IRIDESCITE_AXE, 1));
		RecipeBuilder.Shaped(modId, " I ", " S ", " S ")
			.addInput('I', ItemsList.INGOT_IRIDESCITE)
			.addInput('S', Items.STICK)
			.create("iridescite_shovel", new ItemStack(ItemsList.IRIDESCITE_SHOVEL, 1));
		RecipeBuilder.Shaped(modId, "II ", " S ", " S ")
			.addInput('I', ItemsList.INGOT_IRIDESCITE)
			.addInput('S', Items.STICK)
			.create("iridescite_hoe", new ItemStack(ItemsList.IRIDESCITE_HOE, 1));
		RecipeBuilder.Shaped(modId, " I ", " I ", " S ")
			.addInput('I', ItemsList.INGOT_IRIDESCITE)
			.addInput('S', Items.STICK)
			.create("iridescite_sword", new ItemStack(ItemsList.IRIDESCITE_SWORD, 1));

		RecipeBuilder.Shaped(modId, "", " I ", "R  ")
			.addInput('R', Items.STICK)
			.addInput('I', Items.FLINT)
			.create("flint_knife", new ItemStack(ItemsList.FLINT_FILLET_KNIFE, 1));
		RecipeBuilder.Shaped(modId, " D ", "I I", " I ")
			.addInput('D', Items.DIAMOND)
			.addInput('I', Items.INGOT_IRON)
			.create("diamond_fishing_hook", new ItemStack(ItemsList.DIAMOND_FISHING_HOOK, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.IRIDESCENT_SCALE)
			.addInput(Items.STRING)
			.create("iridescent_bobber", new ItemStack(ItemsList.BOBBER_IRIDESCENT, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.INGOT_GOLD)
			.addInput(Items.STRING)
			.create("gold_bobber", new ItemStack(ItemsList.BOBBER_GOLD, 1));
		RecipeBuilder.Shaped(modId, " G ", "I I", " I ")
			.addInput('G', Items.INGOT_GOLD)
			.addInput('I', Items.INGOT_IRON)
			.create("gold_fishing_hook", new ItemStack(ItemsList.GOLD_FISHING_HOOK, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.STICK)
			.addInput(Items.STICK)
			.addInput(Items.STRING)
			.create("cork_bobber", new ItemStack(ItemsList.BOBBER_CORK, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.STRING)
			.addInput(Items.CLAY)
			.addInput(Items.DYE, DyeColor.RED.itemMeta)
			.create("plain_bobber", new ItemStack(ItemsList.BOBBER_PLAIN, 1));
		List<String> bobberIds = new ArrayList<>();
		for (DyeColor color : DyeColor.values()) {
			if (!ItemBobberDyed.isAvailable(color)) continue;
			String id = color.colorID + "_bobber";
			RecipeBuilder.Shapeless(modId)
				.addInput(ItemsList.BOBBER_PLAIN)
				.addInput(Items.DYE, color.itemMeta)
				.create(id, new ItemStack(ItemsList.BOBBER_DYED, 1, color.itemMeta));
			bobberIds.add(id);
		}
		RecipeBuilder.Shaped(modId, "III", "III", "III")
			.addInput('I', ItemsList.IRIDESCITE_SHARD)
			.create("iridescite_shards", new ItemStack(ItemsList.INGOT_IRIDESCITE, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_FISH_CHUNKS_RAW)
			.addInput(Items.FEATHER_CHICKEN)
			.create("winged_bait", new ItemStack(ItemsList.WINGED_BAIT, 2));
		RecipeBuilder.Shaped(modId, "PPP", "ISI", "PPP")
			.addInput('P', Blocks.PLANKS_OAK)
			.addInput('I', Items.INGOT_IRON)
			.addInput('S', Items.STRING)
			.create("tackle_box", new ItemStack(ItemsList.ITEM_TACKLE_BOX, 1));

		List<String> boxIds = new ArrayList<>();
		for (DyeColor color : DyeColor.values()) {
			String id = color.colorID + "_tackle_box";
			RecipeBuilder.Shapeless(modId)
				.addInput(ItemsList.ITEM_TACKLE_BOX)
				.addInput(Items.DYE, color.itemMeta)
				.create(id, new ItemStack(ItemsList.ITEM_DYED_TACKLE_BOX, 1, color.itemMeta));
			boxIds.add(id);
		}
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.INGOT_IRON)
			.create("iron_can", new ItemStack(ItemsList.IRON_CAN, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.INGOT_GOLD)
			.create("gold_can", new ItemStack(ItemsList.GOLD_CAN, 1));
		RecipeBuilder.Shaped(modId, " I ", "I I", " I ")
			.addInput('I', Items.INGOT_IRON)
			.create("iron_fishing_hook", new ItemStack(ItemsList.IRON_FISHING_HOOK, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.GOLD_FISHING_HOOK)
			.addInput(ItemsList.DIAMOND_FISHING_HOOK)
			.addInput(ItemsList.CLOVER_FISHING_HOOK)
			.addInput(ItemsList.INGOT_IRIDESCITE)
			.create("iridescite_fishing_hook", new ItemStack(ItemsList.IRIDESCITE_FISHING_HOOK, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.RICE)
			.addInput("btf:dry_algae")
			.addInput(ItemsList.FOOD_FISH_FILLET_RAW)
			.create("sushi_roll", new ItemStack(ItemsList.FOOD_SUSHI_ROLL, 2));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_FISH_CHUNKS_COOKED)
			.addInput(Items.WHEAT)
			.create("fish_stick", new ItemStack(ItemsList.FOOD_FISH_STICK, 2));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_SHRIMP_RAW)
			.addInput(Items.WHEAT)
			.create("raw_tempura", new ItemStack(ItemsList.FOOD_RAW_TEMPURA, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.IRON_CAN)
			.addInput(FishGroups.COOKED_FISH)
			.create("canned_fish", new ItemStack(ItemsList.FOOD_CANNED_FISH, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.RICE)
			.addInput(ItemsList.RICE)
			.create("rice_ball", new ItemStack(ItemsList.RICE_BALL, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.RICE_BALL)
			.addInput("btf:dry_algae")
			.create("onigiri", new ItemStack(ItemsList.ONIGIRI, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.BOWL).addInput(ItemsList.RICE).addInput(ItemsList.RICE)
			.create("rice_bowl", new ItemStack(ItemsList.FOOD_RICE_BOWL, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_RICE_BOWL)
			.addInput(ItemsList.FOOD_FISH_FILLET_COOKED)
			.addInput(Items.EGG_CHICKEN)
			.create("donburi", new ItemStack(ItemsList.FOOD_DONBURI, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.BOWL).addInput(ItemsList.RICE).addInput(ItemsList.RICE)
			.addInput(Items.EGG_CHICKEN).addInput(ItemsList.FOOD_SHRIMP_COOKED)
			.create("seafood_fried_rice", new ItemStack(ItemsList.FOOD_SEAFOOD_FRIED_RICE, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.BOWL).addInput(ItemsList.RICE).addInput(ItemsList.RICE)
			.addInput("btf:algae")
			.create("algae_rice_porridge", new ItemStack(ItemsList.FOOD_ALGAE_RICE_PORRIDGE, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_EEL_FILLET_COOKED).addInput(ItemsList.FOOD_EEL_FILLET_COOKED)
			.addInput(Items.STICK)
			.create("grilled_eel_skewer", new ItemStack(ItemsList.FOOD_GRILLED_EEL_SKEWER, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.BOWL)
			.addInput(ItemsList.FOOD_FISH_CHUNKS_COOKED).addInput(ItemsList.FOOD_FISH_CHUNKS_COOKED)
			.addInput("btf:algae")
			.create("fish_stew", new ItemStack(ItemsList.FOOD_FISH_STEW, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.BOWL)
			.addInput(ItemsList.FOOD_CRAB).addInput(ItemsList.FOOD_CRAB)
			.addInput(ItemsList.RED_ALGAE)
			.create("spicy_crab_stew", new ItemStack(ItemsList.FOOD_SPICY_CRAB_STEW, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.BOWL)
			.addInput(ItemsList.FOOD_CLAM).addInput(ItemsList.FOOD_CLAM)
			.addInput(Items.DOUGH)
			.create("clam_chowder", new ItemStack(ItemsList.FOOD_CLAM_CHOWDER, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.FOOD_HALIBUT_COOKED)
			.addInput(ItemsList.RICE)
			.addInput("btf:dry_algae")
			.create("stuffed_halibut", new ItemStack(ItemsList.FOOD_STUFFED_HALIBUT, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(Items.BOWL)
			.addInput(ItemsList.RICE).addInput(ItemsList.FOOD_SHRIMP_COOKED)
			.addInput(ItemsList.FOOD_CRAB).addInput(ItemsList.FOOD_CLAM)
			.create("seafood_gumbo", new ItemStack(ItemsList.FOOD_SEAFOOD_GUMBO, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.IRON_CAN)
			.addInput(ItemsList.FOOD_CLAM).addInput(ItemsList.FOOD_CLAM)
			.create("canned_clams", new ItemStack(ItemsList.FOOD_CANNED_CLAMS, 1));
		RecipeBuilder.Shapeless(modId)
			.addInput(ItemsList.GOLD_CAN)
			.addInput(FishGroups.COOKED_FISH)
			.addInput("btf:algae")
			.create("gourmet_canned_fish", new ItemStack(ItemsList.FOOD_GOURMET_CANNED_FISH, 1));

		consolidateByOutput("btf:chopping_board", ItemsList.ITEM_CHOPPING_BOARD, ItemsList.ITEM_DYED_CHOPPING_BOARD);
		consolidateByOutput("btf:dyed_bobber", ItemsList.BOBBER_DYED);
		consolidateByOutput("btf:tackle_box", ItemsList.ITEM_DYED_TACKLE_BOX);
		StardewCompat.registerRecipes(modId);
	}

	@Override
	public void initNamespaces() {
		RecipeBuilder.initNameSpace(BetterThanFishing.MOD_ID);
	}
}
