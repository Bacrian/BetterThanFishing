package imbacrian.btf.items;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.gamemode.Gamemode;
import net.minecraft.core.player.gamemode.Gamemodes;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HarmfulFood extends ItemFood {
	public int dealDamage;
	public HarmfulFood(String name, String nsid, int id, int healAmount, int healPerTick, boolean favoriteWolfMeat, int maxStackSize, int damage) {
		super(name, nsid, id, healAmount, healPerTick, favoriteWolfMeat, maxStackSize);
		dealDamage = damage;
	}

	@Nullable
	@Override
	public ItemStack onUse(@NotNull ItemStack selfStack, @NotNull World world, @NotNull Player player) {
		if (selfStack.consumeItem(player) && player.gamemode != Gamemodes.CREATIVE) {
			player.eatFood(selfStack);
			int health = player.getHealth();
			player.setHealthRaw(health - dealDamage);
			world.playSoundAtEntity(player, player, "mob.player.neutral.hurt", 0.5F + (itemRand.nextFloat() - itemRand.nextFloat()) * 0.1F, 1.1F + (itemRand.nextFloat() - itemRand.nextFloat()) * 0.1F);
		}

		return selfStack;
	}
}
