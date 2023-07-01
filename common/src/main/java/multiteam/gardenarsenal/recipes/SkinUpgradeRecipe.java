package multiteam.gardenarsenal.recipes;

import com.google.gson.JsonObject;
import dev.architectury.registry.registries.RegistrarManager;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.items.SkinCardItem;
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
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SkinUpgradeRecipe extends SmithingTransformRecipe {

    public static RecipeSerializer<?> DYNAMIC_SERIALIZER;

    public static final RecipeSerializer<?> SERIALIZER = new Serializer();
    
    private final Item weapon;
    
    public SkinUpgradeRecipe(ResourceLocation resourceLocation, Item ingredient) {
        super(resourceLocation, Ingredient.of(ingredient), Ingredient.of(ingredient), Ingredient.of(ingredient), new ItemStack(ingredient));
        this.weapon = ingredient;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return this.weapon == container.getItem(0).getItem() && container.getItem(1).getItem() instanceof SkinCardItem skinCardItem
                && skinCardItem.getSkin().canApplySkin(this.weapon);
    }

    @Override
    public boolean isAdditionIngredient(ItemStack itemStack) {
        return itemStack.getItem() instanceof SkinCardItem skinCardItem && skinCardItem.getSkin().canApplySkin(this.weapon);
    }

    public static RecipeSerializer<?> createSerializer() {
        return DYNAMIC_SERIALIZER = GardenArsenalExpectPlatform.createRecipeSerializer(new Serializer());
    }

    @Override
    public @NotNull ItemStack assemble(Container container, RegistryAccess registryAccess) {
        ItemStack itemStack = new ItemStack(this.weapon);
        CompoundTag compoundTag = container.getItem(0).getTag();
        if (compoundTag != null) {
            itemStack.setTag(compoundTag.copy());
        }
        SkinCardItem skinCardItem = (SkinCardItem) container.getItem(1).getItem();
        Skins skin = skinCardItem.getSkin();
        CompoundTag tag = itemStack.getOrCreateTag();
        tag.putString("skinType", skin.name());

        return itemStack;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return DYNAMIC_SERIALIZER;
    }

    @Override
    public boolean isIncomplete() {
        return this.weapon == null;
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
            friendlyByteBuf.writeItem(new ItemStack(recipe.weapon));
        }
    }
}
