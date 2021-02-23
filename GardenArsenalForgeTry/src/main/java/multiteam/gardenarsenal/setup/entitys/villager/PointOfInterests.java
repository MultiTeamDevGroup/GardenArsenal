package multiteam.gardenarsenal.setup.entitys.villager;

import multiteam.gardenarsenal.setup.ModBlocks;
import multiteam.gardenarsenal.setup.Registration;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;

public class PointOfInterests {

    public static final RegistryObject<PointOfInterestType> SOLDIER_COMMANDER_POI = Registration.POI_TYPES.register("garden_soldier_commander",() -> new PointOfInterestType("garden_soldier_commander_type", VillagerUtil.getAllStates(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get()), 1, 1));
    public static final RegistryObject<PointOfInterestType> SOLDIER_POI = Registration.POI_TYPES.register("garden_soldier",() -> new PointOfInterestType("garden_soldier_type", VillagerUtil.getAllStates(ModBlocks.GARDEN_SOLDIER_POI.get()), 1, 1));

    public static void register(){ }
}
