package imbacrian.btf.models;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.blocks.BlocksList;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import imbacrian.btf.items.BoardColor;
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
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
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

	private String getTexture(BoardColor color) {
		return TEXTURE_PATH + color.getBoardColor() + ".png";
	}

	private float getRotationFromMeta(int meta) {
		Direction dir = Direction.fromId(meta);
		if (dir == Direction.NORTH) return 180f;
		if (dir == Direction.SOUTH) return 0f;
		if (dir == Direction.WEST) return 90f;
		if (dir == Direction.EAST) return -90f;
		return 0f;
	}

	private BoardColor getBoardColor(TileEntityChoppingBoard tileEntity) {
		if (tileEntity.worldObj != null) {
			Block<?> block = tileEntity.worldObj.getBlockType(tileEntity.tilePos);
			int blockId = block == null ? 0 : block.id();
			BoardColor color = BlocksList.getColorForBlock(blockId);
			if (color != null) return color;
		}
		return tileEntity.getColor();
	}

	@Override
	public void doRender(TessellatorGeneral tessellator, TileEntityChoppingBoard tileEntity, double x, double y, double z, float partialTick) {
		StaticEntityModel boardModel = getModel();
		if (boardModel == null) {
			return;
		}

		BoardColor color = getBoardColor(tileEntity);
		int meta = tileEntity.getBlockMeta();
		float rotation = getRotationFromMeta(meta);

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

		bindTexture(getTexture(color));
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
				1,
				0,
				0f,
				light,
				partialTick

			);
		GLRenderer.disableState(State.BLEND);
		GLRenderer.popFrame();
	}
}
