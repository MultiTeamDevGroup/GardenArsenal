package multiteam.gardenarsenal.forge;

import com.google.common.collect.ImmutableSet;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.registries.GardenArsenalTrades;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.File;
import java.util.Set;

public class GardenArsenalExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardenArsenalExpectPlatform#getConfigDirectory()}.
     */
    public static File getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get().toFile();
    }

    public static VillagerProfession createProfession(String nameIn, ResourceLocation pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, SoundEvent soundIn) {
        return new VillagerProfession(
                nameIn,
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
        return new ForgeRecipeSerializer<>(recipeSerializer);
    }

    public static void registerTrades(GardenArsenalTrades.TradeListBuilder tradeListBuilder) {
        GardenArsenalForge.tradeListBuilders.add(tradeListBuilder);
    }
}
