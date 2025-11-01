package multiteam.gardenarsenal.registries;

import multiteam.gardenarsenal.GardenArsenal;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class GardenArsenalPaintingVariants {
    public static final ResourceKey<PaintingVariant> PAINTING_BLUEPRINT_SNIPER = ResourceKey.create(
            Registries.PAINTING_VARIANT,
            GardenArsenal.id("blueprint_sugar_cane_sniper_by_lta")
    );
    public static final ResourceKey<PaintingVariant> PAINTING_BLUEPRINT_PISTOL = ResourceKey.create(
            Registries.PAINTING_VARIANT,
            GardenArsenal.id("blueprint_seed_pistol_by_lta")
    );
    public static final ResourceKey<PaintingVariant> PAINTING_BLUEPRINT_BAZOOKA = ResourceKey.create(
            Registries.PAINTING_VARIANT,
            GardenArsenal.id("blueprint_potato_bazooka_by_lta")
    );
    public static final ResourceKey<PaintingVariant> PAINTING_BLUEPRINT_SHOTGUN = ResourceKey.create(
            Registries.PAINTING_VARIANT,
            GardenArsenal.id("blueprint_cocoabean_shotgun_by_lta")
    );
    public static final ResourceKey<PaintingVariant> PAINTING_BLUEPRINT_RIFLE = ResourceKey.create(
            Registries.PAINTING_VARIANT,
            GardenArsenal.id("blueprint_carrot_rifle_by_lta")
    );

    /**
     * Datagen bootstrap for painting variants
     */
    public static void bootstrap(BootstrapContext<PaintingVariant> context) {
        context.register(PAINTING_BLUEPRINT_SNIPER, new PaintingVariant(5, 3, PAINTING_BLUEPRINT_SNIPER.location()));
        context.register(PAINTING_BLUEPRINT_PISTOL, new PaintingVariant(5, 3, PAINTING_BLUEPRINT_PISTOL.location()));
        context.register(PAINTING_BLUEPRINT_BAZOOKA, new PaintingVariant(5, 3, PAINTING_BLUEPRINT_BAZOOKA.location()));
        context.register(PAINTING_BLUEPRINT_SHOTGUN, new PaintingVariant(5, 3, PAINTING_BLUEPRINT_SHOTGUN.location()));
        context.register(PAINTING_BLUEPRINT_RIFLE, new PaintingVariant(5, 3, PAINTING_BLUEPRINT_RIFLE.location()));
    }
}
