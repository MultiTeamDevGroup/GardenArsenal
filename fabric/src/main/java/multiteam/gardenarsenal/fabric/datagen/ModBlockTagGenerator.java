package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                reverseLookup(GardenArsenalBlocks.MACHINE_BLOCK.get())
        );
        tag(BlockTags.NEEDS_STONE_TOOL).add(
                reverseLookup(GardenArsenalBlocks.AMMO_CRATE.get()),
                reverseLookup(GardenArsenalBlocks.WAR_TACTIC_TABLE.get())
        );
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                reverseLookup(GardenArsenalBlocks.AMMO_CRATE.get()),
                reverseLookup(GardenArsenalBlocks.WAR_TACTIC_TABLE.get())
        );
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                reverseLookup(GardenArsenalBlocks.MACHINE_BLOCK.get())
        );

        // Makers Shift Update - v0.5
//        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
//                reverseLookup(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get())
//        );
//        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
//                reverseLookup(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get()),
//                reverseLookup(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get()),
//                reverseLookup(GardenArsenalBlocks.MAKER_BARRICADE.get()),
//                reverseLookup(GardenArsenalBlocks.INDUSTRIAL_BARRICADE.get())
//        );
//        tag(BlockTags.MINEABLE_WITH_AXE).add(
//                reverseLookup(GardenArsenalBlocks.SCRAP_WOOD_PILE.get())
//        );
    }
}
