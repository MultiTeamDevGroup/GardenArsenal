package multiteam.gardenarsenal.setup;

import multiteam.gardenarsenal.GardenArsenalMod;
import net.minecraft.block.Block;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GardenArsenalMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GardenArsenalMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, GardenArsenalMod.MOD_ID);
    // WHAT IS HAPPENING   public static final RegistryObject<VillagerProfession> SOLDEIROFFICER = VILLAGER_PROFESSIONS.register("garsen_soldier_commandr",() -> new VillagerProfession("garsen_soldier_commandr", new PointOfInterestType("hunting_table", ImmutableSet.of(), ImmutableSet.of(), 5, 40), ImmutableSet.of(ModBlocks.GARDEN_SOLDIER_COMMANDER_POI), SoundEvents.ENTITY_VILLAGER_WORK_BUTCHER));


    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        VILLAGER_PROFESSIONS.register(modEventBus);


        ModBlocks.register();
        ModItems.register();
        VillagerProfessions.register();
    }
}
