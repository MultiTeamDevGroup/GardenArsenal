package multiteam.gardenarsenal.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.Consumer;
import static net.minecraft.world.item.Items.*;
import static multiteam.gardenarsenal.registries.GardenArsenalItems.*;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<FinishedRecipe> consumer) {
        generatedVanillaRecipes(consumer);
        generatedSkinUpgradeRecipes(consumer);
    }

    private void generatedSkinUpgradeRecipes(Consumer<FinishedRecipe> consumer) {
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
                    .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(item) + "_skin"));
        }
    }

    private void generatedVanillaRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(AMMO_CRATE.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(AMMO_CRATE.get())));

        ShapedRecipeBuilder.shaped(SUGAR_CANE_SNIPER.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(SUGAR_CANE_SNIPER.get())));

        ShapedRecipeBuilder.shaped(BEETROOT_SMOKE.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(BEETROOT_SMOKE.get())));

        ShapedRecipeBuilder.shaped(CARROT_RIFLE.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(CARROT_RIFLE.get())));

        ShapedRecipeBuilder.shaped(COCOA_BEAN_SHOTGUN.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(COCOA_BEAN_SHOTGUN.get())));

        ShapedRecipeBuilder.shaped(COCOA_BEANS_SHELL.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(COCOA_BEANS_SHELL.get())));

        ShapelessRecipeBuilder.shapeless(GLIMMERING_MELON_SEEDS.get())
                .requires(GLISTERING_MELON_SLICE)
                .unlockedBy(RecipeProvider.getHasName(GLISTERING_MELON_SLICE),
                        RecipeProvider.has(GLISTERING_MELON_SLICE))
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GLIMMERING_MELON_SEEDS.get())));

        ShapedRecipeBuilder.shaped(GLIMMERING_REVOLVER.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(GLIMMERING_REVOLVER.get())));

        ShapedRecipeBuilder.shaped(IRON_ROD.get())
                .pattern("#")
                .pattern("#")
                .pattern("#")
                .define('#', IRON_NUGGET)
                .unlockedBy(RecipeProvider.getHasName(IRON_NUGGET),
                        RecipeProvider.has(IRON_NUGGET))
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(IRON_ROD.get())));

        ShapedRecipeBuilder.shaped(MACHINE_BLOCK.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(MACHINE_BLOCK.get())));

        ShapedRecipeBuilder.shaped(POTATO_BAZOOKA.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(POTATO_BAZOOKA.get())));

        ShapedRecipeBuilder.shaped(POTATO_GRENADE.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(POTATO_GRENADE.get())));

        ShapedRecipeBuilder.shaped(SEED_PISTOL.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(SEED_PISTOL.get())));

        ShapedRecipeBuilder.shaped(TRAP_CAKE.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(TRAP_CAKE.get())));

        ShapedRecipeBuilder.shaped(WAR_TACTIC_TABLE.get())
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
                .save(consumer, new ResourceLocation(RecipeProvider.getSimpleRecipeName(WAR_TACTIC_TABLE.get())));
    }
}
