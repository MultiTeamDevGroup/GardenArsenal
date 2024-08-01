package multiteam.gardenarsenal.recipes;

import com.google.gson.JsonObject;
import dev.architectury.registry.registries.RegistrarManager;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.items.SkinCardItem;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static multiteam.gardenarsenal.registries.GardenArsenalRecipeSerializers.SKIN_UPGRADE;

public class SkinUpgradeRecipe extends SmithingTransformRecipe {
    public static RecipeSerializer<?> DYNAMIC_SERIALIZER;
    
    public SkinUpgradeRecipe(ResourceLocation resourceLocation, Item ingredient) {
        super(resourceLocation, Ingredient.of(), Ingredient.of(ingredient), getPossibleSkinCards(ingredient), new ItemStack(ingredient));
    }

    private static Ingredient getPossibleSkinCards(Item weapon) {
        return Ingredient.of(
                GardenArsenalItems.SKIN_CARDS.stream()
                        .map(Supplier::get)
                        .filter(item -> ((SkinCardItem) item).getSkin().canApplySkin(weapon))
                        .toList()
                        .toArray(new Item[0])
        );
    }

    public static RecipeSerializer<?> createSerializer() {
        return DYNAMIC_SERIALIZER = GardenArsenalExpectPlatform.createRecipeSerializer(new Serializer());
    }

    @Override
    public @NotNull ItemStack assemble(Container container, RegistryAccess registryAccess) {
        ItemStack itemStack = super.assemble(container, registryAccess);

        SkinCardItem skinCardItem = (SkinCardItem) container.getItem(2).getItem();
        Skins skin = skinCardItem.getSkin();
        CompoundTag tag = itemStack.getOrCreateTag();
        tag.putString("skinType", skin.name());

        return itemStack;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return SKIN_UPGRADE.get();
    }

    public static class Serializer implements RecipeSerializer<SkinUpgradeRecipe> {

        @Override
        public @NotNull SkinUpgradeRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            Item ingredient = RegistrarManager.get(GardenArsenal.MOD_ID).get(Registries.ITEM)
                    .get(new ResourceLocation(jsonObject.get("weapon").getAsString()));

            return new SkinUpgradeRecipe(resourceLocation, ingredient);
        }

        @Override
        public @NotNull SkinUpgradeRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            ItemStack ingredient = friendlyByteBuf.readItem();

            return new SkinUpgradeRecipe(resourceLocation, ingredient.getItem());
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, SkinUpgradeRecipe recipe) {
            friendlyByteBuf.writeItem(recipe.getResultItem(null));
        }
    }
}
