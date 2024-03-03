package multiteam.gardenarsenal.forge;

import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import dev.architectury.utils.Env;
import dev.architectury.utils.EnvExecutor;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalClient;
import multiteam.gardenarsenal.accessor.GuiAccessor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(GardenArsenal.MOD_ID)
public class GardenArsenalForge {
    public GardenArsenalForge() {
        EventBuses.onRegistered(GardenArsenal.MOD_ID, iEventBus -> {
            EnvExecutor.runInEnv(Env.CLIENT, () -> () -> iEventBus.addListener(this::registerGuiOverlay));
        });

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GardenArsenal.MOD_ID, bus);

        MinecraftForge.EVENT_BUS.register(this);

        GardenArsenal.init();

        if (Platform.getEnv() == Dist.CLIENT) {
            GardenArsenalClient.init();
        }
    }

    @OnlyIn(Dist.CLIENT)
    private void registerGuiOverlay(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("garden_arsenal_sniper", (gui, mStack, partialTicks, screenWidth, screenHeight) -> {
            gui.setupOverlayRenderState(true, false);
            ((GuiAccessor)gui).renderGASniperOverlay();
        });
    }
}
