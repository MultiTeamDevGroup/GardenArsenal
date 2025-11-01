package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.BeetrootSmokeProjectile;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;

public class BeetrootSmoke extends WeaponItem {
    public BeetrootSmoke(Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, TooltipDisplay tooltipDisplay, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, tooltipDisplay, consumer, tooltipFlag);
        consumer.accept(Component.translatable("tooltip.gardenarsenal.beetroot_smoke_desc").copy().withStyle(ChatFormatting.DARK_RED));
    }

    @Override
    protected boolean hasSkin() {
        return false;
    }

    @Override
    protected int getCooldown() {
        return 20;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.FIREWORK_ROCKET_SHOOT;
    }

    @Override
    public void createProjectileEntities(Level world, Player playerEntity) {
        BeetrootSmokeProjectile projectile = new BeetrootSmokeProjectile(world, playerEntity, new ItemStack(this::getRenderedItem));
        projectile.bulletDamage = 0;
        projectile.shootFromRotation(playerEntity, playerEntity.getXRot(), playerEntity.getYRot(), 0.0F, 2.0F, 1.0F);

        world.addFreshEntity(projectile);
    }

    @Override
    public Item getAmmoItem() {
        return GardenArsenalItems.BEETROOT_SMOKE.get();
    }
}
