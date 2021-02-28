package multiteam.gardenarsenal.fabric.mixin;

import multiteam.gardenarsenal.GardenArsenal;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Villager.class)
public abstract class VillagerMixin extends AbstractVillager {

    public VillagerMixin(EntityType<? extends AbstractVillager> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow public abstract VillagerData getVillagerData();

    @Inject(method = "getTypeName", at = @At("RETURN"), cancellable = true)
    private void fixGardenArsenalProfessionName(CallbackInfoReturnable<Component> cir) {
        ResourceLocation professionKey = Registry.VILLAGER_PROFESSION.getKey(this.getVillagerData().getProfession());
        if (professionKey.getNamespace().equals(GardenArsenal.MOD_ID)) {
            cir.setReturnValue(new TranslatableComponent(this.getType().getDescriptionId() + '.' + professionKey.getNamespace() + '.' + professionKey.getPath()));
        }
    }
}
