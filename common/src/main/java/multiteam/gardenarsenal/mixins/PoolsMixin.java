package multiteam.gardenarsenal.mixins;

import multiteam.gardenarsenal.utils.ModifiableStructurePool;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.data.worldgen.ProcessorLists;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.structures.StructurePoolElement;
import net.minecraft.world.level.levelgen.feature.structures.StructureTemplatePool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Pools.class)
public class PoolsMixin {

    @Inject(method = "register", at = @At("HEAD"))
    private static void gardenarsenal$injectVillagerHouses(StructureTemplatePool structureTemplatePool, CallbackInfoReturnable<StructureTemplatePool> cir) {
        gardenarsenal$tryAdding(new ResourceLocation("village/plains/houses"), structureTemplatePool, "gardenarsenal:village/plains/houses/ga_commander_tent");
        gardenarsenal$tryAdding(new ResourceLocation("village/plains/houses"), structureTemplatePool, "gardenarsenal:village/plains/houses/ga_soldier_tent");
    }

    private static void gardenarsenal$tryAdding(ResourceLocation poolId, StructureTemplatePool pool, String location) {
        if (poolId.equals(pool.getName())) {
            ModifiableStructurePool mPool = new ModifiableStructurePool(pool);
            mPool.addStructurePoolElement(StructurePoolElement.legacy(location, ProcessorLists.EMPTY).apply(StructureTemplatePool.Projection.RIGID), 2);
        }
    }
}
