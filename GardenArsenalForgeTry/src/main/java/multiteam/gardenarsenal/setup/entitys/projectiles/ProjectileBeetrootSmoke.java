package multiteam.gardenarsenal.setup.entitys.projectiles;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;

public class ProjectileBeetrootSmoke extends WeaponProjectile{

    public ProjectileBeetrootSmoke(World p_i50159_1_, PlayerEntity p_i50159_2_) {
        super(p_i50159_1_, p_i50159_2_);
    }

    public int despTimer = 0;
    boolean isImpactedOnce = false;

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            isImpactedOnce = true;
        }
        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                for (int z = 0; z < 3; z++){
                    this.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.DIRT.getDefaultState()), this.getPosX(), this.getPosY(), this.getPosZ(), x, y, z);
                    //this above does not spawn particles, and i have no idea why. sad moment.
                }
            }
        }

        super.onImpact(result);
    }

    @Override
    public void onAddedToWorld() {
        super.onAddedToWorld();
    }


    @Override
    public void tick() {
        this.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.DIRT.getDefaultState()), this.getPosX(), this.getPosY(), this.getPosZ(), 1, 1, 1);
        if(isImpactedOnce){
            despTimer++;
        }

        if (despTimer >= 3600){
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }

        super.tick();
    }

    @Override
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        super.onEntityHit(p_213868_1_);
        Entity entity = p_213868_1_.getEntity();
        int i = BuletDamage;
        entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
        isImpactedOnce = true;
    }

}