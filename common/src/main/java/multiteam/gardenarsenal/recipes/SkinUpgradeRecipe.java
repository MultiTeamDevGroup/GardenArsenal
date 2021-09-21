package multiteam.gardenarsenal.recipes;

import com.google.gson.JsonObject;
import dev.architectury.registry.registries.Registries;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.items.SkinCardItem;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraft.world.level.Level;

public class SkinUpgradeRecipe extends UpgradeRecipe {

    public static RecipeSerializer<?> DYNAMIC_SERIALIZER;

    public static final RecipeSerializer<?> SERIALIZER = new Serializer();
    
    private final Item weapon;
    
    public SkinUpgradeRecipe(ResourceLocation resourceLocation, Item ingredient) {
        super(resourceLocation, Ingredient.of(ingredient), Ingredient.of(ingredient), new ItemStack(ingredient));
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
    public ItemStack assemble(Container container) {
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
    public RecipeSerializer<?> getSerializer() {
        return DYNAMIC_SERIALIZER;
    }

    public static class Serializer implements RecipeSerializer<SkinUpgradeRecipe> {

        @Override
        public SkinUpgradeRecipe fromJson(ResourceLocation resourceLocation, JsonObject jsonObject) {
            Item ingredient = Registries.get(GardenArsenal.MOD_ID).get(Registry.ITEM_REGISTRY)
                    .get(new ResourceLocation(jsonObject.get("weapon").getAsString()));

            return new SkinUpgradeRecipe(resourceLocation, ingredient);
        }

        @Override
        public SkinUpgradeRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            ItemStack ingredient = friendlyByteBuf.readItem();

            return new SkinUpgradeRecipe(resourceLocation, ingredient.getItem());
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, SkinUpgradeRecipe recipe) {
            friendlyByteBuf.writeItem(new ItemStack(recipe.weapon));
        }
    }
}
