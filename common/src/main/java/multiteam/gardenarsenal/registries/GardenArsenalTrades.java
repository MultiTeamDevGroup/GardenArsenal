package multiteam.gardenarsenal.registries;

import me.shedaniel.architectury.registry.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.utils.RandomTradeBuilder;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.world.entity.npc.VillagerProfession;

import java.util.ArrayList;
import java.util.List;

public class GardenArsenalTrades {

    public static void init() {
        TradeListBuilder commanderTrades = new TradeListBuilder(GardenArsenalProfessions.GARDEN_SOLDIER_COMMANDER);

        for (int i = 0; i < Skins.values().length; i++) {
            Skins skin = Skins.values()[i];
            commanderTrades.add(skin.getTradeLevel(), 16, 10, 0.05F)
                    .setEmeraldPrice(skin.getPrice())
                    .setForSale(GardenArsenalItems.SKIN_CARDS.get(i), 1,1);
        }

        GardenArsenalExpectPlatform.registerTrades(commanderTrades);

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

        GardenArsenalExpectPlatform.registerTrades(soldierTrades);
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
