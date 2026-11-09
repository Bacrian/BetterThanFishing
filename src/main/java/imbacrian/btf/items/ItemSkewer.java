package imbacrian.btf.items;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemSkewer extends ItemFood {
	public ItemSkewer(@NotNull String name, @NotNull String namespaceId, int id, int healAmount, int ticksPerHeal, boolean favouriteWolfMeat, int maxStackSize) {
		super(name, namespaceId, id, healAmount, ticksPerHeal, favouriteWolfMeat, maxStackSize);
	}

	public @Nullable ItemStack onUse(@NotNull ItemStack selfStack, @NotNull World world, @NotNull Player player) {
		int prevStackSize = selfStack.stackSize;
		ItemStack stack = super.onUse(selfStack, world, player);
		if (selfStack.stackSize < prevStackSize) {
			player.inventory.insertItem(Items.STICK.getDefaultStack(), false);
		}
		return stack;
	}
}
