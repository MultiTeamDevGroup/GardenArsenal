package multiteam.gardenarsenal.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.blocks.AmmoCrate;
import multiteam.gardenarsenal.blocks.TrapCake;
import multiteam.gardenarsenal.blocks.WarTacticTable;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import java.util.function.Supplier;

public class GardenArsenalBlocks {

                                                                  //see this line here? ingore it cuz its just cringe ->


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.BLOCK);

    //Vanilla Garden Arsenal - as of v0.3.1
    public static final RegistrySupplier<Block> MACHINE_BLOCK = BLOCKS.register("machine_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6, 6).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistrySupplier<Block> TRAP_CAKE = BLOCKS.register("trap_cake", () -> new TrapCake(BlockBehaviour.Properties.of(Material.CAKE).sound(SoundType.WOOL).strength(0.5F)));
    public static final RegistrySupplier<Block> WAR_TACTIC_TABLE = BLOCKS.register("war_tactic_table", () -> new WarTacticTable(BlockBehaviour.Properties.of(Material.WOOD).strength(2, 2).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistrySupplier<Block> AMMO_CRATE = BLOCKS.register("ammo_crate", () -> new AmmoCrate(BlockBehaviour.Properties.of(Material.WOOD).strength(2, 2).sound(SoundType.WOOD).noOcclusion()));

    //0.4.0 - update to 1.17

    //Makers Shift Update - v0.5
//    public static final RegistrySupplier<Block> SCRAP_WOOD_PILE = registerWithItem("scrap_wood_pile", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(1.0f, 2.0f).sound(SoundType.WOOD)), new Item.Properties().tab(GardenArsenalItems.MISC));
//    public static final RegistrySupplier<Block> MAKERS_CONCRETE_POWDER_BLOCK = registerWithItem("makers_concrete_powder", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(0.5f,0.5f).sound(SoundType.SAND)), new Item.Properties().tab(GardenArsenalItems.MISC));
//    public static final RegistrySupplier<Block> REINFORCED_METAL_BLOCK = registerWithItem("reinforced_metal_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(10.f, 200.0f).sound(SoundType.NETHERITE_BLOCK)), new Item.Properties().tab(GardenArsenalItems.MISC));
//    public static final RegistrySupplier<Block> INDUSTRIAL_BARRIER_BLOCK = registerWithItem("industrial_barrier_block", () -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(10.0f, 100.0f).sound(SoundType.NETHERITE_BLOCK)), new Item.Properties().tab(GardenArsenalItems.MISC));
//    public static final RegistrySupplier<Block> BARRICADE_SURVIVALIST = registerWithItem("survivalist_barricade", () -> new BarricadeBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0f, 3.0f).sound(SoundType.BAMBOO)), new Item.Properties().tab(GardenArsenalItems.MISC));
//    public static final RegistrySupplier<Block> BARRICADE_MAKER = registerWithItem("maker_barricade", () -> new BarricadeBlock(BlockBehaviour.Properties.of(Material.STONE).strength(15.0f, 100.0f).sound(SoundType.NETHER_BRICKS)), new Item.Properties().tab(GardenArsenalItems.MISC));
//    public static final RegistrySupplier<Block> BARRICADE_INDUSTRIAL = registerWithItem("industrial_barricade", () -> new BarricadeBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(40.0f, 900.0f).sound(SoundType.ANVIL)), new Item.Properties().tab(GardenArsenalItems.MISC));



    public static void init() {
        BLOCKS.register();
    }

    private static <T extends Block> RegistrySupplier<T> registerNoItem(String name, Supplier<T> block){
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block, Item.Properties itemProperties){
        RegistrySupplier<T> ret = registerNoItem(name, block);
        GardenArsenalItems.ITEMS.register(name, () -> new BlockItem(ret.get(), itemProperties));
        return ret;
    }
}
