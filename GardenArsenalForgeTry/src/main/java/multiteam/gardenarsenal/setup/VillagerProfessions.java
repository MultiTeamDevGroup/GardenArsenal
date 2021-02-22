package multiteam.gardenarsenal.setup;

import com.google.common.collect.ImmutableSet;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.fml.RegistryObject;

public class VillagerProfessions {

    private static final ImmutableSet<Item> COMMANDER_ITEMS = ImmutableSet.of(Items.BONE, Items.APPLE);
    public static final RegistryObject<VillagerProfession> GARDEN_SOLDIER_COMMANDER = Registration.VILLAGER_PROFESSIONS.register("garden_soldier_commander", () -> new VillagerProfession("garden_soldier_commander", new PointOfInterestType("garden_soldier_commander_poi", ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get().getDefaultState()), 5, 40), COMMANDER_ITEMS, ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get()), SoundEvents.ENTITY_VILLAGER_WORK_WEAPONSMITH));


    /**
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, GardenArsenalMod.MOD_ID);

    public static final RegistryObject<VillagerProfession> SOLDEIROFFICER = PROFESSIONS.register("garsen_soldier_commandr",() -> new VillagerProfession("garsen_soldier_commandr", new PointOfInterestType("hunting_table",ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get().getDefaultState()), 5, 40), ImmutableSet.of(ModBlocks.HUNTING_TABLE.get()),SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));

     send help ;-;

     or this?

     private static final ImmutableSet<Item> HUNTER_ITEMS = ImmutableSet.of();
     public static final RegistryObject<VillagerProfession> HUNTER = VILLAGER_PROFESSIONS.register("garden_soldier_commander", () -> new VillagerProfession("garden_soldier_commander", new PointOfInterestType("garden_soldier_commander_poi", ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get().getDefaultState()), 5, 40), HUNTER_ITEMS, ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI.get()),SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));

     nah, still nothing ;-;
     **/

    static void register() {}
}
