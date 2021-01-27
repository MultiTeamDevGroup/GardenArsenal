package multiteam.gardenarsenal.setup;

import multiteam.gardenarsenal.GardenArsenalMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final RegistryObject<Block> MACHINE_BLOCK = register("machine_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON).hardnessAndResistance(6, 6).harvestLevel(2).sound(SoundType.NETHERITE)));

    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block){
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name_, Supplier<T> block_){
        RegistryObject<T> ret = registerNoItem(name_, block_);
        Registration.ITEMS.register(name_, () -> new BlockItem(ret.get(), new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
        return ret;
    }
}


























