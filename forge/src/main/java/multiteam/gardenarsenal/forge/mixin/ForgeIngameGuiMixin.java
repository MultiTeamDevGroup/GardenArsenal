package multiteam.gardenarsenal.forge.mixin;

import multiteam.gardenarsenal.accessor.GuiAccessor;
import net.minecraftforge.client.gui.ForgeIngameGui;
import net.minecraftforge.client.gui.IIngameOverlay;
import net.minecraftforge.client.gui.OverlayRegistry;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ForgeIngameGui.class)
public class ForgeIngameGuiMixin {

    private static final IIngameOverlay SNIPER_ELEMENT = OverlayRegistry.registerOverlayTop("Garden Arsenal Sniper", (gui, mStack, partialTicks, screenWidth, screenHeight) -> {
        gui.setupOverlayRenderState(true, false);
        ((GuiAccessor)gui).renderGASniperOverlay();
    });
}
