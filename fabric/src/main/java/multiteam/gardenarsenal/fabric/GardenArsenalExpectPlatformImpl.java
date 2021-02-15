package multiteam.gardenarsenal.fabric;

import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;

public class GardenArsenalExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardenArsenalExpectPlatform#getConfigDirectory()}.
     */
    public static File getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir().toFile();
    }
}
