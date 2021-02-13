package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.ExplosiveProjectile;
import multiteam.gardenarsenal.entities.WeaponProjectile;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CocoaShotgun extends WeaponItem {
    public CocoaShotgun(Settings settings) {
        super(settings);
    }

    @Override
    protected int getCooldown() {
        return 50;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("tooltip.gardenarsenal.cocoa_bean_shotgun_desc").copy().formatted(Formatting.BLUE));

        CompoundTag compoundTag = stack.getTag();

        if (compoundTag == null) {
            compoundTag = new CompoundTag();
            stack.setTag(compoundTag);
        }

        compoundTag.putString("skinType", "Default");

        tooltip.add(new TranslatableText(compoundTag.getString("skinType")).copy().formatted(Formatting.DARK_GREEN));
    }

    @Override
    public void createProjectileEntities(World world, PlayerEntity playerEntity) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                WeaponProjectile projectile = new WeaponProjectile(world, playerEntity);
                projectile.bulletDamage = 6;
                projectile.setItem(new ItemStack(this.getAmmoItem()));
                projectile.setProperties(playerEntity, playerEntity.pitch + (x*4), playerEntity.yaw + (y*4), 0.0F, 2.0F, 1.0F);

                world.spawnEntity(projectile);
            }
        }
    }

    @Override
    public Item getAmmoItem() {
        return Items.COCOA_BEANS;
    }
}
