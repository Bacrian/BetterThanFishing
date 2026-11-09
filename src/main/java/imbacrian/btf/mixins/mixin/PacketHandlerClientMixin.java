package imbacrian.btf.mixins.mixin;

import imbacrian.btf.api.ITackleBoxDisplay;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.net.handler.PacketHandlerClient;
import net.minecraft.core.net.packet.PacketContainerOpen;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = PacketHandlerClient.class, remap = false)
public abstract class PacketHandlerClientMixin {

	private static final int BTF_TACKLE_BOX_WINDOW_TYPE = 42;

	@Shadow
	private Minecraft mc;

	@Inject(method = "handleContainerOpen", at = @At("HEAD"), cancellable = true)
	private void BTFHandleTackleBoxOpen(@NotNull PacketContainerOpen packetContainerOpen, CallbackInfo ci) {
		if (packetContainerOpen.inventoryType == BTF_TACKLE_BOX_WINDOW_TYPE) {
			TileEntityTackleBox tileEntity = new TileEntityTackleBox();
			((ITackleBoxDisplay) this.mc.thePlayer).displayTackleBoxScreen(tileEntity);
			this.mc.thePlayer.containerMenu.containerId = packetContainerOpen.windowId;
			ci.cancel();
		}
	}
}
