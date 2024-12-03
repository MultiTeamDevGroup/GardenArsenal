package multiteam.gardenarsenal.fabric.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;
import static net.minecraft.world.item.Items.*;
import static multiteam.gardenarsenal.registries.GardenArsenalItems.*;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<FinishedRecipe> consumer) {
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


    }
}
