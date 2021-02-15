package multiteam.gardenarsenal.forge;

import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;

public class GardenArsenalExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardenArsenalExpectPlatform#getConfigDirectory()}.
     */
    public static File getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get().toFile();
    }
}
