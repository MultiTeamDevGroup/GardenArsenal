package multiteam.gardenarsenal.fabric;

import multiteam.gardenarsenal.GardenArsenal;
import net.fabricmc.api.ModInitializer;

public class GardenArsenalFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        GardenArsenal.init();
    }
}
