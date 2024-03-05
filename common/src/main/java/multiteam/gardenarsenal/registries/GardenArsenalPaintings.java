package multiteam.gardenarsenal.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.decoration.PaintingVariant;

public class GardenArsenalPaintings {

    public static DeferredRegister<PaintingVariant> MOTIVES = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.PAINTING_VARIANT);

    public static RegistrySupplier<PaintingVariant> PAINTING_BLUEPRINT_RIFLE = MOTIVES.register("blueprint_carrot_rifle_by_lta",
            () -> new PaintingVariant(80, 48));
    public static RegistrySupplier<PaintingVariant> PAINTING_BLUEPRINT_SHOTGUN = MOTIVES.register("blueprint_cocoabean_shotgun_by_lta",
            () -> new PaintingVariant(80, 48));
    public static RegistrySupplier<PaintingVariant> PAINTING_BLUEPRINT_BAZOOKA = MOTIVES.register("blueprint_potato_bazooka_by_lta",
            () -> new PaintingVariant(80, 48));
    public static RegistrySupplier<PaintingVariant> PAINTING_BLUEPRINT_PISTOL = MOTIVES.register("blueprint_seed_pistol_by_lta",
            () -> new PaintingVariant(80, 48));
    public static RegistrySupplier<PaintingVariant> PAINTING_BLUEPRINT_SNIPER = MOTIVES.register("blueprint_sugar_cane_sniper_by_lta",
            () -> new PaintingVariant(80, 48));

    public static void init() {
        MOTIVES.register();
    }
}
