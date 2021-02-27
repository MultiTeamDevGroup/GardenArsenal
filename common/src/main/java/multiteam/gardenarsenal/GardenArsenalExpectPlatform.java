package multiteam.gardenarsenal;

import com.google.common.collect.ImmutableSet;
import me.shedaniel.architectury.annotations.ExpectPlatform;
import me.shedaniel.architectury.platform.Platform;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.io.File;
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
}
