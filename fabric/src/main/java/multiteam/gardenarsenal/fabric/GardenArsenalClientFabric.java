package multiteam.gardenarsenal.fabric;

import multiteam.gardenarsenal.GardenArsenalClient;
import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class GardenArsenalClientFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        GardenArsenalClient.init();
        BlockRenderLayerMap.INSTANCE.putBlock(GardenArsenalBlocks.AMMO_CRATE.get(), RenderType.cutout());
//        BlockRenderLayerMap.INSTANCE.putBlock(GardenArsenalBlocks.BARRICADE_SURVIVALIST.get(), RenderType.cutout());
    }
}
