package imbacrian.btf.mixins.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import imbacrian.btf.api.FishData;
import imbacrian.btf.api.ICustomFishingRod;
import imbacrian.btf.items.FishCategory;
import imbacrian.btf.items.FishingRodItem;
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
	private static final FishData[] FISH = {
		new FishData(Items.FOOD_FISH_RAW, 8, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_ANCHOVY_RAW, 4, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_GOLDEN_CARP_RAW, 3, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_KNIFEFISH_RAW, 4, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_SARDINE_RAW, 4, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_SUNFISH_RAW, 4, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_TUNA_RAW, 4, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_ROCKFISH, 5, false, FishCategory.JUNK),
		new FishData(ItemsList.FOOD_CATFISH_RAW, 4, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_BOOTFISH_RAW, 4, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_RED_MULLET_RAW, 5, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_HERRING_RAW, 3, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_HALIBUT_RAW, 6, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_SEA_BASS_RAW, 6, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_PERCH_RAW, 6, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_TROUT_RAW, 4, false, FishCategory.FISH),
		new FishData(ItemsList.FOOD_EEL_RAW, 5, false, FishCategory.NON_FISH),
		new FishData(ItemsList.FOOD_CLAM, 3, false, FishCategory.NON_FISH),
		new FishData(ItemsList.FOOD_CRAB, 3, false, FishCategory.NON_FISH),
		new FishData(ItemsList.FOOD_SHRIMP_RAW, 3, false, FishCategory.NON_FISH),
		new FishData(ItemsList.SEA_ALGAE, 2, false, FishCategory.NON_FISH),
		new FishData(ItemsList.RED_ALGAE, 2, false, FishCategory.NON_FISH),
		new FishData(ItemsList.WHITE_ALGAE, 2, false, FishCategory.NON_FISH),
		new FishData(ItemsList.IRIDESCENT_SCALE, 1, false, FishCategory.TREASURE),
		new FishData(ItemsList.BROKEN_CAN, 5, false, FishCategory.JUNK),
		new FishData(ItemsList.GOLD_BROKEN_CAN, 2, false, FishCategory.JUNK),
		new FishData(ItemsList.STEEL_BROKEN_CAN, 1, false, FishCategory.JUNK),
		new FishData(Items.STICK, 3, false, FishCategory.JUNK),
		new FishData(Items.STRING, 4, false, FishCategory.JUNK),
		new FishData(Items.LEATHER, 3, false, FishCategory.JUNK),
		new FishData(Items.CLOTH, 3, false, FishCategory.JUNK)
	};

	@Unique
	private FishData rollFish() {
		int totalWeight = 0;

		for (FishData fishData : FISH) {
			totalWeight += fishData.weight;
		}

		int random = (int) (Math.random() * totalWeight);

		for (FishData fishData : FISH) {
			random -= fishData.weight;

			if (random < 0) {
				return fishData;
			}
		}

		return FISH[FISH.length - 1];
	}

	@Unique
	private FishData getRandomFish(boolean treasureBoost) {
		FishData result = rollFish();

		if (treasureBoost && result.category != FishCategory.TREASURE) {
			for (int i = 0; i < TREASURE_REROLLS; i++) {
				FishData reroll = rollFish();

				if (reroll.category == FishCategory.TREASURE) {
					return reroll;
				}
			}
		}

		return result;
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
	private boolean hasMultiCatchBoost() {
		if (this.owner == null) {
			return false;
		}

		ItemStack held = this.owner.getCurrentEquippedItem();

		if (held == null) {
			return false;
		}

		Item item = held.getItem();
		return item == ItemsList.DIAMOND_FISHING_ROD || item == ItemsList.IRIDESCITE_FISHING_ROD;
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
		return getRandomFish(hasTreasureBoost()).item;
	}

	@WrapOperation(method="yoink", at =
	@At(value="INVOKE",
		target="Lnet/minecraft/core/world/World;entityJoinedWorld(Lnet/minecraft/core/entity/Entity;)Z"))
	private boolean multiFishCatch(World instance, Entity entity, Operation<Boolean> original) {
		boolean result = original.call(instance, entity);

		if (!(entity instanceof EntityItem baseDrop) || !hasMultiCatchBoost()) {
			return result;
		}

		boolean treasureBoost = hasTreasureBoost();
		double chance = EXTRA_CATCH_CHANCE;

		for (int i = 0; i < MAX_EXTRA_CATCHES && Math.random() < chance; i++) {
			FishData bonus = getRandomFish(treasureBoost);
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
