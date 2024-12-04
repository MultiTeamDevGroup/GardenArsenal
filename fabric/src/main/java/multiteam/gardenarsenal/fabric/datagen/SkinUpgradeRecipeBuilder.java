package multiteam.gardenarsenal.fabric.datagen;

import com.google.gson.JsonObject;
import multiteam.gardenarsenal.recipes.SkinUpgradeRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class SkinUpgradeRecipeBuilder {
    private final Item weapon;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();
    private final RecipeSerializer<?> type;

    public SkinUpgradeRecipeBuilder(Item weapon, RecipeSerializer<?> type) {
        this.weapon = weapon;
        this.type = type;
    }

    public static SkinUpgradeRecipeBuilder upgrading(Item weapon) {
        return new SkinUpgradeRecipeBuilder(weapon, SkinUpgradeRecipe.DYNAMIC_SERIALIZER);
    }

    public SkinUpgradeRecipeBuilder unlocks(String string, CriterionTriggerInstance criterionTriggerInstance) {
        this.advancement.addCriterion(string, criterionTriggerInstance);
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumer, String string) {
        this.save(consumer, new ResourceLocation(string));
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);
        this.advancement.parent(RecipeBuilder.ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(resourceLocation)).requirements(RequirementsStrategy.OR);
        RecipeSerializer serializer = this.type;
        Item item = this.weapon;
        Advancement.Builder criterion = this.advancement;
        String var10011 = resourceLocation.getNamespace();
        String var10012 = this.weapon.getItemCategory().getRecipeFolderName();
        consumer.accept(new Result(resourceLocation, item, criterion, new ResourceLocation(var10011, "recipes/" + var10012 + "/" + resourceLocation.getPath()), serializer));
    }

    private void ensureValid(ResourceLocation resourceLocation) {
        if (this.advancement.getCriteria().isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + resourceLocation);
        }
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item weapon;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;
        private final RecipeSerializer<?> type;

        public Result(ResourceLocation id, Item weapon, Advancement.Builder advancement, ResourceLocation advancementId, RecipeSerializer<?> type) {
            this.id = id;
            this.weapon = weapon;
            this.advancement = advancement;
            this.advancementId = advancementId;
            this.type = type;
        }

        @Override
        public void serializeRecipeData(JsonObject jsonObject) {
            jsonObject.addProperty("weapon", Registry.ITEM.getKey(this.weapon).toString());
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return this.type;
        }

        @Override
        public @Nullable JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @Override
        public @Nullable ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
