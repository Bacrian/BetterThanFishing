package imbacrian.btf.blocks;

import imbacrian.btf.items.ItemsList;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogic;
import net.minecraft.core.block.IPainted;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DyeColor;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import net.minecraft.core.util.helper.Direction;

public class BlockLogicTackleBoxPainted extends BlockLogicTackleBox implements IPainted, BlockLogic.MatcherDataEquivalency {

	public BlockLogicTackleBoxPainted(@NotNull Block<?> block) {
		super(block);
	}

	@Override
	public int getPlacedData(@Nullable Player player, @NotNull ItemStack itemStack, @NotNull World world, @NotNull TilePosc tilePos, @NotNull Side side, double xHit, double yHit) {
		DyeColor color = DyeColor.colorFromItemMeta(itemStack.getMetadata());
		Direction dir = player != null
			? player.getHorizontalPlacementDirection(side)
			: Direction.NORTH;
		return setFacingMeta(color.blockMeta, directionToMeta(dir));
	}

	@Override
	public @NotNull ItemStack @Nullable [] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {
		DyeColor color = DyeColor.colorFromBlockMeta(data & DyeColor.MASK_COLOR);
		return new ItemStack[]{
			new ItemStack(ItemsList.ITEM_DYED_TACKLE_BOX, 1, color.itemMeta)
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
		world.setBlockTypeNotify(tilePos, BlocksList.TACKLE_BOX);
	}
}
