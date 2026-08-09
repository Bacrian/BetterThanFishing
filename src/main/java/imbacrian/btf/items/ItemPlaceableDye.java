package imbacrian.btf.items;

import net.minecraft.core.item.ItemPlaceable;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.block.Block;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;

public class ItemPlaceableDye extends ItemPlaceable {

	public ItemPlaceableDye(
		@NotNull String translationKey,
		@NotNull String namespaceId,
		int id,
		@NotNull Block<?> blockToPlace
	) {
		super(translationKey, namespaceId, id, blockToPlace);
	}

	@Override
	public @NotNull String getLanguageKey(@NotNull ItemStack selfStack) {
		DyeColor color = DyeColor.colorFromItemMeta(selfStack.getMetadata());

		return super.getLanguageKey(selfStack) + "." + color.colorID;
	}
}
