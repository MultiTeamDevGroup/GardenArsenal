package multiteam.gardenarsenal.utils;

import com.mojang.datafixers.util.Pair;
import multiteam.gardenarsenal.mixins.StructureTemplatePoolAccessor;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;

import java.util.List;

public record ModifiableStructurePool(
        StructureTemplatePool pool) {

    public void addStructurePoolElement(StructurePoolElement element) {
        addStructurePoolElement(element, 1);
    }

    public void addStructurePoolElement(StructurePoolElement element, int weight) {
        for (int i = 0; i < weight; i++) {
            ((StructureTemplatePoolAccessor) pool).getTemplates().add(element);
        }
        ((StructureTemplatePoolAccessor) pool).getRawTemplates().add(Pair.of(element, weight));
    }

    public List<StructurePoolElement> getElements() {
        return ((StructureTemplatePoolAccessor) pool).getTemplates();
    }

    public StructureTemplatePool getStructurePool() {
        return pool;
    }
}
