package multiteam.gardenarsenal.mixin;

import multiteam.gardenarsenal.accessor.GuiGraphicsAccessor;
import multiteam.gardenarsenal.utils.Utils;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GuiMixin {

    @Shadow @Final private Minecraft minecraft;

    @Shadow private float scopeScale;

    @Redirect(method = "renderCameraOverlays", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/CameraType;isFirstPerson()Z"))
    public boolean dontRenderSpyglassOverlay(CameraType instance) {
        return instance.isFirstPerson() && !Utils.isUsingSugarCaneSniper(this.minecraft.player);
    }

    @Inject(method = "renderCameraOverlays", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/util/Mth;lerp(FFF)F", ordinal = 0))
    public void addGAOverlayHook(GuiGraphics guiGraphics, float f, CallbackInfo ci) {
        if (this.minecraft.options.getCameraType().isFirstPerson() && Utils.isUsingSugarCaneSniper(this.minecraft.player)) {
            ((GuiGraphicsAccessor) guiGraphics).renderGAOverlay(this.scopeScale, Utils.SUGARCANE_SNIPER_SCOPE_OVERLAY_TEXTURE);
        }
    }
}
