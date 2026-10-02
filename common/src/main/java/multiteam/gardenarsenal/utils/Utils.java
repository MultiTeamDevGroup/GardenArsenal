package multiteam.gardenarsenal.utils;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;

public class Utils {
    public static final Identifier SPYGLASS_OVERLAY_TEXTURE = Identifier.parse("minecraft:textures/misc/spyglass_scope.png");
    public static final Identifier SUGARCANE_SNIPER_SCOPE_OVERLAY_TEXTURE = Identifier.parse(GardenArsenal.MOD_ID +":textures/misc/sugarcane_sniper_scope.png");

    public static boolean isUsingSugarCaneSniper(Player player) {
        return player.isUsingItem() && player.getUseItem().is(GardenArsenalItems.SUGAR_CANE_SNIPER.get());
    }
}
