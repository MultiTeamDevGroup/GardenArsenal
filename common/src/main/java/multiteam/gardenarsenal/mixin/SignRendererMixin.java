package multiteam.gardenarsenal.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import multiteam.gardenarsenal.utils.Utils;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SignRenderer.class)
public class SignRendererMixin {

    @WrapOperation(method = "isOutlineVisible", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isScoping()Z"))
    private static boolean addCustomOverlaySupport(LocalPlayer instance, Operation<Boolean> original) {
        return original.call(instance) || Utils.isUsingSugarCaneSniper(instance);
    }
}
