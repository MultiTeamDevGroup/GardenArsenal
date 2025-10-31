package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.tags.BlockTags;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateTags() {
        tag(BlockTags.NEEDS_IRON_TOOL).add(
                GardenArsenalBlocks.MACHINE_BLOCK.get()
        );
        tag(BlockTags.NEEDS_STONE_TOOL).add(
                GardenArsenalBlocks.AMMO_CRATE.get(),
                GardenArsenalBlocks.WAR_TACTIC_TABLE.get()
        );
        tag(BlockTags.MINEABLE_WITH_AXE).add(
                GardenArsenalBlocks.AMMO_CRATE.get(),
                GardenArsenalBlocks.WAR_TACTIC_TABLE.get()
        );
        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                GardenArsenalBlocks.MACHINE_BLOCK.get()
        );

        // Makers Shift Update - v0.5
//        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
//                GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get()
//        );
//        tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
//                GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get(),
//                GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get(),
//                GardenArsenalBlocks.MAKER_BARRICADE.get(),
//                GardenArsenalBlocks.INDUSTRIAL_BARRICADE.get()
//        );
//        tag(BlockTags.MINEABLE_WITH_AXE).add(
//                GardenArsenalBlocks.SCRAP_WOOD_PILE.get()
//        );
    }
}
