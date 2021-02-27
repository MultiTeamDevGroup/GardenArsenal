package multiteam.gardenarsenal.forge;

import me.shedaniel.architectury.platform.Platform;
import me.shedaniel.architectury.platform.forge.EventBuses;
import me.shedaniel.architectury.utils.Env;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalClient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;

@Mod(GardenArsenal.MOD_ID)
public class GardenArsenalForge {

    private static final Map<String, String> ID_FIXES = new HashMap<>();

    public GardenArsenalForge() {
        ID_FIXES.put("potato_granade", "potato_grenade");
        ID_FIXES.put("skin_card_metalic_gold", "skin_card_metallic_gold");
        ID_FIXES.put("skin_card_metalic_iron", "skin_card_metallic_iron");
        ID_FIXES.put("skin_card_metalic_netherite", "skin_card_metallic_netherite");
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GardenArsenal.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        EventBuses.getModEventBus(GardenArsenal.MOD_ID).get().addGenericListener(Item.class, GardenArsenalForge::fixGrenadeId); // Registering the MissingMappings event for Item
        GardenArsenal.init();
        if (Platform.getEnvironment() == Env.CLIENT) {
            GardenArsenalClient.init();
        }
    }

    // This is supposed to fix the id of the potato grenade...
    public static void fixGrenadeId(RegistryEvent.MissingMappings<Item> event) {
        for (Map.Entry<String, String> fixEntry : ID_FIXES.entrySet()) {
            ResourceLocation old = new ResourceLocation(GardenArsenal.MOD_ID, fixEntry.getKey());
            ResourceLocation newId = new ResourceLocation(GardenArsenal.MOD_ID, fixEntry.getValue());
            for (RegistryEvent.MissingMappings.Mapping<Item> entry : event.getAllMappings()) {
                if (entry.key.equals(old)) {
                    entry.remap(ForgeRegistries.ITEMS.getValue(newId));
                }
            }
        }
    }
}
