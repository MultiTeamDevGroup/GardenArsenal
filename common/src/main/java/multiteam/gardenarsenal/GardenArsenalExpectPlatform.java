package multiteam.gardenarsenal;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.registries.GardenArsenalTrades;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.io.File;
import java.util.function.Supplier;

public class GardenArsenalExpectPlatform {
    /**
     * We can use {@link Platform#getConfigFolder()} but this is just an example of {@link ExpectPlatform}.
     * <p>
     * This must be a public static method. The platform-implemented solution must be placed under a
     * platform sub-package, with its class suffixed with {@code Impl}.
     * <p>
     * Example:
     * Expect: net.examplemod.ExampleExpectPlatform#getConfigDirectory()
     * Actual Fabric: net.examplemod.fabric.ExampleExpectPlatformImpl#getConfigDirectory()
     * Actual Forge: net.examplemod.forge.ExampleExpectPlatformImpl#getConfigDirectory()
     */
    @ExpectPlatform
    public static File getConfigDirectory() {
        // Just throw an error, the content should get replaced at runtime.
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void registerPoiType(PoiType poi) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static RecipeSerializer<?> createRecipeSerializer(RecipeSerializer<?> recipeSerializer) {
        throw new AssertionError();
    }
}
