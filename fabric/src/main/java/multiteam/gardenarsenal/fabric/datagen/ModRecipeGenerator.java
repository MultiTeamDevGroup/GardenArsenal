package multiteam.gardenarsenal.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

import static net.minecraft.world.item.Items.*;
import static multiteam.gardenarsenal.registries.GardenArsenalItems.*;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                generatedVanillaRecipes(this.registries, this.output, this);
                generatedSkinUpgradeRecipes(this.registries, this.output, this);
            }
        };
    }

    private void generatedSkinUpgradeRecipes(HolderLookup.Provider provider, RecipeOutput exporter, RecipeProvider recipeProvider) {
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
                            recipeProvider.has(item))
                    .save(exporter, RecipeProvider.getSimpleRecipeName(item) + "_skin");
        }
    }

    private void generatedVanillaRecipes(HolderLookup.Provider provider, RecipeOutput exporter, RecipeProvider recipeProvider) {
        var items = provider.lookupOrThrow(Registries.ITEM);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, AMMO_CRATE.get())
                .pattern(" # ")
                .pattern("PBN")
                .pattern(" M ")
                .define('#', CARROT)
                .define('P', POTATO_GRENADE.get())
                .define('B', BEETROOT)
                .define('N', COCOA_BEANS_SHELL.get())
                .define('M', BARREL)
                .unlockedBy(RecipeProvider.getHasName(CARROT),
                        recipeProvider.has(CARROT))
                .unlockedBy(RecipeProvider.getHasName(BEETROOT),
                        recipeProvider.has(BEETROOT))
                .unlockedBy(RecipeProvider.getHasName(BARREL),
                        recipeProvider.has(BARREL))
                .unlockedBy(RecipeProvider.getHasName(POTATO_GRENADE.get()),
                        recipeProvider.has(POTATO_GRENADE.get()))
                .unlockedBy(RecipeProvider.getHasName(COCOA_BEANS_SHELL.get()),
                        recipeProvider.has(COCOA_BEANS_SHELL.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, SUGAR_CANE_SNIPER.get())
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
                        recipeProvider.has(GLASS_PANE))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        recipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(BLAST_FURNACE),
                        recipeProvider.has(BLAST_FURNACE))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        recipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        recipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        recipeProvider.has(MACHINE_BLOCK.get()))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        recipeProvider.has(IRON_ROD.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, BEETROOT_SMOKE.get())
                .pattern("#I#")
                .pattern("SBI")
                .pattern("#I#")
                .define('#', SUGAR)
                .define('I', INK_SAC)
                .define('S', STONE_BUTTON)
                .define('B', BEETROOT)
                .unlockedBy(RecipeProvider.getHasName(SUGAR),
                        recipeProvider.has(SUGAR))
                .unlockedBy(RecipeProvider.getHasName(INK_SAC),
                        recipeProvider.has(INK_SAC))
                .unlockedBy(RecipeProvider.getHasName(STONE_BUTTON),
                        recipeProvider.has(STONE_BUTTON))
                .unlockedBy(RecipeProvider.getHasName(BEETROOT),
                        recipeProvider.has(BEETROOT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, CARROT_RIFLE.get())
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
                        recipeProvider.has(REPEATER))
                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
                        recipeProvider.has(IRON_NUGGET))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        recipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        recipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        recipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        recipeProvider.has(MACHINE_BLOCK.get()))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        recipeProvider.has(IRON_ROD.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, COCOA_BEAN_SHOTGUN.get())
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
                        recipeProvider.has(REPEATER))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        recipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        recipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        recipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        recipeProvider.has(MACHINE_BLOCK.get()))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        recipeProvider.has(IRON_ROD.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, COCOA_BEANS_SHELL.get())
                .pattern("###")
                .pattern("#S#")
                .pattern("SPS")
                .define('#', COCOA_BEANS)
                .define('S', SUGAR)
                .define('P', PAPER)
                .unlockedBy(RecipeProvider.getHasName(COCOA_BEANS),
                        recipeProvider.has(COCOA_BEANS))
                .unlockedBy(RecipeProvider.getHasName(SUGAR),
                        recipeProvider.has(SUGAR))
                .unlockedBy(RecipeProvider.getHasName(PAPER),
                        recipeProvider.has(PAPER))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.MISC, GLIMMERING_MELON_SEEDS.get())
                .requires(GLISTERING_MELON_SLICE)
                .unlockedBy(RecipeProvider.getHasName(GLISTERING_MELON_SLICE),
                        recipeProvider.has(GLISTERING_MELON_SLICE))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, GLIMMERING_REVOLVER.get())
                .pattern("#BD")
                .pattern("GL ")
                .define('#', MACHINE_BLOCK.get())
                .define('B', BARREL)
                .define('D', DISPENSER)
                .define('G', GREEN_TERRACOTTA)
                .define('L', LEVER)
                .unlockedBy(RecipeProvider.getHasName(BARREL),
                        recipeProvider.has(BARREL))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        recipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        recipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        recipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        recipeProvider.has(MACHINE_BLOCK.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, IRON_ROD.get())
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .define('#', IRON_NUGGET)
                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
                        recipeProvider.has(IRON_NUGGET))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, MACHINE_BLOCK.get())
                .pattern("/I/")
                .pattern("IAI")
                .pattern("/I/")
                .define('/', IRON_ROD.get())
                .define('I', IRON_NUGGET)
                .define('A', IRON_BLOCK)
                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
                        recipeProvider.has(IRON_NUGGET))
                .unlockedBy(RecipeProvider.getHasName(IRON_BLOCK),
                        recipeProvider.has(IRON_BLOCK))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        recipeProvider.has(IRON_ROD.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, POTATO_BAZOOKA.get())
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
                        recipeProvider.has(COMPARATOR))
                .unlockedBy(RecipeProvider.getHasName(GLASS_PANE),
                        recipeProvider.has(GLASS_PANE))
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        recipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        recipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(IRON_ROD.get()),
                        recipeProvider.has(IRON_ROD.get()))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        recipeProvider.has(MACHINE_BLOCK.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, POTATO_GRENADE.get())
                .pattern("#PT")
                .define('#', STONE_BUTTON)
                .define('P', POTATO)
                .define('T', TNT)
                .unlockedBy(RecipeProvider.getHasName(STONE_BUTTON),
                        recipeProvider.has(STONE_BUTTON))
                .unlockedBy(RecipeProvider.getHasName(POTATO),
                        recipeProvider.has(POTATO))
                .unlockedBy(RecipeProvider.getHasName(TNT),
                        recipeProvider.has(TNT))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.COMBAT, SEED_PISTOL.get())
                .pattern("#D")
                .pattern("GL")
                .define('#', MACHINE_BLOCK.get())
                .define('D', DISPENSER)
                .define('G', GREEN_TERRACOTTA)
                .define('L', LEVER)
                .unlockedBy(RecipeProvider.getHasName(DISPENSER),
                        recipeProvider.has(DISPENSER))
                .unlockedBy(RecipeProvider.getHasName(GREEN_TERRACOTTA),
                        recipeProvider.has(GREEN_TERRACOTTA))
                .unlockedBy(RecipeProvider.getHasName(LEVER),
                        recipeProvider.has(LEVER))
                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
                        recipeProvider.has(MACHINE_BLOCK.get()))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.MISC, TRAP_CAKE.get())
                .pattern(" # ")
                .pattern("SCT")
                .pattern(" # ")
                .define('#', SUGAR)
                .define('S', STONE_BUTTON)
                .define('C', CAKE)
                .define('T', TNT)
                .unlockedBy(RecipeProvider.getHasName(STONE_BUTTON),
                        recipeProvider.has(STONE_BUTTON))
                .unlockedBy(RecipeProvider.getHasName(SUGAR),
                        recipeProvider.has(SUGAR))
                .unlockedBy(RecipeProvider.getHasName(TNT),
                        recipeProvider.has(TNT))
                .unlockedBy(RecipeProvider.getHasName(CAKE),
                        recipeProvider.has(CAKE))
                .save(exporter);

        ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, WAR_TACTIC_TABLE.get())
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
                        recipeProvider.has(BLUE_DYE))
                .unlockedBy(RecipeProvider.getHasName(MAP),
                        recipeProvider.has(MAP))
                .unlockedBy(RecipeProvider.getHasName(RED_DYE),
                        recipeProvider.has(RED_DYE))
                .unlockedBy(RecipeProvider.getHasName(OAK_PLANKS),
                        recipeProvider.has(OAK_PLANKS))
                .unlockedBy(RecipeProvider.getHasName(STICK),
                        recipeProvider.has(STICK))
                .unlockedBy(RecipeProvider.getHasName(CARTOGRAPHY_TABLE),
                        recipeProvider.has(CARTOGRAPHY_TABLE))
                .save(exporter);

        // Makers Shift Update - v0.5
//        ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, GardenArsenalBlocks.SURVIVALIST_BARRICADE.get())
//                .pattern("#I")
//                .pattern("# ")
//                .define('#', GardenArsenalBlocks.SCRAP_WOOD_PILE.get())
//                .define('I', IRON_NUGGET)
//                .unlockedBy(RecipeProvider.getHasName(GardenArsenalBlocks.SCRAP_WOOD_PILE.get()),
//                        recipeProvider.has(GardenArsenalBlocks.SCRAP_WOOD_PILE.get()))
//                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
//                        recipeProvider.has(IRON_NUGGET))
//                .save(consumer);
//
//        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.DECORATIONS, GardenArsenalBlocks.SCRAP_WOOD_PILE.get())
//                .requires(OAK_STAIRS)
//                .requires(WOODEN_AXE)
//                .requires(WOODEN_HOE)
//                .requires(STRIPPED_OAK_WOOD)
//                .unlockedBy(RecipeProvider.getHasName(OAK_STAIRS),
//                        recipeProvider.has(OAK_STAIRS))
//                .unlockedBy(RecipeProvider.getHasName(WOODEN_AXE),
//                        recipeProvider.has(WOODEN_AXE))
//                .unlockedBy(RecipeProvider.getHasName(WOODEN_HOE),
//                        recipeProvider.has(WOODEN_HOE))
//                .unlockedBy(RecipeProvider.getHasName(STRIPPED_OAK_WOOD),
//                        recipeProvider.has(STRIPPED_OAK_WOOD))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get())
//                .pattern("#I#")
//                .pattern("IAI")
//                .pattern("#I#")
//                .define('#', MACHINE_BLOCK.get())
//                .define('I', IRON_BARS)
//                .define('A', ANVIL)
//                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
//                        recipeProvider.has(MACHINE_BLOCK.get()))
//                .unlockedBy(RecipeProvider.getHasName(IRON_BARS),
//                        recipeProvider.has(IRON_BARS))
//                .unlockedBy(RecipeProvider.getHasName(ANVIL),
//                        recipeProvider.has(ANVIL))
//                .save(consumer);
//
//        ShapelessRecipeBuilder.shapeless(items, RecipeCategory.DECORATIONS, GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get())
//                .requires(WHITE_CONCRETE_POWDER)
//                .requires(COBBLESTONE)
//                .requires(GRAVEL)
//                .requires(SAND)
//                .requires(SUGAR)
//                .unlockedBy(RecipeProvider.getHasName(WHITE_CONCRETE_POWDER),
//                        recipeProvider.has(WHITE_CONCRETE_POWDER))
//                .unlockedBy(RecipeProvider.getHasName(COBBLESTONE),
//                        recipeProvider.has(COBBLESTONE))
//                .unlockedBy(RecipeProvider.getHasName(GRAVEL),
//                        recipeProvider.has(GRAVEL))
//                .unlockedBy(RecipeProvider.getHasName(SAND),
//                        recipeProvider.has(SAND))
//                .unlockedBy(RecipeProvider.getHasName(SUGAR),
//                        recipeProvider.has(SUGAR))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, GardenArsenalBlocks.MAKER_BARRICADE.get())
//                .pattern("#W#")
//                .pattern("#W#")
//                .pattern("#W#")
//                .define('#', IRON_NUGGET)
//                .define('W', GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get())
//                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
//                        recipeProvider.has(IRON_NUGGET))
//                .unlockedBy(RecipeProvider.getHasName(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get()),
//                        recipeProvider.has(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get()))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get())
//                .pattern("#B#")
//                .pattern("BIB")
//                .pattern("#B#")
//                .define('#', YELLOW_CONCRETE)
//                .define('B', BLACK_CONCRETE)
//                .define('I', MACHINE_BLOCK.get())
//                .unlockedBy(RecipeProvider.getHasName(YELLOW_CONCRETE),
//                        recipeProvider.has(YELLOW_CONCRETE))
//                .unlockedBy(RecipeProvider.getHasName(BLACK_CONCRETE),
//                        recipeProvider.has(BLACK_CONCRETE))
//                .unlockedBy(RecipeProvider.getHasName(MACHINE_BLOCK.get()),
//                        recipeProvider.has(MACHINE_BLOCK.get()))
//                .save(consumer);
//
//        ShapedRecipeBuilder.shaped(items, RecipeCategory.DECORATIONS, GardenArsenalBlocks.INDUSTRIAL_BARRICADE.get())
//                .pattern("###")
//                .pattern("III")
//                .pattern("###")
//                .define('#', GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get())
//                .define('I', GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get())
//                .unlockedBy(RecipeProvider.getHasName(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get()),
//                        recipeProvider.has(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get()))
//                .unlockedBy(RecipeProvider.getHasName(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get()),
//                        recipeProvider.has(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get()))
//                .save(consumer);
    }

    @Override
    public String getName() {
        return "Garden Arsenal - Recipe Generator";
    }
}
