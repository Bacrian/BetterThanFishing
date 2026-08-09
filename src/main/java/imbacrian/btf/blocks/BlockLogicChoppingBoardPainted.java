package imbacrian.btf.blocks;

import imbacrian.btf.items.ItemsList;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLogicChoppingBoardPainted extends BlockLogicChoppingBoard implements IPainted, BlockLogic.MatcherDataEquivalency {

	public BlockLogicChoppingBoardPainted(@NotNull Block<?> block) {
		super(block);
	}

	@Override
	public int getPlacedData(@Nullable Player player, @NotNull ItemStack itemStack, @NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit) {
		DyeColor color = DyeColor.colorFromItemMeta(itemStack.getMetadata());

		Direction dir = player != null
			? player.getHorizontalPlacementDirection(side)
			: Direction.SOUTH;

		return setFacingMeta(
			color.blockMeta,
			directionToMeta(dir)
		);
	}

	@Override
	public @NotNull ItemStack @Nullable [] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {
		int colorMeta = data & DyeColor.MASK_COLOR;
		DyeColor color = DyeColor.colorFromBlockMeta(colorMeta);

		return new ItemStack[]{
			new ItemStack(
				ItemsList.ITEM_DYED_CHOPPING_BOARD,
				1,
				color.itemMeta
			)
		};
	}

	@NotNull
	@Override
	public DyeColor fromMetadata(int meta) {
		return DyeColor.colorFromBlockMeta(meta & 15);
	}

	@Override
	public int toMetadata(@NotNull DyeColor color) {
		return color.blockMeta;
	}

	@Override
	public int stripColorFromMetadata(int meta) {
		return 0;
	}

	@Override
	public void removeDye(@NotNull World world, @NotNull TilePosc tilePos) {
		world.setBlockTypeNotify(tilePos, BlocksList.CHOPPING_BOARD);
	}
}
