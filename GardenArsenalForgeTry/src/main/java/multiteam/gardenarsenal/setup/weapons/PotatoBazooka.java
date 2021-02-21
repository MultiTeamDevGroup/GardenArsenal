package multiteam.gardenarsenal.setup.weapons;

import multiteam.gardenarsenal.setup.ModItems;
import multiteam.gardenarsenal.setup.ModWeapons;
import multiteam.gardenarsenal.setup.entitys.projectiles.ProjectileExplosivePotato;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class PotatoBazooka extends ModWeapons {
    public PotatoBazooka(Properties builder) {
        super(builder);
    }

    @Override
    protected double getArrowDamage(ItemStack bowStack, AbstractArrowEntity arrowEntity) {
        int powerLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, bowStack);

        return (double)powerLevel * 0.5D + 0.5D;
    }

    @Override
    public Predicate<ItemStack> getInventoryAmmoPredicate() {
        return (ammoStack) -> {
            return ammoStack.getItem() == ModItems.POTATO_GRANADE.get();
        };
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.gardenarsenal.potato_bazooka_desc").copyRaw().mergeStyle(TextFormatting.YELLOW));

        CompoundNBT nbtTagCompound = stack.getTag();

        if (nbtTagCompound == null){
            nbtTagCompound = new CompoundNBT();
            stack.setTag(nbtTagCompound);
            nbtTagCompound.putString("skinType", "Default");
        }


        tooltip.add(new TranslationTextComponent("tooltip.gardenarsenal.skin."+ nbtTagCompound.getString("skinType")).copyRaw().mergeStyle(TextFormatting.DARK_GREEN));
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack bowStack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            boolean hasInfinity = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bowStack) > 0;
            ItemStack ammoStack = playerentity.findAmmo(bowStack);

            playerentity.getCooldownTracker().setCooldown(this, 30);

            int timeDrawn = this.getUseDuration(bowStack) - timeLeft;
            timeDrawn = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(bowStack, worldIn, playerentity, timeDrawn, !ammoStack.isEmpty() || hasInfinity);
            if (timeDrawn < 0) return;

            if (!ammoStack.isEmpty() || hasInfinity) {

                float velocity = getArrowVelocity(timeDrawn);
                if (!((double)velocity < 0.1D)) {
                    if (!worldIn.isRemote) {

                        ProjectileExplosivePotato weaponProjectile = new ProjectileExplosivePotato(worldIn, playerentity);
                        weaponProjectile.BuletDamage = 8;
                        weaponProjectile.setItem(new ItemStack(ModItems.POTATO_GRANADE.get()));
                        weaponProjectile.func_234612_a_(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, 2.0F, 1.0F);
                        worldIn.addEntity(weaponProjectile);
                        worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

                        // reduce bow durability
                        bowStack.damageItem(1, playerentity, (p_220009_1_) -> {
                            p_220009_1_.sendBreakAnimation(playerentity.getActiveHand());
                        });

                    }

                    // use an ammo
                    if(!playerentity.isCreative()){
                        ammoStack.shrink(1);
                        if (ammoStack.isEmpty()) {
                            playerentity.inventory.deleteStack(ammoStack);
                        }
                    }


                    playerentity.addStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

}