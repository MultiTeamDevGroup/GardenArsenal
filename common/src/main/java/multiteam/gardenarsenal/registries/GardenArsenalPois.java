package multiteam.gardenarsenal.registries;

import com.google.common.collect.ImmutableSet;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class GardenArsenalPois {

    private static DeferredRegister<PoiType> POIS = DeferredRegister.create(GardenArsenal.MOD_ID, Registry.POINT_OF_INTEREST_TYPE_REGISTRY);

    public static RegistrySupplier<PoiType> SOLDIER_COMMANDER_POI = POIS.register("garden_soldier_commander",
            () -> GardenArsenalExpectPlatform.createPoi("garden_soldier_commander",
                    ImmutableSet.copyOf(GardenArsenalBlocks.WAR_TACTIC_TABLE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static RegistrySupplier<PoiType> SOLDIER_POI = POIS.register("garden_soldier",
            () -> GardenArsenalExpectPlatform.createPoi("garden_soldier",
                    ImmutableSet.copyOf(GardenArsenalBlocks.AMMO_CRATE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static void init() {
        POIS.register();
    }
}
