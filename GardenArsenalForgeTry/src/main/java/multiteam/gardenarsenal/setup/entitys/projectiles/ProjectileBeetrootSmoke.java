package multiteam.gardenarsenal.setup.entitys.projectiles;

import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class ProjectileBeetrootSmoke extends WeaponProjectile{

    public ProjectileBeetrootSmoke(World p_i50159_1_, PlayerEntity p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }


    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            AreaEffectCloudEntity smokeCloud = new AreaEffectCloudEntity(EntityType.AREA_EFFECT_CLOUD,world);
            smokeCloud.setPosition(this.getPosX(), this.getPosY(), this.getPosZ());
            smokeCloud.setRadius(5.0F);
            smokeCloud.setParticleData(ParticleTypes.CAMPFIRE_COSY_SMOKE);
            smokeCloud.setPotion(new Potion(new EffectInstance(Effects.BLINDNESS, 1200)));
            world.addEntity(smokeCloud);
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }

    }

    @Override
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = BuletDamage;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
    }

}