package multiteam.gardenarsenal.items;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.utils.SkinRarity;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

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
    public InteractionResult use(Level level, Player player, InteractionHand interactionHand) {
        if (!level.isClientSide()) {
            List<RegistrySupplier<Item>> skinList = this.skinRarity.getSkinsForRarity();

            player.addItem(new ItemStack(skinList.get(ThreadLocalRandom.current().nextInt(0, skinList.size())).getOrNull()));

            ItemStack handItem = player.getItemInHand(interactionHand);
            player.awardStat(Stats.ITEM_USED.get(this));
            handItem.shrink(1);

            if (handItem.isEmpty()) {
                player.getInventory().removeItem(handItem);
            }

            return new InteractionResult.Success(InteractionResult.SwingSource.CLIENT,
                    new InteractionResult.ItemContext(false, player.getItemInHand(interactionHand)));
        }

        return new InteractionResult.Success(InteractionResult.SwingSource.CLIENT,
                new InteractionResult.ItemContext(false, player.getItemInHand(interactionHand)));
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext tooltipContext, List<Component> list, TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        list.add(Component.translatable("rarity.gardenarsenal." + this.skinRarity.name().toLowerCase(Locale.ENGLISH)).copy()
                .withStyle(Style.EMPTY.withColor(this.skinRarity.getTextColor())));
    }

    @Override
    public Component getName(ItemStack itemStack) {
        return super.getName(itemStack).copy().withStyle(Style.EMPTY.withColor(this.skinRarity.getTextColor()));
    }
}
