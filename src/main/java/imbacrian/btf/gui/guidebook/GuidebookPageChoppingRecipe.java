package imbacrian.btf.gui.guidebook;

import imbacrian.btf.api.ChoppingRegistry;
import imbacrian.btf.items.ItemsList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ItemElement;
import net.minecraft.client.gui.TooltipElement;
import net.minecraft.client.gui.guidebook.GuidebookPage;
import net.minecraft.client.gui.guidebook.GuidebookPageManager;
import net.minecraft.client.gui.guidebook.GuidebookSection;
import net.minecraft.client.gui.guidebook.GuidebookSections;
import net.minecraft.client.gui.guidebook.ScreenGuidebook;
import net.minecraft.client.gui.guidebook.SlotGuidebook;
import net.minecraft.client.gui.guidebook.search.GuidebookPageSearch;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.option.enums.DescriptionPromptEnum;
import net.minecraft.client.render.TextureManager;
import net.minecraft.client.render.font.FontRenderer;
import net.minecraft.core.data.registry.recipe.SearchQuery;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.player.inventory.slot.Slot;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class GuidebookPageChoppingRecipe extends GuidebookPage {
	public static final int RECIPES_PER_PAGE = 4;
	private static final int ROW_START_Y = 40;
	private static final int ROW_HEIGHT = 42;
	private static final Minecraft MC = Minecraft.getMinecraft();
	private static final ItemElement ITEM_ELEMENT = new ItemElement(MC);
	private static final TooltipElement TOOLTIP = new TooltipElement(MC);

	private static final List<ItemStack> KNIVES = List.of(
		new ItemStack(ItemsList.WOOD_FILLET_KNIFE, 1), new ItemStack(ItemsList.STONE_FILLET_KNIFE, 1),
		new ItemStack(ItemsList.FLINT_FILLET_KNIFE, 1), new ItemStack(ItemsList.IRON_FILLET_KNIFE, 1),
		new ItemStack(ItemsList.GOLD_FILLET_KNIFE, 1), new ItemStack(ItemsList.DIAMOND_FILLET_KNIFE, 1),
		new ItemStack(ItemsList.STEEL_FILLET_KNIFE, 1), new ItemStack(ItemsList.IRIDESCITE_FILLET_KNIFE, 1));

	private final List<ChoppingRegistry.ChopGroup> groups;
	private final ItemStack boardStack = new ItemStack(ItemsList.ITEM_CHOPPING_BOARD, 1);
	private final List<SlotGuidebook> slots = new ArrayList<>();
	private final List<List<ItemStack>> cycles = new ArrayList<>();
	private int ticks = 0;
	private int cycleIndex = 0;

	public GuidebookPageChoppingRecipe(GuidebookSection section, List<ChoppingRegistry.ChopGroup> groups) {
		super(section);
		this.groups = groups;

		for (int i = 0; i < groups.size(); i++) {
			ChoppingRegistry.ChopGroup group = groups.get(i);
			int slotY = ROW_START_Y + i * ROW_HEIGHT + 1;

			List<ItemStack> inputs = new ArrayList<>();
			for (Item item : group.inputs()) {
				inputs.add(new ItemStack(item, 1));
			}
			addSlot(11, slotY, inputs);
			addSlot(43, slotY, List.of(this.boardStack));
			addSlot(75, slotY, KNIVES);
			addSlot(131, slotY, List.of(new ItemStack(group.result().output(), group.result().count())));
		}
	}

	private void addSlot(int x, int y, List<ItemStack> items) {
		SlotGuidebook slot = new SlotGuidebook(this.slots.size(), x, y, null, true, null);
		slot.item = items.get(0);
		this.slots.add(slot);
		this.cycles.add(items);
	}

	@Override
	public void onTick() {
		this.ticks++;
		if (this.ticks >= 20) {
			this.ticks = 0;
			this.cycleIndex++;
			for (int i = 0; i < this.slots.size(); i++) {
				List<ItemStack> items = this.cycles.get(i);
				if (items.size() > 1) {
					this.slots.get(i).item = items.get(this.cycleIndex % items.size());
				}
			}
		}
	}

	private boolean isMouseOver(Slot slot, int x, int y, int mouseX, int mouseY) {
		return mouseX >= x + slot.x - 1 && mouseX < x + slot.x + 17 && mouseY >= y + slot.y - 1 && mouseY < y + slot.y + 17;
	}

	private SlotGuidebook slotUnderMouse(int x, int y, int mouseX, int mouseY) {
		SlotGuidebook found = null;
		for (SlotGuidebook slot : this.slots) {
			if (isMouseOver(slot, x, y, mouseX, mouseY)) {
				found = slot;
			}
		}
		return found;
	}

	@Override
	protected void renderForeground(TextureManager re, FontRenderer sr, int x, int y, int mouseX, int mouseY, float partialTicks) {
		I18n i18n = I18n.getInstance();
		this.drawStringNoShadow(sr, i18n.translateKey("guidebook.section.chopping_board.recipes"), x + 8, y + 8, 0);
		this.drawStringNoShadow(sr, i18n.translateKey("guidebook.section.chopping_board.recipe_hint"), x + 8, y + 18, 5263440);

		if (this.groups.isEmpty()) {
			this.drawStringCenteredNoShadow(sr, i18n.translateKey("guidebook.section.search.error.no_recipes"), x + 158 / 2, y + 220 / 2, -8355712);
		}

		SlotGuidebook over = slotUnderMouse(x, y, mouseX, mouseY);
		for (SlotGuidebook slot : this.slots) {
			this.drawSlot(x + slot.x - 1, y + slot.y - 1, -1);
			ITEM_ELEMENT.render(slot.getItemStack(), x + slot.x, y + slot.y, over == slot, slot);
		}

		for (int i = 0; i < this.groups.size(); i++) {
			int rowY = y + ROW_START_Y + i * ROW_HEIGHT;
			this.drawStringNoShadow(sr, "+", x + 32, rowY + 5, 5263440);
			this.drawStringNoShadow(sr, "+", x + 64, rowY + 5, 5263440);
		}
	}

	@Override
	protected void renderOverlay(TextureManager re, FontRenderer sr, int x, int y, int mouseX, int mouseY, float partialTicks) {
		super.renderOverlay(re, sr, x, y, mouseX, mouseY, partialTicks);
		SlotGuidebook over = slotUnderMouse(x, y, mouseX, mouseY);
		if (over != null && over.hasItem()) {
			String text = TOOLTIP.getTooltipText(over.getItemStack(), DescriptionPromptEnum.showDescription(), over);
			if (!text.isEmpty()) {
				TOOLTIP.render(text, mouseX, mouseY, 8, -8);
			}
		}
	}

	@Override
	public boolean keyTyped(char c, int key, int x, int y, int mouseX, int mouseY) {
		super.keyTyped(c, key, x, y, mouseX, mouseY);
		boolean recipe = GameSettings.KEY_SHOW_RECIPE.isKeyboardKey(key);
		boolean usage = GameSettings.KEY_SHOW_USAGE.isKeyboardKey(key);
		if (!recipe && !usage) {
			return false;
		}

		SlotGuidebook over = slotUnderMouse(x, y, mouseX, mouseY);
		if (over == null || !over.hasItem()) {
			return false;
		}

		String query = (recipe ? "r:" : "u:") + over.getItemStack().getDisplayName() + "!";
		GuidebookPageManager.searchQuery = SearchQuery.resolve(query);
		GuidebookPageSearch.searchField.setText(query);
		ScreenGuidebook.getPageManager().updatePages();
		ScreenGuidebook.getPageManager().setCurrentPage(
			ScreenGuidebook.getPageManager().getSectionIndex(GuidebookSections.CRAFTING), true);
		return true;
	}

	@Override
	protected void renderBackground(TextureManager re, int x, int y) {
		super.renderBackground(re, x, y);
		re.bindTexture(re.loadTexture("/assets/minecraft/textures/gui/container/guidebook/guidebook.png"));

		for (int i = 0; i < this.groups.size(); i++) {
			int rowY = y + ROW_START_Y + i * ROW_HEIGHT;
			this.drawTexturedModalRect(x + 100, rowY + 2, 234, 0, 22, 15);
		}
	}
}
