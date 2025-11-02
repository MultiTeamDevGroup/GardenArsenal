package multiteam.gardenarsenal.mixin;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import multiteam.gardenarsenal.accessor.GuiGraphicsAccessor;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GuiGraphics.class)
public abstract class GuiGraphicsMixin implements GuiGraphicsAccessor {

    @Shadow public abstract int guiWidth();

    @Shadow public abstract int guiHeight();

    @Shadow public abstract void fill(RenderPipeline renderType, int i, int j, int k, int l, int n);

    @Shadow public abstract void blit(RenderPipeline function, ResourceLocation resourceLocation, int i, int j, float f, float g, int k, int l, int m, int n);

    @Override
    public void renderGAOverlay(float f, ResourceLocation texture) {
        float g = (float)Math.min(this.guiWidth(), this.guiHeight());
        float i = Math.min((float)this.guiWidth() / g, (float)this.guiHeight() / g) * f;
        int j = Mth.floor(g * i);
        int k = Mth.floor(g * i);
        int l = (this.guiWidth() - j) / 2;
        int m = (this.guiHeight() - k) / 2;
        int n = l + j;
        int o = m + k;
        this.blit(RenderPipelines.GUI_TEXTURED, texture, l, m, 0.0F, 0.0F, j, k, j, k);
        this.fill(RenderPipelines.GUI, 0, o, this.guiWidth(), this.guiHeight(), -16777216);
        this.fill(RenderPipelines.GUI, 0, 0, this.guiWidth(), m, -16777216);
        this.fill(RenderPipelines.GUI, 0, m, l, o, -16777216);
        this.fill(RenderPipelines.GUI, n, m, this.guiWidth(), o, -16777216);
    }
}
