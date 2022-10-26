package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static multiteam.gardenarsenal.registries.GardenArsenalItems.MISC;

public class SkinCardItem extends Item {

    private final Skins skin;

    public SkinCardItem(Skins skin) {
        super(new Item.Properties().tab(MISC).stacksTo(64));
        this.skin = skin;
    }

    public Skins getSkin() {
        return skin;
    }

    @Override
    public Component getName(ItemStack itemStack) {
        return Component.translatable(this.getDescriptionId(itemStack)).withStyle(Style.EMPTY.withColor(getRarityColor()));
    }

    public TextColor getRarityColor() {
        return this.skin.getRarity().getTextColor();
    }
}
