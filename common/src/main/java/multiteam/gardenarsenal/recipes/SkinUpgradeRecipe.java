package multiteam.gardenarsenal.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import multiteam.gardenarsenal.items.SkinCardItem;
import multiteam.gardenarsenal.mixin.IngredientAccessor;
import multiteam.gardenarsenal.registries.GardenArsenalDataComponents;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import multiteam.gardenarsenal.registries.GardenArsenalRecipeSerializers;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class SkinUpgradeRecipe implements SmithingRecipe {
    public static RecipeSerializer<SkinUpgradeRecipe> DYNAMIC_SERIALIZER;

    final Optional<Ingredient> weapon;
    final Optional<Ingredient> skin;
    final ItemStack result;
    @Nullable
    private PlacementInfo placementInfo;

    public SkinUpgradeRecipe(Ingredient weapon) {
        this.weapon = Optional.ofNullable(weapon);
        this.skin = Optional.of(getPossibleSkinCards(weapon));
        this.result = new ItemStack(((IngredientAccessor) (Object) weapon).getValues().get(0).value());
    }

    public static RecipeSerializer<SkinUpgradeRecipe> createSerializer() {
        return DYNAMIC_SERIALIZER = new Serializer();
    }

    private static Ingredient getPossibleSkinCards(Ingredient weapon) {
        return Ingredient.of(
                GardenArsenalItems.SKIN_CARDS.stream()
                        .map(Supplier::get)
                        .filter(item -> ((SkinCardItem) item).getSkin().canApplySkin(weapon))
                        .toList()
                        .toArray(new Item[0])
        );
    }

    @Override
    public ItemStack assemble(SmithingRecipeInput recipeInput, HolderLookup.Provider provider) {
        ItemStack itemStack = recipeInput.base().transmuteCopy(this.result.getItem(), this.result.getCount());
        itemStack.applyComponents(this.result.getComponentsPatch());

        SkinCardItem skinCardItem = (SkinCardItem) recipeInput.getItem(2).getItem();
        Skins skin = skinCardItem.getSkin();
        itemStack.set(GardenArsenalDataComponents.SKIN.get(), skin);

        return itemStack;
    }

    @Override
    public RecipeSerializer<SkinUpgradeRecipe> getSerializer() {
        return GardenArsenalRecipeSerializers.SKIN_UPGRADE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        if (this.placementInfo == null) {
            this.placementInfo = PlacementInfo.createFromOptionals(List.of(this.weapon, this.skin));
        }

        return this.placementInfo;
    }

    @Override
    public Optional<Ingredient> templateIngredient() {
        return Optional.empty();
    }

    @Override
    public Optional<Ingredient> baseIngredient() {
        return this.weapon;
    }

    @Override
    public Optional<Ingredient> additionIngredient() {
        return this.skin;
    }

    public static class Serializer implements RecipeSerializer<SkinUpgradeRecipe> {
        private static final MapCodec<SkinUpgradeRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) ->
                instance.group(
                        Ingredient.CODEC.fieldOf("weapon")
                                .forGetter((smithingTransformRecipe) -> smithingTransformRecipe.weapon.get()))
                        .apply(instance, SkinUpgradeRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, SkinUpgradeRecipe> STREAM_CODEC;

        @Override
        public MapCodec<SkinUpgradeRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, SkinUpgradeRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        static {
            STREAM_CODEC = StreamCodec.composite(Ingredient.CONTENTS_STREAM_CODEC,
                    (smithingTransformRecipe) -> smithingTransformRecipe.weapon.get(), SkinUpgradeRecipe::new);
        }
    }
}
