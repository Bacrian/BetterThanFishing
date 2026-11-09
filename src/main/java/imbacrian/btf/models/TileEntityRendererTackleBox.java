package imbacrian.btf.models;

import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.renderer.BlendFactor;
import net.minecraft.client.render.renderer.GLRenderer;
import net.minecraft.client.render.renderer.State;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.util.helper.DyeColor;
import org.useless.dragonfly.data.entity.mojang.EntityGeometryMojangData;
import org.useless.dragonfly.models.entity.StaticEntityModel;

@Environment(EnvType.CLIENT)
public class TileEntityRendererTackleBox extends TileEntityRenderer<TileEntityTackleBox> {
	private static final String TEXTURE_PLAIN   = "/assets/btf/textures/block/tackle_box/tackle_box.png";
	private static final String TEXTURE_BASE    = "/assets/btf/textures/block/tackle_box/tackle_box_colored.png";
	private static final String TEXTURE_OVERLAY = "/assets/btf/textures/block/tackle_box/tackle_box_colored_overlay.png";
	private static final float FRONT_OFFSET = 0f;
	private static final String GEO_ID = "geometry.tackle_box";
	private static StaticEntityModel tackleBoxModel;

	private StaticEntityModel getModel() {
		if (tackleBoxModel == null) {
			tackleBoxModel = EntityGeometryMojangData.Cache.getModel(GEO_ID, 0);
		}
		return tackleBoxModel;
	}

	private float getRotationFromMeta(int facing) {
		float base = switch (facing) {
			case 0 -> 180f;  // NORTH
			case 1 -> 90f;  // EAST
			case 2 -> 0f;    // SOUTH
			case 3 -> -90f;   // WEST
			default -> 0f;
		};
		return base + FRONT_OFFSET;
	}

	private float[] getTintColor(TileEntityTackleBox tileEntity) {
		if (tileEntity.worldObj != null) {
			Block<?> block = tileEntity.worldObj.getBlockType(tileEntity.tilePos);
			if (Block.getLogicClass(block) instanceof IPainted painted) {
				DyeColor color = painted.fromMetadata(tileEntity.getBlockMeta());
				return new float[]{
					color.color.getRed() / 255.0F,
					color.color.getGreen() / 255.0F,
					color.color.getBlue() / 255.0F
				};
			}
		}
		return new float[]{1.0F, 1.0F, 1.0F};
	}

	private boolean isPainted(TileEntityTackleBox tileEntity) {
		return tileEntity.worldObj != null
			&& Block.getLogicClass(tileEntity.worldObj.getBlockType(tileEntity.tilePos)) instanceof IPainted;
	}

	@Override
	public void doRender(TessellatorGeneral tessellator, TileEntityTackleBox tileEntity, double x, double y, double z, float partialTick) {
		StaticEntityModel model = getModel();
		if (model == null) {
			return;
		}

		int data = tileEntity.getBlockMeta();
		int facing = (data >> 4) & 3;
		float rotation = getRotationFromMeta(facing);
		boolean painted = isPainted(tileEntity);
		float[] tint = getTintColor(tileEntity);

		GLRenderer.pushFrame();

		float scale = 1.0F / 16.0F;
		GLRenderer.modelM4f().translate((float) x + 0.5F, (float) y, (float) z + 0.5F);
		GLRenderer.modelM4f().scale(scale, scale, scale);
		GLRenderer.modelM4f().translate(0.0F, -14.5F, 0.0F);
		GLRenderer.modelM4f().rotateY((float) Math.toRadians(rotation));   // <- esta línea

		GLRenderer.enableState(State.BLEND);
		GLRenderer.disableState(State.CULL_FACE);
		GLRenderer.setBlendFunc(BlendFactor.SRC_ALPHA, BlendFactor.ONE_MINUS_SRC_ALPHA);

		if (!painted) {
			GLRenderer.setColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			bindTexture(TEXTURE_PLAIN);
			model.render();
		} else {
			GLRenderer.setColor4f(tint[0], tint[1], tint[2], 1.0F);
			bindTexture(TEXTURE_BASE);
			model.render();

			GLRenderer.pushFrame();
			GLRenderer.modelM4f().translate(0.0F, 6.5F, 0.0F);
			GLRenderer.modelM4f().scale(1.002F, 1.002F, 1.002F);
			GLRenderer.modelM4f().translate(0.0F, -6.5F, 0.0F);
			GLRenderer.setColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			bindTexture(TEXTURE_OVERLAY);
			model.render();
			GLRenderer.popFrame();
		}

		GLRenderer.setColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GLRenderer.enableState(State.CULL_FACE);
		GLRenderer.disableState(State.BLEND);

		GLRenderer.popFrame();
	}
}
