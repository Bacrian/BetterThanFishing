package imbacrian.btf.models;

import net.minecraft.client.render.item.model.ItemModelStandard;
import net.minecraft.core.item.Item;
import net.minecraft.core.util.helper.DyeColor;
import org.jetbrains.annotations.NotNull;

public class ItemModelDye extends ItemModelMetadata {

	private final String texturePrefix;

	public ItemModelDye(
		@NotNull Item item,
		@NotNull String texturePrefix
	) {
		super(item, DyeColor.COLOR_AMOUNT);

		this.texturePrefix = texturePrefix;

		for (DyeColor color : DyeColor.values()) {
			setIcon(
				color.itemMeta,
				texturePrefix + color.colorID
			);
		}
	}
}
