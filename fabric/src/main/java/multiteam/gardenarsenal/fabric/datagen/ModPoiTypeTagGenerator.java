package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.registries.GardenArsenalPois;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.tags.PoiTypeTags;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class ModPoiTypeTagGenerator extends FabricTagProvider<PoiType> {
    public ModPoiTypeTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, Registry.POINT_OF_INTEREST_TYPE);
    }

    @Override
    protected void generateTags() {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).add(
                GardenArsenalPois.SOLDIER_COMMANDER_POI.get(),
                GardenArsenalPois.SOLDIER_POI.get()
        );
    }
}
