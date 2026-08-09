package imbacrian.btf.mixins.mixin;

import imbacrian.btf.api.BTFAchievements;
import imbacrian.btf.items.ItemsList;
import imbacrian.btf.mixins.accessor.SlotResultAccessor;
import net.minecraft.core.achievement.Achievements;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Objects;

@Mixin(value = EntityItem.class, remap = false)
public class EntityItemMixin {

	@Inject(method = "playerTouch", at = @At("TAIL"))
	public void BTFItemAchievement(Player player, CallbackInfo ci) {
		ItemStack itemStack = ((EntityItem)(Object)this).item;
		if (itemStack != null && (Objects.equals(itemStack.getItem(), ItemsList.BROKEN_CAN)
			|| Objects.equals(itemStack.getItem(), ItemsList.GOLD_BROKEN_CAN)
			|| Objects.equals(itemStack.getItem(), ItemsList.STEEL_BROKEN_CAN))) {
			player.triggerAchievement(BTFAchievements.GOD_DAMMIT);
		}
		if (itemStack != null && (Objects.equals(itemStack.getItem(), ItemsList.IRIDESCENT_SCALE))) {
			player.triggerAchievement(BTFAchievements.GOT_LUCKY);
		}
	}
}
