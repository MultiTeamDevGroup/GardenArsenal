package multiteam.gardenarsenal;

import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.platform.Platform;
import multiteam.gardenarsenal.registries.GardenArsenalTrades;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.io.File;
import java.util.List;
import java.util.Set;

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
    public static VillagerProfession createProfession(String nameIn, PoiType pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, SoundEvent soundIn) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static PoiType createPoi(String string, Set<BlockState> set, int i, int j) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static RecipeSerializer<?> createRecipeSerializer(RecipeSerializer<?> recipeSerializer) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void registerTrades(GardenArsenalTrades.TradeListBuilder tradeListBuilder) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static List<StructurePoolElement> getPoolElements(StructureTemplatePool pool) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void setPoolElements(StructureTemplatePool pool, List<StructurePoolElement> elements) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static List<Pair<StructurePoolElement, Integer>> getPoolElementCounts(StructureTemplatePool pool) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static void setPoolElementCounts(StructureTemplatePool pool, List<Pair<StructurePoolElement, Integer>> elementCounts) {
        throw new AssertionError();
    }
}
