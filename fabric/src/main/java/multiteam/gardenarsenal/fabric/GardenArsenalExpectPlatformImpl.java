package multiteam.gardenarsenal.fabric;

import com.google.common.collect.ImmutableSet;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class GardenArsenalExpectPlatformImpl {
    /**
     * This is our actual method to {@link GardenArsenalExpectPlatform#getConfigDirectory()}.
     */
    public static File getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir().toFile();
    }

    public static VillagerProfession createProfession(String nameIn, PoiType pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, SoundEvent soundIn) {
        try {
            Constructor<VillagerProfession> constructor = VillagerProfession.class.getDeclaredConstructor(String.class, PoiType.class, ImmutableSet.class, ImmutableSet.class, SoundEvent.class);
            constructor.setAccessible(true);
            return constructor.newInstance(nameIn, pointOfInterestIn, specificItemsIn, relatedWorldBlocksIn, soundIn);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PoiType createPoi(String string, Set<BlockState> set, int i, int j) {
        try {
            Constructor<PoiType> constructor = PoiType.class.getDeclaredConstructor(String.class, Set.class, int.class, int.class);
            constructor.setAccessible(true);
            PoiType type = constructor.newInstance(string, set, i, i);

            for (Method method : PoiType.class.getDeclaredMethods()) {
                if (method.getParameterCount() == 1 && method.getParameterTypes()[0] == PoiType.class) {
                    method.setAccessible(true);
                    method.invoke(type, type);
                    break;
                }
            }

            return type;
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
