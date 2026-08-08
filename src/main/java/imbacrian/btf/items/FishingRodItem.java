package imbacrian.btf.items;

import imbacrian.btf.api.ICustomFishingRod;
import imbacrian.btf.entity.EntityBTFishingBobber;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemFishingRod;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FishingRodItem extends ItemFishingRod implements ICustomFishingRod {
	public FishingRodItem(String translationKey, String namespaceId, int itemId, ToolMaterial material) {
		super(translationKey, namespaceId, itemId);
		int itemDurability = material.getDurability();
		this.setMaxDamage(itemDurability);
		this.setMaxStackSize(1);
	}

	@Nullable
	@Override
	public ItemStack onUse(@NotNull ItemStack selfStack, @NotNull World world, @NotNull Player player) {
		System.out.println("bobber = " + player.bobberEntity);
		if (player.bobberEntity != null) {
			int damage = player.bobberEntity.yoink();
			selfStack.damageItem(damage, player);
			System.out.println("Recogiendo");
		} else {
			world.playSoundAtEntity(player, player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isClientSide) {
				System.out.println("Antes");
				world.entityJoinedWorld(new EntityBTFishingBobber(world, player));
				System.out.println(EntityBTFishingBobber.class.getName());
				System.out.println("Después");
				System.out.println("Creando");
			}
		}

		player.swingItem();
		return selfStack;
	}
}
