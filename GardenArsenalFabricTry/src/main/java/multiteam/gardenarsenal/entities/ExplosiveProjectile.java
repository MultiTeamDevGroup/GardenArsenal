package multiteam.gardenarsenal.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class ExplosiveProjectile extends WeaponProjectile {
    public ExplosiveProjectile(World world, LivingEntity owner) {
        super(world, owner);
    }

    @Override
    public void collision(HitResult hitResult) {
        if (!this.world.isClient) {
            this.world.createExplosion(null, this.getX() + 1D, this.getY() + 1D, this.getZ() + 1D, 3, Explosion.DestructionType.BREAK);
            this.world.sendEntityStatus(this, (byte) 3);
            this.remove();
        }
    }

    @Override
    public void entityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), this.bulletDamage);
        this.world.createExplosion(null, entity.getX() + 1D, entity.getY() + 1D, entity.getZ() + 1D, 3, Explosion.DestructionType.BREAK);
    }
}
