package multiteam.gardenarsenal.forge;

import com.google.common.collect.ImmutableSet;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.loading.FMLPaths;

import javax.annotation.Nullable;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
        try {
            Constructor<PoiType> constructor = PoiType.class.getDeclaredConstructor(String.class, Set.class, int.class, int.class);

            return constructor.newInstance(string, set, i, i);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
