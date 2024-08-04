package multiteam.gardenarsenal.utils;

import multiteam.gardenarsenal.registries.GardenArsenalDataComponents;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SkinItemPropertyFunction implements ClampedItemPropertyFunction {

    @Override
    public float unclampedCall(ItemStack stack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i) {
        if (!stack.has(GardenArsenalDataComponents.SKIN.get()))
            return 0;

        Skins Skin = stack.get(GardenArsenalDataComponents.SKIN.get());
        return Skin.ordinal() / 100.0F;
    }
}
