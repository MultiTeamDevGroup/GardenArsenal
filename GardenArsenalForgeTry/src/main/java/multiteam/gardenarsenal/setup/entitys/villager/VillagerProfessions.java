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

    public static final RegistryObject<VillagerProfession> SOLDEIROFFICER = PROFESSIONS.register("hunter",() -> new VillagerProfession("hunter",new PointOfInterestType("hunting_table",ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get().getDefaultState()), 5, 40), ImmutableSet.of(ModBlocks.HUNTING_TABLE.get()),SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));

     send help ;-;
     **/

    @SubscribeEvent
    public static void registerVillagerProfessions(RegistryEvent.Register<VillagerProfession> event)
    {
        IForgeRegistry<VillagerProfession> registry = event.getRegistry();

        registry.register(VillagerUtil.villagerProfession("garden_soldier_commander", PointOfInterests.GARSENAL_SOLDIER_COMMANDER, ImmutableSet.of(), ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get()), null).setRegistryName(GardenArsenalMod.MOD_ID, "garden_soldier_commander"));
    }


}
