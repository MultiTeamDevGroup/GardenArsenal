package multiteam.gardenarsenal.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import multiteam.gardenarsenal.GardenArsenal;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(GardenArsenal.MOD_ID)
public class GardenArsenalForge {
    public GardenArsenalForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GardenArsenal.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        EventBuses.getModEventBus(GardenArsenal.MOD_ID).get().addGenericListener(Item.class, GardenArsenalForge::fixGrenadeId); // Registering the MissingMappings event for Item
        GardenArsenal.init();
    }

    // This is supposed to fix the id of the potato grenade...
    public static void fixGrenadeId(RegistryEvent.MissingMappings<Item> event) {
        ResourceLocation old = new ResourceLocation(GardenArsenal.MOD_ID, "potato_granade");
        ResourceLocation newId = new ResourceLocation(GardenArsenal.MOD_ID, "potato_grenade");
        for (RegistryEvent.MissingMappings.Mapping<Item> entry : event.getAllMappings()) {
            if (entry.key.equals(old)) {
                entry.remap(ForgeRegistries.ITEMS.getValue(newId));
            }
        }
    }
}
