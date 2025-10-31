package multiteam.gardenarsenal.fabric.datagen;

import com.google.gson.JsonObject;
import multiteam.gardenarsenal.recipes.SkinUpgradeRecipe;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class SkinUpgradeRecipeBuilder {
    private final Item weapon;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    private final RecipeSerializer<?> type;
    private final RecipeCategory category;

    public SkinUpgradeRecipeBuilder(Item weapon, RecipeSerializer<?> type, RecipeCategory category) {
        this.weapon = weapon;
        this.type = type;
        this.category = category;
    }

    public static SkinUpgradeRecipeBuilder upgrading(Item weapon) {
        return new SkinUpgradeRecipeBuilder(weapon, SkinUpgradeRecipe.DYNAMIC_SERIALIZER, RecipeCategory.COMBAT);
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
        RecipeSerializer serializer = this.type;
        Item item = this.weapon;
        String var10011 = resourceLocation.getNamespace();
        String var10012 = this.category.getFolderName();
        exporter.accept(new Result(resourceLocation, item, advancement.build(new ResourceLocation(var10011, "recipes/" + var10012 + "/" + resourceLocation.getPath())), serializer));
    }

    private void ensureValid(ResourceLocation resourceLocation) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + resourceLocation);
        }
    }

    public record Result(ResourceLocation id, Item weapon, AdvancementHolder advancement,
                         RecipeSerializer<?> type) implements FinishedRecipe {

        @Override
        public void serializeRecipeData(JsonObject jsonObject) {
            jsonObject.addProperty("weapon", BuiltInRegistries.ITEM.getKey(this.weapon).toString());
        }

        @Override
        public @Nullable AdvancementHolder advancement() {
            return this.advancement;
        }
    }
}
