package multiteam.gardenarsenal.mixin;

import multiteam.gardenarsenal.accessor.GuiGraphicsAccessor;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Function;

@Mixin(GuiGraphics.class)
public abstract class GuiGraphicsMixin implements GuiGraphicsAccessor {

    @Shadow public abstract int guiWidth();

    @Shadow public abstract int guiHeight();

    @Shadow public abstract void fill(RenderType renderType, int i, int j, int k, int l, int m, int n);

    @Shadow public abstract void blit(Function<ResourceLocation, RenderType> function, ResourceLocation resourceLocation, int i, int j, float f, float g, int k, int l, int m, int n);

    @Override
    public void renderGAOverlay(float f, ResourceLocation texture) {
        float g;
        float h = g = (float)Math.min(this.guiWidth(), this.guiHeight());
        float i = Math.min((float)this.guiWidth() / g, (float)this.guiHeight() / h) * f;
        int j = Mth.floor(g * i);
        int k = Mth.floor(h * i);
        int l = (this.guiWidth() - j) / 2;
        int m = (this.guiHeight() - k) / 2;
        int n = l + j;
        int o = m + k;
        this.blit(RenderType::guiTextured, texture, l, m, 0.0f, 0.0f, j, k, j, k);
        this.fill(RenderType.guiOverlay(), 0, o, this.guiWidth(), this.guiHeight(), -90, -16777216);
        this.fill(RenderType.guiOverlay(), 0, 0, this.guiWidth(), m, -90, -16777216);
        this.fill(RenderType.guiOverlay(), 0, m, l, o, -90, -16777216);
        this.fill(RenderType.guiOverlay(), n, m, this.guiWidth(), o, -90, -16777216);
    }
}
