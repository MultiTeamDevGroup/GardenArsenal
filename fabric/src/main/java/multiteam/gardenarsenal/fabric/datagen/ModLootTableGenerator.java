package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.function.BiConsumer;

import static multiteam.gardenarsenal.fabric.datagen.ModDataGeneration.fromId;

public class ModLootTableGenerator extends SimpleFabricLootTableProvider {
    public ModLootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextParamSets.BLOCK);
    }

    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> resourceLocationBuilderBiConsumer) {
        resourceLocationBuilderBiConsumer.accept(
                fromId(GardenArsenalBlocks.MACHINE_BLOCK.getId(), "blocks/"),
                BlockLoot.createSingleItemTable(GardenArsenalBlocks.MACHINE_BLOCK.get())
        );
        resourceLocationBuilderBiConsumer.accept(
                fromId(GardenArsenalBlocks.AMMO_CRATE.getId(), "blocks/"),
                BlockLoot.createSingleItemTable(GardenArsenalBlocks.AMMO_CRATE.get())
        );
        resourceLocationBuilderBiConsumer.accept(
                fromId(GardenArsenalBlocks.WAR_TACTIC_TABLE.getId(), "blocks/"),
                BlockLoot.createSingleItemTable(GardenArsenalBlocks.WAR_TACTIC_TABLE.get())
        );
        resourceLocationBuilderBiConsumer.accept(
                fromId(GardenArsenalBlocks.TRAP_CAKE.getId(), "blocks/"),
                BlockLoot.noDrop()
        );
    }
}
