package imbacrian.btf.gui.guidebook;

import imbacrian.btf.items.ItemsList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.guidebook.GuidebookPage;
import net.minecraft.client.gui.guidebook.GuidebookSection;
import net.minecraft.client.gui.guidebook.SearchableGuidebookSection;
import net.minecraft.core.data.registry.recipe.SearchQuery;
import net.minecraft.core.item.ItemStack;

import imbacrian.btf.api.ChoppingRegistry;
import net.minecraft.core.util.helper.DyeColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Environment(EnvType.CLIENT)
public class GuidebookSectionChopping extends SearchableGuidebookSection {
	private List<GuidebookPage> pages = null;
	private static List<ItemStack> stationStacks = null;

	@Override
	public List<GuidebookPage> getPages() {
		if (this.pages == null) {
			this.pages = new ArrayList<>();
			this.pages.add(new GuidebookPageChopping(this));
			this.pages.addAll(createRecipePages(ChoppingRegistry.getGroupedRecipes()));
		}
		return this.pages;
	}

	public GuidebookSectionChopping() {
		super("guidebook.section.chopping_board", new ItemStack(ItemsList.ITEM_CHOPPING_BOARD, 1), 13148517, 4861719);
	}

	private List<GuidebookPage> createRecipePages(List<ChoppingRegistry.ChopGroup> groups) {
		List<GuidebookPage> recipePages = new ArrayList<>();
		for (int i = 0; i < groups.size(); i += GuidebookPageChoppingRecipe.RECIPES_PER_PAGE) {
			int end = Math.min(i + GuidebookPageChoppingRecipe.RECIPES_PER_PAGE, groups.size());
			recipePages.add(new GuidebookPageChoppingRecipe(this, groups.subList(i, end)));
		}
		return recipePages;
	}

	@Override
	public List<GuidebookSection.Index> getIndices() {
		return null;
	}

	private String cachedQuery = null;
	private List<GuidebookPage> cachedPages = null;

	@Override
	public List<GuidebookPage> searchPages(SearchQuery query) {
		if (this.cachedPages != null && Objects.equals(this.cachedQuery, query.rawQuery)) {
			return this.cachedPages;
		}

		List<ChoppingRegistry.ChopGroup> matching = new ArrayList<>();
		for (ChoppingRegistry.ChopGroup group : ChoppingRegistry.getGroupedRecipes()) {
			if (matchesQuery(group, query)) {
				matching.add(group);
			}
		}

		this.cachedQuery = query.rawQuery;
		this.cachedPages = createRecipePages(matching);
		return this.cachedPages;
	}

	private static List<ItemStack> stationStacks() {
		if (stationStacks == null) {
			List<ItemStack> list = new ArrayList<>();
			list.add(new ItemStack(ItemsList.ITEM_CHOPPING_BOARD, 1));
			for (DyeColor color : DyeColor.values()) {
				list.add(new ItemStack(ItemsList.ITEM_DYED_CHOPPING_BOARD, 1, color.itemMeta));
			}
			list.add(new ItemStack(ItemsList.WOOD_FILLET_KNIFE, 1));
			list.add(new ItemStack(ItemsList.STONE_FILLET_KNIFE, 1));
			list.add(new ItemStack(ItemsList.FLINT_FILLET_KNIFE, 1));
			list.add(new ItemStack(ItemsList.IRON_FILLET_KNIFE, 1));
			list.add(new ItemStack(ItemsList.GOLD_FILLET_KNIFE, 1));
			list.add(new ItemStack(ItemsList.DIAMOND_FILLET_KNIFE, 1));
			list.add(new ItemStack(ItemsList.STEEL_FILLET_KNIFE, 1));
			list.add(new ItemStack(ItemsList.IRIDESCITE_FILLET_KNIFE, 1));
			stationStacks = list;
		}
		return stationStacks;
	}

	private static boolean matchesStation(SearchQuery query) {
		for (ItemStack stack : stationStacks()) {
			if (matchesName(stack, query)) {
				return true;
			}
		}
		return false;
	}

	private static boolean matchesQuery(ChoppingRegistry.ChopGroup group, SearchQuery query) {
		if (query.query.getLeft() != SearchQuery.QueryType.NAME) {
			return false;
		}

		boolean matchesInput = group.inputs().stream()
			.anyMatch(item -> matchesName(item.getDefaultStack(), query))
			|| matchesStation(query);
		boolean matchesOutput = matchesName(group.result().output().getDefaultStack(), query);
		switch (query.mode) {
			case RECIPE:
				return matchesOutput;
			case USAGE:
				return matchesInput;
			case ALL:
				return matchesInput || matchesOutput;
			default:
				return false;
		}
	}

	private static boolean matchesQuery(ChoppingRegistry.ChopRecipe recipe, SearchQuery query) {
		if (query.query.getLeft() != SearchQuery.QueryType.NAME) {
			return false;
		}

		boolean matchesInput = matchesName(recipe.input().getDefaultStack(), query);
		boolean matchesOutput = matchesName(recipe.result().output().getDefaultStack(), query);
		switch (query.mode) {
			case RECIPE:
				return matchesOutput;
			case USAGE:
				return matchesInput;
			case ALL:
				return matchesInput || matchesOutput;
			default:
				return false;
		}
	}

	private static boolean matchesName(ItemStack stack, SearchQuery query) {
		String itemName = stack.getDisplayName();
		String searchTerm = query.query.getRight();
		return query.strict
			? itemName.equalsIgnoreCase(searchTerm)
			: itemName.toLowerCase().contains(searchTerm.toLowerCase());
	}

	/*@Override
	public List<GuidebookSection.Index> getIndices() {
		return null;
	}*/
}
