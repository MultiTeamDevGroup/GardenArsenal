package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.SkinDescriptionRarityUtil;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
import java.util.concurrent.ThreadLocalRandom;

public class SkinCardPack extends Item {

    public SkinCardPack(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if(!level.isClientSide()){
            Item[] commonSkinCards = {Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_camo_desert")),Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_camo_end")),Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_camo_forest")),Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_camo_frost")),Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_camo_nether"))};
            Item[] uncommonSkinCards = {Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_metallic_gold")),Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_metallic_iron"))};
            Item[] rareSkinCards = {Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_seasonal_christmas")),Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_seasonal_halloween")), Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_special_aquatic"))};
            Item[] epicSkinCards = {Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_metallic_netherite")), Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_special_ectoplasm")), Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_special_rubik"))};
            Item[] legendarySkinCards = {Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_special_neon")), Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_special_nerf"))};
            Item[] mythicalSkinCards = {Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_teams_mcabnormals")), Registry.ITEM.get(ResourceLocation.tryParse("gardenarsenal:skin_card_teams_multiteam"))};

            switch (getRarityType()){
                case "common":
                    player.addItem(new ItemStack(commonSkinCards[ThreadLocalRandom.current().nextInt(0, commonSkinCards.length)]));
                    break;
                case "uncommon":
                    player.addItem(new ItemStack(uncommonSkinCards[ThreadLocalRandom.current().nextInt(0, uncommonSkinCards.length)]));
                    break;
                case "rare":
                    player.addItem(new ItemStack(rareSkinCards[ThreadLocalRandom.current().nextInt(0, rareSkinCards.length)]));
                    break;
                case "epic":
                    player.addItem(new ItemStack(epicSkinCards[ThreadLocalRandom.current().nextInt(0, epicSkinCards.length)]));
                    break;
                case "legendary":
                    player.addItem(new ItemStack(legendarySkinCards[ThreadLocalRandom.current().nextInt(0, legendarySkinCards.length)]));
                    break;
                case "mythical":
                    player.addItem(new ItemStack(mythicalSkinCards[ThreadLocalRandom.current().nextInt(0, mythicalSkinCards.length)]));
                    break;
            }

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
            compoundTag.putString("garden_rarity", getRarityType());
            stack.setTag(compoundTag);
        }

        tooltip.add(new TranslatableComponent("rarity.gardenarsenal." + compoundTag.getString("garden_rarity")).copy().withStyle(Style.EMPTY.withColor(SkinDescriptionRarityUtil.getRarityColorByRarity(compoundTag.getString("garden_rarity")))));

    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = super.getDefaultInstance();
        CompoundTag tag = stack.getTag();
        if (!tag.contains("garden_rarity")) {
            tag.putString("garden_rarity", getRarityType());
            stack.setTag(tag);
        }
        return stack;
    }

    @Override
    public Component getName(ItemStack itemStack) {
        return new TranslatableComponent(this.getDescriptionId(itemStack)).withStyle(Style.EMPTY.withColor(SkinDescriptionRarityUtil.getRarityColorByRarity(getRarityType())));
    }

    public String getRarityType(){
        if (this.asItem() == GardenArsenalItems.COMMON_SKINCARDPACK.get().asItem()){
            return "common";
        }else if (this.asItem() == GardenArsenalItems.UNCOMMON_SKINCARDPACK.get().asItem()){
            return "uncommon";
        } if (this.asItem() == GardenArsenalItems.RARE_SKINCARDPACK.get().asItem()){
            return "rare";
        } if (this.asItem() == GardenArsenalItems.EPIC_SKINCARDPACK.get().asItem()){
            return "epic";
        } if (this.asItem() == GardenArsenalItems.LEGENDARY_SKINCARDPACK.get().asItem()){
            return "legendary";
        } if (this.asItem() == GardenArsenalItems.MYTHICAL_SKINCARDPACK.get().asItem()){
            return "mythical";
        }else{
            return "default"; //even tho this will never be a thing
        }
    }
}
