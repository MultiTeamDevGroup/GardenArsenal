package multiteam.gardenarsenal.entities;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class WeaponProjectile extends Snowball {
    public WeaponProjectile(Level world, LivingEntity owner) {
        super(world, owner);
    }

    public int bulletDamage;

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        super.onHitEntity(entityHitResult);
        this.entityHit(entityHitResult);
    }

    public void entityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), this.bulletDamage);
    }

    @Override
    protected void onHit(HitResult hitResult) {
        super.onHit(hitResult);
        this.collision(hitResult);
    }

    public void collision(HitResult hitResult) {
        if (!this.level.isClientSide) {
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove(RemovalReason.DISCARDED);
        }
    }
}
