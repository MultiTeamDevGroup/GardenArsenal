package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.WeaponProjectile;
import multiteam.gardenarsenal.registries.GardenArsenalDataComponents;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Consumer;

public class GlimmeringRevolver extends WeaponItem {
    public GlimmeringRevolver(Item.Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, TooltipDisplay tooltipDisplay, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, tooltipDisplay, consumer, tooltipFlag);
        consumer.accept(Component.translatable("tooltip.gardenarsenal.glimmering_revolver_desc").copy().withStyle(ChatFormatting.GOLD));
    }

    @Override
    public void useWeaponAmmo(Player playerEntity, ItemStack ammoStack, ItemStack stack, boolean bl, int remainingUseTicks, Level world) {
        int bulets = stack.getOrDefault(GardenArsenalDataComponents.SHELL_LOAD.get(), 0);
        if (bulets == 0) {
            if (!ammoStack.isEmpty()) {
                bulets = 6;
                stack.set(GardenArsenalDataComponents.SHELL_LOAD.get(), bulets);
            }
        } else if (bulets >= 1) {
            if (bulets == 1) {
                playerEntity.getCooldowns().addCooldown(this.arch$registryName(), this.getCooldown());
            }

            if ((!ammoStack.isEmpty() && this.getAllSupportedProjectiles().test(ammoStack)) || bl) {
                if (ammoStack.isEmpty()) {
                    ammoStack = new ItemStack(this.getAmmoItem());
                }

                int i = this.getMaxUseTime(stack) - remainingUseTicks;
                float f = getPullProgress(i);
                boolean bl2 = bl && ammoStack.getItem() == this.getAmmoItem();
                if (!world.isClientSide) {
                    this.createProjectileEntities(world, playerEntity);

                    stack.hurtAndBreak(1, playerEntity, playerEntity.getUsedItemHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                }

                --bulets;
                stack.set(GardenArsenalDataComponents.SHELL_LOAD.get(), bulets);

                this.usedAmmo(world, playerEntity, bl2, ammoStack, f);
            }
        }
    }

    @Override
    protected int getCooldown() {
        return 30;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.FIREWORK_ROCKET_BLAST;
    }

    @Override
    public void createProjectileEntities(Level world, Player playerEntity) {
        WeaponProjectile weaponProjectile = new WeaponProjectile(world, playerEntity, new ItemStack(this.getRenderedItem()));
        weaponProjectile.bulletDamage = 2;
        weaponProjectile.shootFromRotation(playerEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0F, 2.0F, 1.0F);
        world.addFreshEntity(weaponProjectile);
    }

    @Override
    public Item getAmmoItem() {
        return GardenArsenalItems.GLIMMERING_MELON_SEEDS.get();
    }
}
