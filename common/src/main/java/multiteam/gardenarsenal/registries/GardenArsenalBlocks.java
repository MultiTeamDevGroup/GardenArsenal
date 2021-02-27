package multiteam.gardenarsenal.registries;

import me.shedaniel.architectury.registry.BlockProperties;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import me.shedaniel.architectury.registry.ToolType;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.blocks.TrapCake;
import net.minecraft.core.Registry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;

public class GardenArsenalBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(GardenArsenal.MOD_ID, Registry.BLOCK_REGISTRY);

    public static final RegistrySupplier<Block> MACHINE_BLOCK = BLOCKS.register("machine_block",
            () -> new Block(BlockProperties.of(Material.METAL).tool(ToolType.PICKAXE, 2).strength(6, 6).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistrySupplier<Block> TRAP_CAKE = BLOCKS.register("trap_cake",
            () -> new TrapCake(BlockProperties.of(Material.CAKE).sound(SoundType.WOOL).strength(0.5F)));
    public static final RegistrySupplier<Block> GARDEN_SOLDIER_COMMANDER_POI = BLOCKS.register("garden_soldier_commander_poi",
            () -> new Block(BlockProperties.of(Material.WOOD).tool(ToolType.AXE, 1).strength(3,3).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> GARDEN_SOLDIER_POI = BLOCKS.register("garden_soldier_poi",
            () -> new Block(BlockProperties.of(Material.WOOD).tool(ToolType.AXE, 1).strength(3,3).sound(SoundType.WOOD)));

    public static void init() {
        BLOCKS.register();
    }
}
