package multiteam.gardenarsenal.mixin;

import multiteam.gardenarsenal.utils.Utils;
import net.minecraft.client.player.AbstractClientPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(AbstractClientPlayer.class)
public class AbstractClientPlayerMixin {

    @Redirect(method = "getFieldOfViewModifier", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/AbstractClientPlayer;isScoping()Z"))
    public boolean addCustomOverlaySupport(AbstractClientPlayer instance) {
        return instance.isScoping() || Utils.isUsingSugarCaneSniper(instance);
    }
}
