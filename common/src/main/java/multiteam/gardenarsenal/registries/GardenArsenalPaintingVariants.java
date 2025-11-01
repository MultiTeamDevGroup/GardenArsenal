package multiteam.gardenarsenal.registries;

import multiteam.gardenarsenal.GardenArsenal;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;

import java.util.Optional;

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

    public static final ResourceKey<PaintingVariant>[] PAINTINGS = new ResourceKey[] {
            PAINTING_BLUEPRINT_SNIPER,
            PAINTING_BLUEPRINT_PISTOL,
            PAINTING_BLUEPRINT_BAZOOKA,
            PAINTING_BLUEPRINT_SHOTGUN,
            PAINTING_BLUEPRINT_RIFLE
    };

    /**
     * Datagen bootstrap for painting variants
     */
    public static void bootstrap(BootstrapContext<PaintingVariant> context) {
        context.register(PAINTING_BLUEPRINT_SNIPER, register(5, 3, PAINTING_BLUEPRINT_SNIPER));
        context.register(PAINTING_BLUEPRINT_PISTOL, register(5, 3, PAINTING_BLUEPRINT_PISTOL));
        context.register(PAINTING_BLUEPRINT_BAZOOKA, register(5, 3, PAINTING_BLUEPRINT_BAZOOKA));
        context.register(PAINTING_BLUEPRINT_SHOTGUN, register(5, 3, PAINTING_BLUEPRINT_SHOTGUN));
        context.register(PAINTING_BLUEPRINT_RIFLE, register(5, 3, PAINTING_BLUEPRINT_RIFLE));
    }

    private static PaintingVariant register(int width, int height, ResourceKey<PaintingVariant> key) {
        return new PaintingVariant(
                width, height,
                key.location(),
                Optional.of(Component.translatable("painting." + key.location().toLanguageKey() + ".title").withStyle(ChatFormatting.YELLOW)),
                Optional.of(Component.translatable("painting." + key.location().toLanguageKey() + ".author").withStyle(ChatFormatting.GRAY))
        );
    }
}
