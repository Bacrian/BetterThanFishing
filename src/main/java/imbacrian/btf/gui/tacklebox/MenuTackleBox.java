package imbacrian.btf.gui.tacklebox;

import imbacrian.btf.api.BaitRegistry;
import imbacrian.btf.api.BobberRegistry;
import imbacrian.btf.api.RodGearSync;
import imbacrian.btf.blocks.entity.TileEntityTackleBox;
import imbacrian.btf.items.ItemFishingHook;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.player.inventory.container.ContainerInventory;
import net.minecraft.core.player.inventory.menu.MenuAbstract;
import net.minecraft.core.player.inventory.slot.Slot;
import org.jetbrains.annotations.NotNull;

public class MenuTackleBox extends MenuAbstract {
	private static final int GRID_STEP = 18;
	private static final int STORAGE_ORIGIN_X = 8;
	private static final int STORAGE_ORIGIN_Y = 16;
	private static final int ROD_RACK_ORIGIN_X = 65;
	private static final int PLAYER_INV_ORIGIN_Y = 110;
	private static final int PLAYER_HOTBAR_Y = 168;
	public static final int PLAYER_INV_START = TileEntityTackleBox.CONTAINER_SIZE;
	private static final int STORAGE_START = TileEntityTackleBox.SLOT_STORAGE_START;
	private static final int STORAGE_COUNT = TileEntityTackleBox.SLOT_ROD_RACK_START - STORAGE_START;
	private static final int RACK_START = TileEntityTackleBox.SLOT_ROD_RACK_START;
	private static final int RACK_COUNT = TileEntityTackleBox.SLOT_ROD_ACTIVE - RACK_START;
	private static final int PLAYER_HOTBAR_START = PLAYER_INV_START + 27;
	private static final int GEAR_START = TileEntityTackleBox.SLOT_ROD_ACTIVE + 1;

	public final TileEntityTackleBox tackleBox;
	private final RodGearContainer gear;


	public MenuTackleBox(ContainerInventory inventory, TileEntityTackleBox tileEntity) {
		this.tackleBox = tileEntity;
		this.gear = new RodGearContainer(tileEntity);

		// General storage: 3 columns x 5 rows
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 3; col++) {
				this.addSlot(new Slot(
					tileEntity,
					TileEntityTackleBox.SLOT_STORAGE_START + row * 3 + col,
					STORAGE_ORIGIN_X + col * GRID_STEP,
					STORAGE_ORIGIN_Y + row * GRID_STEP
				));
			}
		}

		// Rod & gear rack: 2 columns x 5 rows
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 2; col++) {
				this.addSlot(new SlotRodAccessory(
					tileEntity,
					TileEntityTackleBox.SLOT_ROD_RACK_START + row * 2 + col,
					ROD_RACK_ORIGIN_X + col * GRID_STEP,
					STORAGE_ORIGIN_Y + row * GRID_STEP
				));
			}
		}

		// Customization slots
		this.addSlot(new SlotFishingRod(tileEntity, TileEntityTackleBox.SLOT_ROD_ACTIVE, 129, 16));
		this.addSlot(new SlotRodGear(gear, RodGearContainer.BAIT, 108, 61, s -> BaitRegistry.isBait(s.getItem())));
		this.addSlot(new SlotRodGear(gear, RodGearContainer.HOOK,   151, 61, s -> s.getItem() instanceof ItemFishingHook));
		this.addSlot(new SlotRodGear(gear, RodGearContainer.BOBBER, 129, 88, s -> BobberRegistry.isBobber(s.getItem())));

		// Player inventory (3 rows)
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				this.addSlot(new Slot(inventory, col + row * 9 + 9, STORAGE_ORIGIN_X + col * GRID_STEP, PLAYER_INV_ORIGIN_Y + row * GRID_STEP));
			}
		}

		// Hotbar
		for (int col = 0; col < 9; col++) {
			this.addSlot(new Slot(inventory, col, STORAGE_ORIGIN_X + col * GRID_STEP, PLAYER_HOTBAR_Y));
		}
	}

	@Override
	public boolean stillValid(@NotNull Player player) {
		return this.tackleBox.stillValid(player);
	}

	@Override
	public IntList getMoveSlots(@NotNull InventoryAction action, @NotNull Slot slot, int target, Player player) {
		if (slot.index >= PLAYER_INV_START) {
			if (action == InventoryAction.MOVE_ALL) {
				return slot.index < PLAYER_HOTBAR_START
					? this.getSlots(PLAYER_INV_START, 27, false)
					: this.getSlots(PLAYER_HOTBAR_START, 9, false);
			}
			return this.getSlots(PLAYER_INV_START, 36, false);
		}
		if (slot.index < RACK_START) {
			return this.getSlots(STORAGE_START, STORAGE_COUNT, false);
		}
		if (slot.index < TileEntityTackleBox.SLOT_ROD_ACTIVE) {
			return this.getSlots(RACK_START, RACK_COUNT, false);
		}
		return this.getSlots(slot.index, 1, false);
	}

	@Override
	public void onCraftGuiClosed(@NotNull Player player) {
		super.onCraftGuiClosed(player);
		this.gear.flush();
		this.tackleBox.setChanged();
	}

	@Override
	public IntList getTargetSlots(@NotNull InventoryAction action, @NotNull Slot slot, int target, Player player) {
		if (slot.index >= PLAYER_INV_START) {
			// 1) Fishing Rod Gear, 2) Extra Gear Storage, 3) Misc. Storage
			IntList targets = this.getSlots(GEAR_START, 3, false);
			this.getSlots(targets, RACK_START, RACK_COUNT, false);
			this.getSlots(targets, STORAGE_START, STORAGE_COUNT, false);
			return targets;
		}
		return this.getSlots(PLAYER_INV_START, 36, false);
	}
}
