package multiteam.gardenarsenal.utils;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ItemPropertyFunction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SkinItemPropertyFunction implements ItemPropertyFunction {
    @Override
    public float call(ItemStack stack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity) {
        if (stack.getTag() == null)
            return 0;
        String skinName = stack.getTag().getString("skinType");
        Skins Skin = Skins.valueOf(skinName);
        return Skin.ordinal() >= 15 ? Skin.ordinal() + 1 : Skin.ordinal();
    }
}
