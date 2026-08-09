package imbacrian.btf.blocks.entity;

import com.mojang.nbt.tags.CompoundTag;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.packet.Packet;
import net.minecraft.core.net.packet.PacketTileEntityData;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TileEntityChoppingBoard extends TileEntity {
	private int heldItemId = 0;

	public boolean isEmpty() {
		return this.heldItemId == 0;
	}

	@Nullable
	public Item getHeldItem() {
		return this.heldItemId == 0 ? null : Item.itemsList[this.heldItemId];
	}

	public void setHeldItem(@NotNull Item item) {
		this.heldItemId = item.id;
		this.setChanged();
	}

	public void clear() {
		this.heldItemId = 0;
		this.setChanged();
	}

	@Override
	public void readAdditionalData(@NotNull CompoundTag compoundTag) {
		this.heldItemId = compoundTag.getInteger("HeldItem");
	}

	@Override
	public void writeAdditionalData(@NotNull CompoundTag compoundTag) {
		compoundTag.putInt("HeldItem", this.heldItemId);
	}

	@Override
	public Packet getDescriptionPacket() {
		return new PacketTileEntityData(this);
	}

	@Override
	public void dropContents(World world, int x, int y, int z) {
		super.dropContents(world, x, y, z);
		if (!this.isEmpty()) {
			double dx = x + 0.5;
			double dy = y + 0.5;
			double dz = z + 0.5;
			EntityItem entityItem = new EntityItem(world, dx, dy, dz, new ItemStack(this.heldItemId, 1, 0));
			world.entityJoinedWorld(entityItem);
			this.clear();
		}
	}
}
