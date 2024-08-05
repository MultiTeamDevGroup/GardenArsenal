package multiteam.gardenarsenal.neoforge;

import dev.architectury.platform.Platform;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalClient;
import multiteam.gardenarsenal.accessor.GuiGraphicsAccessor;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;

@Mod(GardenArsenal.MOD_ID)
public class GardenArsenalNeoForge {
    public GardenArsenalNeoForge(IEventBus bus) {
        GardenArsenal.init();

        if (Platform.getEnv() == Dist.CLIENT) {
            GardenArsenalClient.init();
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = GardenArsenal.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void registerGuiOverlay(RegisterGuiLayersEvent event)
        {
            event.registerAboveAll(new ResourceLocation(GardenArsenal.MOD_ID, "garden_arsenal_sniper"), (gui, f) -> {
//                gui.setupOverlayRenderState(true, false);
                ((GuiGraphicsAccessor)gui).renderGASniperOverlay();
            });
        }
    }
}
