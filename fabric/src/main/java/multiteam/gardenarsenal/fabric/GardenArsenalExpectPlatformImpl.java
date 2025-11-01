package multiteam.gardenarsenal.fabric;

import multiteam.gardenarsenal.mixin.PoiTypesInvoker;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class GardenArsenalExpectPlatformImpl {
    public static void registerPoiType(PoiType poi) {
        var key = BuiltInRegistries.POINT_OF_INTEREST_TYPE.getResourceKey(poi);
        PoiTypesInvoker.invokeRegisterBlockStates(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getOrThrow(key.get()), poi.matchingStates());
    }
}
