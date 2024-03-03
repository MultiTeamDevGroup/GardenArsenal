package multiteam.gardenarsenal.forge;

import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;

public class GardenArsenalExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardenArsenalExpectPlatform#getConfigDirectory()}.
     */
    public static File getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get().toFile();
    }

    public static RecipeSerializer<?> createRecipeSerializer(RecipeSerializer<?> recipeSerializer) {
        return new ForgeRecipeSerializer<>(recipeSerializer);
    }

    public static void registerPoiType(PoiType poi) {}
}
