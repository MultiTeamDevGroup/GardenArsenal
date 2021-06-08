package multiteam.gardenarsenal.items;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.utils.SkinRarity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class SkinCardPack extends Item {

    private final SkinRarity skinRarity;

    public SkinCardPack(SkinRarity skinRarity, Properties properties) {
        super(properties);
        this.skinRarity = skinRarity;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (!level.isClientSide()) {
            List<RegistrySupplier<Item>> skinList = this.skinRarity.getSkinsForRarity();

            player.addItem(new ItemStack(skinList.get(ThreadLocalRandom.current().nextInt(0, skinList.size())).getOrNull()));

            ItemStack handItem = player.getItemInHand(interactionHand);
            player.awardStat(Stats.ITEM_USED.get(this));
            handItem.shrink(1);

            if (handItem.isEmpty()) {
                player.getInventory().removeItem(handItem);
            }

            return InteractionResultHolder.success(player.getItemInHand(interactionHand));
        }

        return InteractionResultHolder.success(player.getItemInHand(interactionHand));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, level, tooltip, tooltipFlag);

        CompoundTag compoundTag = stack.getOrCreateTag();
        if (!compoundTag.contains("garden_rarity")) {
            compoundTag.putString("garden_rarity", this.skinRarity.name());
            stack.setTag(compoundTag);
        }

        tooltip.add(new TranslatableComponent("rarity.gardenarsenal." + this.skinRarity.name().toLowerCase(Locale.ENGLISH)).copy().withStyle(Style.EMPTY.withColor(this.skinRarity.getTextColor())));

    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        CompoundTag tag = stack.getOrCreateTag();

        if (!tag.contains("garden_rarity")) {
            tag.putString("garden_rarity", this.skinRarity.name());
            stack.setTag(tag);
        }

        return stack;
    }

    @Override
    public Component getName(ItemStack itemStack) {
        return new TranslatableComponent(this.getDescriptionId(itemStack)).withStyle(Style.EMPTY.withColor(this.skinRarity.getTextColor()));
    }
}
