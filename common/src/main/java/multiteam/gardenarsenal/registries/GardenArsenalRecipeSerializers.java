package multiteam.gardenarsenal.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.recipes.SkinUpgradeRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class GardenArsenalRecipeSerializers {

    private static DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(GardenArsenal.MOD_ID, Registry.RECIPE_SERIALIZER_REGISTRY);

    public static RegistrySupplier<RecipeSerializer<?>> SKIN_UPGRADE = SERIALIZERS.register("skin_upgrade",
            SkinUpgradeRecipe::createSerializer);

    public static void init() {
        SERIALIZERS.register();
    }
}
