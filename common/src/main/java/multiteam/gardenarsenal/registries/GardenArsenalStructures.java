package multiteam.gardenarsenal.registries;

import dev.architectury.event.events.common.LifecycleEvent;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.utils.JigsawUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;

public class GardenArsenalStructures {

    public static final ResourceLocation PLAINS_HOUSES = new ResourceLocation("village/plains/houses");

    public static void init() {
        LifecycleEvent.SERVER_BEFORE_START.register(GardenArsenalStructures::registerStructures);
    }

    private static void registerStructures(MinecraftServer server) {
        JigsawUtils.registerJigsaw(server, PLAINS_HOUSES,
                new ResourceLocation(GardenArsenal.MOD_ID, "village/plains/houses/ga_commander_tent"), 6);
        JigsawUtils.registerJigsaw(server, PLAINS_HOUSES,
                new ResourceLocation(GardenArsenal.MOD_ID, "village/plains/houses/ga_soldier_tent"), 6);
    }
}
