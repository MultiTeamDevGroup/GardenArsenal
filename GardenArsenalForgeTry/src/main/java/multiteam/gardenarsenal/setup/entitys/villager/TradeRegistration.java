package multiteam.gardenarsenal.setup.entitys.villager;

import multiteam.gardenarsenal.GardenArsenalMod;
import multiteam.gardenarsenal.setup.ModItems;
import multiteam.gardenarsenal.setup.VillagerProfessions;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = GardenArsenalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class TradeRegistration {

    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event){
        if (event.getType() == VillagerProfessions.GARDEN_SOLDIER_COMMANDER.get()) {

            event.getTrades().get(1).add(new RandomTradeBuilder(64, 25, 0.05F).setPrice(ModItems.SKIN_CARD0.get(), 1,1).setEmeraldPrice(1).build());

        }

        if (event.getType() == VillagerProfessions.GARDEN_SOLDIER.get()) {

            event.getTrades().get(1).add(new RandomTradeBuilder(64, 25, 0.05F).setPrice(ModItems.COCOA_BEANS_SHELL.get(), 5,7).setEmeraldPrice(6).build());

        }
    }
}
