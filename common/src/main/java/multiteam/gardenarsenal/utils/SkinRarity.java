package multiteam.gardenarsenal.utils;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public enum SkinRarity {
    common(14540253, 1, 1),
    uncommon(2066191, 2, 3),
    rare(2909434, 2, 3),
    epic(9849850, 3, 4),
    legendary(16559363, 4, 5),
    mythical(16393225, 5, 6);

    private final int color;
    private final int tradeLevel;
    private final int price;

    SkinRarity(int color, int tradeLevel, int price) {
        this.color = color;
        this.tradeLevel = tradeLevel;
        this.price = price;
    }

    public TextColor getTextColor() {
        return TextColor.fromRgb(this.color);
    }

    public List<RegistrySupplier<Item>> getSkinsForRarity() {
        List<RegistrySupplier<Item>> list = new ArrayList<>();

        for (Skins skin : Skins.values()) {
            if (skin.getRarity() == this) list.add(skin.getItem());
        }

        return list;
    }

    public int getPrice() {
        return price;
    }

    public int getTradeLevel() {
        return tradeLevel;
    }

    public RegistrySupplier<Item> getItem() {
        return GardenArsenalItems.SKIN_CARD_PACKS.get(this.ordinal());
    }
}
