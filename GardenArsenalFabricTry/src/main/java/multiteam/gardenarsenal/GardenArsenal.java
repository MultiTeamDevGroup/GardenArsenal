package multiteam.gardenarsenal;

import multiteam.gardenarsenal.registries.ModBlocks;
import multiteam.gardenarsenal.registries.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GardenArsenal implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "gardenarsenal";

	public static final ItemGroup WEAPONS = FabricItemGroupBuilder
			.create(GardenArsenal.id("weapons"))
			.icon(() -> new ItemStack(ModItems.CARROT_RIFLE))
			.build();
	public static final ItemGroup MISC = FabricItemGroupBuilder
			.create(GardenArsenal.id("misc"))
			.icon(() -> new ItemStack(ModItems.PROJECTILE_CARROT))
			.build();

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Garden Arsenal.");
		ModBlocks.init();
		LOGGER.info("Blocks initialized.");
		ModItems.init();
		LOGGER.info("Items initialized.");
		LOGGER.info("Initialization done!");
	}

	public static Identifier id(String path) {
		return new Identifier(MODID, path);
	}
}
