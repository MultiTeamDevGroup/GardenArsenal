package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.registries.GardenArsenalDataComponents;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;

public abstract class WeaponItem extends BowItem {
    public WeaponItem(Item.Properties settings) {
        super(settings);
    }

    public ItemStack getAmmoInInventory(Player playerEntity) {
        Item predicate = this.getAmmoItem();
        Inventory playerInventory = playerEntity.getInventory();
        for (int i = 0; i < playerInventory.getContainerSize(); i++) {
            ItemStack stack = playerInventory.getItem(i);
            if (predicate == stack.getItem()) {
                return stack;
            }
        }

        return playerEntity.getAbilities().instabuild ? new ItemStack(predicate) : ItemStack.EMPTY;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        boolean bl = !this.getAmmoInInventory(player).isEmpty();
        if (!player.getAbilities().instabuild && !bl) {
            return InteractionResultHolder.fail(itemStack);
        } else {
            player.startUsingItem(interactionHand);
            return InteractionResultHolder.consume(itemStack);
        }
    }

    @Override
    public int getDefaultProjectileRange() {
        return 15;
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return (stack) -> stack.getItem() == this.getAmmoItem();
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        this.useWeapon(stack, world, user, remainingUseTicks);
    }

    public boolean cooldownIsFinishedLogic(Player playerEntity) {
        playerEntity.getCooldowns().addCooldown(this, this.getCooldown());
        return true;
    }

    public void useWeapon(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof Player playerEntity) {
            ItemStack itemStack = getAmmoInInventory(playerEntity);
            boolean bl = playerEntity.getAbilities().instabuild || (world instanceof ServerLevel serverLevel && EnchantmentHelper.processAmmoUse(serverLevel, stack, itemStack, 1) > 0);
            this.useWeaponAmmo(playerEntity, itemStack, stack, bl, remainingUseTicks, world);
        }
    }

    public void useWeaponAmmo(Player playerEntity, ItemStack itemStack, ItemStack stack, boolean bl, int remainingUseTicks, Level world) {
        if (this.cooldownIsFinishedLogic(playerEntity)) {
            if ((!itemStack.isEmpty() && this.getAllSupportedProjectiles().test(itemStack)) || bl) {
                if (itemStack.isEmpty()) {
                    itemStack = new ItemStack(this.getAmmoItem());
                }

                int i = this.getMaxUseTime(stack) - remainingUseTicks;
                float f = getPullProgress(i);
                if (!((double) f < 0.1D)) {
                    boolean bl2 = bl && itemStack.getItem() == this.getAmmoItem();
                    if (!world.isClientSide) {
                        this.createProjectileEntities(world, playerEntity);

                        stack.hurtAndBreak(1, playerEntity, playerEntity.getUsedItemHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                    }

                    this.usedAmmo(world, playerEntity, bl2, itemStack, f);
                }
            }
        }
    }

    public void usedAmmo(Level world, Player playerEntity, boolean bl2, ItemStack itemStack, float f) {
        world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), this.getSoundEvent(), SoundSource.PLAYERS, 1.0F, 1.0F / (ThreadLocalRandom.current().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
        if (!bl2 && !playerEntity.getAbilities().instabuild) {
            itemStack.shrink(1);
            if (itemStack.isEmpty()) {
                playerEntity.getInventory().removeItem(itemStack);
            }
        }

        playerEntity.awardStat(Stats.ITEM_USED.get(this));
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        if (this.hasSkin()) stack.set(GardenArsenalDataComponents.SKIN.get(), Skins.Default);
        return stack;
    }

    protected boolean hasSkin() {
        return true;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.BOW;
    }

    protected abstract int getCooldown();

    public int getMaxUseTime(ItemStack stack) {
        return 72000;
    }

    public abstract SoundEvent getSoundEvent();

    public abstract void createProjectileEntities(Level world, Player playerEntity);

    public abstract Item getAmmoItem();

    public Item getRenderedItem() {
        return this.getAmmoItem();
    }

    public static float getPullProgress(int useTicks) {
        float f = (float)useTicks / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    @Override
    public Component getName(ItemStack itemStack) {
        if (itemStack.has(GardenArsenalDataComponents.SKIN.get())) {
            return Component.translatable(this.getDescriptionId(itemStack)).withStyle(Style.EMPTY.withColor(
                    itemStack.get(GardenArsenalDataComponents.SKIN.get()).getRarity().getTextColor()
            ));
        } else {
            return Component.translatable(this.getDescriptionId(itemStack));
        }
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }
}
