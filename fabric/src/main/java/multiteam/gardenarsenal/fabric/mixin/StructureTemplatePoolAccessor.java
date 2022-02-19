package multiteam.gardenarsenal.fabric.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(StructureTemplatePool.class)
public interface StructureTemplatePoolAccessor {

    @Accessor("rawTemplates")
    List<Pair<StructurePoolElement, Integer>> getRawTemplates();

    @Mutable
    @Accessor("rawTemplates")
    void setRawTemplates(List<Pair<StructurePoolElement, Integer>> rawTemplates);

    @Accessor("templates")
    List<StructurePoolElement> getTemplates();

    @Mutable
    @Accessor("templates")
    void setTemplates(List<StructurePoolElement> rawTemplates);
}
