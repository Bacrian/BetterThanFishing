package imbacrian.btf.items;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;

public class ItemBobberDyed extends Item {
	public ItemBobberDyed(String translationKey, String namespaceId, int itemId) {
		super(translationKey, namespaceId, itemId);
		this.setMaxStackSize(1);
	}

	public static boolean isAvailable(DyeColor color) {
		return color != DyeColor.RED;
	}

	@Override
	public String getLanguageKey(@NotNull ItemStack selfStack) {
		return super.getKey() + "." + DyeColor.colorFromItemMeta(selfStack.getMetadata()).colorID;
	}
}
