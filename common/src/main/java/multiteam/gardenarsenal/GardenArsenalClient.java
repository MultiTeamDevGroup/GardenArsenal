package multiteam.gardenarsenal;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.SkinItemPropertyFunction;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

public class GardenArsenalClient {

    public static void init() {
        ClientLifecycleEvent.CLIENT_SETUP.register(instance -> register());
    }

    public static void register() {
        ItemPropertiesRegistry.register(GardenArsenalItems.CARROT_RIFLE.get(), GardenArsenal.id("skin"), new SkinItemPropertyFunction());
        ItemPropertiesRegistry.register(GardenArsenalItems.COCOA_BEAN_SHOTGUN.get(), GardenArsenal.id("skin"), new SkinItemPropertyFunction());
        ItemPropertiesRegistry.register(GardenArsenalItems.POTATO_BAZOOKA.get(), GardenArsenal.id("skin"), new SkinItemPropertyFunction());
        ItemPropertiesRegistry.register(GardenArsenalItems.SEED_PISTOL.get(), GardenArsenal.id("skin"), new SkinItemPropertyFunction());
        ItemPropertiesRegistry.register(GardenArsenalItems.SUGAR_CANE_SNIPER.get(), GardenArsenal.id("skin"), new SkinItemPropertyFunction());
        ItemPropertiesRegistry.register(GardenArsenalItems.GLIMMERING_REVOLVER.get(), GardenArsenal.id("skin"), new SkinItemPropertyFunction());
        RenderTypeRegistry.register(RenderType.cutout(),
                GardenArsenalBlocks.AMMO_CRATE.get()/*,
                GardenArsenalBlocks.BARRICADE_SURVIVALIST.get()*/
        );
    }
}
