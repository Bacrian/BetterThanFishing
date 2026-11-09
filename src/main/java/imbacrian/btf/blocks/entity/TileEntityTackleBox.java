package imbacrian.btf.blocks.entity;

import com.mojang.nbt.tags.CompoundTag;
import com.mojang.nbt.tags.ListTag;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.packet.Packet;
import net.minecraft.core.net.packet.PacketTileEntityData;
import net.minecraft.core.player.inventory.container.Container;
import net.minecraft.core.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class TileEntityTackleBox extends TileEntity implements Container {
	public static final int STORAGE_SLOTS = 15;
	public static final int ROD_RACK_SLOTS = 10;
	public static final int SLOT_STORAGE_START = 0;
	public static final int SLOT_ROD_RACK_START = STORAGE_SLOTS;
	public static final int SLOT_ROD_ACTIVE = STORAGE_SLOTS + ROD_RACK_SLOTS;
	public static final int SLOT_BAIT = SLOT_ROD_ACTIVE + 1;
	public static final int SLOT_HOOK = SLOT_ROD_ACTIVE + 2;
	public static final int SLOT_BOBBER = SLOT_ROD_ACTIVE + 3;
	public static final int CONTAINER_SIZE = SLOT_BOBBER + 1;

	private final Random random = new Random();
	private final ItemStack[] items = new ItemStack[CONTAINER_SIZE];

	@Override
	public int getContainerSize() {
		return this.items.length;
	}

	@Nullable
	@Override
	public ItemStack getItem(int slot) {
		return this.items[slot];
	}

	@Nullable
	@Override
	public ItemStack removeItem(int slot, int takeAmount) {
		if (this.items[slot] == null) {
			return null;
		}
		if (this.items[slot].stackSize <= takeAmount) {
			ItemStack itemstack = this.items[slot];
			this.items[slot] = null;
			return itemstack;
		} else {
			ItemStack split = this.items[slot].splitStack(takeAmount);
			if (this.items[slot].stackSize <= 0) {
				this.items[slot] = null;
			}
			return split;
		}
	}

	@Override
	public void setItem(int slot, @Nullable ItemStack stack) {
		this.items[slot] = stack;
		if (stack != null && stack.stackSize > this.getMaxStackSize()) {
			stack.stackSize = this.getMaxStackSize();
		}
	}

	@NotNull
	@Override
	public String getNameTranslationKey() {
		return "container.btf.tackle_box";
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public boolean stillValid(@NotNull Player player) {
		return this.worldObj != null && this.worldObj.getTileEntity(this.tilePos.x, this.tilePos.y, this.tilePos.z) == this
			&& player.distanceToSqr(this.tilePos.x + 0.5, this.tilePos.y + 0.5, this.tilePos.z + 0.5) <= 64.0;
	}

	@Override
	public void sort() {
	}

	@Override
	public void readAdditionalData(@NotNull CompoundTag compoundTag) {
		ListTag list = compoundTag.getList("Items");
		for (int i = 0; i < this.items.length; i++) {
			this.items[i] = null;
		}
		for (int i = 0; i < list.tagCount(); i++) {
			CompoundTag itemTag = (CompoundTag) list.tagAt(i);
			int slot = itemTag.getByte("Slot") & 255;
			if (slot < this.items.length) {
				this.items[slot] = ItemStack.readItemStackFromNbt(itemTag);
			}
		}
	}

	@Override
	public void writeAdditionalData(@NotNull CompoundTag compoundTag) {
		ListTag list = new ListTag();
		for (int i = 0; i < this.items.length; i++) {
			if (this.items[i] != null) {
				CompoundTag itemTag = new CompoundTag();
				itemTag.putByte("Slot", (byte) i);
				this.items[i].writeToNBT(itemTag);
				list.addTag(itemTag);
			}
		}
		compoundTag.put("Items", list);
	}

	@Override
	public Packet getDescriptionPacket() {
		return new PacketTileEntityData(this);
	}

	@Override
	public void dropContents(World world, int x, int y, int z) {
		super.dropContents(world, x, y, z);
		for (int i = 0; i < this.getContainerSize(); i++) {
			ItemStack stack = this.getItem(i);
			if (stack != null) {
				float fx = this.random.nextFloat() * 0.8F + 0.1F;
				float fy = this.random.nextFloat() * 0.8F + 0.1F;
				float fz = this.random.nextFloat() * 0.8F + 0.1F;
				EntityItem entityItem = new EntityItem(world, x + fx, y + fy, z + fz, stack.copy());
				world.entityJoinedWorld(entityItem);
				this.setItem(i, null);
			}
		}
	}
}
