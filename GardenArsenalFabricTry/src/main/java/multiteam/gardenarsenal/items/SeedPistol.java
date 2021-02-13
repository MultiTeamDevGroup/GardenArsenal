package multiteam.gardenarsenal.items;

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

public class SeedPistol extends WeaponItem {
    public SeedPistol(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("tooltip.gardenarsenal.seed_pistol_desc").copy().formatted(Formatting.DARK_GREEN));

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
        return 15;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST;
    }

    @Override
    public void createProjectileEntities(World world, PlayerEntity playerEntity) {
        WeaponProjectile weaponProjectile = new WeaponProjectile(world, playerEntity);
        weaponProjectile.bulletDamage = 2;
        weaponProjectile.setItem(new ItemStack(this.getAmmoItem()));
        weaponProjectile.setProperties(playerEntity, playerEntity.pitch, playerEntity.yaw, 0.0F, 2.0F, 1.0F);
        world.spawnEntity(weaponProjectile);
    }

    @Override
    public Item getAmmoItem() {
        return Items.WHEAT_SEEDS;
    }
}
