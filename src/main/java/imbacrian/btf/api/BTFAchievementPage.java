package imbacrian.btf.api;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.achievements.data.AchievementPage;
import net.minecraft.client.gui.achievements.data.AchievementPages;

@Environment(EnvType.CLIENT)
public class BTFAchievementPage {
	private static final AchievementPage OVERWORLD_PAGE = AchievementPages.overworldPage;

	public static void init() {
		int centerX = 4;
		int centerY = 5;
		OVERWORLD_PAGE.addAchievement(BTFAchievements.FISHING_TIME, centerX, centerY);
		int itemX = centerX + 2;
		int itemY = centerY + 2;
		OVERWORLD_PAGE.addAchievement(BTFAchievements.GOT_LUCKY, itemX-1, itemY);
		OVERWORLD_PAGE.addAchievement(BTFAchievements.GOD_DAMMIT, itemX - 4, itemY + 1);
		OVERWORLD_PAGE.addAchievement(BTFAchievements.MASTER_BAITER, itemX + 3, itemY);
		OVERWORLD_PAGE.addAchievement(BTFAchievements.IRIDESCITE_ITEM, itemX + 2, itemY - 1);
		OVERWORLD_PAGE.addAchievement(BTFAchievements.IRIDESCITE_ARMOR, itemX + 2, itemY - 3);


	}
}
