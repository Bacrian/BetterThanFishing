package imbacrian.btf.models;

import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.render.item.model.ItemModelDispatcher;
import net.minecraft.client.render.renderer.BlendFactor;
import net.minecraft.client.render.renderer.GLRenderer;
import net.minecraft.client.render.renderer.State;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.DyeColor;
import org.useless.dragonfly.data.entity.mojang.EntityGeometryMojangData;
import org.useless.dragonfly.models.entity.StaticEntityModel;

@Environment(EnvType.CLIENT)
public class TileEntityRendererChoppingBoard extends TileEntityRenderer<TileEntityChoppingBoard> {
	private static final String TEXTURE_PATH = "/assets/minecraft/textures/block/planks/";
	private static final String TABLE_GEO_ID = "geometry.chopping.board";

	private static StaticEntityModel boardModel;

	private StaticEntityModel getModel() {
		if (boardModel == null) {
			boardModel = EntityGeometryMojangData.Cache.getModel(TABLE_GEO_ID, 0);
		}
		return boardModel;
	}

	private String getTexture(TileEntityChoppingBoard tileEntity) {
		if (tileEntity.worldObj != null) {
			Block<?> block = tileEntity.worldObj.getBlockType(tileEntity.tilePos);
			if (Block.getLogicClass(block) instanceof IPainted painted) {
				DyeColor color = painted.fromMetadata(tileEntity.getBlockMeta());
				return TEXTURE_PATH + color.colorID + ".png";
			}
		}
		return TEXTURE_PATH + "oak.png";
	}

	private float getRotationFromMeta(int meta) {
		if (meta == 0) return 180f;  // NORTH
		if (meta == 1) return -90f;  // EAST
		if (meta == 2) return 0f;    // SOUTH
		if (meta == 3) return 90f;   // WEST

		return 0f;
	}

	@Override
	public void doRender(TessellatorGeneral tessellator, TileEntityChoppingBoard tileEntity, double x, double y, double z, float partialTick) {
		StaticEntityModel boardModel = getModel();
		if (boardModel == null) {
			return;
		}

		int data = tileEntity.getBlockMeta();
		int facingMeta = (data >> 4) & 3;
		float rotation = getRotationFromMeta(facingMeta);

		GLRenderer.pushFrame();

		float scale = 1.0f / 16.0f;
		GLRenderer.modelM4f().translate((float) x + 0.5f, (float) y, (float) z + 0.5f);
		GLRenderer.modelM4f().scale(scale, scale, scale);
		GLRenderer.modelM4f().translate(0.0f, -13.5f, 0.0f);
		GLRenderer.modelM4f().rotateY((float)Math.toRadians(rotation));

		GLRenderer.enableState(State.BLEND);
		GLRenderer.disableState(State.CULL_FACE);
		GLRenderer.setBlendFunc(BlendFactor.SRC_ALPHA, BlendFactor.ONE_MINUS_SRC_ALPHA);
		GLRenderer.setColor4f(1.0f, 1.0f, 1.0f, 1.0f);

		bindTexture(getTexture(tileEntity));
		boardModel.render();


		GLRenderer.enableState(State.CULL_FACE);
		GLRenderer.disableState(State.BLEND);

		GLRenderer.popFrame();

		this.renderHeldItem(tessellator, tileEntity, x, y, z, partialTick);
	}

	private void renderHeldItem(TessellatorGeneral tessellator, TileEntityChoppingBoard tileEntity, double x, double y, double z, float partialTick) {
		Item heldItem = tileEntity.getHeldItem();
		if (heldItem == null || tileEntity.worldObj == null) {
			return;
		}

		int data = tileEntity.getBlockMeta();
		int facingMeta = (data >> 4) & 3;
		float rotation = getRotationFromMeta(facingMeta);

		ItemStack displayStack = new ItemStack(heldItem, 1, 0);
		byte light = tileEntity.worldObj.getLightIndex(tileEntity.tilePos, 0);

		GLRenderer.pushFrame();
		GLRenderer.modelM4f().translate((float) x + 0.5f, (float) y + 0.14f, (float) z + 0.5f);
		GLRenderer.enableState(State.BLEND);
		GLRenderer.setBlendFunc(BlendFactor.SRC_ALPHA, BlendFactor.ONE_MINUS_SRC_ALPHA);
		ItemModelDispatcher.getInstance()
			.getDispatch(heldItem)
			.renderItemEntity(
				tessellator,
				displayStack,
				GameSettings.ITEMS_3D.value,
				1, 0,
				rotation,   // <- antes era 0f
				light,
				partialTick);
		GLRenderer.disableState(State.BLEND);
		GLRenderer.popFrame();
	}
}
