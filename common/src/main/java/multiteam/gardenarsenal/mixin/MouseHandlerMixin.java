package multiteam.gardenarsenal.mixin;

import multiteam.gardenarsenal.utils.Utils;
import net.minecraft.client.MouseHandler;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {

    @Redirect(method = "turnPlayer", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/LocalPlayer;isScoping()Z"))
    public boolean addCustomOverlaySupport(LocalPlayer instance) {
        return instance.isScoping() || Utils.isUsingSugarCaneSniper(instance);
    }
}
