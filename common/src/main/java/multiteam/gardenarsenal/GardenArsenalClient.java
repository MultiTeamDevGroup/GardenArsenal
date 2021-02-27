package multiteam.gardenarsenal;

import me.shedaniel.architectury.event.events.client.ClientLifecycleEvent;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.SkinItemPropertyFunction;

public class GardenArsenalClient {

    public static void init() {
        ClientLifecycleEvent.CLIENT_SETUP.register(instance -> register());
    }

    private static void register() {
        GardenArsenalExpectPlatform.registerItemProperty(GardenArsenalItems.CARROT_RIFLE.get(), "skin", new SkinItemPropertyFunction());
        GardenArsenalExpectPlatform.registerItemProperty(GardenArsenalItems.COCOA_BEAN_SHOTGUN.get(), "skin", new SkinItemPropertyFunction());
        GardenArsenalExpectPlatform.registerItemProperty(GardenArsenalItems.POTATO_BAZOOKA.get(), "skin", new SkinItemPropertyFunction());
        GardenArsenalExpectPlatform.registerItemProperty(GardenArsenalItems.SEED_PISTOL.get(), "skin", new SkinItemPropertyFunction());
        GardenArsenalExpectPlatform.registerItemProperty(GardenArsenalItems.SUGAR_CANE_SNIPER.get(), "skin", new SkinItemPropertyFunction());
    }
}
