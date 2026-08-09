package imbacrian.btf.items;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;

public class ItemDyeMetadata extends Item {

	private final String languagePrefix;

	public ItemDyeMetadata(
		@NotNull String languagePrefix,
		@NotNull String namespaceID,
		int id
	) {
		super(languagePrefix, namespaceID, id);
		this.languagePrefix = languagePrefix;
	}

	@Override
	public @NotNull String getLanguageKey(@NotNull ItemStack stack) {
		int metadata = stack.getMetadata() & 15;

		DyeColor color = DyeColor.colorFromItemMeta(metadata);

		return languagePrefix + "." + color.colorID;
	}
}
