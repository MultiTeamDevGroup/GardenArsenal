package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.WeaponProjectile;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SugarcaneSniper extends WeaponItem{
    public SugarcaneSniper(Item.Properties settings) {
        super(settings);
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.SPYGLASS;
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof Player playerEntity) {
            boolean bl = playerEntity.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
            ItemStack itemStack = getAmmoInInventory(playerEntity);
            playerEntity.getCooldowns().addCooldown(this, this.getCooldown());
            if ((!itemStack.isEmpty() && this.getAllSupportedProjectiles().test(itemStack)) || bl) {
                if (itemStack.isEmpty()) {
                    itemStack = new ItemStack(this.getAmmoItem());
                }

                int i = this.getMaxUseTime(stack) - remainingUseTicks;
                float f = getPullProgress(i);
                if (!((double)f < 0.1D)) {
                    boolean bl2 = bl && itemStack.getItem() == this.getAmmoItem();
                    if (!world.isClientSide) {
                        this.createProjectileEntities(world, playerEntity);

                        stack.hurtAndBreak(1, playerEntity, (p) -> p.broadcastBreakEvent(playerEntity.getUsedItemHand()));
                    }

                    world.playSound(null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), this.getSoundEvent(), SoundSource.PLAYERS, 1.0F, 1.0F / (ThreadLocalRandom.current().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!bl2 && !playerEntity.getAbilities().instabuild) {
                        itemStack.shrink(1);
                        if (itemStack.isEmpty()) {
                            playerEntity.getInventory().removeItem(itemStack);
                        }
                    }

                    if(world.isClientSide){
                        //Minecraft.getInstance().player.isScoping() = false;
                        //this.minecraft.player.isScoping()
                    }

                    playerEntity.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(Component.translatable("tooltip.gardenarsenal.sugar_cane_sniper_desc").copy().withStyle(ChatFormatting.GREEN));

        CompoundTag compoundTag = itemStack.getOrCreateTag();

        if (!compoundTag.contains("skinType")) {
            compoundTag.putString("skinType", "Default");
        }

        itemStack.setTag(compoundTag);

        list.add(Component.translatable("tooltip.gardenarsenal.skin." + compoundTag.getString("skinType")).copy().withStyle(Style.EMPTY.withColor(this.getTextColor(compoundTag))));
    }

    @Override
    protected int getCooldown() {
        return 70;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.FIREWORK_ROCKET_BLAST_FAR;
    }

    @Override
    public void createProjectileEntities(Level world, Player playerEntity) {
        WeaponProjectile projectile = new WeaponProjectile(world, playerEntity);
        projectile.bulletDamage = 10;
        projectile.setItem(new ItemStack(this.getRenderedItem()));
        projectile.shootFromRotation(playerEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0F, 8.0F, 1.0F);
        world.addFreshEntity(projectile);
    }

    @Override
    public Item getAmmoItem() {
        return Items.SUGAR_CANE;
    }

}
