package multiteam.gardenarsenal.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import multiteam.gardenarsenal.GardenArsenalExpectPlatform;
import multiteam.gardenarsenal.items.SkinCardItem;
import multiteam.gardenarsenal.registries.GardenArsenalDataComponents;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
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
    public @NotNull ItemStack assemble(Container container, HolderLookup.Provider registryAccess) {
        ItemStack itemStack = super.assemble(container, registryAccess);

        SkinCardItem skinCardItem = (SkinCardItem) container.getItem(2).getItem();
        Skins skin = skinCardItem.getSkin();
        itemStack.set(GardenArsenalDataComponents.SKIN.get(), skin);

        return itemStack;
    }

    @Override
    public @NotNull RecipeSerializer<?> getSerializer() {
        return SKIN_UPGRADE.get();
    }

    public static class Serializer implements RecipeSerializer<SkinUpgradeRecipe> {
        private static final MapCodec<SkinUpgradeRecipe> CODEC = RecordCodecBuilder.mapCodec(
                instance -> instance.group(
                                BuiltInRegistries.ITEM.byNameCodec().fieldOf("weapon")
                                        .forGetter(smithingTransformRecipe -> smithingTransformRecipe.getResultItem(null).getItem())
                        )
                        .apply(instance, SkinUpgradeRecipe::new)
        );

        private static final StreamCodec<RegistryFriendlyByteBuf, SkinUpgradeRecipe> STREAM_CODEC = StreamCodec.of(
                Serializer::toNetwork, Serializer::fromNetwork
        );

        @Override
        public MapCodec<SkinUpgradeRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, SkinUpgradeRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        public static void toNetwork(RegistryFriendlyByteBuf friendlyByteBuf, SkinUpgradeRecipe recipe) {
            ItemStack.STREAM_CODEC.encode(friendlyByteBuf, recipe.getResultItem(null));
        }

        public static @NotNull SkinUpgradeRecipe fromNetwork(RegistryFriendlyByteBuf friendlyByteBuf) {
            ItemStack ingredient = ItemStack.STREAM_CODEC.decode(friendlyByteBuf);

            return new SkinUpgradeRecipe(ingredient.getItem());
        }
    }
}
