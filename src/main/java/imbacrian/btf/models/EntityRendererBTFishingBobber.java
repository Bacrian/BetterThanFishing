package imbacrian.btf.models;

import imbacrian.btf.api.BobberRegistry;
import imbacrian.btf.api.RodGear;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererSprite;
import net.minecraft.client.render.renderer.DrawMode;
import net.minecraft.client.render.renderer.GLRenderer;
import net.minecraft.client.render.renderer.Shaders;
import net.minecraft.client.render.tessellator.TessellatorGeneral;
import net.minecraft.client.render.texture.stitcher.TextureRegistry;
import net.minecraft.core.entity.EntityFishingBobber;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3d;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class EntityRendererBTFishingBobber extends EntityRenderer<EntityFishingBobber> {
	private static final String DEFAULT_TEXTURE = "minecraft:particle/bobber";

	private final Map<String, EntityRendererSprite<EntityFishingBobber>> sprites = new HashMap<>();

	private EntityRendererSprite<EntityFishingBobber> spriteFor(String texture) {
		return sprites.computeIfAbsent(texture, t -> {
			EntityRendererSprite<EntityFishingBobber> sprite = new EntityRendererSprite<>(TextureRegistry.getTexture(t));
			sprite.init(EntityFishingBobber.class, this.renderDispatcher);
			return sprite;
		});
	}

	@Override
	public void render(@NotNull TessellatorGeneral tessellator, @NotNull EntityFishingBobber entity, double x, double y, double z, float yaw, float partialTick) {
		String texture = DEFAULT_TEXTURE;
		if (entity.owner != null) {
			ItemStack rod = entity.owner.getCurrentEquippedItem();
			ItemStack bobber = RodGear.get(rod, RodGear.BOBBER);
			BobberRegistry.BobberData data = bobber == null ? null : BobberRegistry.get(bobber.getItem());
			if (data != null) {
				texture = data.floatTextureFor(bobber);
			}
		}
		spriteFor(texture).render(tessellator, entity, x, y, z, yaw, partialTick);

		if (entity.owner == null) {
			return;
		}

		int handedNess = entity.owner.isLeftHanded() ? -1 : 1;
		float f11 = entity.owner.getSwingProgress(partialTick);
		float f12 = MathHelper.sin(MathHelper.sqrt_float(f11) * (float) Math.PI);
		Vector3d vec3 = new Vector3d(-0.75 * handedNess, -0.05, 0.8);
		vec3.rotateX(-(entity.owner.xRotO + (entity.owner.xRot - entity.owner.xRotO) * partialTick) * (float) Math.PI / 180.0F);
		vec3.rotateY(-(entity.owner.yRotO + (entity.owner.yRot - entity.owner.yRotO) * partialTick) * (float) Math.PI / 180.0F);
		vec3.rotateY(f12 * 0.5F);
		vec3.rotateX(-f12 * 0.7F);
		double xp = MathHelper.lerp(entity.owner.xo, entity.owner.x, partialTick) + vec3.x;
		double yp = MathHelper.lerp(entity.owner.yo, entity.owner.y, partialTick) + entity.owner.getHeadHeight() + vec3.y;
		double zp = MathHelper.lerp(entity.owner.zo, entity.owner.z, partialTick) + vec3.z;
		if (GameSettings.THIRD_PERSON_VIEW.value > 0) {
			float rr = (entity.owner.yBodyRotO + (entity.owner.yBodyRot - entity.owner.yBodyRotO) * partialTick) * (float) Math.PI / 180.0F;
			double ss = MathHelper.sin(rr);
			double cc = MathHelper.cos(rr);
			xp = MathHelper.lerp(entity.owner.xo, entity.owner.x, partialTick) - cc * 0.35 * handedNess - ss * 0.85;
			yp = MathHelper.lerp(entity.owner.yo, entity.owner.y, partialTick) + entity.owner.getHeadHeight() - 0.45;
			zp = MathHelper.lerp(entity.owner.zo, entity.owner.z, partialTick) - ss * 0.35 * handedNess + cc * 0.85;
		}

		double xh = entity.xo + (entity.x - entity.xo) * partialTick;
		double yh = entity.yo + (entity.y - entity.yo) * partialTick + 0.25;
		double zh = entity.zo + (entity.z - entity.zo) * partialTick;
		double xa = (float) (xp - xh);
		double ya = (float) (yp - yh);
		double za = (float) (zp - zh);
		GLRenderer.pushFrame();
		GLRenderer.setShader(Shaders.COLOR_WORLD);
		GLRenderer.globalSetLightEnabled(false);
		tessellator.startDrawing(DrawMode.LINE_STRIP);
		tessellator.setColorOpaque1i(0);
		for (int i = 0; i <= 16; i++) {
			float aa = (float) i / 16;
			tessellator.addVertex(x + xa * aa, y + ya * (aa * aa + aa) * 0.5 + 0.25, z + za * aa);
		}
		tessellator.draw();
		GLRenderer.globalSetLightEnabled(true);
		GLRenderer.popFrame();
	}
}
