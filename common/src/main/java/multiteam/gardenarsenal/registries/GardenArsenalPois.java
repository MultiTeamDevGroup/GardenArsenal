package multiteam.gardenarsenal.registries;

import com.google.common.collect.ImmutableSet;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.village.poi.PoiType;

import java.util.function.Supplier;

public class GardenArsenalPois {

    private static final DeferredRegister<PoiType> POIS = DeferredRegister.create(GardenArsenal.MOD_ID, Registry.POINT_OF_INTEREST_TYPE_REGISTRY);

    public static Supplier<PoiType> SOLDIER_COMMANDER_POI = GardenArsenalExpectPlatform.registerPoiType("garden_soldier_commander",
            () -> new PoiType(
                    ImmutableSet.copyOf(GardenArsenalBlocks.WAR_TACTIC_TABLE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static Supplier<PoiType> SOLDIER_POI = GardenArsenalExpectPlatform.registerPoiType("garden_soldier",
            () -> new PoiType(
                    ImmutableSet.copyOf(GardenArsenalBlocks.AMMO_CRATE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static void init() {
        POIS.register();
    }
}
