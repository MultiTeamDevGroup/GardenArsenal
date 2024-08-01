package multiteam.gardenarsenal.registries;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class GardenArsenalCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.CREATIVE_MODE_TAB);

    public static final RegistrySupplier<CreativeModeTab> WEAPONS = TABS.register("weapons", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup.gardenarsenal.weapons"),
                    () -> new ItemStack(GardenArsenalItems.CARROT_RIFLE.get())));
    public static final RegistrySupplier<CreativeModeTab> MISC = TABS.register("misc", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup.gardenarsenal.misc"),
                    () -> new ItemStack(GardenArsenalItems.PROJECTILE_CARROT.get())));

    public static void init() {
        TABS.register();
    }
}
