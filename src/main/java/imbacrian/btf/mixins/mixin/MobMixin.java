package imbacrian.btf.mixins.mixin;

import imbacrian.btf.api.BTFAchievements;
import imbacrian.btf.items.ItemsList;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Mob.class, remap = false)
public class MobMixin {

	@Inject(method = "eatFood", at = @At("HEAD"))
	private void BTFRiceBallAchievement(ItemStack stack, CallbackInfo ci) {
		if ((Object) this instanceof Player player
			&& stack != null
			&& stack.getItem() == ItemsList.RICE_BALL) {
			player.triggerAchievement(BTFAchievements.RICE_BALL);
		}
	}
}
