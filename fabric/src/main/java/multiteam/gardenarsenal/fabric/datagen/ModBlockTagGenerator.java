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
    }
}
