package imbacrian.btf.gui.guidebook;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.guidebook.GuidebookSections;

@Environment(EnvType.CLIENT)
public class BTFGuidebook {
	private static boolean registered = false;
	public static void registerOnce() {
		if (registered) return;
		registered = true;
		GuidebookSections.register(new GuidebookSectionChopping());
	}
}
