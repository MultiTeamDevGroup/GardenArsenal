package multiteam.gardenarsenal.entities;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class BeetrootSmokeProjectile extends WeaponProjectile {
    public BeetrootSmokeProjectile(Level world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    public void collision(HitResult hitResult) {
        if (!this.level.isClientSide) {
            this.level.explode(null, this.getX() + 1D, this.getY() + 1D, this.getZ() + 1D, 3, Explosion.BlockInteraction.BREAK);
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove();

            AreaEffectCloud smokeCloud = new AreaEffectCloud(EntityType.AREA_EFFECT_CLOUD, this.level);
            smokeCloud.setPos(this.getX(), this.getY(), this.getZ());
            smokeCloud.setRadius(5.0F);
            smokeCloud.setParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE);
            smokeCloud.setPotion(new Potion(new MobEffectInstance(MobEffects.BLINDNESS, 1200)));
            this.level.addFreshEntity(smokeCloud);
            this.level.broadcastEntityEvent(this, (byte)3);
            this.remove();
        }
    }
}
