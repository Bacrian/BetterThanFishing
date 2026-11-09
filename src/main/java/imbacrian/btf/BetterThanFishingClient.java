package imbacrian.btf;

import imbacrian.btf.api.BTFAchievementPage;
import imbacrian.btf.gui.guidebook.BTFGuidebook;
import imbacrian.btf.models.CommonRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.texture.stitcher.AtlasStitcher;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.client.sound.SoundRepository;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.util.dependency.Key;

import java.io.IOException;
import java.net.URISyntaxException;

import static imbacrian.btf.BetterThanFishing.MOD_ID;

public final class BetterThanFishingClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Event listener keys are unique: do not replace the common recipe setup.
		ClientEvents.BEFORE_CLIENT_START.listen(Key.of(MOD_ID + "_client"), this::beforeClientStart);
		ClientEvents.AFTER_CLIENT_START.listen(Key.of(MOD_ID + "_client"), this::afterGameStart);
		ClientEvents.ITEM_MODEL_RELOAD.listen(Key.of(MOD_ID + "_client"), CommonRenderer::initItemModels);
		ClientEvents.BLOCK_MODEL_RELOAD.listen(Key.of(MOD_ID + "_client"), CommonRenderer::initBlockModels);
		ClientEvents.TILE_ENTITY_RENDERER_RELOAD.listen(Key.of(MOD_ID + "_client"), CommonRenderer::initTileEntityModels);
		ClientEvents.ENTITY_RENDERER_RELOAD.listen(Key.of(MOD_ID + "_client"), CommonRenderer::initEntityModels);
		ClientEvents.BLOCK_COLOR_RELOAD.listen(Key.of(MOD_ID + "_client"), CommonRenderer::initBlockColors);
	}

	public void beforeClientStart() {
		for (final AtlasStitcher stitcher : TextureRegistry.stitcherMap.values()) {
			try {
				TextureRegistry.initializeAllFiles(MOD_ID, stitcher, true);
			} catch (URISyntaxException | IOException e) {
				BetterThanFishing.LOGGER.error("Failed to initialize texture files!", e);
			}
		}
		SoundRepository.namespaceAdded(MOD_ID);
	}

	public void afterGameStart() {
		BTFAchievementPage.init();
	}
}
