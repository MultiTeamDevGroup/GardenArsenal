package multiteam.gardenarsenal.mixin;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.utils.SkinModelProperty;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperties;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SelectItemModelProperties.class)
public class SelectItemModelPropertiesMixin {
    @Shadow
    @Final
    private static ExtraCodecs.LateBoundIdMapper<ResourceLocation, SelectItemModelProperty.Type<?, ?>> ID_MAPPER;

    @Inject(method = "bootstrap", at = @At("HEAD"))
    private static void gardenarsenal_register(CallbackInfo ci) {
        ID_MAPPER.put(GardenArsenal.id("skin"), SkinModelProperty.TYPE);
    }
}
