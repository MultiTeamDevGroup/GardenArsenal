package multiteam.gardenarsenal.forge.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeRegistration;
import multiteam.gardenarsenal.GardenArsenal;
import net.minecraft.resources.Identifier;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class GardenArsenalJei implements IModPlugin {
    @Override
    public @NotNull Identifier getPluginUid() {
        return GardenArsenal.id("default");
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        IModPlugin.super.registerRecipes(registration);
        registration.addRecipes(RecipeTypes.SMITHING, RecipeHelper.createSkinRecipes());
    }
}
