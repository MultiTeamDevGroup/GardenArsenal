//Made with Blockbench

package net.minecraft.src;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlockbench extends ModelBase {

    //fields
    ModelRenderer e0;
    ModelRenderer e1;
    ModelRenderer e2;
    ModelRenderer e3;
    ModelRenderer e4;
    ModelRenderer e5;
    ModelRenderer e6;
    ModelRenderer e7;
    ModelRenderer e8;
    ModelRenderer e9;
    ModelRenderer e10;
    ModelRenderer e11;
    ModelRenderer e12;
    ModelRenderer e13;

    public ModelBlockbench() {
        this.textureWidth = 32;
        this.textureHeight = 32;

        this.e0 = new ModelRenderer(this, 0, 0);
        this.e0.addBox(7F, 8F, 4.75F, 2, 2, 3, 1.0F);
        this.e1 = new ModelRenderer(this, 0, 0);
        this.e1.addBox(7.5F, 8.5F, 3F, 1, 1, 3, 1.0F);
        this.e2 = new ModelRenderer(this, 0, 0);
        this.e2.addBox(6.5F, 7.5F, 7F, 3, 3, 4, 1.0F);
        this.e3 = new ModelRenderer(this, 0, 0);
        this.e3.addBox(7F, 8F, 9.75F, 2, 2, 2, 1.0F);
        this.e4 = new ModelRenderer(this, 0, 0);
        this.e4.addBox(7F, 8F, 11.75F, 0, 2, 4, 1.0F);
        this.e5 = new ModelRenderer(this, 0, 0);
        this.e5.addBox(9F, 8F, 11.75F, 0, 2, 4, 1.0F);
        this.e6 = new ModelRenderer(this, 0, 0);
        this.e6.addBox(7F, 10F, 11.75F, 2, 0, 4, 1.0F);
        this.e7 = new ModelRenderer(this, 0, 0);
        this.e7.addBox(7F, 8F, 11.75F, 2, 0, 4, 1.0F);
        this.e8 = new ModelRenderer(this, 0, 0);
        this.e8.addBox(7F, 9F, 11.75F, 2, 0, 4, 1.0F);
        this.8.setRotationPoint(8F, 9F, 13.75F);
        this.setRotateAngle(e8, 0.0F, 0.0F, 45F);
        this.e9 = new ModelRenderer(this, 0, 0);
        this.e9.addBox(7F, 9F, 11.75F, 2, 0, 4, 1.0F);
        this.9.setRotationPoint(8F, 9F, 13.75F);
        this.setRotateAngle(e9, 0.0F, 0.0F, -45F);
        this.e10 = new ModelRenderer(this, 0, 0);
        this.e10.addBox(7F, 10F, 11.75F, 2, 0, 4, 1.0F);
        this.10.setRotationPoint(8F, 10F, 13.75F);
        this.setRotateAngle(e10, -22.5F, 0.0F, 0.0F);
        this.e11 = new ModelRenderer(this, 0, 0);
        this.e11.addBox(7F, 8F, 11.75F, 2, 0, 4, 1.0F);
        this.11.setRotationPoint(8F, 8F, 13.75F);
        this.setRotateAngle(e11, 22.5F, 0.0F, 0.0F);
        this.e12 = new ModelRenderer(this, 0, 0);
        this.e12.addBox(7F, 8F, 11.75F, 0, 2, 4, 1.0F);
        this.12.setRotationPoint(7F, 9F, 13.75F);
        this.setRotateAngle(e12, 0.0F, -22.5F, 0.0F);
        this.e13 = new ModelRenderer(this, 0, 0);
        this.e13.addBox(9F, 8F, 11.75F, 0, 2, 4, 1.0F);
        this.13.setRotationPoint(9F, 9F, 13.75F);
        this.setRotateAngle(e13, 0.0F, 22.5F, 0.0F);

    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.e0.render(f5);
        this.e1.render(f5);
        this.e2.render(f5);
        this.e3.render(f5);
        this.e4.render(f5);
        this.e5.render(f5);
        this.e6.render(f5);
        this.e7.render(f5);
        this.e8.render(f5);
        this.e9.render(f5);
        this.e10.render(f5);
        this.e11.render(f5);
        this.e12.render(f5);
        this.e13.render(f5);

    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}