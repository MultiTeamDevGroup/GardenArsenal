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

    public static RegistrySupplier<PoiType> SOLDIER_COMMANDER_POI = POIS.register("garden_soldier_commander",
            () -> new PoiType(
                    ImmutableSet.copyOf(GardenArsenalBlocks.WAR_TACTIC_TABLE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static RegistrySupplier<PoiType> SOLDIER_POI = POIS.register("garden_soldier",
            () -> new PoiType(
                    ImmutableSet.copyOf(GardenArsenalBlocks.AMMO_CRATE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static void init() {
        POIS.forEach(poi -> poi.listen(GardenArsenalPois::postRegisterEvent));

        POIS.register();
    }

    public static void postRegisterEvent(PoiType type) {
        GardenArsenalExpectPlatform.registerPoiType(type);
    }
}
