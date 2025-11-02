package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL).add(
                GardenArsenalBlocks.MACHINE_BLOCK.get()
        );
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL).add(
                GardenArsenalBlocks.AMMO_CRATE.get(),
                GardenArsenalBlocks.WAR_TACTIC_TABLE.get()
        );
        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE).add(
                GardenArsenalBlocks.AMMO_CRATE.get(),
                GardenArsenalBlocks.WAR_TACTIC_TABLE.get()
        );
        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(
                GardenArsenalBlocks.MACHINE_BLOCK.get()
        );

        valueLookupBuilder(ConventionalBlockTags.VILLAGER_JOB_SITES).add(
                GardenArsenalBlocks.AMMO_CRATE.get(),
                GardenArsenalBlocks.WAR_TACTIC_TABLE.get()
        );

        // Makers Shift Update - v0.5
//        valueLookupBuilder(BlockTags.MINEABLE_WITH_SHOVEL).add(
//                GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get()
//        );
//        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE).add(
//                GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get(),
//                GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get(),
//                GardenArsenalBlocks.MAKER_BARRICADE.get(),
//                GardenArsenalBlocks.INDUSTRIAL_BARRICADE.get()
//        );
//        valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE).add(
//                GardenArsenalBlocks.SCRAP_WOOD_PILE.get()
//        );
    }
}
