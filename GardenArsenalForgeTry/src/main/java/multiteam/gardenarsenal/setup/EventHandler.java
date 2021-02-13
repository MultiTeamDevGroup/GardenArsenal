package multiteam.gardenarsenal.setup;

import multiteam.gardenarsenal.GardenArsenalMod;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GardenArsenalMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onCreated(final PlayerEvent.ItemCraftedEvent event){
        //if(event.getCrafting())
        //ItemStack item = event.getCrafting();

    }

}
