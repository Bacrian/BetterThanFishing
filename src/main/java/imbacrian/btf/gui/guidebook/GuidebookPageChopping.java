package imbacrian.btf.gui.guidebook;

import imbacrian.btf.items.ItemsList;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ItemElement;
import net.minecraft.client.gui.guidebook.GuidebookPage;
import net.minecraft.client.gui.guidebook.GuidebookSection;
import net.minecraft.client.render.TextureManager;
import net.minecraft.client.render.font.FontRenderer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.lang.I18n;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class GuidebookPageChopping extends GuidebookPage {
	private static final Minecraft mc = Minecraft.getMinecraft();
	private static final ItemElement itemElement = new ItemElement(mc);

	private final ItemStack boardStack = new ItemStack(ItemsList.ITEM_CHOPPING_BOARD, 1);
	private final ItemStack knifeStack = new ItemStack(ItemsList.IRON_FILLET_KNIFE, 1);

	public GuidebookPageChopping(GuidebookSection section) {
		super(section);
	}

	private static String[] wrapText(FontRenderer sr, String translationKey) {
		String[] words = I18n.getInstance().translateKey(translationKey).split(" ");
		List<String> lines = new ArrayList<>();
		StringBuilder line = new StringBuilder();

		for (String word : words) {
			if (sr.stringWidthDouble(line + " " + word) > 142.0) {
				lines.add(line.toString());
				line = new StringBuilder();
			}
			line.append(word).append(" ");
		}
		lines.add(line.toString());
		return lines.toArray(new String[0]);
	}

	@Override
	protected void renderForeground(TextureManager re, FontRenderer sr, int x, int y, int mouseX, int mouseY, float partialTicks) {
		I18n i18n = I18n.getInstance();

		this.drawStringNoShadow(sr, i18n.translateKey("guidebook.section.chopping_board.title"), x + 8, y + 8, 0);

		itemElement.render(this.boardStack, x + 20, y + 26);
		itemElement.render(this.knifeStack, x + 60, y + 26);

		int yOffset = y + 56;
		for (String line : wrapText(sr, "guidebook.section.chopping_board.desc")) {
			this.drawStringNoShadow(sr, line, x + 8, yOffset, 5263440);
			yOffset += 10;
		}
	}
}
