package multiteam.gardenarsenal.forge;

import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalClient;
import multiteam.gardenarsenal.accessor.GuiAccessor;
import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import multiteam.gardenarsenal.registries.GardenArsenalStructures;
import multiteam.gardenarsenal.registries.GardenArsenalTrades;
import multiteam.gardenarsenal.utils.RandomTradeBuilder;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerAboutToStartEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@Mod(GardenArsenal.MOD_ID)
public class GardenArsenalForge {
    protected static List<GardenArsenalTrades.TradeListBuilder> tradeListBuilders = new ArrayList<>();

    public GardenArsenalForge() {
        EventBuses.onRegistered(GardenArsenal.MOD_ID, iEventBus -> {
            iEventBus.addListener(this::doClientStuff);
            iEventBus.addListener(this::registerGuiOverlay);
        });

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GardenArsenal.MOD_ID, bus);

        GardenArsenalExpectPlatformImpl.POI_TYPES.register(bus);
        GardenArsenalExpectPlatformImpl.PROFESSIONS.register(bus);

        MinecraftForge.EVENT_BUS.addListener(new Consumer<VillagerTradesEvent>() {
            @Override
            public void accept(VillagerTradesEvent event) {
                registerTrades(event);
            }
        });

        MinecraftForge.EVENT_BUS.register(this);

        GardenArsenal.init();
        if (Platform.getEnv() == Dist.CLIENT) {
            GardenArsenalClient.init();
        }
    }

    @SubscribeEvent
    public void onServerAboutToStartEvent(ServerAboutToStartEvent event) {
        GardenArsenalStructures.registerStructures(event.getServer());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(GardenArsenalBlocks.AMMO_CRATE.get(), RenderType.cutout());
       // ItemBlockRenderTypes.setRenderLayer(GardenArsenalBlocks.BARRICADE_SURVIVALIST.get(), RenderType.cutout());
    }

    private void registerGuiOverlay(RegisterGuiOverlaysEvent event) {
        event.registerAboveAll("garden_arsenal_sniper", (gui, mStack, partialTicks, screenWidth, screenHeight) -> {
            gui.setupOverlayRenderState(true, false);
            ((GuiAccessor)gui).renderGASniperOverlay();
        });
    }

    public static void registerTrades(VillagerTradesEvent event) {
        for (GardenArsenalTrades.TradeListBuilder tradeListBuilder : tradeListBuilders) {
            if (event.getType() == tradeListBuilder.getProfession().get()) {
                for (int i = 0; i < tradeListBuilder.size(); i++) {
                    List<RandomTradeBuilder> list = tradeListBuilder.get(i);
                    int level = i + 1;

                    for (RandomTradeBuilder randomTradeBuilder : list) {
                        event.getTrades().get(level).add(randomTradeBuilder.build());
                    }
                }
            }
        }
    }
}
