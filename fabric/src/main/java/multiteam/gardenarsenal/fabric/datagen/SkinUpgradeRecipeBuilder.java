package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.recipes.SkinUpgradeRecipe;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

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
        this.save(exporter, new ResourceLocation(string));
    }

    public void save(RecipeOutput exporter, ResourceLocation resourceLocation) {
        this.ensureValid(resourceLocation);
        var advancement = exporter.advancement().addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation)).rewards(net.minecraft.advancements.AdvancementRewards.Builder.recipe(resourceLocation)).requirements(AdvancementRequirements.Strategy.OR);
        Objects.requireNonNull(advancement);
        this.criteria.forEach(advancement::addCriterion);
        String var10011 = resourceLocation.getNamespace();
        String var10012 = this.category.getFolderName();
        exporter.accept(
                resourceLocation,
                new SkinUpgradeRecipe(this.weapon),
                advancement.build(new ResourceLocation(var10011, "recipes/" + var10012 + "/" + resourceLocation.getPath()))
        );
    }

    private void ensureValid(ResourceLocation resourceLocation) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + resourceLocation);
        }
    }
}
