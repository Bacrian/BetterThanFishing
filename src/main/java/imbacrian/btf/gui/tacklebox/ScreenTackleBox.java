package imbacrian.btf.gui.tacklebox;

import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import net.minecraft.client.gui.container.ScreenContainerAbstract;
import net.minecraft.client.render.renderer.GLRenderer;
import net.minecraft.core.player.inventory.container.ContainerInventory;

public class ScreenTackleBox extends ScreenContainerAbstract {
	private static final String TEXTURE = "/assets/btf/textures/gui/tackle.png";

	public ScreenTackleBox(ContainerInventory inventory, TileEntityTackleBox tileEntity) {
		super(new MenuTackleBox(inventory, tileEntity));
		this.xSize = 176;
		this.ySize = 194;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTick) {
		this.mc.textureManager.loadTexture(TEXTURE).bind();
		GLRenderer.setColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		int x = (this.width - this.xSize) / 2;
		int y = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
}
