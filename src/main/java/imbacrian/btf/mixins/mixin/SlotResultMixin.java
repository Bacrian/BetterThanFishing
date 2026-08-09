package imbacrian.btf.mixins.mixin;

import imbacrian.btf.api.BTFAchievements;
import imbacrian.btf.api.ICustomFishingRod;
import imbacrian.btf.items.FishingRodItem;
import imbacrian.btf.items.ItemsList;
import imbacrian.btf.mixins.accessor.SlotResultAccessor;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.player.inventory.slot.SlotResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = SlotResult.class, remap = false)
public class SlotResultMixin {
	@Inject(method = "onTake", at = @At("TAIL"))
	private void BTFAchievementInject(ItemStack itemStack, CallbackInfo ci){
		Item item = itemStack.getItem();
		if (item instanceof ICustomFishingRod || item == Items.TOOL_FISHINGROD) {
			((SlotResultAccessor) this).getThePlayer().addStat(BTFAchievements.FISHING_TIME, 1);
		}
		if (item == ItemsList.DIAMOND_FISHING_ROD) {
			((SlotResultAccessor) this).getThePlayer().addStat(BTFAchievements.MASTER_BAITER, 1);
		}
		if (item == ItemsList.INGOT_IRIDESCITE) {
			((SlotResultAccessor) this).getThePlayer().addStat(BTFAchievements.IRIDESCITE_ITEM, 1);
		}
		if (item == ItemsList.IRIDESCITE_BOOTS
			|| item == ItemsList.IRIDESCITE_LEGGINGS
			|| item == ItemsList.IRIDESCITE_CHESTPLATE
			|| item == ItemsList.IRIDESCITE_HELMET ) {
			((SlotResultAccessor) this).getThePlayer().addStat(BTFAchievements.IRIDESCITE_ARMOR, 1);
		}

	}
}
