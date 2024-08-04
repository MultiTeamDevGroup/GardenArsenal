package multiteam.gardenarsenal.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;

public class GardenArsenalDataComponents {
    private static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPE = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.DATA_COMPONENT_TYPE);

    public static final RegistrySupplier<DataComponentType<Skins>> SKIN = DATA_COMPONENT_TYPE.register("skin",
            () -> DataComponentType.<Skins>builder()
                    .persistent(Skins.CODEC)
                    .networkSynchronized(Skins.STREAM_CODEC)
                    .build());
    public static final RegistrySupplier<DataComponentType<Integer>> SHELL_LOAD = DATA_COMPONENT_TYPE.register("shell_load",
            () -> DataComponentType.<Integer>builder()
                    .persistent(ExtraCodecs.NON_NEGATIVE_INT)
                    .networkSynchronized(ByteBufCodecs.VAR_INT)
                    .build());

    public static void init() {
        DATA_COMPONENT_TYPE.register();
    }
}
