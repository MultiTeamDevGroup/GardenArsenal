package multiteam.gardenarsenal.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.recipes.SkinUpgradeRecipe;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class GardenArsenalRecipeSerializers {

    private static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.RECIPE_SERIALIZER);

    public static RegistrySupplier<RecipeSerializer<?>> SKIN_UPGRADE = SERIALIZERS.register("skin_upgrade",
            SkinUpgradeRecipe::createSerializer);

    public static void init() {
        SERIALIZERS.register();
    }
}
