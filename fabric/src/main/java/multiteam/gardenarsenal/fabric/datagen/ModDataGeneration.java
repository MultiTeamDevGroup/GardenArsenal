package multiteam.gardenarsenal.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.resources.ResourceLocation;

public class ModDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(ModLootTableGenerator::new);
        fabricDataGenerator.addProvider(ModRecipeGenerator::new);
        fabricDataGenerator.addProvider(ModBlockTagGenerator::new);
        fabricDataGenerator.addProvider(ModPaintingVariantTagGenerator::new);
        fabricDataGenerator.addProvider(ModPoiTypeTagGenerator::new);
        fabricDataGenerator.addProvider(ModModelGenerator::new);
        fabricDataGenerator.addProvider(ModLanguageGenerator::new);
    }

    public static ResourceLocation fromId(ResourceLocation id, String prefix) {
        return new ResourceLocation(id.getNamespace(), prefix + id.getPath());
    }
}
