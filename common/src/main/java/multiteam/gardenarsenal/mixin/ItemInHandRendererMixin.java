package multiteam.gardenarsenal.mixin;

import multiteam.gardenarsenal.utils.Utils;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.ItemInHandRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ItemInHandRenderer.class)
public class ItemInHandRendererMixin {
    @Redirect(method = "renderArmWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/AbstractClientPlayer;isScoping()Z"))
    public boolean addCustomOverlaySupport(AbstractClientPlayer instance) {
        return instance.isScoping() || Utils.isUsingSugarCaneSniper(instance);
    }
}
