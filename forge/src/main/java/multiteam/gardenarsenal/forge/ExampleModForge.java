package multiteam.gardenarsenal.forge;

import me.shedaniel.architectury.platform.forge.EventBuses;
import multiteam.gardenarsenal.GardenArsenal;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GardenArsenal.MOD_ID)
public class ExampleModForge {
    public ExampleModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GardenArsenal.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        GardenArsenal.init();
    }
}
