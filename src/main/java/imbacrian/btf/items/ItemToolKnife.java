package imbacrian.btf.items;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemToolSword;
import org.jetbrains.annotations.NotNull;

public class ItemToolKnife extends ItemToolSword {
	private final int weaponDamage;
	private final ToolMaterial material;

	public ItemToolKnife(@NotNull String name, @NotNull String namespaceId, int id, @NotNull ToolMaterial toolMaterial) {
		super(name, namespaceId, id, toolMaterial);
		this.setMaxDamage(toolMaterial.getDurability());
		this.maxStackSize = 1;
		this.weaponDamage = 3 + toolMaterial.getDamage();
		this.material = toolMaterial;
	}

	public boolean hitEntity(@NotNull ItemStack selfStack, @NotNull Mob target, @NotNull Mob attacker) {
		selfStack.damageItem(1, attacker);
		return true;
	}
	public int getDamageVsEntity(@NotNull ItemStack selfStack, @NotNull Entity entity) {
		return this.weaponDamage;
	}

	public boolean isSilkTouch() {
		return this.material.isSilkTouch();
	}
}
