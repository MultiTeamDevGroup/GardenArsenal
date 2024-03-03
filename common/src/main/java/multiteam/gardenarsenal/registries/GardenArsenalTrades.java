package multiteam.gardenarsenal.registries;

import dev.architectury.registry.level.entity.trade.TradeRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.utils.RandomTradeBuilder;
import multiteam.gardenarsenal.utils.SkinRarity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class GardenArsenalTrades {

    public static void init() {
        TradeListBuilder commanderTrades = new TradeListBuilder(GardenArsenalProfessions.GARDEN_SOLDIER_COMMANDER);

        for (int i = 0; i < SkinRarity.values().length; i++) {
            SkinRarity skinRarity = SkinRarity.values()[i];
            commanderTrades.add(skinRarity.getTradeLevel(), 16, 10, 0.05F)
                    .setEmeraldPrice(skinRarity.getPrice())
                    .setForSale(skinRarity.getItem(), 1,1);
        }

        registerTrades(commanderTrades);

        TradeListBuilder soldierTrades = new TradeListBuilder(GardenArsenalProfessions.GARDEN_SOLDIER);

        soldierTrades.add(1, 16, 10, 0.05F)
                .setEmeraldPrice(20)
                .setForSale(GardenArsenalItems.CARROT_RIFLE, 1,1);
        soldierTrades.add(1, 16, 10, 0.05F)
                .setEmeraldPrice(25)
                .setForSale(GardenArsenalItems.POTATO_BAZOOKA, 1,1);
        soldierTrades.add(1, 16, 10, 0.05F)
                .setEmeraldPrice(25)
                .setForSale(GardenArsenalItems.COCOA_BEAN_SHOTGUN, 1,1);
        soldierTrades.add(1, 16, 10, 0.05F)
                .setEmeraldPrice(15)
                .setForSale(GardenArsenalItems.SEED_PISTOL, 1,1);
        soldierTrades.add(1, 16, 10, 0.05F)
                .setEmeraldPrice(30)
                .setForSale(GardenArsenalItems.SUGAR_CANE_SNIPER, 1,1);
        soldierTrades.add(1, 16, 10, 0.05F)
                .setEmeraldPrice(10)
                .setForSale(GardenArsenalItems.BEETROOT_SMOKE, 1,1);
        soldierTrades.add(2, 64, 10, 0.05F)
                .setEmeraldPrice(5)
                .setForSale(GardenArsenalItems.POTATO_GRENADE, 1,1);
        soldierTrades.add(2, 64, 10, 0.05F)
                .setEmeraldPrice(10)
                .setForSale(GardenArsenalItems.COCOA_BEANS_SHELL, 5,5);
        soldierTrades.add(3, 16, 10, 0.05F)
                .setEmeraldPrice(10)
                .setForSale(GardenArsenalItems.TRAP_CAKE, 1,1);
        soldierTrades.add(3, 64, 10, 0.05F)
                .setEmeraldPrice(5)
                .setForSale(GardenArsenalItems.MACHINE_BLOCK, 1,1);

        registerTrades(soldierTrades);
    }

    private static void registerTrades(TradeListBuilder builder) {
        builder.getProfession().listen(profession -> {
            for (int i = 0; i < builder.size(); i++) {
                int level = i + 1;
                List<VillagerTrades.ItemListing> list = new ArrayList<>();
                for (RandomTradeBuilder randomTradeBuilder : builder.get(i)) {
                    list.add(randomTradeBuilder.build());
                }

                TradeRegistry.registerVillagerTrade(profession, level, list.toArray(new VillagerTrades.ItemListing[0]));
            }
        });
    }


    public static class TradeListBuilder extends ArrayList<List<RandomTradeBuilder>> {

        private final RegistrySupplier<VillagerProfession> profession;

        public TradeListBuilder(RegistrySupplier<VillagerProfession> profession) {
            super();
            this.profession = profession;
            for (int i = 0; i < 6; i++) {
                this.add(new ArrayList<>());
            }
        }

        public RegistrySupplier<VillagerProfession> getProfession() {
            return profession;
        }

        public RandomTradeBuilder add(int level, int maxTrades, int xp, float priceMult) {
            RandomTradeBuilder builder = new RandomTradeBuilder(maxTrades, xp, priceMult);
            this.get(level - 1).add(builder);
            return builder;
        }
    }
}
