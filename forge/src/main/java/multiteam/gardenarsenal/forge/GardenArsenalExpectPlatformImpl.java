package multiteam.gardenarsenal.forge;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.registries.GardenArsenalTrades;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.File;
import java.util.function.Supplier;

public class GardenArsenalExpectPlatformImpl {
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, GardenArsenal.MOD_ID);
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, GardenArsenal.MOD_ID);

    /**
     * This is our actual method to {@link GardenArsenalExpectPlatform#getConfigDirectory()}.
     */
    public static File getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get().toFile();
    }

    public static RecipeSerializer<?> createRecipeSerializer(RecipeSerializer<?> recipeSerializer) {
        return new ForgeRecipeSerializer<>(recipeSerializer);
    }

    public static void registerTrades(GardenArsenalTrades.TradeListBuilder tradeListBuilder) {
        GardenArsenalForge.tradeListBuilders.add(tradeListBuilder);
    }

    public static Supplier<PoiType> registerPoiType(String name, Supplier<PoiType> poiType) {
        return POI_TYPES.register(name, poiType);
    }

    public static Supplier<VillagerProfession> registerProfession(String name, Supplier<VillagerProfession> profession) {
        return PROFESSIONS.register(name, profession);
    }
}
