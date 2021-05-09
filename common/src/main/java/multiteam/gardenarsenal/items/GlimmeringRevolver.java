package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.WeaponProjectile;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GlimmeringRevolver extends WeaponItem {
    public GlimmeringRevolver(Item.Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);
        tooltip.add(new TranslatableComponent("tooltip.gardenarsenal.glimmering_revolver_desc").copy().withStyle(ChatFormatting.GOLD));

        CompoundTag compoundTag = stack.getOrCreateTag();

        if (!compoundTag.contains("skinType")) {
            compoundTag.putString("skinType", "Default");
        }
        if (!compoundTag.contains("shellLoad")) {
            compoundTag.putInt("shellLoad", 0);
        }

        stack.setTag(compoundTag);

        tooltip.add(new TranslatableComponent("tooltip.gardenarsenal.skin." + compoundTag.getString("skinType")).copy().withStyle(ChatFormatting.DARK_GREEN));
    }

    @Override
    public void releaseUsing(ItemStack stack, Level world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof Player) {
            CompoundTag nbt = stack.getTag();

            if(nbt != null){
                Player playerEntity = (Player)user;
                ItemStack ammoStack = getAmmoInInventory(playerEntity);
                int bulets = nbt.getInt("shellLoad");
                if( bulets == 0){
                    if(!ammoStack.isEmpty()){
                        bulets = 6;
                        nbt.putInt("shellLoad", bulets);
                    }
                }else if (bulets >= 1){
                    boolean bl = playerEntity.abilities.instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, stack) > 0;
                    if(bulets == 1){
                        playerEntity.getCooldowns().addCooldown(this, this.getCooldown());
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

                            stack.hurtAndBreak(1, (LivingEntity)playerEntity, (p) -> {
                                ((Player)p).broadcastBreakEvent(playerEntity.getUsedItemHand());
                            });
                        }

                        --bulets;
                        nbt.putInt("shellLoad", bulets);

                        world.playSound((Player) null, playerEntity.getX(), playerEntity.getY(), playerEntity.getZ(), this.getSoundEvent(), SoundSource.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                        if (!bl2 && !playerEntity.abilities.instabuild) {
                            ammoStack.shrink(1);
                            if (ammoStack.isEmpty()) {
                                playerEntity.inventory.removeItem(ammoStack);
                            }
                        }

                        playerEntity.awardStat(Stats.ITEM_USED.get(this));
                    }
                }
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
        WeaponProjectile weaponProjectile = new WeaponProjectile(world, playerEntity);
        weaponProjectile.bulletDamage = 2;
        weaponProjectile.setItem(new ItemStack(this.getRenderedItem()));
        weaponProjectile.shootFromRotation(playerEntity, playerEntity.xRot, playerEntity.yRot, 0.0F, 2.0F, 1.0F);
        world.addFreshEntity(weaponProjectile);
    }

    @Override
    public Item getAmmoItem() {
        return GardenArsenalItems.GLIMMERING_MELON_SEEDS.get();
    }
}
