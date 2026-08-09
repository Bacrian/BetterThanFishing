package imbacrian.btf.blocks;

import imbacrian.btf.api.ChoppingRegistry;
import imbacrian.btf.blocks.entity.TileEntityChoppingBoard;
import imbacrian.btf.items.ItemToolKnife;
import imbacrian.btf.items.ItemsList;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLogicChoppingBoard extends BlockLogic {

	private static final int COLOR_MASK = 0x0F;
	private static final int FACING_SHIFT = 4;

	protected static int getColorMeta(int data) {
		return data & COLOR_MASK;
	}

	protected static int getFacingMeta(int data) {
		return (data >> FACING_SHIFT) & 3;
	}

	protected static int setFacingMeta(int data, int facing) {
		return (data & COLOR_MASK) | ((facing & 3) << FACING_SHIFT);
	}

	protected static int directionToMeta(Direction direction) {
		return switch (direction) {
			case NORTH -> 0;
			case EAST  -> 1;
			case SOUTH -> 2;
			case WEST  -> 3;
			default    -> 2;
		};
	}

	public BlockLogicChoppingBoard(@NotNull Block<?> block) {
		super(block, Materials.WOOD);
		block.withEntity(TileEntityChoppingBoard::new);
		setBlockBounds(0.0625,0,0.1875,0.9375,0.125,0.8125);
	}

	@Override
	public @NotNull ItemStack @Nullable [] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {

		return new ItemStack[]{
			new ItemStack(
				ItemsList.ITEM_CHOPPING_BOARD,
				1
			)
		};
	}

	@Override
	public boolean isCubeShaped() {
		return false;
	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean blocksLight() {
		return false;
	}

	@Override
	public void onPlacedByMob(@NotNull World world,@NotNull TilePosc tilePos,@NotNull Side side,@NotNull Mob mob,double xHit,double yHit) {
		Direction dir = mob.getHorizontalPlacementDirection(side);
		int data = world.getBlockData(tilePos);
		int color = getColorMeta(data);

		world.setBlockDataNotify(
			tilePos,
			setFacingMeta(color, directionToMeta(dir))
		);
	}

	@Override
	public void onPlacedOnSide(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit) {
		if (!side.isHorizontal()) {
			side = Side.SOUTH;
		}
		int data = world.getBlockData(tilePos);
		int color = getColorMeta(data);

		world.setBlockDataNotify(
			tilePos,
			setFacingMeta(color, directionToMeta(side.direction()))
		);
	}

	@Override
	public boolean onInteracted(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @Nullable Side side, double xHit, double yHit) {
		if (!(world.getTileEntity(tilePos) instanceof TileEntityChoppingBoard table)) {
			return false;
		}

		ItemStack held = player.inventory.getCurrentItem();

		if (table.isEmpty()) {
			return this.tryPlaceOnTable(world, tilePos, player, table, held);
		} else {
			return this.tryUseTable(world, tilePos, player, table, held);
		}
	}

	private boolean tryPlaceOnTable(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @NotNull TileEntityChoppingBoard table, @Nullable ItemStack held) {
		if (held == null || !ChoppingRegistry.isChoppable(held.getItem())) {
			return false;
		}

		if (!world.isClientSide) {
			table.setHeldItem(held.getItem());
			player.inventory.removeItem(player.inventory.getCurrentSlot(), 1);
		}

		return true;
	}

	private boolean tryUseTable(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @NotNull TileEntityChoppingBoard table, @Nullable ItemStack held) {
		if (held != null && held.getItem() instanceof ItemToolKnife) {
			if (!world.isClientSide) {
				ChoppingRegistry.ChopResult result = ChoppingRegistry.getResult(table.getHeldItem());
				if (result != null) {
					player.inventory.insertItem(new ItemStack(result.output().id, result.count(), 0), true);
					held.damageItem(1, player);
				}

				table.clear();
				world.playSoundAtEntity(player, player, "random.pop", 0.4F, 1.2F);
			}

			return true;
		} else if (held == null) {
			if (!world.isClientSide) {
				Item heldItem = table.getHeldItem();
				if (heldItem != null) {
					player.inventory.insertItem(new ItemStack(heldItem.id, 1, 0), true);
				}

				table.clear();
			}

			return true;
		}

		return false;
	}
}
