package multiteam.gardenarsenal.forge.jei;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.UpgradeRecipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeHelper {

    public static List<UpgradeRecipe> createSkinRecipes() {
        List<UpgradeRecipe> list = new ArrayList<>();

        int i = 0;
        for (Skins skin : Skins.values()) {
            i++;

            int j = 0;
            for (RegistrySupplier<Item> item : skin.getWeapons()) {
                j++;
                Item weapon = item.getOrNull();
                ItemStack result = new ItemStack(weapon);
                result.getOrCreateTag().putString("skinType", skin.name());
                list.add(new UpgradeRecipe(
                        new ResourceLocation(GardenArsenal.MOD_ID, "skin_" + i + "_" + j),
                        getWeaponVariants(weapon),
                        Ingredient.of(new ItemStack(skin.getItem().getOrNull())),
                        result
                ));
            }
        }

        return list;
    }

    private static Ingredient getWeaponVariants(Item weapon) {
        List<ItemStack> list = new ArrayList<>();

        for (Skins skin : Skins.values()) {
            if (!skin.canApplySkin(weapon)) continue;
            ItemStack stack = new ItemStack(weapon);
            stack.getOrCreateTag().putString("skinType", skin.name());

            list.add(stack);
        }

        return Ingredient.of(list.stream());
    }
}
