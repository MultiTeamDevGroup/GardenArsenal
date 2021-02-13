package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.ExplosiveProjectile;
import multiteam.gardenarsenal.entities.WeaponProjectile;
import multiteam.gardenarsenal.registries.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PotatoBazooka extends WeaponItem {
    public PotatoBazooka(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("tooltip.gardenarsenal.potato_bazooka_desc").copy().formatted(Formatting.BLUE));

        CompoundTag compoundTag = stack.getTag();

        if (compoundTag == null) {
            compoundTag = new CompoundTag();
            stack.setTag(compoundTag);
        }

        compoundTag.putString("skinType", "Default");

        tooltip.add(new TranslatableText(compoundTag.getString("skinType")).copy().formatted(Formatting.DARK_GREEN));
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
