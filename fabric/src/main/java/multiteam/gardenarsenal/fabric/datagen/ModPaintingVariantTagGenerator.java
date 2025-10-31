package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.registries.GardenArsenalPaintings;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.Registry;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class ModPaintingVariantTagGenerator extends FabricTagProvider<PaintingVariant> {
    public ModPaintingVariantTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, Registry.PAINTING_VARIANT);
    }

    @Override
    protected void generateTags() {
        tag(PaintingVariantTags.PLACEABLE).add(
                GardenArsenalPaintings.PAINTING_BLUEPRINT_RIFLE.get(),
                GardenArsenalPaintings.PAINTING_BLUEPRINT_SHOTGUN.get(),
                GardenArsenalPaintings.PAINTING_BLUEPRINT_BAZOOKA.get(),
                GardenArsenalPaintings.PAINTING_BLUEPRINT_PISTOL.get(),
                GardenArsenalPaintings.PAINTING_BLUEPRINT_SNIPER.get()
        );
    }
}
