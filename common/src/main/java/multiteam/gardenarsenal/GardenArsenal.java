package multiteam.gardenarsenal;

import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import multiteam.gardenarsenal.registries.GardenArsenalItems;

public class GardenArsenal {
    public static final String MOD_ID = "gardenarsenal";
    
    public static void init() {
        GardenArsenalBlocks.init();
        GardenArsenalItems.init();
    }
}
