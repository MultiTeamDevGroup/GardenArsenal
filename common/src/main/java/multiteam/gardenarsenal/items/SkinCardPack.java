package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.SkinDescriptionRarityUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SkinCardPack extends Item {

    public SkinCardPack(Properties properties) {
        super(properties);
    }

    @Override
    public void releaseUsing(ItemStack itemStack, Level level, LivingEntity livingEntity, int i) {

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
