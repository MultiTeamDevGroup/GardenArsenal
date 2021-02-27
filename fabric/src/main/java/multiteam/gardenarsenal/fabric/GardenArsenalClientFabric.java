package multiteam.gardenarsenal.fabric;

import me.shedaniel.architectury.platform.Platform;
import me.shedaniel.architectury.utils.Env;
import multiteam.gardenarsenal.GardenArsenalClient;
import net.fabricmc.api.ClientModInitializer;

public class GardenArsenalClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GardenArsenalClient.init();
    }
}
