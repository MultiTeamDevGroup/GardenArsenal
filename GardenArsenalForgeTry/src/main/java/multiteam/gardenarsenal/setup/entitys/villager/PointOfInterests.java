package multiteam.gardenarsenal.setup.entitys.villager;

import multiteam.gardenarsenal.GardenArsenalMod;
import multiteam.gardenarsenal.setup.ModBlocks;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = GardenArsenalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GardenArsenalMod.MOD_ID)
public class PointOfInterests {

    public static final PointOfInterestType GARSENAL_SOLDIER_COMMANDER = null;

    @SubscribeEvent
    public static void registerPointOfIntersts(RegistryEvent.Register<PointOfInterestType> event){
        IForgeRegistry<PointOfInterestType> registry = event.getRegistry();

        registry.register(VillagerUtil.pointOfInterestType("garden_soldier_commander", VillagerUtil.getAllStates(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get()), 1, 1).setRegistryName(GardenArsenalMod.MOD_ID, "garden_soldier_commander"));
    }
}
