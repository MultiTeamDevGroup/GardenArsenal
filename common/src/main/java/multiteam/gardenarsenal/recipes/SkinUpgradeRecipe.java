package multiteam.gardenarsenal.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.items.SkinCardItem;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
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
    
    public SkinUpgradeRecipe(Item ingredient) {
        super(Ingredient.of(), Ingredient.of(ingredient), getPossibleSkinCards(ingredient), new ItemStack(ingredient));
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
        return DYNAMIC_SERIALIZER = new Serializer();
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
        private static final Codec<SkinUpgradeRecipe> CODEC = RecordCodecBuilder.create(
                instance -> instance.group(
                                BuiltInRegistries.ITEM.byNameCodec().fieldOf("weapon")
                                        .forGetter(smithingTransformRecipe -> smithingTransformRecipe.getResultItem(null).getItem())
                        )
                        .apply(instance, SkinUpgradeRecipe::new)
        );

        @Override
        public @NotNull SkinUpgradeRecipe fromNetwork(FriendlyByteBuf friendlyByteBuf) {
            ItemStack ingredient = friendlyByteBuf.readItem();

            return new SkinUpgradeRecipe(ingredient.getItem());
        }

        @Override
        public Codec<SkinUpgradeRecipe> codec() {
            return CODEC;
        }

        @Override
        public void toNetwork(FriendlyByteBuf friendlyByteBuf, SkinUpgradeRecipe recipe) {
            friendlyByteBuf.writeItem(recipe.getResultItem(null));
        }
    }
}
