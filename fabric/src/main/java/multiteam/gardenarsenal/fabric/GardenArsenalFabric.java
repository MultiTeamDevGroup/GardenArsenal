package multiteam.gardenarsenal.fabric;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.registries.GardenArsenalStructures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

public class GardenArsenalFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GardenArsenal.init();
        ServerLifecycleEvents.SERVER_STARTING.register(GardenArsenalStructures::registerStructures);
    }
}
