package multiteam.gardenarsenal.items;

import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.world.item.Item;

import static multiteam.gardenarsenal.registries.GardenArsenalItems.MISC;

public class SkinCardItem extends Item {

    private Skins skin;

    public SkinCardItem(Skins skin) {
        super(new Item.Properties().tab(MISC));
        this.skin = skin;
    }

    public Skins getSkin() {
        return skin;
    }
}
