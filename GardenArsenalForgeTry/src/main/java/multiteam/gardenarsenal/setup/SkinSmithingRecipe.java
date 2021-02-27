package multiteam.gardenarsenal.setup;

import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.item.crafting.SmithingRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class SkinSmithingRecipe extends SmithingRecipe
{
	public static final IRecipeSerializer<?> SERIALIZER = new Serializer();
	private final String skin;

	private static ItemStack addSkin(ItemStack stack, String skin)
	{
		CompoundNBT nbtTagCompound = stack.getTag();

		if (nbtTagCompound == null){
			nbtTagCompound = new CompoundNBT();
			stack.setTag(nbtTagCompound);
		}

		nbtTagCompound.putString("skinType", skin);

		return stack;
	}

	public SkinSmithingRecipe(ResourceLocation recipeId, Ingredient base, Ingredient addition, ItemStack result, String skin)
	{
		super(recipeId, base, addition, addSkin(result, skin));
		this.skin = skin;
	}

	@Override
	public ItemStack getCraftingResult(IInventory inv) {
		ItemStack result = super.getCraftingResult(inv);

		if (result.getTag() != null)
			result.getTag().putString("skinType", skin);

		return result;
	}

	@Override
	public IRecipeSerializer<?> getSerializer()
	{
		return SERIALIZER;
	}

	public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SkinSmithingRecipe> {
		@Override
		public SkinSmithingRecipe read(ResourceLocation recipeId, JsonObject json) {
			Ingredient ingredient = Ingredient.deserialize(JSONUtils.getJsonObject(json, "base"));
			Ingredient ingredient1 = Ingredient.deserialize(JSONUtils.getJsonObject(json, "addition"));
			ItemStack itemstack = ShapedRecipe.deserializeItem(JSONUtils.getJsonObject(json, "result"));
			String skin = JSONUtils.getString(json, "skin");
			return new SkinSmithingRecipe(recipeId, ingredient, ingredient1, itemstack, skin);
		}

		@Override
		public SkinSmithingRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
			Ingredient ingredient = Ingredient.read(buffer);
			Ingredient ingredient1 = Ingredient.read(buffer);
			ItemStack itemstack = buffer.readItemStack();
			String skin = buffer.readString();
			return new SkinSmithingRecipe(recipeId, ingredient, ingredient1, itemstack, skin);
		}

		@Override
		public void write(PacketBuffer buffer, SkinSmithingRecipe recipe) {
			IRecipeSerializer.SMITHING.write(buffer, recipe);
			buffer.writeString(recipe.skin);
		}
	}
}
