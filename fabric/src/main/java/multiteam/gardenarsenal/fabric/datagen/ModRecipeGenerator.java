package multiteam.gardenarsenal.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import static net.minecraft.world.item.Items.*;
import static multiteam.gardenarsenal.registries.GardenArsenalItems.*;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(RecipeOutput exporter) {
        generatedVanillaRecipes(exporter);
        generatedSkinUpgradeRecipes(exporter);
    }

    private void generatedSkinUpgradeRecipes(RecipeOutput exporter) {
        for (Item item : new Item[]{
                SUGAR_CANE_SNIPER.get(),
                CARROT_RIFLE.get(),
                COCOA_BEAN_SHOTGUN.get(),
                GLIMMERING_REVOLVER.get(),
                POTATO_BAZOOKA.get(),
                SEED_PISTOL.get()
        }) {
            SkinUpgradeRecipeBuilder.upgrading(item)
                    .unlocks(RecipeProvider.getHasName(item),
                            RecipeProvider.has(item))
                    .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(item) + "_skin"));
        }
    }

    private void generatedVanillaRecipes(RecipeOutput exporter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, AMMO_CRATE.get())
                .pattern(" # ")
                .pattern("PBN")
                .pattern(" M ")
                .define('#', CARROT)
                .define('P', POTATO_GRENADE.get())
                .define('B', BEETROOT)
                .define('N', COCOA_BEANS_SHELL.get())
                .define('M', BARREL)
                .unlockedBy(RecipeProvider.getHasName(CARROT),
                        RecipeProvider.has(CARROT))
                .unlockedBy(RecipeProvider.getHasName(BEETROOT),
                        RecipeProvider.has(BEETROOT))
                .unlockedBy(RecipeProvider.getHasName(BARREL),
                        RecipeProvider.has(BARREL))
                .unlockedBy(RecipeProvider.getHasName(POTATO_GRENADE.get()),
                        RecipeProvider.has(POTATO_GRENADE.get()))
                .unlockedBy(RecipeProvider.getHasName(COCOA_BEANS_SHELL.get()),
                        RecipeProvider.has(COCOA_BEANS_SHELL.get()))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(AMMO_CRATE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SUGAR_CANE_SNIPER.get())
                .pattern("#G#")
                .pattern("IBD")
                .pattern("IL/")
                .define('#', GLASS_PANE)
                .define('G', GREEN_TERRACOTTA)
                .define('I', MACHINE_BLOCK.get())
                .define('B', BLAST_FURNACE)
                .define('D', DISPENSER)
                .define('L', LEVER)
                .define('/', IRON_ROD.get())
                .unlockedBy(RecipeProvider.getHasName(GLASS_PANE),
                        RecipeProvider.has(GLASS_PANE))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        RecipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(BLAST_FURNACE),
                        RecipeProvider.has(BLAST_FURNACE))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        RecipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        RecipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        RecipeProvider.has(MACHINE_BLOCK.get()))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        RecipeProvider.has(IRON_ROD.get()))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(SUGAR_CANE_SNIPER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BEETROOT_SMOKE.get())
                .pattern("#I#")
                .pattern("SBI")
                .pattern("#I#")
                .define('#', SUGAR)
                .define('I', INK_SAC)
                .define('S', STONE_BUTTON)
                .define('B', BEETROOT)
                .unlockedBy(RecipeProvider.getHasName(SUGAR),
                        RecipeProvider.has(SUGAR))
                .unlockedBy(RecipeProvider.getHasName(INK_SAC),
                        RecipeProvider.has(INK_SAC))
                .unlockedBy(RecipeProvider.getHasName(STONE_BUTTON),
                        RecipeProvider.has(STONE_BUTTON))
                .unlockedBy(RecipeProvider.getHasName(BEETROOT),
                        RecipeProvider.has(BEETROOT))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(BEETROOT_SMOKE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CARROT_RIFLE.get())
                .pattern("#II")
                .pattern("GDC")
                .pattern("/L ")
                .define('#', REPEATER)
                .define('I', IRON_NUGGET)
                .define('G', GREEN_TERRACOTTA)
                .define('D', MACHINE_BLOCK.get())
                .define('C', DISPENSER)
                .define('/', IRON_ROD.get())
                .define('L', LEVER)
                .unlockedBy(RecipeProvider.getHasName(REPEATER),
                        RecipeProvider.has(REPEATER))
                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
                        RecipeProvider.has(IRON_NUGGET))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        RecipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        RecipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        RecipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        RecipeProvider.has(MACHINE_BLOCK.get()))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        RecipeProvider.has(IRON_ROD.get()))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(CARROT_RIFLE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, COCOA_BEAN_SHOTGUN.get())
                .pattern("#ID")
                .pattern("RID")
                .pattern("/L ")
                .define('#', GREEN_TERRACOTTA)
                .define('I', MACHINE_BLOCK.get())
                .define('D', DISPENSER)
                .define('R', REPEATER)
                .define('/', IRON_ROD.get())
                .define('L', LEVER)
                .unlockedBy(RecipeProvider.getHasName(REPEATER),
                        RecipeProvider.has(REPEATER))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        RecipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        RecipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        RecipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        RecipeProvider.has(MACHINE_BLOCK.get()))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        RecipeProvider.has(IRON_ROD.get()))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(COCOA_BEAN_SHOTGUN.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, COCOA_BEANS_SHELL.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("SPS")
                .define('#', COCOA_BEANS)
                .define('S', SUGAR)
                .define('P', PAPER)
                .unlockedBy(RecipeProvider.getHasName(COCOA_BEANS),
                        RecipeProvider.has(COCOA_BEANS))
                .unlockedBy(RecipeProvider.getHasName(SUGAR),
                        RecipeProvider.has(SUGAR))
                .unlockedBy(RecipeProvider.getHasName(PAPER),
                        RecipeProvider.has(PAPER))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(COCOA_BEANS_SHELL.get())));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GLIMMERING_MELON_SEEDS.get())
                .requires(GLISTERING_MELON_SLICE)
                .unlockedBy(RecipeProvider.getHasName(GLISTERING_MELON_SLICE),
                        RecipeProvider.has(GLISTERING_MELON_SLICE))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GLIMMERING_MELON_SEEDS.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, GLIMMERING_REVOLVER.get())
                .pattern("#BD")
                .pattern("GL ")
                .define('#', MACHINE_BLOCK.get())
                .define('B', BARREL)
                .define('D', DISPENSER)
                .define('G', GREEN_TERRACOTTA)
                .define('L', LEVER)
                .unlockedBy(RecipeProvider.getHasName(BARREL),
                        RecipeProvider.has(BARREL))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        RecipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        RecipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        RecipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        RecipeProvider.has(MACHINE_BLOCK.get()))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GLIMMERING_REVOLVER.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, IRON_ROD.get())
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .define('#', IRON_NUGGET)
                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
                        RecipeProvider.has(IRON_NUGGET))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(IRON_ROD.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MACHINE_BLOCK.get())
                .pattern("/I/")
                .pattern("IAI")
                .pattern("/I/")
                .define('/', IRON_ROD.get())
                .define('I', IRON_NUGGET)
                .define('A', IRON_BLOCK)
                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
                        RecipeProvider.has(IRON_NUGGET))
                .unlockedBy(RecipeProvider.getHasName(IRON_BLOCK),
                        RecipeProvider.has(IRON_BLOCK))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        RecipeProvider.has(IRON_ROD.get()))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(MACHINE_BLOCK.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, POTATO_BAZOOKA.get())
                .pattern("#/G")
                .pattern("IID")
                .pattern("//L")
                .define('#', COMPARATOR)
                .define('/', IRON_ROD.get())
                .define('G', GLASS_PANE)
                .define('I', MACHINE_BLOCK.get())
                .define('D', DISPENSER)
                .define('L', LEVER)
                .unlockedBy(RecipeProvider.getHasName(COMPARATOR),
                        RecipeProvider.has(COMPARATOR))
                .unlockedBy(RecipeProvider.getHasName(GLASS_PANE),
                        RecipeProvider.has(GLASS_PANE))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        RecipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        RecipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        RecipeProvider.has(IRON_ROD.get()))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        RecipeProvider.has(MACHINE_BLOCK.get()))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(POTATO_BAZOOKA.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, POTATO_GRENADE.get())
                .pattern("#PT")
                .define('#', STONE_BUTTON)
                .define('P', POTATO)
                .define('T', TNT)
                .unlockedBy(RecipeProvider.getHasName(STONE_BUTTON),
                        RecipeProvider.has(STONE_BUTTON))
                .unlockedBy(RecipeProvider.getHasName(POTATO),
                        RecipeProvider.has(POTATO))
                .unlockedBy(RecipeProvider.getHasName(TNT),
                        RecipeProvider.has(TNT))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(POTATO_GRENADE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SEED_PISTOL.get())
                .pattern("#D")
                .pattern("GL")
                .define('#', MACHINE_BLOCK.get())
                .define('D', DISPENSER)
                .define('G', GREEN_TERRACOTTA)
                .define('L', LEVER)
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        RecipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        RecipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        RecipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        RecipeProvider.has(MACHINE_BLOCK.get()))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(SEED_PISTOL.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, TRAP_CAKE.get())
                .pattern(" # ")
                .pattern("SCT")
                .pattern(" # ")
                .define('#', SUGAR)
                .define('S', STONE_BUTTON)
                .define('C', CAKE)
                .define('T', TNT)
                .unlockedBy(RecipeProvider.getHasName(STONE_BUTTON),
                        RecipeProvider.has(STONE_BUTTON))
                .unlockedBy(RecipeProvider.getHasName(SUGAR),
                        RecipeProvider.has(SUGAR))
                .unlockedBy(RecipeProvider.getHasName(TNT),
                        RecipeProvider.has(TNT))
                .unlockedBy(RecipeProvider.getHasName(CAKE),
                        RecipeProvider.has(CAKE))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(TRAP_CAKE.get())));

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, WAR_TACTIC_TABLE.get())
                .pattern("#MR")
                .pattern("OCO")
                .pattern("/ /")
                .define('#', BLUE_DYE)
                .define('M', MAP)
                .define('R', RED_DYE)
                .define('O', OAK_PLANKS)
                .define('/', STICK)
                .define('C', CARTOGRAPHY_TABLE)
                .unlockedBy(RecipeProvider.getHasName(BLUE_DYE),
                        RecipeProvider.has(BLUE_DYE))
                .unlockedBy(RecipeProvider.getHasName(MAP),
                        RecipeProvider.has(MAP))
                .unlockedBy(RecipeProvider.getHasName(RED_DYE),
                        RecipeProvider.has(RED_DYE))
                .unlockedBy(RecipeProvider.getHasName(OAK_PLANKS),
                        RecipeProvider.has(OAK_PLANKS))
                .unlockedBy(RecipeProvider.getHasName(STICK),
                        RecipeProvider.has(STICK))
                .unlockedBy(RecipeProvider.getHasName(CARTOGRAPHY_TABLE),
                        RecipeProvider.has(CARTOGRAPHY_TABLE))
                .save(exporter, new ResourceLocation(RecipeProvider.getSimpleRecipeName(WAR_TACTIC_TABLE.get())));

        // Makers Shift Update - v0.5
//        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, GardenArsenalBlocks.SURVIVALIST_BARRICADE.get())
//                .pattern("#I")
//                .pattern("# ")
//                .define('#', GardenArsenalBlocks.SCRAP_WOOD_PILE.get())
//                .define('I', IRON_NUGGET)
//                .unlockedBy(RecipeProvider.getHasName(GardenArsenalBlocks.SCRAP_WOOD_PILE.get()),
//                        RecipeProvider.has(GardenArsenalBlocks.SCRAP_WOOD_PILE.get()))
//                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
//                        RecipeProvider.has(IRON_NUGGET))
//                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GardenArsenalBlocks.SURVIVALIST_BARRICADE.get())));
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, GardenArsenalBlocks.SCRAP_WOOD_PILE.get())
//                .requires(OAK_STAIRS)
//                .requires(WOODEN_AXE)
//                .requires(WOODEN_HOE)
//                .requires(STRIPPED_OAK_WOOD)
//                .unlockedBy(RecipeProvider.getHasName(OAK_STAIRS),
//                        RecipeProvider.has(OAK_STAIRS))
//                .unlockedBy(RecipeProvider.getHasName(WOODEN_AXE),
//                        RecipeProvider.has(WOODEN_AXE))
//                .unlockedBy(RecipeProvider.getHasName(WOODEN_HOE),
//                        RecipeProvider.has(WOODEN_HOE))
//                .unlockedBy(RecipeProvider.getHasName(STRIPPED_OAK_WOOD),
//                        RecipeProvider.has(STRIPPED_OAK_WOOD))
//                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GardenArsenalBlocks.SCRAP_WOOD_PILE.get())));
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get())
//                .pattern("#I#")
//                .pattern("IAI")
//                .pattern("#I#")
//                .define('#', MACHINE_BLOCK.get())
//                .define('I', IRON_BARS)
//                .define('A', ANVIL)
//                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
//                        RecipeProvider.has(MACHINE_BLOCK.get()))
//                .unlockedBy(RecipeProvider.getHasName(IRON_BARS),
//                        RecipeProvider.has(IRON_BARS))
//                .unlockedBy(RecipeProvider.getHasName(ANVIL),
//                        RecipeProvider.has(ANVIL))
//                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get())));
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get())
//                .requires(WHITE_CONCRETE_POWDER)
//                .requires(COBBLESTONE)
//                .requires(GRAVEL)
//                .requires(SAND)
//                .requires(SUGAR)
//                .unlockedBy(RecipeProvider.getHasName(WHITE_CONCRETE_POWDER),
//                        RecipeProvider.has(WHITE_CONCRETE_POWDER))
//                .unlockedBy(RecipeProvider.getHasName(COBBLESTONE),
//                        RecipeProvider.has(COBBLESTONE))
//                .unlockedBy(RecipeProvider.getHasName(GRAVEL),
//                        RecipeProvider.has(GRAVEL))
//                .unlockedBy(RecipeProvider.getHasName(SAND),
//                        RecipeProvider.has(SAND))
//                .unlockedBy(RecipeProvider.getHasName(SUGAR),
//                        RecipeProvider.has(SUGAR))
//                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get())));
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, GardenArsenalBlocks.MAKER_BARRICADE.get())
//                .pattern("#W#")
//                .pattern("#W#")
//                .pattern("#W#")
//                .define('#', IRON_NUGGET)
//                .define('W', GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get())
//                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
//                        RecipeProvider.has(IRON_NUGGET))
//                .unlockedBy(RecipeProvider.getHasName(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get()),
//                        RecipeProvider.has(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get()))
//                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GardenArsenalBlocks.MAKER_BARRICADE.get())));
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get())
//                .pattern("#B#")
//                .pattern("BIB")
//                .pattern("#B#")
//                .define('#', YELLOW_CONCRETE)
//                .define('B', BLACK_CONCRETE)
//                .define('I', MACHINE_BLOCK.get())
//                .unlockedBy(RecipeProvider.getHasName(YELLOW_CONCRETE),
//                        RecipeProvider.has(YELLOW_CONCRETE))
//                .unlockedBy(RecipeProvider.getHasName(BLACK_CONCRETE),
//                        RecipeProvider.has(BLACK_CONCRETE))
//                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
//                        RecipeProvider.has(MACHINE_BLOCK.get()))
//                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get())));
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, GardenArsenalBlocks.INDUSTRIAL_BARRICADE.get())
//                .pattern("###")
//                .pattern("III")
//                .pattern("###")
//                .define('#', GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get())
//                .define('I', GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get())
//                .unlockedBy(RecipeProvider.getHasName(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get()),
//                        RecipeProvider.has(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get()))
//                .unlockedBy(RecipeProvider.getHasName(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get()),
//                        RecipeProvider.has(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get()))
//                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GardenArsenalBlocks.INDUSTRIAL_BARRICADE.get())));
    }
}
