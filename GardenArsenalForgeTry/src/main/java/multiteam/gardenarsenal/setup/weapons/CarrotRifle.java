package multiteam.gardenarsenal.setup.weapons;

import multiteam.gardenarsenal.setup.ModWeapons;
import multiteam.gardenarsenal.setup.entitys.TorchArrowEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import sun.security.mscapi.CPublicKey;

import javax.annotation.Nullable;
import java.util.List;
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
        tooltip.add(new TranslationTextComponent("tooltip.gardenarsenal.carrot_rifle_skintype"));
    }
    int timeR = 0;
    @Override
    public void onUsingTick(ItemStack stack, LivingEntity player, int count) {
        if (!(player instanceof PlayerEntity)) {
            return;
        }
        boolean hasAmmo = ((PlayerEntity) player).inventory.hasItemStack(new ItemStack(Items.CARROT));
        World worldIn = player.world;
        if (!worldIn.isRemote && timeR >= 5 && hasAmmo) {
            SnowballEntity snowballentity = new SnowballEntity(worldIn, player);
            snowballentity.setItem(new ItemStack(Items.CARROT));
            snowballentity.func_234612_a_(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.0F, 1.0F);
            worldIn.addEntity(snowballentity);
            worldIn.playSound((PlayerEntity)null, player.getPosX(), player.getPosY(), player.getPosZ(), SoundEvents.BLOCK_ANCIENT_DEBRIS_HIT, SoundCategory.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
            timeR = 0;

            ItemStack ammoStack = ((PlayerEntity) player).inventory.getStackInSlot(((PlayerEntity) player).inventory.getSlotFor(new ItemStack(Items.CARROT)));

            // use an ammo
            if(!((PlayerEntity) player).isCreative()){
                ammoStack.shrink(1);
                if (ammoStack.isEmpty()) {
                    ((PlayerEntity) player).inventory.deleteStack(ammoStack);
                }
            }
        }
        timeR++;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack bowStack, World worldIn, LivingEntity entityLiving, int timeLeft){
        return;
    }

}