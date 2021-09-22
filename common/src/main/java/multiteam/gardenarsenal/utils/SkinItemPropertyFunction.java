package multiteam.gardenarsenal.utils;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SkinItemPropertyFunction implements ClampedItemPropertyFunction {

    @Override
    public float unclampedCall(ItemStack stack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i) {
        if (stack.getTag() == null)
            return 0;
        String skinName = stack.getTag().getString("skinType");
        Skins Skin = skinName.isEmpty() ? Skins.Default : Skins.valueOf(skinName);
        return Skin.ordinal() >= 15 ? (float) ((Skin.ordinal() + 1) / 100.0) : (float) (Skin.ordinal() / 100.0);
    }

    public float m_142187_(ItemStack arg, @Nullable ClientLevel arg2, @Nullable LivingEntity arg3, int i) {
        return this.unclampedCall(arg, arg2, arg3, i);
    }
}
