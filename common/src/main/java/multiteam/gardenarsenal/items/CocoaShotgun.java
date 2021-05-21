package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.entities.WeaponProjectile;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
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
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag context) {
        super.appendHoverText(stack, world, tooltip, context);
        tooltip.add(new TranslatableComponent("tooltip.gardenarsenal.cocoa_bean_shotgun_desc").copy().withStyle(ChatFormatting.BLUE));

        CompoundTag compoundTag = stack.getOrCreateTag();

        if (!compoundTag.contains("skinType")) {
            compoundTag.putString("skinType", "Default");
            stack.setTag(compoundTag);
        }

        tooltip.add(new TranslatableComponent("tooltip.gardenarsenal.skin." + compoundTag.getString("skinType")).copy().withStyle(Style.EMPTY.withColor(SkinDescriptionRarityUtil.getRarityColor(compoundTag.getString("skinType")))));
    }

    @Override
    public void createProjectileEntities(Level world, Player playerEntity) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                WeaponProjectile projectile = new WeaponProjectile(world, playerEntity);
                projectile.bulletDamage = 6;
                projectile.setItem(new ItemStack(this.getRenderedItem()));
                projectile.shootFromRotation(playerEntity, playerEntity.xRot + (x*4), playerEntity.yRot + (y*4), 0.0F, 2.0F, 1.0F);

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
