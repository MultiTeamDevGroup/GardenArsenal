package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.WeaponProjectile;
import multiteam.gardenarsenal.utils.SkinDescriptionRarityUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
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

public class SeedPistol extends WeaponItem {
    public SeedPistol(Item.Properties settings) {
        super(settings);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);
        tooltip.add(new TranslatableComponent("tooltip.gardenarsenal.seed_pistol_desc").copy().withStyle(ChatFormatting.DARK_GREEN));

        CompoundTag compoundTag = stack.getOrCreateTag();

        if (!compoundTag.contains("skinType")) {
            compoundTag.putString("skinType", "Default");
        }

        stack.setTag(compoundTag);

        tooltip.add(new TranslatableComponent("tooltip.gardenarsenal.skin." + compoundTag.getString("skinType")).copy().withStyle(Style.EMPTY.withColor(SkinDescriptionRarityUtil.getRarityColorBySkin(compoundTag.getString("skinType")))));
    }

    @Override
    protected int getCooldown() {
        return 15;
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
        return Items.WHEAT_SEEDS;
    }
}
