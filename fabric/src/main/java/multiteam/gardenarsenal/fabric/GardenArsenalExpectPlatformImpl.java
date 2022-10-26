package multiteam.gardenarsenal.fabric;

import com.google.common.collect.ImmutableSet;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.registries.GardenArsenalTrades;
import multiteam.gardenarsenal.utils.RandomTradeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GardenArsenalExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardenArsenalExpectPlatform#getConfigDirectory()}.
     */
    public static File getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir().toFile();
    }

    public static VillagerProfession createProfession(String nameIn, ResourceLocation pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, SoundEvent soundIn) {
        return new VillagerProfession(
                new ResourceLocation(GardenArsenal.MOD_ID, nameIn).toString(),
                poiTypeHolder -> poiTypeHolder.is(pointOfInterestIn),
                poiTypeHolder -> poiTypeHolder.is(pointOfInterestIn),
                specificItemsIn,
                relatedWorldBlocksIn,
                soundIn
        );
    }

    public static PoiType createPoi(String string, Set<BlockState> set, int i, int j) {
        return new PoiType(set, i, j);
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
}
