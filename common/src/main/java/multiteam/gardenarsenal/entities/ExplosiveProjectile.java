package multiteam.gardenarsenal.entities;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class ExplosiveProjectile extends WeaponProjectile {
    public ExplosiveProjectile(Level world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    public void collision(HitResult hitResult) {
        if (!this.level.isClientSide) {
            this.level.explode(null, this.getX() + 1D, this.getY() + 1D, this.getZ() + 1D, 3, Explosion.BlockInteraction.BREAK);
            this.level.broadcastEntityEvent(this, (byte) 3);
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    public void entityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), this.bulletDamage);
        this.level.explode(null, entity.getX() + 1D, entity.getY() + 1D, entity.getZ() + 1D, 3, Explosion.BlockInteraction.BREAK);
    }
}
