package multiteam.gardenarsenal.utils;

import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.world.entity.player.Player;

public class Utils {
    public static boolean isUsingSugarCaneSniper(Player player) {
        return player.isUsingItem() && player.getUseItem().is(GardenArsenalItems.SUGAR_CANE_SNIPER.get());
    }
}
