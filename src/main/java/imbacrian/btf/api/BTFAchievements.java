package imbacrian.btf.api;

import imbacrian.btf.BetterThanFishing;
import imbacrian.btf.items.ItemsList;
import net.minecraft.core.achievement.Achievement;
import net.minecraft.core.achievement.Achievements;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.collection.NamespaceID;

public class BTFAchievements {

	public static Achievement FISHING_TIME = new Achievement(
		NamespaceID.fromPool(BetterThanFishing.MOD_ID, "fishing_time"),
		"fishing_time",
		Items.TOOL_FISHINGROD,
		Achievements.BUILD_WORKBENCH
	)
		.setClientsideAchievement()
		.registerAchievement();

	public static Achievement GOT_LUCKY = new Achievement(
		NamespaceID.fromPool(BetterThanFishing.MOD_ID,"got_lucky"),
		"got_lucky",
		ItemsList.IRIDESCENT_SCALE,
		FISHING_TIME
	)
		.setType(Achievement.TYPE_SPECIAL)
		.setClientsideAchievement()
		.registerAchievement();

	public static Achievement GOD_DAMMIT = new Achievement(
		NamespaceID.fromPool(BetterThanFishing.MOD_ID,"god_dammit"),
		"god_dammit",
		ItemsList.BROKEN_CAN,
		FISHING_TIME
	)
		.setClientsideAchievement()
		.registerAchievement();

	public static Achievement IRIDESCITE_ITEM = new Achievement(
		NamespaceID.fromPool(BetterThanFishing.MOD_ID, "iridescite_item"), //Inner Value
		"iridescite_item", // lang mapping
		ItemsList.INGOT_IRIDESCITE, // Icon
		GOT_LUCKY // Parent
	)
		.setClientsideAchievement()
		.registerAchievement();
	public static Achievement MASTER_BAITER = new Achievement(
		NamespaceID.fromPool(BetterThanFishing.MOD_ID, "master_baiter"),
		"master_baiter",
		ItemsList.DIAMOND_FISHING_ROD,
		FISHING_TIME
	)
		.setType(Achievement.TYPE_SECRET)
		.setClientsideAchievement()
		.registerAchievement();

	public static Achievement IRIDESCITE_ARMOR = new Achievement(
		NamespaceID.fromPool(BetterThanFishing.MOD_ID, "iridescite_armor"),
		"iridescite_armor",
		ItemsList.IRIDESCITE_CHESTPLATE,
		IRIDESCITE_ITEM
	)
		.setType(Achievement.TYPE_SPECIAL)
		.setClientsideAchievement()
		.registerAchievement();

	public static void init(){
	}
}
