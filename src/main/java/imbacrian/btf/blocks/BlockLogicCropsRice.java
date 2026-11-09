package imbacrian.btf.blocks;

import imbacrian.btf.items.ItemsList;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLogicCropsWheat;
import net.minecraft.core.block.BlockLogicFarmland;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePos;
import net.minecraft.core.world.pos.TilePosc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockLogicCropsRice extends BlockLogicCropsWheat {

	public BlockLogicCropsRice(@NotNull Block<?> block) {
		super(block);
	}

	@Override
	public boolean canPlaceAt(@NotNull World world, @NotNull TilePosc tilePos) {
		return super.canPlaceAt(world, tilePos) && this.isFarmlandWet(world, tilePos);
	}

	@Override
	public boolean canStay(@NotNull World world, @NotNull TilePosc tilePos) {
		return super.canStay(world, tilePos);
	}

	private boolean isFarmlandWet(@NotNull World world, @NotNull TilePosc tilePos) {
		int farmlandData = world.getBlockData(tilePos.down(new TilePos()));
		return BlockLogicFarmland.isWet(farmlandData);
	}

	@NotNull
	@Override
	public ItemStack @Nullable [] getBreakResult(@NotNull World world, @NotNull EnumDropCause dropCause, int data, @Nullable TileEntity tileEntity) {
		if (data < MAX_GROWTH_STATE) {
			return new ItemStack[]{new ItemStack(ItemsList.RICE_SEEDS)};
		}

		return new ItemStack[]{
			new ItemStack(ItemsList.RICE_SEEDS, world.rand.nextInt(3) + 1),
			new ItemStack(ItemsList.RICE)
		};
	}
}
