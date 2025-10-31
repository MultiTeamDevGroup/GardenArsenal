package multiteam.gardenarsenal.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.resources.ResourceLocation;

public class ModDataGeneration implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        pack.addProvider(ModLootTableGenerator::new);
        pack.addProvider(ModRecipeGenerator::new);
        pack.addProvider(ModBlockTagGenerator::new);
        pack.addProvider(ModPaintingVariantTagGenerator::new);
        pack.addProvider(ModPoiTypeTagGenerator::new);
        pack.addProvider(ModModelGenerator::new);
        pack.addProvider(ModLanguageGenerator::new);
        pack.addProvider(ModItemTagGenerator::new);
    }

    public static ResourceLocation fromId(ResourceLocation id, String prefix) {
        return new ResourceLocation(id.getNamespace(), prefix + id.getPath());
    }
}
