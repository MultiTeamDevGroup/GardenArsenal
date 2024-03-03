package multiteam.gardenarsenal;

import dev.architectury.event.events.common.LifecycleEvent;
import multiteam.gardenarsenal.registries.*;

public class GardenArsenal {
    public static final String MOD_ID = "gardenarsenal";
    
    public static void init() {
        GardenArsenalBlocks.init();
        GardenArsenalItems.init();
        GardenArsenalPaintings.init();
        GardenArsenalPois.init();
        GardenArsenalProfessions.init();
        GardenArsenalRecipeSerializers.init();
        GardenArsenalTrades.init();
        LifecycleEvent.SERVER_BEFORE_START.register(GardenArsenalStructures::registerStructures);
    }
}
