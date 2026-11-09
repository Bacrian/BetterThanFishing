package imbacrian.btf.mixins.mixin;

import imbacrian.btf.api.ITackleBoxDisplay;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import net.minecraft.core.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(value = Player.class, remap = false)
public class PlayerMixin implements ITackleBoxDisplay {

	@Override
	public void displayTackleBoxScreen(TileEntityTackleBox tileEntity) {
	}
}
