package multiteam.gardenarsenal.registries;

import com.mojang.datafixers.util.Pair;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class GardenArsenalStructures {

    public static final ResourceLocation PLAINS_HOUSES = new ResourceLocation("village/plains/houses");

    public static List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> getPoolAdditions() {
        List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> list = new ArrayList<>();

        list.add(Pair.of(
                StructurePoolElement.legacy(
                        "gardenarsenal:village/plains/houses/ga_commander_tent"
                ),
                2
        ));

        list.add(Pair.of(
                StructurePoolElement.legacy(
                        "gardenarsenal:village/plains/houses/ga_soldier_tent"
                ),
                2
        ));

        return list;
    }
}
