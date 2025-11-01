package multiteam.gardenarsenal.utils;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import multiteam.gardenarsenal.registries.GardenArsenalDataComponents;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public record SkinModelProperty() implements SelectItemModelProperty<String> {
    public static final SelectItemModelProperty.Type<SkinModelProperty, String> TYPE;

    @Override
    public @Nullable String get(ItemStack itemStack, @Nullable ClientLevel clientLevel, @Nullable LivingEntity livingEntity, int i, ItemDisplayContext itemDisplayContext) {
        var skin = itemStack.get(GardenArsenalDataComponents.SKIN.get());
        return skin != null ? skin.getSerializedName() : null;
    }

    @Override
    public Codec<String> valueCodec() {
        return Codec.STRING;
    }

    @Override
    public Type<? extends SelectItemModelProperty<String>, String> type() {
        return TYPE;
    }

    static {
        TYPE = Type.create(MapCodec.unit(new SkinModelProperty()), Codec.STRING);
    }
}
