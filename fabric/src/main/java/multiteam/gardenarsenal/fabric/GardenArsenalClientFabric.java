package multiteam.gardenarsenal.fabric;

import multiteam.gardenarsenal.GardenArsenalClient;
import net.fabricmc.api.ClientModInitializer;

public class GardenArsenalClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GardenArsenalClient.register();
    }
}
