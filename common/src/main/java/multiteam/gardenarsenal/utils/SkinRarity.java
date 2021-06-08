package multiteam.gardenarsenal.utils;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

public enum SkinRarity {
    common(14540253),
    uncommon(2066191),
    rare(2909434),
    epic(9849850),
    legendary(16559363),
    mythical(16393225);

    private final int color;

    SkinRarity(int color) {
        this.color = color;
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

    public RegistrySupplier<Item> getItem() {
        return GardenArsenalItems.SKIN_CARD_PACKS.get(this.ordinal());
    }
}
