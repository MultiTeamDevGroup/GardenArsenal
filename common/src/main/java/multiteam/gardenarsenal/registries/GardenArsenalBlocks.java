package multiteam.gardenarsenal.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.blocks.AmmoCrate;
import multiteam.gardenarsenal.blocks.BarricadeBlock;
import multiteam.gardenarsenal.blocks.TrapCake;
import multiteam.gardenarsenal.blocks.WarTacticTable;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Function;

public class GardenArsenalBlocks {

                                                                  //see this line here? ingore it cuz its just cringe ->


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.BLOCK);

    //Vanilla Garden Arsenal - as of v0.3.1
    public static final RegistrySupplier<Block> MACHINE_BLOCK = register("machine_block", (properties) -> new Block(properties.mapColor(MapColor.METAL).strength(6, 6).sound(SoundType.NETHERITE_BLOCK)));
    public static final RegistrySupplier<Block> TRAP_CAKE = register("trap_cake", (properties) -> new TrapCake(properties.mapColor(MapColor.NONE).pushReaction(PushReaction.DESTROY).sound(SoundType.WOOL).strength(0.5F)));
    public static final RegistrySupplier<Block> WAR_TACTIC_TABLE = register("war_tactic_table", (properties) -> new WarTacticTable(properties.mapColor(MapColor.WOOD).ignitedByLava().instrument(NoteBlockInstrument.BASS).strength(2, 2).sound(SoundType.WOOD).noOcclusion()));
    public static final RegistrySupplier<Block> AMMO_CRATE = register("ammo_crate", (properties) -> new AmmoCrate(properties.mapColor(MapColor.WOOD).ignitedByLava().instrument(NoteBlockInstrument.BASS).strength(2, 2).sound(SoundType.WOOD).noOcclusion()));

    //0.4.0 - update to 1.17

    //Makers Shift Update - v0.5
//    public static final RegistrySupplier<Block> SCRAP_WOOD_PILE = register("scrap_wood_pile", (properties) -> new Block(properties.mapColor(MapColor.WOOD).ignitedByLava().instrument(NoteBlockInstrument.BASS).strength(1.0f, 2.0f).sound(SoundType.WOOD)));
//    public static final RegistrySupplier<Block> MAKERS_CONCRETE_POWDER = register("makers_concrete_powder", (properties) -> new Block(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.5f,0.5f).sound(SoundType.SAND)));
//    public static final RegistrySupplier<Block> REINFORCED_METAL_BLOCK = register("reinforced_metal_block", (properties) -> new Block(properties.mapColor(MapColor.METAL).pushReaction(PushReaction.BLOCK).strength(10.f, 200.0f).sound(SoundType.NETHERITE_BLOCK)));
//    public static final RegistrySupplier<Block> INDUSTRIAL_BARRIER_BLOCK = register("industrial_barrier_block", (properties) -> new Block(properties.mapColor(MapColor.METAL).pushReaction(PushReaction.BLOCK).strength(10.0f, 100.0f).sound(SoundType.NETHERITE_BLOCK)));
//    public static final RegistrySupplier<Block> SURVIVALIST_BARRICADE = register("survivalist_barricade", (properties) -> new BarricadeBlock(properties.mapColor(MapColor.WOOD).ignitedByLava().instrument(NoteBlockInstrument.BASS).strength(2.0f, 3.0f).sound(SoundType.BAMBOO)));
//    public static final RegistrySupplier<Block> MAKER_BARRICADE = register("maker_barricade", (properties) -> new BarricadeBlock(properties.mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(15.0f, 100.0f).sound(SoundType.NETHER_BRICKS)));
//    public static final RegistrySupplier<Block> INDUSTRIAL_BARRICADE = register("industrial_barricade", (properties) -> new BarricadeBlock(properties.mapColor(MapColor.METAL).pushReaction(PushReaction.BLOCK).strength(40.0f, 900.0f).sound(SoundType.ANVIL)));

    public static void init() {
        BLOCKS.register();
    }

    private static RegistrySupplier<Block> register(String name, Function<BlockBehaviour.Properties, Block> blockFactory) {
        return BLOCKS.register(name, () -> blockFactory.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, GardenArsenal.id(name)))));
    }
}
