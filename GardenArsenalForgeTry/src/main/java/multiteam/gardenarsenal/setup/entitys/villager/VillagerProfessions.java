package multiteam.gardenarsenal.setup.entitys.villager;

import com.google.common.collect.ImmutableSet;
import multiteam.gardenarsenal.GardenArsenalMod;
import multiteam.gardenarsenal.setup.ModBlocks;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = GardenArsenalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(GardenArsenalMod.MOD_ID)
public class VillagerProfessions {

    public static final VillagerProfession GARSENAL_SOLDIER_COMMANDER = null;
    /**
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, GardenArsenalMod.MOD_ID);

    public static final RegistryObject<VillagerProfession> SOLDEIROFFICER = PROFESSIONS.register("garsen_soldier_commandr",() -> new VillagerProfession("garsen_soldier_commandr", new PointOfInterestType("hunting_table",ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get().getDefaultState()), 5, 40), ImmutableSet.of(ModBlocks.HUNTING_TABLE.get()),SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));

     send help ;-;

     or this?

     private static final ImmutableSet<Item> HUNTER_ITEMS = ImmutableSet.of();
     public static final RegistryObject<VillagerProfession> HUNTER = VILLAGER_PROFESSIONS.register("garden_soldier_commander", () -> new VillagerProfession("garden_soldier_commander", new PointOfInterestType("garden_soldier_commander_poi", ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get().getDefaultState()), 5, 40), HUNTER_ITEMS, ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get()),SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));

     nah, still nothing ;-;
     **/

    @SubscribeEvent
    public static void registerVillagerProfessions(RegistryEvent.Register<VillagerProfession> event)
    {
        IForgeRegistry<VillagerProfession> registry = event.getRegistry();

        registry.register(VillagerUtil.villagerProfession("garden_soldier_commander", PointOfInterests.GARSENAL_SOLDIER_COMMANDER, ImmutableSet.of(), ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get()), null).setRegistryName(GardenArsenalMod.MOD_ID, "garden_soldier_commander"));
    }


}
