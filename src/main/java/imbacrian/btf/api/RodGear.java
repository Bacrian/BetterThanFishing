package imbacrian.btf.api;

import com.mojang.nbt.tags.CompoundTag;
import imbacrian.btf.items.ItemFishingHook;
import net.minecraft.core.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public final class RodGear {
	public static final String TAG = "btfGear";
	public static final String HOOK = "hook";
	public static final String BAIT = "bait";
	public static final String BOBBER = "bobber";

	private RodGear() {}

	@Nullable
	public static ItemStack get(@Nullable ItemStack rod, String key) {
		if (rod == null) return null;
		CompoundTag data = rod.getData();
		if (!data.containsKey(TAG)) return null;
		CompoundTag gear = data.getCompound(TAG);
		if (!gear.containsKey(key)) return null;
		return ItemStack.readItemStackFromNbt(gear.getCompound(key));
	}

	public static void set(@Nullable ItemStack rod, String key, @Nullable ItemStack stack) {
		if (rod == null) return;
		CompoundTag data = rod.getData();
		CompoundTag gear = data.containsKey(TAG) ? data.getCompound(TAG) : new CompoundTag();
		if (stack == null || stack.stackSize <= 0) {
			gear.getValue().remove(key);
		} else {
			gear.putCompound(key, stack.writeToNBT(new CompoundTag()));
		}
		if (gear.getValue().isEmpty()) {
			data.getValue().remove(TAG);
		} else {
			data.putCompound(TAG, gear);
		}
	}

	@Nullable
	public static ItemFishingHook getHook(@Nullable ItemStack rod) {
		ItemStack hook = get(rod, HOOK);
		return hook != null && hook.getItem() instanceof ItemFishingHook h ? h : null;
	}
}
