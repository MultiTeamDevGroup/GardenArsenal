package multiteam.gardenarsenal.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import multiteam.gardenarsenal.accessor.GuiGraphicsAccessor;
import multiteam.gardenarsenal.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
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

    @Override
    public void renderGAOverlay(float g, ResourceLocation texture) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, texture);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        float f = (float)Math.min(this.guiWidth(), this.guiHeight());
        float f1 = Math.min((float)this.guiWidth() / f, (float)this.guiHeight() / f) * g;
        float f2 = f * f1;
        float f3 = f * f1;
        float f4 = ((float)this.guiWidth() - f2) / 2.0F;
        float f5 = ((float)this.guiHeight() - f3) / 2.0F;
        float f6 = f4 + f2;
        float f7 = f5 + f3;
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex((double)f4, (double)f7, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)f6, (double)f7, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)f6, (double)f5, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex((double)f4, (double)f5, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        bufferbuilder.vertex(0.0D, (double)this.guiHeight(), -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.guiWidth(), (double)this.guiHeight(), -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.guiWidth(), (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.guiWidth(), (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.guiWidth(), 0.0D, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)f4, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)f4, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)f6, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.guiWidth(), (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.guiWidth(), (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)f6, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        tesselator.end();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
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
