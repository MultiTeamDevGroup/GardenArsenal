package multiteam.gardenarsenal.recipes;

import com.google.gson.JsonObject;
import me.shedaniel.architectury.registry.Registries;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.items.SkinCardItem;
import multiteam.gardenarsenal.items.WeaponItem;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.UpgradeRecipe;
import net.minecraft.world.level.Level;

public class SkinUpgradeRecipe extends UpgradeRecipe {

    public static RecipeSerializer<?> DYNAMIC_SERIALIZER;

    public static final RecipeSerializer<?> SERIALIZER = new Serializer();
    
    private final Ingredient weapon;
    
    public SkinUpgradeRecipe(ResourceLocation resourceLocation, Ingredient ingredient) {
        super(resourceLocation, ingredient, ingredient, ingredient.getItems()[0]);
        this.weapon = ingredient;
    }

    @Override
    public boolean matches(Container container, Level level) {
        return this.weapon.test(container.getItem(0)) && container.getItem(1).getItem() instanceof SkinCardItem;
    }

    public static RecipeSerializer<?> createSerializer() {
        return DYNAMIC_SERIALIZER = GardenArsenalExpectPlatform.createRecipeSerializer(new Serializer());
    }

    @Override
    public ItemStack assemble(Container container) {
        ItemStack itemStack = this.weapon.getItems()[0].copy();
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
            Ingredient ingredient = Ingredient.of(Registries.get(GardenArsenal.MOD_ID).get(Registry.ITEM_REGISTRY)
                    .get(new ResourceLocation(jsonObject.get("weapon").getAsString())));

            return new SkinUpgradeRecipe(resourceLocation, ingredient);
        }

        @Override
        public SkinUpgradeRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf friendlyByteBuf) {
            Ingredient ingredient = Ingredient.fromNetwork(friendlyByteBuf);

            return new SkinUpgradeRecipe(resourceLocation, ingredient);
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, SkinUpgradeRecipe recipe) {
            recipe.weapon.toNetwork(friendlyByteBuf);
        }
    }
}
