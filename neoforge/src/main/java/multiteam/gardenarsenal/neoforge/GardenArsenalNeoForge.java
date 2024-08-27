package multiteam.gardenarsenal.neoforge;

import dev.architectury.platform.Platform;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(GardenArsenal.MOD_ID)
public class GardenArsenalNeoForge {
    public GardenArsenalNeoForge(IEventBus bus) {
        GardenArsenal.init();

        if (Platform.getEnv() == Dist.CLIENT) {
            GardenArsenalClient.init();
        }
    }
}
