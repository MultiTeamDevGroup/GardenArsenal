package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.function.BiConsumer;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate() {
        dropSelf(GardenArsenalBlocks.MACHINE_BLOCK.get());
        dropSelf(GardenArsenalBlocks.AMMO_CRATE.get());
        dropSelf(GardenArsenalBlocks.WAR_TACTIC_TABLE.get());
        add(GardenArsenalBlocks.TRAP_CAKE.get(), noDrop());

        //Makers Shift Update - v0.5
//        dropSelf(GardenArsenalBlocks.SCRAP_WOOD_PILE.get());
//        dropSelf(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get());
//        dropSelf(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get());
//        dropSelf(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get());
//        dropSelf(GardenArsenalBlocks.INDUSTRIAL_BARRICADE.get());
//        dropSelf(GardenArsenalBlocks.SURVIVALIST_BARRICADE.get());
//        dropSelf(GardenArsenalBlocks.MAKER_BARRICADE.get());
    }

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> resourceLocationBuilderBiConsumer) {
        this.generate(resourceLocationBuilderBiConsumer);
    }
}
