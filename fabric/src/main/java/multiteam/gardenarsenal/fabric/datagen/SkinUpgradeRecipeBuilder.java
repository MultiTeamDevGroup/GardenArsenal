package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.recipes.SkinUpgradeRecipe;
import net.minecraft.advancements.*;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class SkinUpgradeRecipeBuilder {
    private final Item weapon;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    private final RecipeCategory category;

    public SkinUpgradeRecipeBuilder(Item weapon, RecipeCategory category) {
        this.weapon = weapon;
        this.category = category;
    }

    public static SkinUpgradeRecipeBuilder upgrading(Item weapon) {
        return new SkinUpgradeRecipeBuilder(weapon, RecipeCategory.COMBAT);
    }

    public SkinUpgradeRecipeBuilder unlocks(String string, Criterion<InventoryChangeTrigger.TriggerInstance> criterionTriggerInstance) {
        this.criteria.put(string, criterionTriggerInstance);
        return this;
    }

    public void save(RecipeOutput exporter, String string) {
        this.save(exporter, ResourceKey.create(Registries.RECIPE, Identifier.parse(string)));
    }

    public void save(RecipeOutput exporter, Identifier Identifier) {
        this.save(exporter, ResourceKey.create(Registries.RECIPE, Identifier));
    }

    public void save(RecipeOutput exporter, ResourceKey<Recipe<?>> resourceKey) {
        this.ensureValid(resourceKey);
        var advancement = exporter.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(resourceKey)).requirements(AdvancementRequirements.Strategy.OR);
        Objects.requireNonNull(advancement);
        this.criteria.forEach(advancement::addCriterion);
        String var10012 = this.category.getFolderName();
        exporter.accept(
                resourceKey,
                new SkinUpgradeRecipe(Ingredient.of(this.weapon)),
                advancement.build(resourceKey.identifier().withPrefix("recipes/" + var10012 + "/"))
        );
    }

    private void ensureValid(ResourceKey<Recipe<?>> resourceKey) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + resourceKey.identifier());
        }
    }
}
