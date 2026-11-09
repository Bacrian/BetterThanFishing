package imbacrian.btf.blocks;

import imbacrian.btf.api.ITackleBoxDisplay;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import imbacrian.btf.items.ItemsList;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Materials;
import net.minecraft.core.block.support.ISupport;
import net.minecraft.core.block.support.PartialSupport;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;

public class BlockLogicTackleBox extends BlockLogic {

	private static final int COLOR_MASK = 0x0F;
	private static final int FACING_SHIFT = 4;

	private static final double MIN_X = 0.03125, MAX_X = 0.96875;
	private static final double MIN_Z = 0.125, MAX_Z = 0.875;
	private static final double MIN_Y = 0.0, MAX_Y = 0.8125;

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
			default    -> 0;
		};
	}

	public BlockLogicTackleBox(@NotNull Block<?> block) {
		super(block, Materials.WOOD);
		block.withEntity(TileEntityTackleBox::new);
		setBlockBounds(MIN_X, MIN_Y, MIN_Z, MAX_X, MAX_Y, MAX_Z);
	}

	@Override
	public @NotNull AABBdc getBoundsFromState(@NotNull WorldSource source, @NotNull TilePosc tilePos) {
		int facing = getFacingMeta(source.getBlockData(tilePos));
		if (facing == 1 || facing == 3) {
			return new AABBd(MIN_Z, MIN_Y, MIN_X, MAX_Z, MAX_Y, MAX_X);
		}
		return new AABBd(MIN_X, MIN_Y, MIN_Z, MAX_X, MAX_Y, MAX_Z);
	}

	@NotNull
	@Override
	public ISupport getSupport(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side) {
		return PartialSupport.INSTANCE;
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
	public void onPlacedByMob(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, @NotNull Mob mob, double xHit, double yHit) {
		Direction dir = mob.getHorizontalPlacementDirection(side);
		int color = getColorMeta(world.getBlockData(tilePos));
		world.setBlockDataNotify(tilePos, setFacingMeta(color, directionToMeta(dir)));
	}

	@Override
	public void onPlacedOnSide(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit) {
		if (!side.isHorizontal()) {
			side = Side.SOUTH;
		}
		int color = getColorMeta(world.getBlockData(tilePos));
		world.setBlockDataNotify(tilePos, setFacingMeta(color, directionToMeta(side.direction())));
	}

	@Override
	public @NotNull ItemStack @Nullable [] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {
		return new ItemStack[]{ new ItemStack(ItemsList.ITEM_TACKLE_BOX, 1) };
	}

	@Override
	public boolean onInteracted(@NotNull World world, @NotNull TilePosc tilePos, @NotNull Player player, @Nullable Side side, double xHit, double yHit) {
		if (!world.isClientSide && world.getTileEntity(tilePos) instanceof TileEntityTackleBox tackleBox) {
			((ITackleBoxDisplay) player).displayTackleBoxScreen(tackleBox);
		}
		return true;
	}
}
