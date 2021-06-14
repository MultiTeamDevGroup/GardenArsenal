package multiteam.gardenarsenal.mixins;

import com.mojang.datafixers.util.Pair;
import multiteam.gardenarsenal.registries.GardenArsenalStructures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Mixin(StructureTemplatePool.class)
public class MixinStructureTemplatePool {

    @ModifyVariable(
            method = "<init>(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/resources/ResourceLocation;Ljava/util/List;Lnet/minecraft/world/level/levelgen/feature/structures/StructureTemplatePool$Projection;)V",
            at = @At("HEAD")
    )
    private static List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> gardenarsenal$injectVillagerHouses(
            List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> list, ResourceLocation id, ResourceLocation terminatorsId,
            List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> elementCounts, StructureTemplatePool.Projection projection) {
        if (id.equals(GardenArsenalStructures.PLAINS_HOUSES)) {
            List<Pair<Function<StructureTemplatePool.Projection, ? extends StructurePoolElement>, Integer>> copy = new ArrayList<>(list);

            copy.addAll(GardenArsenalStructures.getPoolAdditions());

            return copy;
        }

        return list;
    }
}
