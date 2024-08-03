package multiteam.gardenarsenal;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class GardenArsenalExpectPlatform {
    @ExpectPlatform
    public static void registerPoiType(PoiType poi) {
        throw new AssertionError();
    }
}
