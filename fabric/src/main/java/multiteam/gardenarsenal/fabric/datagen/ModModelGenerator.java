package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.items.SkinCardItem;
import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.Skins;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.MACHINE_BLOCK.get());

        blockStateModelGenerator.createSimpleFlatItemModel(GardenArsenalItems.TRAP_CAKE.get());
        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.multiVariant(GardenArsenalBlocks.TRAP_CAKE.get())
                .with(PropertyDispatch.property(BlockStateProperties.BITES)
                        .select(0, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/uneaten")))
                        .select(1, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice1")))
                        .select(2, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice2")))
                        .select(3, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice3")))
                        .select(4, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice4")))
                        .select(5, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice5")))
                        .select(6, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice6")))
                )
        );

        //Makers Shift Update - v0.5
//        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get());
//        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get());
//        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get());
//        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.SCRAP_WOOD_PILE.get());
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        for (var packEntry : GardenArsenalItems.SKIN_CARD_PACKS) {
            itemModelGenerator.generateFlatItem(packEntry.get(), ModelTemplates.FLAT_ITEM);
        }

        for (var cardEntry : GardenArsenalItems.SKIN_CARDS) {
            if (((SkinCardItem) cardEntry.get()).getSkin() == Skins.Default) {
                ModelTemplates.FLAT_ITEM.create(
                        ModelLocationUtils.getModelLocation(cardEntry.get()),
                        TextureMapping.layer0(new ResourceLocation(GardenArsenal.MOD_ID, "item/skin_card_skinless")),
                        itemModelGenerator.output
                );
            } else if (((SkinCardItem) cardEntry.get()).getSkin() == Skins.exclusive_pistols) {
                ModelTemplates.FLAT_ITEM.create(
                        ModelLocationUtils.getModelLocation(cardEntry.get()),
                        TextureMapping.layer0(new ResourceLocation(GardenArsenal.MOD_ID, "item/skin_card_exclusive_revolver_pistols")),
                        itemModelGenerator.output
                );
            } else {
                itemModelGenerator.generateFlatItem(cardEntry.get(), ModelTemplates.FLAT_ITEM);
            }
        }

        itemModelGenerator.generateFlatItem(GardenArsenalItems.IRON_ROD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(GardenArsenalItems.COCOA_BEANS_SHELL.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(GardenArsenalItems.GLIMMERING_MELON_SEEDS.get(), ModelTemplates.FLAT_ITEM);
    }
}
