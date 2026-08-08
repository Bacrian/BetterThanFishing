package imbacrian.btf.mixins.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import imbacrian.btf.api.ICustomFishingRod;
import imbacrian.btf.items.FishingRodItem;
import net.minecraft.core.entity.EntityFishingBobber;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;


@Mixin(EntityFishingBobber.class)
public class EntityFishingBobberMixin {
	@WrapOperation(method="tick", at =
	@At(value="INVOKE",
		target="Lnet/minecraft/core/item/ItemStack;getItem()Lnet/minecraft/core/item/Item;"))
	private Item allowCustomFishingRods(ItemStack instance, Operation<Item> original) {
		Item item = original.call(instance);

		if (item instanceof ICustomFishingRod || item instanceof FishingRodItem) {
			return Items.TOOL_FISHINGROD;
		}
		return item;
	}
}
