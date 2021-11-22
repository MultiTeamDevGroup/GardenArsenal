package multiteam.gardenarsenal.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Gui.class)
public class MixinGui extends GuiComponent {

    @Shadow protected int screenWidth;
    @Shadow protected int screenHeight;
    @Shadow @Final protected Minecraft minecraft;
    @Shadow protected float scopeScale;

    @Inject(at = @At("HEAD"), method = "render", cancellable = true)
    public void render(PoseStack arg, float g){
        this.screenWidth = this.minecraft.getWindow().getGuiScaledWidth();
        this.screenHeight = this.minecraft.getWindow().getGuiScaledHeight();
        Font font = this.minecraft.font;
        RenderSystem.enableBlend();

        float f = this.minecraft.getDeltaFrameTime();
        this.scopeScale = Mth.lerp(0.5F * f, this.scopeScale, 1.125F);
        if (this.minecraft.options.getCameraType().isFirstPerson()) {
            if (isUsingSugarCaneSniper(this.minecraft.player)) {
                renderOverlay(this.scopeScale, MixinConstants.SUGARCANE_SNIPER_SCOPE_OVERLAY_TEXTURE);
            }
        }
    }

    public boolean isUsingSugarCaneSniper(Player player) {
        return player.isUsingItem() && player.getUseItem().is(GardenArsenalItems.SUGAR_CANE_SNIPER.get());
    }

    protected void renderOverlay(float g, ResourceLocation texture) {
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, texture);
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder bufferbuilder = tesselator.getBuilder();
        float f = (float)Math.min(this.screenWidth, this.screenHeight);
        float f1 = Math.min((float)this.screenWidth / f, (float)this.screenHeight / f) * g;
        float f2 = f * f1;
        float f3 = f * f1;
        float f4 = ((float)this.screenWidth - f2) / 2.0F;
        float f5 = ((float)this.screenHeight - f3) / 2.0F;
        float f6 = f4 + f2;
        float f7 = f5 + f3;
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
        bufferbuilder.vertex((double)f4, (double)f7, -90.0D).uv(0.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)f6, (double)f7, -90.0D).uv(1.0F, 1.0F).endVertex();
        bufferbuilder.vertex((double)f6, (double)f5, -90.0D).uv(1.0F, 0.0F).endVertex();
        bufferbuilder.vertex((double)f4, (double)f5, -90.0D).uv(0.0F, 0.0F).endVertex();
        tesselator.end();
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.disableTexture();
        bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        bufferbuilder.vertex(0.0D, (double)this.screenHeight, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.screenWidth, (double)this.screenHeight, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.screenWidth, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.screenWidth, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.screenWidth, 0.0D, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, 0.0D, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)f4, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)f4, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex(0.0D, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)f6, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.screenWidth, (double)f7, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)this.screenWidth, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        bufferbuilder.vertex((double)f6, (double)f5, -90.0D).color(0, 0, 0, 255).endVertex();
        tesselator.end();
        RenderSystem.enableTexture();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
    }
}
