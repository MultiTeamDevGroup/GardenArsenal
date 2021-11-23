package multiteam.gardenarsenal.accessor;

import net.minecraft.resources.ResourceLocation;

public interface GuiAccessor {

    void renderGAOverlay(float g, ResourceLocation texture);

    void renderGASniperOverlay();
}
