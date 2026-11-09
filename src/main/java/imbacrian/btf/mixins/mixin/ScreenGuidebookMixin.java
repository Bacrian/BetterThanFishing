package imbacrian.btf.mixins.mixin;

import imbacrian.btf.gui.guidebook.BTFGuidebook;
import net.minecraft.client.gui.guidebook.GuidebookPageManager;
import net.minecraft.client.gui.guidebook.ScreenGuidebook;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ScreenGuidebook.class)
public class ScreenGuidebookMixin {

	@Inject(method = "getPageManager",
		at = @At(value = "INVOKE",
			target = "Lnet/minecraft/client/gui/guidebook/GuidebookSections;init()V",
			shift = At.Shift.AFTER))
	private static void btf$registerSections(CallbackInfoReturnable<GuidebookPageManager> cir) {
		BTFGuidebook.registerOnce();
	}
}
