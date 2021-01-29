package multiteam.gardenarsenal.setup.entitys.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ProjectileExplosivePotato extends WeaponProjectile{

    public ProjectileExplosivePotato(World p_i50159_1_, PlayerEntity p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.createExplosion(null, this.getPosX() + 1D, this.getPosY() + 1D, this.getPosZ() + 1D, 3, Explosion.Mode.BREAK);
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }

    }

    @Override
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 0;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
        this.world.createExplosion(null, entity.getPosX() + 1D, entity.getPosY() + 1D, entity.getPosZ() + 1D, 3, Explosion.Mode.BREAK);
    }

}
