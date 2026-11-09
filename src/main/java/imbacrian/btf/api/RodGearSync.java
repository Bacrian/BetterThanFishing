package imbacrian.btf.api;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.menu.MenuAbstract;

public final class RodGearSync {
	private RodGearSync() {}

	private static boolean isServer(Player player) {
		return player != null && player.world != null && !player.world.isClientSide;
	}

	public static void markDirty(Player player, ItemStack rod) {
		if (!isServer(player) || rod == null) return;
		invalidate(player.inventoryMenu, rod);
		if (player.containerMenu != player.inventoryMenu) {
			invalidate(player.containerMenu, rod);
		}
	}

	private static void invalidate(MenuAbstract menu, ItemStack rod) {
		if (menu == null) return;
		for (int i = 0; i < menu.slots.size(); i++) {
			if (menu.slots.get(i).getItemStack() == rod) {
				menu.lastSlots.set(i, null);
			}
		}
	}
}
