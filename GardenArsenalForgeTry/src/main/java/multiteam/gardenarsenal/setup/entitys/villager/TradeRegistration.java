package multiteam.gardenarsenal.setup.entitys.villager;

import multiteam.gardenarsenal.GardenArsenalMod;
import multiteam.gardenarsenal.setup.ModBlocks;
import multiteam.gardenarsenal.setup.ModItems;
import multiteam.gardenarsenal.setup.VillagerProfessions;
import multiteam.gardenarsenal.setup.entitys.villager.RandomTradeBuilder;
import net.minecraft.item.Items;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = GardenArsenalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TradeRegistration {

    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event){
        if (event.getType() == VillagerProfessions.GARDEN_SOLDIER_COMMANDER.get()) {

            //COMMON SKIN CARDS
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(1).setForSale(ModItems.SKIN_CARD0.get(), 1, 1).build()));
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(1).setForSale(ModItems.SKIN_CARD1.get(), 1, 1).build()));
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(1).setForSale(ModItems.SKIN_CARD2.get(), 1, 1).build()));
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(1).setForSale(ModItems.SKIN_CARD3.get(), 1, 1).build()));
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(1).setForSale(ModItems.SKIN_CARD4.get(), 1, 1).build()));

            //UNCOMMON SKIN CARDS
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(2).setForSale(ModItems.SKIN_CARD6.get(), 1, 1).build()));

            //RARE SKIN CARDS
            event.getTrades().get(2).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(3).setForSale(ModItems.SKIN_CARD5.get(), 1, 1).build()));
            event.getTrades().get(2).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(3).setForSale(ModItems.SKIN_CARD8.get(), 1, 1).build()));
            event.getTrades().get(2).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(3).setForSale(ModItems.SKIN_CARD9.get(), 1, 1).build()));
            event.getTrades().get(2).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(3).setForSale(ModItems.SKIN_CARD10.get(), 1, 1).build()));

            //EPIC SKIN CARDS
            event.getTrades().get(3).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(4).setForSale(ModItems.SKIN_CARD7.get(), 1, 1).build()));

            //LEGENDARY SKIN CARDS
            event.getTrades().get(4).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(5).setForSale(ModItems.SKIN_CARD11.get(), 1, 1).build()));

            //MYTHICAL SKIN CARDS
            event.getTrades().get(5).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(6).setForSale(ModItems.SKIN_CARD12.get(), 1, 1).build()));
            event.getTrades().get(5).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(6).setForSale(ModItems.SKIN_CARD13.get(), 1, 1).build()));
            event.getTrades().get(5).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(6).setForSale(ModItems.SKIN_CARD14.get(), 1, 1).build()));

        }

        if (event.getType() == VillagerProfessions.GARDEN_SOLDIER.get()) {

            //WEAPONS
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(20).setForSale(ModItems.CARROT_RIFLE.get(), 1, 1).build()));
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(25).setForSale(ModItems.POTATO_BAZOOKA.get(), 1, 1).build()));
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(25).setForSale(ModItems.COCOA_BEAN_SHOTGUN.get(), 1, 1).build()));
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(15).setForSale(ModItems.SEED_PISTOL.get(), 1, 1).build()));
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(30).setForSale(ModItems.SUGAR_CANE_SNIPER.get(), 1, 1).build()));
            event.getTrades().get(1).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(10).setForSale(ModItems.BEETROOT_SMOKE.get(), 1, 1).build()));

            //AMMUNITION
            event.getTrades().get(2).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(5).setForSale(ModItems.POTATO_GRANADE.get(), 1, 1).build()));
            event.getTrades().get(2).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(10).setForSale(ModItems.COCOA_BEANS_SHELL.get(), 5, 5).build()));

            //MISC
            event.getTrades().get(3).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(10).setForSale(ModBlocks.TRAP_CAKE.get().asItem(), 1, 1).build()));
            event.getTrades().get(3).add((new RandomTradeBuilder(16, 10, 0.05F).setEmeraldPrice(5).setForSale(ModBlocks.MACHINE_BLOCK.get().asItem(), 1, 1).build()));

        }
    }
}
