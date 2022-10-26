package multiteam.gardenarsenal.utils;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import multiteam.gardenarsenal.mixin.StructureTemplatePoolAccessor;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.ArrayList;
import java.util.List;

public class JigsawUtils {

    public static void registerJigsaw(MinecraftServer server, ResourceLocation poolLocation, ResourceLocation nbtLocation, int weight) {
        RegistryAccess manager = server.registryAccess();
        Registry<StructureTemplatePool> pools = manager.registryOrThrow(Registry.TEMPLATE_POOL_REGISTRY);
        StructureTemplatePool pool = pools.get(poolLocation);

        ObjectArrayList<StructurePoolElement> elements = ((StructureTemplatePoolAccessor)pool).getTemplates();

        StructurePoolElement element = StructurePoolElement.legacy(nbtLocation.toString(), ProcessorLists.EMPTY).apply(StructureTemplatePool.Projection.RIGID);
        for (int i = 0; i < weight; i++) {
            elements.add(element);
        }

        List<Pair<StructurePoolElement, Integer>> elementCounts = new ArrayList<>(((StructureTemplatePoolAccessor)pool).getRawTemplates());

        elements.addAll(((StructureTemplatePoolAccessor)pool).getTemplates());
        elementCounts.addAll(((StructureTemplatePoolAccessor)pool).getRawTemplates());

        ((StructureTemplatePoolAccessor)pool).setTemplates(elements);
        ((StructureTemplatePoolAccessor)pool).setRawTemplates(elementCounts);
    }

}
