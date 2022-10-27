package multiteam.gardenarsenal.forge;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

public class ForgeRecipeSerializer<T extends Recipe<?>> implements RecipeSerializer<T> {

    private RecipeSerializer<T> recipeSerializer;

    protected ForgeRecipeSerializer(RecipeSerializer<T> recipeSerializer) {
        super();
        this.recipeSerializer = recipeSerializer;
    }

    @Override
    public T fromJson(ResourceLocation arg, JsonObject jsonObject) {
        return this.recipeSerializer.fromJson(arg, jsonObject);
    }

    @Nullable
    @Override
    public T fromNetwork(ResourceLocation arg, FriendlyByteBuf arg2) {
        return this.recipeSerializer.fromNetwork(arg, arg2);
    }

    @Override
    public void toNetwork(FriendlyByteBuf arg, T arg2) {
        this.recipeSerializer.toNetwork(arg, arg2);
    }
}
