package multiteam.gardenarsenal.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import multiteam.gardenarsenal.accessor.GuiGraphicsAccessor;
import multiteam.gardenarsenal.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

@Mixin(GuiGraphics.class)
public abstract class GuiGraphicsMixin implements GuiGraphicsAccessor {

    @Shadow @Final private Minecraft minecraft;

    @Shadow public abstract int guiWidth();

    @Shadow public abstract int guiHeight();

    @Shadow public abstract void fill(RenderType renderType, int i, int j, int k, int l, int m, int n);

    @Shadow public abstract void blit(ResourceLocation resourceLocation, int i, int j, int k, float f, float g, int l, int m, int n, int o);

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
        RenderSystem.enableBlend();
        this.blit(texture, l, m, -90, 0.0f, 0.0f, j, k, j, k);
        RenderSystem.disableBlend();
        this.fill(RenderType.guiOverlay(), 0, o, this.guiWidth(), this.guiHeight(), -90, -16777216);
        this.fill(RenderType.guiOverlay(), 0, 0, this.guiWidth(), m, -90, -16777216);
        this.fill(RenderType.guiOverlay(), 0, m, l, o, -90, -16777216);
        this.fill(RenderType.guiOverlay(), n, m, this.guiWidth(), o, -90, -16777216);
    }

    @Unique
    private float ga$scopeScale;

    @Override
    public void renderGASniperOverlay() {
        float deltaFrame = this.minecraft.getDeltaFrameTime();
        this.ga$scopeScale = Mth.lerp(0.5f * deltaFrame, this.ga$scopeScale, 1.125f);
        if (this.minecraft.options.getCameraType().isFirstPerson()) {
            if (Utils.isUsingSugarCaneSniper(this.minecraft.player)) {
                this.renderGAOverlay(this.ga$scopeScale, Utils.SUGARCANE_SNIPER_SCOPE_OVERLAY_TEXTURE);
            } else {
                this.ga$scopeScale = 0.5f;
            }
        }
    }
}
