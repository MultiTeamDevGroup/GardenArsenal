package multiteam.gardenarsenal.registries;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.blocks.TrapCake;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static Block MACHINE_BLOCK;
    public static Block TRAP_CAKE;

    public static void init() {
        MACHINE_BLOCK = register("machine_block", new Block(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES, 2).strength(6,6).sounds(BlockSoundGroup.NETHERITE)));
        TRAP_CAKE = register("trap_cake", new TrapCake(AbstractBlock.Settings.of(Material.CAKE).sounds(BlockSoundGroup.WOOL).strength(0.5F)));
    }

    private static Block register(String name, Block block) {
        Identifier id = GardenArsenal.id(name);
        Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Settings().group(GardenArsenal.MISC)));
        return Registry.register(Registry.BLOCK, id, block);
    }
}
