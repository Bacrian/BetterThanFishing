package imbacrian.btf.mixins.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import imbacrian.btf.api.*;
import imbacrian.btf.compat.stardew.StardewCompat;
import imbacrian.btf.items.FishCategory;
import imbacrian.btf.api.GearEffects;
import imbacrian.btf.items.FishingRodItem;
import imbacrian.btf.items.ItemFishingHook;
import imbacrian.btf.items.ItemsList;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityFishingBobber;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.world.World;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Mixin(EntityFishingBobber.class)
public class EntityFishingBobberMixin {

	@Unique
	private static final int TREASURE_REROLLS = 2;
	@Unique
	private static final double EXTRA_CATCH_CHANCE = 0.35;
	@Unique
	private static final double EXTRA_CATCH_FALLOFF = 0.5;
	@Unique
	private static final int MAX_EXTRA_CATCHES = 3;

	@Shadow
	public Player owner;

	@Unique
	private Item btf$chosen;

	@Unique
	private boolean btf$weDecide() {
		if (!StardewCompat.isLoaded()) {
			return true;
		}
		if (((Entity) (Object) this).isInLava()) {
			return false;
		}
		ItemStack rod = this.owner == null ? null : this.owner.getCurrentEquippedItem();
		if (rod == null) {
			return false;
		}
		return rod.getItem() instanceof ICustomFishingRod || GearEffects.of(rod).affectsCatch();
	}

	@Unique
	private static List<FishData> btf$allFish;

	@Unique
	private static List<FishData> allFish() {
		final FishData[] FISH = {
			new FishData(ItemsList.FOOD_CLAM, 3, false, FishCategory.NON_FISH),
			new FishData(ItemsList.FOOD_CRAB, 3, false, FishCategory.NON_FISH),
			new FishData(ItemsList.FOOD_SHRIMP_RAW, 3, false, FishCategory.NON_FISH),
			new FishData(ItemsList.SEA_ALGAE, 2, false, FishCategory.NON_FISH),
			new FishData(ItemsList.RED_ALGAE, 2, false, FishCategory.NON_FISH),
			new FishData(ItemsList.WHITE_ALGAE, 2, false, FishCategory.NON_FISH),
			new FishData(ItemsList.IRIDESCENT_SCALE, 4, false, FishCategory.TREASURE),
			new FishData(ItemsList.BROKEN_CAN, 5, false, FishCategory.JUNK),
			new FishData(ItemsList.GOLD_BROKEN_CAN, 3, false, FishCategory.JUNK),
			new FishData(ItemsList.STEEL_BROKEN_CAN, 2, false, FishCategory.JUNK),
			new FishData(Items.STICK, 3, false, FishCategory.JUNK),
			new FishData(Items.STRING, 4, false, FishCategory.JUNK),
			new FishData(Items.LEATHER, 3, false, FishCategory.JUNK),
			new FishData(Items.CLOTH, 3, false, FishCategory.JUNK),
			new FishData(ItemsList.BOBBER_OLD, 3, false, FishCategory.JUNK),
			new FishData(ItemsList.CLOVER_FISHING_HOOK, 2, false, FishCategory.TREASURE),
			new FishData(Items.DIAMOND, 1, false, FishCategory.TREASURE),
			new FishData(Items.ARMOR_BOOTS_LEATHER, 3, false, FishCategory.JUNK),
			new FishData(Items.FEATHER_CHICKEN, 4, false, FishCategory.JUNK),
			new FishData(Items.SLIMEBALL, 2, false, FishCategory.JUNK),
			new FishData(ItemsList.IRIDESCITE_SHARD,4,false,FishCategory.TREASURE)
		};

		if (btf$allFish == null) {
			List<FishData> all = new ArrayList<>(Arrays.asList(FISH));
			all.addAll(FishRegistry.tableEntries());
			all.addAll(FishRegistry.extras());
			btf$allFish = all;
		}
		return btf$allFish;
	}

	@Unique
	private boolean hasTreasureBoost() {
		if (this.owner == null) {
			return false;
		}

		ItemStack held = this.owner.getCurrentEquippedItem();

		if (held == null) {
			return false;
		}

		Item item = held.getItem();
		return item == ItemsList.GOLD_FISHING_ROD || item == ItemsList.IRIDESCITE_FISHING_ROD;
	}

	@Unique
	private boolean rodIsMultiCatch() {
		if (this.owner == null) return false;
		ItemStack held = this.owner.getCurrentEquippedItem();
		if (held == null) return false;
		Item item = held.getItem();
		return item == ItemsList.DIAMOND_FISHING_ROD || item == ItemsList.IRIDESCITE_FISHING_ROD;
	}

	@Unique
	private GearEffects gear() {
		return this.owner == null ? GearEffects.NONE : GearEffects.of(this.owner.getCurrentEquippedItem());
	}

	@Unique
	private FishData rollFish(GearEffects gear) {
		List<FishData> table = allFish();

		double total = 0;
		for (FishData f : table) {
			total += f.weight * gear.weightMultiplier(f.category, f.item);
		}

		double roll = Math.random() * total;
		for (FishData f : table) {
			roll -= f.weight * gear.weightMultiplier(f.category, f.item);
			if (roll < 0) return f;
		}
		return table.get(table.size() - 1);
	}

	@Unique
	private FishData getRandomFish(GearEffects gear) {
		FishData result = rollFish(gear);

		// Treasure reroll: From the fishing rod (gold, iridescite) plus the hook.
		int treasureRerolls = (hasTreasureBoost() ? TREASURE_REROLLS : 0) + gear.extraTreasureRerolls();
		if (result.category != FishCategory.TREASURE) {
			for (int i = 0; i < treasureRerolls; i++) {
				FishData reroll = rollFish(gear);
				if (reroll.category == FishCategory.TREASURE) {
					return reroll;
				}
			}
		}

		// Trash reroll
		if (result.category == FishCategory.JUNK) {
			for (int i = 0; i < gear.junkRerolls(); i++) {
				FishData reroll = rollFish(gear);
				if (reroll.category != FishCategory.JUNK) {
					return reroll;
				}
			}
		}

		return result;
	}

	@WrapOperation(method="tick", at =
	@At(value="INVOKE",
		target="Lnet/minecraft/core/item/ItemStack;getItem()Lnet/minecraft/core/item/Item;"))
	private Item allowCustomFishingRods(ItemStack instance, Operation<Item> original) {
		Item item = original.call(instance);

		if (item instanceof ICustomFishingRod || item instanceof FishingRodItem) {
			return Items.TOOL_FISHINGROD;
		}
		return item;
	}

	@WrapOperation(method="yoink", at =
	@At(value="FIELD",
		target="Lnet/minecraft/core/item/Items;FOOD_FISH_RAW:Lnet/minecraft/core/item/Item;",
		opcode=Opcodes.GETSTATIC))
	private Item customFishLootTable(Operation<Item> original) {
		if (!btf$weDecide()) {
			return original.call();
		}

		GearEffects gear = gear();
		Item fish = getRandomFish(gear).item;
		this.btf$chosen = fish;
		if (this.owner != null && Math.random() >= gear.baitSaveChance()) {
			ItemStack rod = this.owner.getCurrentEquippedItem();
			BaitRegistry.consumeOne(rod);
			RodGearSync.markDirty(this.owner, rod);
		}
		return fish;
	}

	@WrapOperation(method = "tick", at = @At(value = "INVOKE", target = "Ljava/util/Random;nextInt(I)I"))
	private int btf$gearRolls(Random instance, int bound, Operation<Integer> original) {
		if (bound > 30) { // bite throw
			double m = gear().biteTimeMultiplier();
			if (m != 1.0) {
				bound = Math.max(1, (int) Math.round(bound * m));
			}
			return original.call(instance, bound);
		}

		int roll = original.call(instance, bound);
		if (bound == 30) { // Capture window: ticksCatchable = roll + 10
			double m = gear().catchWindowMultiplier();
			if (m != 1.0) {
				roll = Math.max(0, (int) Math.round((roll + 10) * m) - 10);
			}
		}
		return roll;
	}

	@WrapOperation(method="yoink", at =
	@At(value="INVOKE",
		target="Lnet/minecraft/core/world/World;entityJoinedWorld(Lnet/minecraft/core/entity/Entity;)Z"))
	private boolean multiFishCatch(World instance, Entity entity, Operation<Boolean> original) {
		if (!(entity instanceof EntityItem baseDrop)) {
			return original.call(instance, entity);
		}
		if (this.btf$chosen != null && baseDrop.item != null && baseDrop.item.getItem() != this.btf$chosen) {
			baseDrop.item = new ItemStack(this.btf$chosen);
		}

		boolean result = original.call(instance, entity);
		if (!btf$weDecide()) return result;

		GearEffects gear = gear();
		ItemFishingHook hook = gear.hook();
		boolean rodMulti = rodIsMultiCatch();
		if (!rodMulti && (hook == null || !hook.grantsMultiCatch)) return result;

		double chance = EXTRA_CATCH_CHANCE;
		int maxExtra = MAX_EXTRA_CATCHES;
		if (rodMulti && hook != null) {
			chance += hook.extraCatchChanceBonus;
			maxExtra += hook.extraMaxCatches;
		}

		for (int i = 0; i < maxExtra && Math.random() < chance; i++) {
			FishData bonus = getRandomFish(gear);
			EntityItem extraDrop = new EntityItem(instance, baseDrop.x, baseDrop.y, baseDrop.z, new ItemStack(bonus.item));
			extraDrop.xd = baseDrop.xd + (Math.random() - Math.random()) * 0.05;
			extraDrop.yd = baseDrop.yd;
			extraDrop.zd = baseDrop.zd + (Math.random() - Math.random()) * 0.05;
			instance.entityJoinedWorld(extraDrop);
			chance *= EXTRA_CATCH_FALLOFF;
		}
		return result;
	}
}
