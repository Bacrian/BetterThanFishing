package imbacrian.btf.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelEmpty;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.util.helper.Side;

/**
 * Same idea as BlockModelChoppingBoard: the block itself renders nothing through the normal
 * block model pipeline (BlockModelEmpty) - the actual 3D look comes from
 * TileEntityRendererTackleBox instead. We only need this to supply a particle/break texture.
 * <p>
 * Unlike the chopping board, we don't have 16 separate per-color textures - the dyed variant
 * gets its color from a GL tint in the renderer instead, so the particle texture is always the
 * plain tackle_box.png regardless of color (minor visual simplification, worth revisiting if
 * you want dye-accurate break particles later).
 */
@Environment(EnvType.CLIENT)
public class BlockModelTackleBox<T extends BlockLogic> extends BlockModelEmpty<T> {
	private static final String TEXTURE = "btf:block/tackle_box/tackle_box";

	public BlockModelTackleBox(Block<T> block) {
		super(block);
	}

	@Override
	public IconCoordinate getParticleTexture(Side side, int meta) {
		return TextureRegistry.getTexture(TEXTURE);
	}
}
