package multiteam.gardenarsenal.mixin;

import multiteam.gardenarsenal.utils.Utils;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SignRenderer.class)
public class SignRendererMixin {

    @Redirect(method = "isOutlineVisible", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isScoping()Z"))
    private static boolean addCustomOverlaySupport(LocalPlayer instance) {
        return instance.isScoping() || Utils.isUsingSugarCaneSniper(instance);
    }
}
