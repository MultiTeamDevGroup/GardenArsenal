package multiteam.gardenarsenal.registries;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.utils.JigsawUtils;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class GardenArsenalStructures {

    public static final ResourceLocation PLAINS_HOUSES = ResourceLocation.withDefaultNamespace("village/plains/houses");

    public static void registerStructures(MinecraftServer server) {
        Registry<StructureTemplatePool> templatePoolRegistry = server.registryAccess().lookupOrThrow(Registries.TEMPLATE_POOL);
        Registry<StructureProcessorList> processorListRegistry = server.registryAccess().lookupOrThrow(Registries.PROCESSOR_LIST);

        JigsawUtils.addBuildingToPool(templatePoolRegistry, processorListRegistry, PLAINS_HOUSES,
                GardenArsenal.id("village/plains/houses/ga_commander_tent"), 6);
        JigsawUtils.addBuildingToPool(templatePoolRegistry, processorListRegistry, PLAINS_HOUSES,
                GardenArsenal.id("village/plains/houses/ga_soldier_tent"), 6);
    }
}
