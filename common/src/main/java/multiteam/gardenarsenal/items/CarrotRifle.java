package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.WeaponProjectile;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public class CarrotRifle extends WeaponItem {
    public CarrotRifle(Item.Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(Component.translatable("tooltip.gardenarsenal.carrot_rifle_desc").copy().withStyle(ChatFormatting.DARK_GREEN));
    }

    @Override
    public void onUseTick(Level world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        this.useWeapon(stack, world, user, remainingUseTicks);
    }

    @Override
    public boolean cooldownIsFinishedLogic(Player playerEntity) {
        return !playerEntity.getCooldowns().isOnCooldown(this);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {

    }

    @Override
    protected int getCooldown() {
        return 3;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.ANCIENT_DEBRIS_HIT;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (stack) -> stack.getItem() == this.getAmmoItem() && stack.getCount() > 5;
    }

    @Override
    public void createProjectileEntities(Level world, Player playerEntity) {
        WeaponProjectile weaponProjectile = new WeaponProjectile(world, playerEntity);
        weaponProjectile.bulletDamage = 4;
        weaponProjectile.setItem(new ItemStack(this.getRenderedItem()));
        weaponProjectile.shootFromRotation(playerEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0F, 2.0F, 1.0F);
        world.addFreshEntity(weaponProjectile);
    }

    @Override
    public Item getAmmoItem() {
        return Items.CARROT;
    }

    @Override
    public Item getRenderedItem() {
        return GardenArsenalItems.PROJECTILE_CARROT.get();
    }
}
