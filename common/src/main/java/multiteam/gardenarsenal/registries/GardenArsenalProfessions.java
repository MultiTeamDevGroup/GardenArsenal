package multiteam.gardenarsenal.registries;

import com.google.common.collect.ImmutableSet;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class GardenArsenalProfessions {

    private static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.VILLAGER_PROFESSION);

    public static RegistrySupplier<VillagerProfession> GARDEN_SOLDIER_COMMANDER = PROFESSIONS.register("garden_soldier_commander",
            () -> create("garden_soldier_commander", holder -> holder.value().equals(GardenArsenalPois.SOLDIER_COMMANDER_POI.get())));
    public static RegistrySupplier<VillagerProfession> GARDEN_SOLDIER = PROFESSIONS.register("garden_soldier",
            () -> create("garden_soldier", holder -> holder.value().equals(GardenArsenalPois.SOLDIER_POI.get())));

    public static void init() {
        PROFESSIONS.register();
    }

    private static VillagerProfession create(String name, Predicate<Holder<PoiType>> sites) {
        return new VillagerProfession(name, sites, sites, ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_WEAPONSMITH);
    }
}
