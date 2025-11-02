package multiteam.gardenarsenal.entities;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class BeetrootSmokeProjectile extends WeaponProjectile {
    public BeetrootSmokeProjectile(Level world, LivingEntity owner, ItemStack stack) {
        super(world, owner, stack);
    }

    @Override
    public void collision(HitResult hitResult) {
        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.remove(RemovalReason.DISCARDED);

            AreaEffectCloud smokeCloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
            smokeCloud.setRadius(5.0F);
            smokeCloud.setCustomParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE);
            smokeCloud.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 1200));
            this.level().addFreshEntity(smokeCloud);
            this.level().broadcastEntityEvent(this, (byte)3);
            this.remove(RemovalReason.DISCARDED);
        }
    }
}
