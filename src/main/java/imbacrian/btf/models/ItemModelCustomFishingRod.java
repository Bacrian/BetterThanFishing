package imbacrian.btf.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.item.model.ItemModelFishingRod;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class ItemModelCustomFishingRod extends ItemModelFishingRod {
	protected IconCoordinate customRodCast;

	public ItemModelCustomFishingRod(@NotNull Item item, boolean defaultTextureLookup, String castTextureNamespaceId) {
		super(item, defaultTextureLookup);
		this.customRodCast = TextureRegistry.getTexture(castTextureNamespaceId);
	}

	@Override
	public @NotNull IconCoordinate getIcon(@Nullable Entity entity, @NotNull ItemStack itemStack) {
		boolean isCast = entity instanceof Player
			&& itemStack == ((Player)entity).getHeldItem()
			&& ((Player)entity).bobberEntity != null;

		return isCast ? this.customRodCast : super.getIcon(entity, itemStack);
	}
}
