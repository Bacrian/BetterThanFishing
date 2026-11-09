package imbacrian.btf.mixins.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import imbacrian.btf.api.RodGear;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ItemElement;
import net.minecraft.client.gui.TooltipElement;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.render.renderer.BlendFactor;
import net.minecraft.client.render.renderer.GLRenderer;
import net.minecraft.client.render.renderer.State;
import net.minecraft.core.item.ItemFishingRod;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TooltipElement.class)
public abstract class TooltipElementMixin extends Gui {

	@Unique private static final String PANEL_TEXTURE = "/assets/btf/textures/gui/fishing_tooltip.png";
	@Unique private static final int PANEL_W = 68;
	@Unique private static final int PANEL_H = 32;
	@Unique private static final double TEX_SIZE = 68.0;
	@Unique private static final long MAX_AGE_NS = 20_000_000L;

	@Unique private static final int BAIT_X = 8, BOBBER_X = 26, HOOK_X = 44, SLOT_Y = 8;

	@Unique private static ItemStack btf$stack;
	@Unique private static long btf$stackTime;
	@Unique private ItemElement btf$itemElement;

	@Shadow
	Minecraft mc;

	@Inject(method = "getTooltipText(Lnet/minecraft/core/item/ItemStack;ZLnet/minecraft/core/player/inventory/slot/Slot;)Ljava/lang/String;",
		at = @At("HEAD"))
	private void btf$captureStack(ItemStack itemStack, boolean showDescription, Slot slot, CallbackInfoReturnable<String> cir) {
		btf$stack = itemStack;
		btf$stackTime = System.nanoTime();
	}

	@WrapOperation(method = "render(Ljava/lang/CharSequence;IIIIIIZ)V",
		at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/TooltipElement;drawBackground(IIII)[I"))
	private int[] btf$drawRodGearPanel(TooltipElement instance, int minX, int minY, int maxX, int maxY, Operation<int[]> original) {
		int[] result = original.call(instance, minX, minY, maxX, maxY);

		ItemStack stack = btf$stack;
		boolean fresh = System.nanoTime() - btf$stackTime < MAX_AGE_NS;
		btf$stack = null;

		if (stack != null && fresh && stack.getItem() instanceof ItemFishingRod) {
			btf$drawPanel(stack, minX, minY, maxX, maxY);
		}
		return result;
	}

	@Unique
	private void btf$drawPanel(ItemStack rod, int minX, int minY, int maxX, int maxY) {
		TooltipElement.Style style = TooltipElement.styleMap.get(GameSettings.TOOLTIP_STYLE.value);
		int padLeft = style != null ? style.paddingLeft : 3;
		int padTop = style != null ? style.paddingTop : 3;
		int padBottom = style != null ? style.paddingBottom : 3;

		int screenW = this.mc.resolution.getScaledWidthScreenCoords();
		int screenH = this.mc.resolution.getScaledHeightScreenCoords();

		int x = Math.max(0, Math.min(minX - 2 - padLeft, screenW - PANEL_W));
		int y = maxY + 2 + padBottom + 1;
		if (y + PANEL_H > screenH) {
			y = minY - 2 - padTop - 1 - PANEL_H;
		}

		GLRenderer.pushFrame();
		try {
			GLRenderer.enableState(State.BLEND);
			GLRenderer.setBlendFunc(BlendFactor.SRC_ALPHA, BlendFactor.ONE_MINUS_SRC_ALPHA);
			GLRenderer.setColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.mc.textureManager.loadTexture(PANEL_TEXTURE).bind();
			this.drawTexturedModalRect(x, y, 0, 0, PANEL_W, PANEL_H, 1.0 / TEX_SIZE, 1.0 / TEX_SIZE);
			GLRenderer.disableState(State.BLEND);

			if (btf$itemElement == null) {
				btf$itemElement = new ItemElement(this.mc);
			}
			btf$drawGear(rod, RodGear.BAIT, x + BAIT_X, y + SLOT_Y);
			btf$drawGear(rod, RodGear.BOBBER, x + BOBBER_X, y + SLOT_Y);
			btf$drawGear(rod, RodGear.HOOK, x + HOOK_X, y + SLOT_Y);
		} finally {
			GLRenderer.popFrame();
		}
	}

	@Unique
	private void btf$drawGear(ItemStack rod, String key, int x, int y) {
		ItemStack gear = RodGear.get(rod, key);
		if (gear != null) {
			btf$itemElement.render(gear, x, y);
		}
	}
}
