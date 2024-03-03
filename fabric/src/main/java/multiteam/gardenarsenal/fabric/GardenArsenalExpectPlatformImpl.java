package multiteam.gardenarsenal.fabric;

import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.mixin.PoiTypesInvoker;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.io.File;

public class GardenArsenalExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardenArsenalExpectPlatform#getConfigDirectory()}.
     */
    public static File getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir().toFile();
    }

    public static RecipeSerializer<?> createRecipeSerializer(RecipeSerializer<?> recipeSerializer) {
        return recipeSerializer;
    }

    public static void registerPoiType(PoiType poi) {
        var key = BuiltInRegistries.POINT_OF_INTEREST_TYPE.getResourceKey(poi);
        PoiTypesInvoker.invokeRegisterBlockStates(BuiltInRegistries.POINT_OF_INTEREST_TYPE.getHolderOrThrow(key.get()), poi.matchingStates());
    }
}
