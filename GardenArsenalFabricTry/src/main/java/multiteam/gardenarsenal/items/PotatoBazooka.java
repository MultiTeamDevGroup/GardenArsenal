package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.ExplosiveProjectile;
import multiteam.gardenarsenal.entities.WeaponProjectile;
import multiteam.gardenarsenal.registries.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class PotatoBazooka extends WeaponItem {
    public PotatoBazooka(Settings settings) {
        super(settings);
    }

    @Override
    protected int getCooldown() {
        return 30;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH;
    }

    @Override
    public void createProjectileEntities(World world, PlayerEntity playerEntity) {
        WeaponProjectile projectile = new ExplosiveProjectile(world, playerEntity);
        projectile.bulletDamage = 8;
        projectile.setItem(new ItemStack(this.getAmmoItem()));
        projectile.setProperties(playerEntity, playerEntity.pitch, playerEntity.yaw, 0.0F, 2.0F, 1.0F);
        world.spawnEntity(projectile);
    }

    @Override
    public Item getAmmoItem() {
        return ModItems.POTATO_GRENADE;
    }
}
