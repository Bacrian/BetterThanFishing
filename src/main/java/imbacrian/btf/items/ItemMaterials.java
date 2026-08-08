package imbacrian.btf.items;

import imbacrian.btf.BetterThanFishing;
import net.minecraft.core.item.material.ArmorMaterial;
import net.minecraft.core.item.material.ToolMaterial;
import turniplabs.halplibe.helper.ArmorHelper;

public class ItemMaterials {
	public static final ArmorMaterial IRIDESCITE = ArmorHelper.createArmorMaterial(
		BetterThanFishing.MOD_ID,
		"iridescite",
		850,
		1.0f,
		1.0f,
		1.0f,
		1.0f
	);
	public static final ToolMaterial iridesciteItem = new ToolMaterial()
		.setDurability(850)
		.setEfficiency(8.0F, 13.0F)
		.setMiningLevel(3)
		.setDamage(2)
		.setBlockHitDelay(4);
}
