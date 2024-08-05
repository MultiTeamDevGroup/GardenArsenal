package multiteam.gardenarsenal.accessor;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;

public interface GuiGraphicsAccessor {

    void renderGAOverlay(float g, ResourceLocation texture);
    void renderGASniperOverlay();
}
