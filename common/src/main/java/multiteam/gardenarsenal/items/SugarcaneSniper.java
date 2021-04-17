package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.WeaponProjectile;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SugarcaneSniper extends WeaponItem {
    public SugarcaneSniper(Item.Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, level, list, tooltipFlag);
        list.add(new TranslatableComponent("tooltip.gardenarsenal.sugar_cane_sniper_desc").copy().withStyle(ChatFormatting.GREEN));

        CompoundTag compoundTag = itemStack.getTag();

        if (compoundTag == null) {
            compoundTag = new CompoundTag();
            itemStack.setTag(compoundTag);
            compoundTag.putString("skinType", "Default");
        }

        list.add(new TranslatableComponent("tooltip.gardenarsenal.skin." + compoundTag.getString("skinType")).copy().withStyle(ChatFormatting.DARK_GREEN));
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
        projectile.shootFromRotation(playerEntity, playerEntity.xRot, playerEntity.yRot, 0.0F, 8.0F, 1.0F);
        world.addFreshEntity(projectile);
    }

    @Override
    public Item getAmmoItem() {
        return Items.SUGAR_CANE;
    }
}
