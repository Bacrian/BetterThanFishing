package imbacrian.btf.models;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.model.BlockModelEmpty;
import net.minecraft.client.render.texture.stitcher.IconCoordinate;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;

@Environment(EnvType.CLIENT)
public class BlockModelChoppingBoard<T extends BlockLogic> extends BlockModelEmpty<T> {
	private static final int COLOR_MASK = 0x0F;
	private static final String PLANKS_PATH = "minecraft:block/planks/";

	public BlockModelChoppingBoard(Block<T> block) { super(block); }

	@Override
	public IconCoordinate getParticleTexture(Side side, int meta) {
		if (Block.getLogicClass(this.block) instanceof IPainted painted) {
			DyeColor color = painted.fromMetadata(meta & COLOR_MASK);
			return TextureRegistry.getTexture(PLANKS_PATH + color.colorID);
		}
		return TextureRegistry.getTexture(PLANKS_PATH + "oak");
	}
}
