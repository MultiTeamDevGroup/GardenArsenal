package multiteam.gardenarsenal.fabric;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.mixin.PoiTypesInvoker;
import multiteam.gardenarsenal.registries.GardenArsenalTrades;
import multiteam.gardenarsenal.utils.RandomTradeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.crafting.RecipeSerializer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

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

    public static void registerTrades(GardenArsenalTrades.TradeListBuilder tradeListBuilder) {
        VillagerProfession profession = tradeListBuilder.getProfession().get();
        for (int i = 0; i < tradeListBuilder.size(); i++) {
            int level = i + 1;
            List<VillagerTrades.ItemListing> list = new ArrayList<>();
            for (RandomTradeBuilder randomTradeBuilder : tradeListBuilder.get(i)) {
                list.add(randomTradeBuilder.build());
            }
            TradeOfferHelper.registerVillagerOffers(profession, level, factory -> factory.addAll(list));
        }
    }

    public static Supplier<PoiType> registerPoiType(String name, Supplier<PoiType> poiType) {
        ResourceKey<PoiType> resourceKey = ResourceKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, new ResourceLocation(GardenArsenal.MOD_ID, name));
        var registry = Registry.register(Registry.POINT_OF_INTEREST_TYPE, resourceKey, poiType.get());
        PoiTypesInvoker.invokeRegisterBlockStates(Registry.POINT_OF_INTEREST_TYPE.getHolderOrThrow(resourceKey));
        return () -> registry;
    }

    public static Supplier<VillagerProfession> registerProfession(String name, Supplier<VillagerProfession> profession) {
        var registry = Registry.register(Registry.VILLAGER_PROFESSION, new ResourceLocation(GardenArsenal.MOD_ID, name), profession.get());
        return () -> registry;
    }
}
