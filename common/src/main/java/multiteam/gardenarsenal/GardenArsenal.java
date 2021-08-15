package multiteam.gardenarsenal;

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
        GardenArsenalStructures.init();
    }
}
