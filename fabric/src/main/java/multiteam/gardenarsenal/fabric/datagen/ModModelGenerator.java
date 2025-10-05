package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.items.SkinCardItem;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.Skins;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

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
