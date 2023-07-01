package multiteam.gardenarsenal.registries;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.utils.JigsawUtils;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class GardenArsenalStructures {

    public static final ResourceLocation PLAINS_HOUSES = new ResourceLocation("village/plains/houses");

    public static void registerStructures(MinecraftServer server) {
        Registry<StructureTemplatePool> templatePoolRegistry = server.registryAccess().registry(Registry.TEMPLATE_POOL_REGISTRY).orElseThrow();
        Registry<StructureProcessorList> processorListRegistry = server.registryAccess().registry(Registry.PROCESSOR_LIST_REGISTRY).orElseThrow();

        JigsawUtils.addBuildingToPool(templatePoolRegistry, processorListRegistry, PLAINS_HOUSES,
                new ResourceLocation(GardenArsenal.MOD_ID, "village/plains/houses/ga_commander_tent"), 6);
        JigsawUtils.addBuildingToPool(templatePoolRegistry, processorListRegistry, PLAINS_HOUSES,
                new ResourceLocation(GardenArsenal.MOD_ID, "village/plains/houses/ga_soldier_tent"), 6);
    }
}
