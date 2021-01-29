package multiteam.gardenarsenal.setup.weapons;

import multiteam.gardenarsenal.setup.ModWeapons;
import multiteam.gardenarsenal.setup.entitys.projectiles.WeaponProjectile;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;


public class CarrotRifle extends ModWeapons {
    public CarrotRifle(Properties builder) {
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
            return ammoStack.getItem() == Items.CARROT;
        };
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.gardenarsenal.carrot_rifle_desc"));

        CompoundNBT nbtTagCompound = stack.getTag();

        if (nbtTagCompound == null){
            nbtTagCompound = new CompoundNBT();
            stack.setTag(nbtTagCompound);
        }

        nbtTagCompound.putString("skinType", "Default");

        // idk why this doesnt work
        // tooltip.add(new StringTextComponent(nbtTagCompound.getString("skinType")).setStyle(new Style().setColor(TextFormatting.DARK_GREEN)));
    }

    int timeR = 0;
    boolean hasAmmo;

    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        if (!(player instanceof PlayerEntity)) {
            return;
        }
        boolean detectedCarrots = ((PlayerEntity) player).inventory.hasItemStack(new ItemStack(Items.CARROT));

        if(((PlayerEntity) player).isCreative()){
            hasAmmo = true;
        }else hasAmmo = detectedCarrots;

        World worldIn = player.world;
        if (!worldIn.isRemote && timeR >= 5 && hasAmmo) {

            WeaponProjectile weaponProjectile = new WeaponProjectile(worldIn, (PlayerEntity) player);
            weaponProjectile.BuletDamage = 4;
            weaponProjectile.setItem(new ItemStack(Items.CARROT));
            weaponProjectile.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.0F, 1.0F);
            worldIn.addEntity(weaponProjectile);
            worldIn.playSound((PlayerEntity)null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.BLOCK_ANCIENT_DEBRIS_HIT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            timeR = 0;

            // use an ammo and damage the item
            if(!((PlayerEntity) player).isCreative()){
                ItemStack ammoStack = ((PlayerEntity) player).inventory.getStackInSlot(((PlayerEntity) player).inventory.getSlotFor(new ItemStack(Items.CARROT)));
                ammoStack.shrink(1);
                if (ammoStack.isEmpty()) {
                    ((PlayerEntity) player).inventory.deleteStack(ammoStack);
                }
                //Damage the item, but im dumb.
                // this.damageItem(1, player, player);
              }

        }
        timeR++;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack bowStack, World worldIn, LivingEntity entityLiving, int timeLeft){
        return;
    }

}