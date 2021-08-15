package multiteam.gardenarsenal.forge;

import dev.architectury.platform.Platform;
import dev.architectury.platform.forge.EventBuses;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalClient;
import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import multiteam.gardenarsenal.registries.GardenArsenalTrades;
import multiteam.gardenarsenal.utils.RandomTradeBuilder;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
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

    private static final Map<String, String> ID_FIXES = new HashMap<>();

    protected static List<GardenArsenalTrades.TradeListBuilder> tradeListBuilders = new ArrayList<>();

    public GardenArsenalForge() {
        ID_FIXES.put("potato_granade", "potato_grenade");
        ID_FIXES.put("skin_card_metalic_gold", "skin_card_metallic_gold");
        ID_FIXES.put("skin_card_metalic_iron", "skin_card_metallic_iron");
        ID_FIXES.put("skin_card_metalic_netherite", "skin_card_metallic_netherite");
        EventBuses.onRegistered(GardenArsenal.MOD_ID, iEventBus -> {
            iEventBus.addListener(this::doClientStuff);
            iEventBus.addGenericListener(Item.class, GardenArsenalForge::fixOldIds); // Registering the MissingMappings event for Item
        });

        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(GardenArsenal.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.addListener(new Consumer<VillagerTradesEvent>() {
            @Override
            public void accept(VillagerTradesEvent event) {
                registerTrades(event);
            }
        });

        GardenArsenal.init();
        if (Platform.getEnv() == Dist.CLIENT) {
            GardenArsenalClient.init();
        }
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(GardenArsenalBlocks.AMMO_CRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(GardenArsenalBlocks.BARRICADE_SURVIVALIST.get(), RenderType.cutout());
    }

    // This is supposed to fix the renamed ids...
    public static void fixOldIds(RegistryEvent.MissingMappings<Item> event) {
        for (Map.Entry<String, String> fixEntry : ID_FIXES.entrySet()) {
            ResourceLocation old = new ResourceLocation(GardenArsenal.MOD_ID, fixEntry.getKey());
            ResourceLocation newId = new ResourceLocation(GardenArsenal.MOD_ID, fixEntry.getValue());
            for (RegistryEvent.MissingMappings.Mapping<Item> entry : event.getAllMappings()) {
                if (entry.key.equals(old)) {
                    entry.remap(ForgeRegistries.ITEMS.getValue(newId));
                }
            }
        }
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
