package multiteam.gardenarsenal.setup.weapons;

import multiteam.gardenarsenal.setup.ModItems;
import multiteam.gardenarsenal.setup.ModWeapons;
import multiteam.gardenarsenal.setup.entitys.projectiles.ProjectileShotgunShell;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;

public class CocoaShotgun extends ModWeapons {
    public CocoaShotgun(Properties builder) {
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
            return ammoStack.getItem() == ModItems.COCOA_BEANS_SHELL.get();
        };
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.gardenarsenal.cocoa_bean_shotgun_desc"));
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack bowStack, World worldIn, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)entityLiving;
            boolean hasInfinity = playerentity.abilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, bowStack) > 0;
            ItemStack ammoStack = playerentity.findAmmo(bowStack);

            int timeDrawn = this.getUseDuration(bowStack) - timeLeft;
            timeDrawn = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(bowStack, worldIn, playerentity, timeDrawn, !ammoStack.isEmpty() || hasInfinity);
            if (timeDrawn < 0) return;

            if (!ammoStack.isEmpty() || hasInfinity) {

                float velocity = getArrowVelocity(timeDrawn);
                if (!((double)velocity < 0.1D)) {
                    if (!worldIn.isRemote) {

                        for (int x = -1; x < 2; x++){
                            for (int y = -1; y < 2; y++){
                                ProjectileShotgunShell weaponProjectile = new ProjectileShotgunShell(worldIn, playerentity);
                                weaponProjectile.setItem(new ItemStack(Items.COCOA_BEANS));
                                weaponProjectile.func_234612_a_(playerentity, playerentity.rotationPitch+x*3, playerentity.rotationYaw+y*2, 0.0F, 2.0F, 1.0F);
                                worldIn.addEntity(weaponProjectile);
                            }
                        }

                        worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_FIREWORK_ROCKET_LARGE_BLAST_FAR, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));

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