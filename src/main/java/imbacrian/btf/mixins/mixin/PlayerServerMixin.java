package imbacrian.btf.mixins.mixin;

import imbacrian.btf.api.ITackleBoxDisplay;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import imbacrian.btf.gui.tacklebox.MenuTackleBox;
import net.minecraft.core.net.packet.PacketContainerOpen;
import net.minecraft.server.entity.player.PlayerServer;
import net.minecraft.server.net.handler.PacketHandlerServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * btf: vanilla's PacketContainerOpen "inventoryType" ids only go up to 7 (see
 * PacketHandlerClient#handleContainerOpen in the client jar) - anything else just logs a
 * warning and is ignored client-side, so we pick a value well clear of that range and handle
 * it ourselves via PacketHandlerClientMixin instead of colliding with a future vanilla id.
 * <p>
 * Note: playerNetServerHandler/currentWindowId are @Shadow'd because they're declared directly
 * on PlayerServer itself. containerMenu/inventory are declared on Player (the superclass), and
 * @Shadow only resolves members declared in the exact mixin target - so those are accessed
 * directly off the cast "self" reference instead (they're public, so that's fine).
 */
@Mixin(value = PlayerServer.class, remap = false)
public abstract class PlayerServerMixin implements ITackleBoxDisplay {

	private static final int BTF_TACKLE_BOX_WINDOW_TYPE = 42;

	@Shadow
	public PacketHandlerServer playerNetServerHandler;

	@Shadow
	private int currentWindowId;

	@Override
	public void displayTackleBoxScreen(TileEntityTackleBox tileEntity) {
		PlayerServer self = (PlayerServer) (Object) this;

		this.currentWindowId = this.currentWindowId % 100 + 1;
		this.playerNetServerHandler.sendPacket(new PacketContainerOpen(
			this.currentWindowId,
			BTF_TACKLE_BOX_WINDOW_TYPE,
			tileEntity.getNameTranslationKey(),
			tileEntity.getContainerSize()
		));
		self.containerMenu.onCraftGuiClosed(self);
		self.containerMenu = new MenuTackleBox(self.inventory, tileEntity);
		self.containerMenu.containerId = this.currentWindowId;
		self.containerMenu.addSlotListener(self);
	}
}
