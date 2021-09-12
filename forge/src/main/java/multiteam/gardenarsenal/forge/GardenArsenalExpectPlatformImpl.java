package multiteam.gardenarsenal.forge;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.registries.GardenArsenalTrades;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;
import net.minecraftforge.fml.loading.FMLPaths;

import javax.annotation.Nullable;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

public class GardenArsenalExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardenArsenalExpectPlatform#getConfigDirectory()}.
     */
    public static File getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get().toFile();
    }

    public static VillagerProfession createProfession(String nameIn, PoiType pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, SoundEvent soundIn) {
        return new VillagerProfession(nameIn, pointOfInterestIn, specificItemsIn, relatedWorldBlocksIn, soundIn);
    }

    public static PoiType createPoi(String string, Set<BlockState> set, int i, int j) {
        return new PoiType(string, set, i, j);
    }

    public static RecipeSerializer<?> createRecipeSerializer(RecipeSerializer<?> recipeSerializer) {
        return new ForgeRecipeSerializer<>(recipeSerializer);
    }

    public static void registerTrades(GardenArsenalTrades.TradeListBuilder tradeListBuilder) {
        GardenArsenalForge.tradeListBuilders.add(tradeListBuilder);
    }

    public static List<StructurePoolElement> getPoolElements(StructureTemplatePool pool) {
        return pool.templates;
    }

    public static void setPoolElements(StructureTemplatePool pool, List<StructurePoolElement> elements) {
        pool.templates = elements;
    }

    public static List<Pair<StructurePoolElement, Integer>> getPoolElementCounts(StructureTemplatePool pool) {
        return pool.rawTemplates;
    }

    public static void setPoolElementCounts(StructureTemplatePool pool, List<Pair<StructurePoolElement, Integer>> elementCounts) {
        pool.rawTemplates = elementCounts;
    }
}
