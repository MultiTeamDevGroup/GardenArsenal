package multiteam.gardenarsenal.neoforge;

import dev.architectury.platform.Platform;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalClient;
import multiteam.gardenarsenal.accessor.GuiAccessor;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

@Mod(GardenArsenal.MOD_ID)
public class GardenArsenalNeoForge {
    public GardenArsenalNeoForge(IEventBus bus) {
        GardenArsenal.init();

        if (Platform.getEnv() == Dist.CLIENT) {
            GardenArsenalClient.init();
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = GardenArsenal.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void registerGuiOverlay(RegisterGuiOverlaysEvent event)
        {
            event.registerAboveAll(new ResourceLocation(GardenArsenal.MOD_ID, "garden_arsenal_sniper"), (gui, mStack, partialTicks, screenWidth, screenHeight) -> {
                gui.setupOverlayRenderState(true, false);
                ((GuiAccessor)gui).renderGASniperOverlay();
            });
        }
    }
}
