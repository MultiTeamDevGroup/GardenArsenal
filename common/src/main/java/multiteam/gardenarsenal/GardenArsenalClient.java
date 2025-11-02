package multiteam.gardenarsenal;

import dev.architectury.event.events.client.ClientLifecycleEvent;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;

public class GardenArsenalClient {

    public static void init() {
        ClientLifecycleEvent.CLIENT_SETUP.register(instance -> register());
    }

    public static void register() {
        RenderTypeRegistry.register(ChunkSectionLayer.CUTOUT,
                GardenArsenalBlocks.AMMO_CRATE.get()/*,
                GardenArsenalBlocks.BARRICADE_SURVIVALIST.get()*/
        );
    }
}
