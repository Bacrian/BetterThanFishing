package imbacrian.btf.mixins.mixin;

import imbacrian.btf.api.ITackleBoxDisplay;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import imbacrian.btf.gui.tacklebox.ScreenTackleBox;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.PlayerLocal;
import net.minecraft.core.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * Note: "mc" is @Shadow'd because it's declared directly on PlayerLocal. "inventory" lives on
 * Player (the superclass) instead - @Shadow only resolves members declared in the exact mixin
 * target, so that one's read off the cast Player reference instead (it's public, so that's fine).
 * See PlayerServerMixin for the same issue on the server side.
 */
@Mixin(value = PlayerLocal.class, remap = false)
public abstract class PlayerLocalMixin implements ITackleBoxDisplay {

	@Shadow
	protected Minecraft mc;

	@Override
	public void displayTackleBoxScreen(TileEntityTackleBox tileEntity) {
		Player self = (Player) (Object) this;
		this.mc.displayScreen(new ScreenTackleBox(self.inventory, tileEntity));
	}
}
