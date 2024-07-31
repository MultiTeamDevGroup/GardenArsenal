package multiteam.gardenarsenal.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.recipes.SkinUpgradeRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeType;

public class GardenArsenalRecipeTypes {
    private static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.RECIPE_TYPE);

    public static RegistrySupplier<RecipeType<SkinUpgradeRecipe>> SKIN_UPGRADE = RECIPE_TYPES.register("skin_upgrade", () -> new RecipeType<>() {
        public String toString() {
            return "gardenarsenal:skin_upgrade";
        }
    });

    public static void init() {
        RECIPE_TYPES.register();
    }
}
