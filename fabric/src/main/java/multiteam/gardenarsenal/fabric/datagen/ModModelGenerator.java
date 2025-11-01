package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.utils.SkinModelProperty;
import multiteam.gardenarsenal.items.SkinCardItem;
import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.Skins;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.renderer.item.SelectItemModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.ArrayList;

public class ModModelGenerator extends FabricModelProvider {
    public ModModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.MACHINE_BLOCK.get());

        blockStateModelGenerator.blockStateOutput.accept(MultiVariantGenerator.dispatch(GardenArsenalBlocks.TRAP_CAKE.get())
                .with(PropertyDispatch.initial(BlockStateProperties.BITES)
                        .select(0, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/uneaten")))
                        .select(1, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice1")))
                        .select(2, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice2")))
                        .select(3, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice3")))
                        .select(4, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice4")))
                        .select(5, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice5")))
                        .select(6, BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(GardenArsenalBlocks.TRAP_CAKE.get(), "/slice6")))
                )
        );

        blockStateModelGenerator.createNonTemplateHorizontalBlock(GardenArsenalBlocks.AMMO_CRATE.get());
        blockStateModelGenerator.createNonTemplateHorizontalBlock(GardenArsenalBlocks.WAR_TACTIC_TABLE.get());

        //Makers Shift Update - v0.5
//        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get());
//        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get());
//        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get());
//        blockStateModelGenerator.createTrivialCube(GardenArsenalBlocks.SCRAP_WOOD_PILE.get());
//        blockStateModelGenerator.createNonTemplateHorizontalBlock(GardenArsenalBlocks.INDUSTRIAL_BARRICADE.get());
//        blockStateModelGenerator.createNonTemplateHorizontalBlock(GardenArsenalBlocks.SURVIVALIST_BARRICADE.get());
//        blockStateModelGenerator.createNonTemplateHorizontalBlock(GardenArsenalBlocks.MAKER_BARRICADE.get());
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
                        TextureMapping.layer0(ResourceLocation.fromNamespaceAndPath(GardenArsenal.MOD_ID, "item/skin_card_skinless")),
                        itemModelGenerator.modelOutput
                );
                itemModelGenerator.declareCustomModelItem(cardEntry.get());
            } else if (((SkinCardItem) cardEntry.get()).getSkin() == Skins.exclusive_pistols) {
                ModelTemplates.FLAT_ITEM.create(
                        ModelLocationUtils.getModelLocation(cardEntry.get()),
                        TextureMapping.layer0(ResourceLocation.fromNamespaceAndPath(GardenArsenal.MOD_ID, "item/skin_card_exclusive_revolver_pistols")),
                        itemModelGenerator.modelOutput
                );
                itemModelGenerator.declareCustomModelItem(cardEntry.get());
            } else {
                itemModelGenerator.generateFlatItem(cardEntry.get(), ModelTemplates.FLAT_ITEM);
            }
        }

        itemModelGenerator.generateFlatItem(GardenArsenalItems.IRON_ROD.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(GardenArsenalItems.COCOA_BEANS_SHELL.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(GardenArsenalItems.GLIMMERING_MELON_SEEDS.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(GardenArsenalItems.TRAP_CAKE.get(), ModelTemplates.FLAT_ITEM);
        itemModelGenerator.declareCustomModelItem(GardenArsenalItems.AMMO_CRATE.get());
        itemModelGenerator.declareCustomModelItem(GardenArsenalItems.BEETROOT_SMOKE.get());
        itemModelGenerator.declareCustomModelItem(GardenArsenalItems.POTATO_GRENADE.get());
        itemModelGenerator.declareCustomModelItem(GardenArsenalItems.PROJECTILE_CARROT.get());
        itemModelGenerator.declareCustomModelItem(GardenArsenalItems.WAR_TACTIC_TABLE.get());

        for (var weapon : GardenArsenalItems.WEAPONS) {
            createGunModel(itemModelGenerator, weapon.get());
        }
    }

    private static void createGunModel(ItemModelGenerators generators, Item item) {
        var baseModel = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(item));

        var list = new ArrayList<SelectItemModel.SwitchCase<String>>();

        for (var skin : Skins.values()) {
            if (skin.canApplySkin(item)) {
                var skinName = skin.getSerializedName();
                if (skinName.contains("_")) {
                    list.add(ItemModelUtils.when(skinName, ItemModelUtils.plainModel(getVariantLocation(item, skin))));
                } else {
                    list.add(ItemModelUtils.when(skinName, baseModel));
                }
            }
        }

        generators.itemModelOutput.accept(
                item,
                ItemModelUtils.select(
                        new SkinModelProperty(), baseModel, list
                )
        );
    }

    private static ResourceLocation getVariantLocation(Item item, Skins skin) {
        ResourceLocation resourceLocation = BuiltInRegistries.ITEM.getKey(item);
        return resourceLocation.withPrefix("item/skins/" + skin.getSerializedName().replace("_", "/") + "/" + skin.getSerializedName() + "_");
    }
}
