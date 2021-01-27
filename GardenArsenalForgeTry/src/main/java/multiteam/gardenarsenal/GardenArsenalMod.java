package multiteam.gardenarsenal;

import multiteam.gardenarsenal.setup.*;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(GardenArsenalMod.MOD_ID)
public class GardenArsenalMod {

    public static final String MOD_ID = "gardenarsenal";
    private static final Logger LOGGER = LogManager.getLogger();

    public static final ModItemGroup GARDEN_ARSENAL_WEAPONS_TAB = new ModItemGroup("garden_arsenal_weapons_tab", () -> new ItemStack(ModItems.CARROT_RIFLE.get()));
    public static final ModItemGroup GARDEN_ARSENAL_MISC_TAB = new ModItemGroup("garden_arsenal_misc_tab", () -> new ItemStack(ModBlocks.MACHINE_BLOCK.get()));

    public GardenArsenalMod() {

        Registration.register();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {

        InterModComms.sendTo("gardenarsenal", "helloworld", () -> { LOGGER.info("Garden Arsenal's own hello world :)"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {

        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            LOGGER.info("Garden Arsenal is keeping the old fashion Registry block, since idk when im gonna need it.");
        }
    }


}
