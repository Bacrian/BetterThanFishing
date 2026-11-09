package imbacrian.btf.mixins.mixin;

import imbacrian.btf.compat.stardew.StardewCompat;
import imbacrian.btf.items.ItemsList;
import net.minecraft.core.block.BlockLogicMud;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

@Mixin(BlockLogicMud.class)
public class BlockLogicMudMixin {

	@Unique
	private static final float WORM_CHANCE = 0.15F;

	@Shadow
	@Final
	private boolean isHardened;

	@Inject(method = "getBreakResult", at = @At("RETURN"), cancellable = true)
	private void btf$wormDrop(World world, EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity,
	                          CallbackInfoReturnable<ItemStack[]> cir) {
		if (this.isHardened) {
			return;
		}
		if (dropCause != EnumDropCause.PROPER_TOOL && dropCause != EnumDropCause.IMPROPER_TOOL) {
			return;
		}
		if (world.rand.nextFloat() >= WORM_CHANCE) {
			return;
		}

		ItemStack[] base = cir.getReturnValue();
		if (base == null) {
			base = new ItemStack[0];
		}
		ItemStack[] result = Arrays.copyOf(base, base.length + 1);
		result[base.length] = new ItemStack(StardewCompat.wormOr(ItemsList.WORM));
		cir.setReturnValue(result);
	}
}
