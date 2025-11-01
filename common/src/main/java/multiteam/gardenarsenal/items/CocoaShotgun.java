package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.WeaponProjectile;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class CocoaShotgun extends WeaponItem {
    public CocoaShotgun(Item.Properties settings) {
        super(settings);
    }

    @Override
    protected int getCooldown() {
        return 50;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return SoundEvents.FIREWORK_ROCKET_LARGE_BLAST_FAR;
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(Component.translatable("tooltip.gardenarsenal.cocoa_bean_shotgun_desc").copy().withStyle(ChatFormatting.BLUE));
    }

    @Override
    public void createProjectileEntities(Level world, Player playerEntity) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                WeaponProjectile projectile = new WeaponProjectile(world, playerEntity, new ItemStack(this.getRenderedItem()));
                projectile.bulletDamage = 6;
                projectile.shootFromRotation(playerEntity, playerEntity.getXRot() + (x*4), playerEntity.getYRot() + (y*4), 0.0F, 2.0F, 1.0F);

                world.addFreshEntity(projectile);
            }
        }
    }

    @Override
    public Item getAmmoItem() {
        return GardenArsenalItems.COCOA_BEANS_SHELL.get();
    }

    @Override
    public Item getRenderedItem() {
        return Items.COCOA_BEANS;
    }
}
