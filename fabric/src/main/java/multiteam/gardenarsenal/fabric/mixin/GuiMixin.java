package multiteam.gardenarsenal.fabric.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import multiteam.gardenarsenal.accessor.GuiAccessor;
import multiteam.gardenarsenal.utils.Utils;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
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

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/CameraType;isFirstPerson()Z"))
    public boolean dontRenderSpyglassOverlay(CameraType instance) {
        return instance.isFirstPerson() && !Utils.isUsingSugarCaneSniper(this.minecraft.player);
    }

    @Inject(method = "render", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/util/Mth;lerp(FFF)F"))
    public void addGAOverlayHook(PoseStack poseStack, float f, CallbackInfo ci) {
        if (this.minecraft.options.getCameraType().isFirstPerson() && Utils.isUsingSugarCaneSniper(this.minecraft.player)) {
            ((GuiAccessor)this).renderGAOverlay(this.scopeScale, Utils.SUGARCANE_SNIPER_SCOPE_OVERLAY_TEXTURE);
        }
    }
}
