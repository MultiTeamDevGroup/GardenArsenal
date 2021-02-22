package multiteam.gardenarsenal.setup.entitys.villager;

import multiteam.gardenarsenal.GardenArsenalMod;
import multiteam.gardenarsenal.setup.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.MerchantOffer;
import net.minecraftforge.common.BasicTrade;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;
import java.util.Random;

@Mod.EventBusSubscriber(modid = GardenArsenalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class TradeRegistration {

    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event){
        if (event.getType() == VillagerProfessions.GARSENAL_SOLDIER_COMMANDER)
        {
            event.getTrades().get(1).add(new RandomTradeBuilder(64, 25, 0.05F).setPrice(ModItems.SKIN_CARD0.get(), 1,3).build());

            /**
            event.getTrades().get(1).add((new RandomTradeBuilder(64, 25, 0.05F).setPrice(Items.COAL, 1,1).setPrice2(Items.STONE, 8,8).setForSale(Items.COAL_ORE, 1, 2).build()));

            event.getTrades().get(2).add((new RandomTradeBuilder(64, 25, 0.2F).setPrice(Items.IRON_INGOT, 1,1).setPrice2(Items.STONE, 8,8).setForSale(Items.IRON_ORE, 1, 2).build()));
            event.getTrades().get(2).add((new RandomTradeBuilder(64, 25, 0.2F).setPrice(Items.GOLD_INGOT, 1,1).setPrice2(Items.STONE, 8,8).setForSale(Items.GOLD_ORE, 1, 2).build()));
            event.getTrades().get(2).add((new RandomTradeBuilder(64, 25, 0.2F).setPrice(Items.GOLD_INGOT, 1,1).setPrice2(Items.NETHERRACK, 8,8).setForSale(Items.NETHER_GOLD_ORE, 1, 2).build()));

            event.getTrades().get(3).add((new RandomTradeBuilder(64, 25, 0.05F).setPrice(Items.REDSTONE, 1,1).setPrice2(Items.STONE, 8,8).setForSale(Items.REDSTONE_ORE, 1, 2).build()));
            event.getTrades().get(3).add((new RandomTradeBuilder(64, 25, 0.05F).setPrice(Items.LAPIS_LAZULI, 1,1).setPrice2(Items.STONE, 8,8).setForSale(Items.LAPIS_ORE, 1, 2).build()));

            event.getTrades().get(4).add((new RandomTradeBuilder(64, 25, 0.2F).setPrice(Items.QUARTZ, 1,1).setPrice2(Items.NETHERRACK, 8,8).setForSale(Items.NETHER_QUARTZ_ORE, 1, 2).build()));
            event.getTrades().get(4).add((new RandomTradeBuilder(64, 25, 0.2F).setPrice(Items.DIAMOND, 1,1).setPrice2(Items.STONE, 8,8).setForSale(Items.DIAMOND_ORE, 1, 2).build()));

            event.getTrades().get(5).add((new RandomTradeBuilder(64, 25, 0.2F).setPrice(Items.EMERALD, 1,1).setPrice2(Items.STONE, 8,8).setForSale(Items.EMERALD_ORE, 1, 2).build()));
            event.getTrades().get(5).add((new RandomTradeBuilder(64, 25, 0.2F).setPrice(Items.NETHERITE_INGOT, 1,1).setPrice2(Items.NETHERRACK, 8,8).setForSale(Items.ANCIENT_DEBRIS, 1, 1).build()));
            event.getTrades().get(5).add((new RandomTradeBuilder(64, 50, 0.05F).setPrice(Items.WITHER_SKELETON_SKULL, 3,6).setPrice2(Items.SOUL_SAND, 4,4).setForSale(Items.NETHER_STAR, 1, 1).build()));
            **/
        }
    }
}
