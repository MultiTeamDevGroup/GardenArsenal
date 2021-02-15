package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.ExplosiveProjectile;
import multiteam.gardenarsenal.entities.WeaponProjectile;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PotatoBazooka extends WeaponItem {
    public PotatoBazooka(Item.Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);
        tooltip.add(new TranslatableComponent("tooltip.gardenarsenal.potato_bazooka_desc").copy().withStyle(ChatFormatting.BLUE));

        CompoundTag compoundTag = stack.getTag();

        if (compoundTag == null) {
            compoundTag = new CompoundTag();
            stack.setTag(compoundTag);
        }

        compoundTag.putString("skinType", "Default");

        tooltip.add(new TranslatableComponent(compoundTag.getString("skinType")).copy().withStyle(ChatFormatting.DARK_GREEN));
    }

    @Override
    protected int getCooldown() {
        return 30;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.FIREWORK_ROCKET_LAUNCH;
    }

    @Override
    public void createProjectileEntities(Level world, Player playerEntity) {
        WeaponProjectile projectile = new ExplosiveProjectile(world, playerEntity);
        projectile.bulletDamage = 8;
        projectile.setItem(new ItemStack(this.getAmmoItem()));
        projectile.shootFromRotation(playerEntity, playerEntity.xRot, playerEntity.yRot, 0.0F, 2.0F, 1.0F);
        world.addFreshEntity(projectile);
    }

    @Override
    public Item getAmmoItem() {
        return GardenArsenalItems.POTATO_GRENADE.get();
    }
}
