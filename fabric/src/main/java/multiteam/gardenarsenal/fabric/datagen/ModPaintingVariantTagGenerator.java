package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.registries.GardenArsenalPaintings;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.concurrent.CompletableFuture;

public class ModPaintingVariantTagGenerator extends FabricTagProvider<PaintingVariant> {
    public ModPaintingVariantTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, Registries.PAINTING_VARIANT, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(PaintingVariantTags.PLACEABLE).add(
                reverseLookup(GardenArsenalPaintings.PAINTING_BLUEPRINT_RIFLE.get()),
                reverseLookup(GardenArsenalPaintings.PAINTING_BLUEPRINT_SHOTGUN.get()),
                reverseLookup(GardenArsenalPaintings.PAINTING_BLUEPRINT_BAZOOKA.get()),
                reverseLookup(GardenArsenalPaintings.PAINTING_BLUEPRINT_PISTOL.get()),
                reverseLookup(GardenArsenalPaintings.PAINTING_BLUEPRINT_SNIPER.get())
        );
    }
}
