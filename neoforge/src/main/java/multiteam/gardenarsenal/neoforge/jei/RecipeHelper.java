//package multiteam.gardenarsenal.neoforge.jei;
//
//import dev.architectury.registry.registries.RegistrySupplier;
//import multiteam.gardenarsenal.GardenArsenal;
//import multiteam.gardenarsenal.registries.GardenArsenalDataComponents;
//import multiteam.gardenarsenal.utils.Skins;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.item.crafting.RecipeHolder;
//import net.minecraft.world.item.crafting.SmithingRecipe;
//import net.minecraft.world.item.crafting.SmithingTransformRecipe;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RecipeHelper {
//
//    public static List<RecipeHolder<SmithingRecipe>> createSkinRecipes() {
//        List<RecipeHolder<SmithingRecipe>> list = new ArrayList<>();
//
//        int i = 0;
//        for (Skins skin : Skins.values()) {
//            i++;
//
//            int j = 0;
//            for (RegistrySupplier<Item> item : skin.getWeapons()) {
//                j++;
//                Item weapon = item.getOrNull();
//                ItemStack result = new ItemStack(weapon);
//                result.set(GardenArsenalDataComponents.SKIN.get(), skin);
//
//                list.add(new RecipeHolder<>(
//                        GardenArsenal.id("skin_" + i + "_" + j),
//                        new SmithingTransformRecipe(
//                                Ingredient.EMPTY,
//                                getWeaponVariants(weapon),
//                                Ingredient.of(new ItemStack(skin.getItem().getOrNull())),
//                                result
//                        )
//                ));
//            }
//        }
//
//        return list;
//    }
//
//    private static Ingredient getWeaponVariants(Item weapon) {
//        List<ItemStack> list = new ArrayList<>();
//
//        for (Skins skin : Skins.values()) {
//            if (!skin.canApplySkin(weapon)) continue;
//            ItemStack stack = new ItemStack(weapon);
//            stack.set(GardenArsenalDataComponents.SKIN.get(), skin);
//
//            list.add(stack);
//        }
//
//        return Ingredient.of(list.stream());
//    }
//}
