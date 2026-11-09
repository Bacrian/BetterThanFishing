package imbacrian.btf.items;

import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemCannedFood extends ItemFood {
	private final Item emptyCan;

	public ItemCannedFood(@NotNull String name, @NotNull String namespaceId, int id, int healAmount, int maxStackSize, @NotNull Item emptyCan) {
		super(name, namespaceId, id, healAmount, 5, false, maxStackSize);
		this.emptyCan = emptyCan;
	}

	@Nullable
	@Override
	public ItemStack onUse(@NotNull ItemStack selfStack, @NotNull World world, @NotNull Player player) {
		int before = selfStack.stackSize;
		ItemStack result = super.onUse(selfStack, world, player);

		if (selfStack.stackSize < before) {
			ItemStack can = new ItemStack(this.emptyCan, 1);
			if (selfStack.stackSize <= 0) {
				return can;
			}
			player.inventory.insertItem(can, true);
			if (can.stackSize > 0) {
				player.dropPlayerItem(can);
			}
		}
		return result;
	}
}
