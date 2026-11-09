package imbacrian.btf;

import imbacrian.btf.compat.stardew.StardewCompat;
import net.fabricmc.loader.api.FabricLoader;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static imbacrian.btf.BetterThanFishing.MOD_ID;

public final class BTFConfig {
	private static final int DEFAULT_BLOCK_START = 6200;
	private static final int DEFAULT_ITEM_START = 29500;

	public static int blockStart = DEFAULT_BLOCK_START;
	public static int itemStart = DEFAULT_ITEM_START;

	private BTFConfig() {}

	public static void init() {
		Toml props = new Toml("Better Than Fishing Configs.toml");
		props.addCategory("General")
			.addEntry("cfgVersion", 1)
			.addEntry("BLOCK_ID_STARTING_FROM", blockStart)
			.addEntry("ITEM_ID_STARTING_FROM", DEFAULT_ITEM_START);

		TomlConfigHandler cfg = new TomlConfigHandler(MOD_ID, props);
		if (cfg.getConfigFile().exists()) {
			cfg.loadConfig();
		} else {
			try {
				cfg.getConfigFile().createNewFile();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			cfg.writeConfig();
		}

		blockStart = cfg.getInt("General.BLOCK_ID_STARTING_FROM");
		itemStart = cfg.getInt("General.ITEM_ID_STARTING_FROM");
	}
}
