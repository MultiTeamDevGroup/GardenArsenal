package multiteam.gardenarsenal.utils;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.Optional;
import java.util.function.Function;

public class RandomTradeBuilder {

    private Function<RandomSource, ItemCost> price;
    private Function<RandomSource, Optional<ItemCost>> price2;
    private Function<RandomSource, ItemStack> forSale;

    private final int maxTrades;
    private final int xp;
    private final float priceMult;

    private boolean rare;

    public RandomTradeBuilder(int maxTrades, int xp, float priceMult) {
        this.maxTrades = maxTrades;
        this.xp = xp;
        this.priceMult = priceMult;

        this.price = null;
        this.price2 = random -> Optional.empty();
        this.forSale = null;
        this.rare = false;
    }

    public RandomTradeBuilder setPrice(Function<RandomSource, ItemCost> price) {
        this.price = price;
        return this;
    }

    public RandomTradeBuilder setPrice(Item item, int min, int max) {
        return this.setPrice(toItemCostFunction(item, min, max));
    }

    public RandomTradeBuilder setPrice2(Function<RandomSource, Optional<ItemCost>> price) {
        this.price2 = price;
        return this;
    }

    public RandomTradeBuilder setPrice2(Item item, int min, int max) {
        return this.setPrice2(toItemCostFunction(item, min, max).andThen(Optional::of));
    }

    public RandomTradeBuilder setForSale(Function<RandomSource, ItemStack> forSale) {
        this.forSale = forSale;
        return this;
    }

    public RandomTradeBuilder setForSale(RegistrySupplier<Item> item, int min, int max) {
        return this.setForSale(toItemStackFunction(item, min, max));
    }

    public RandomTradeBuilder setEmeraldPrice(int count) {
        return this.setPrice(toItemCostFunction(Items.EMERALD, count));
    }

    public RandomTradeBuilder setEmeraldPriceFor(int emeralds, Item item, int count) {
        this.setEmeraldPrice(emeralds);
        return this.setForSale(toItemStackFunction(item, count));
    }

    public RandomTradeBuilder setEmeraldPriceFor(int emeralds, Item item) {
        return this.setEmeraldPriceFor(emeralds, item, 1);
    }

    public RandomTradeBuilder setEmeraldPrice(int min, int max) {
        return this.setPrice(Items.EMERALD, min, max);
    }

    public RandomTradeBuilder setEmeraldPriceFor(int min, int max, Item item, int count) {
        this.setEmeraldPrice(min, max);
        return this.setForSale(toItemStackFunction(item, count));
    }

    public RandomTradeBuilder setEmeraldPriceFor(int min, int max, Item item) {
        return this.setEmeraldPriceFor(min, max, item, 1);
    }

    public RandomTradeBuilder setRare() {
        this.rare = true;
        return this;
    }

    private Function<RandomSource, ItemStack> toItemStackFunction(Item item, int min, int max) {
        return (random) -> new ItemStack(item, random.nextInt(max) + min);
    }

    private Function<RandomSource, ItemStack> toItemStackFunction(RegistrySupplier<Item> item, int min, int max) {
        return (random) -> new ItemStack(item.get(), random.nextInt(max) + min);
    }

    private Function<RandomSource, ItemStack> toItemStackFunction(Item item, int count) {
        return (random) -> new ItemStack(item, count);
    }

    private Function<RandomSource, ItemStack> toItemStackFunction(RegistrySupplier<Item> item, int count) {
        return (random) -> new ItemStack(item.get(), count);
    }

    private Function<RandomSource, ItemCost> toItemCostFunction(Item item, int min, int max) {
        return (random) -> new ItemCost(item, random.nextInt(max) + min);
    }

    private Function<RandomSource, ItemCost> toItemCostFunction(RegistrySupplier<Item> item, int min, int max) {
        return (random) -> new ItemCost(item.get(), random.nextInt(max) + min);
    }

    private Function<RandomSource, ItemCost> toItemCostFunction(Item item, int count) {
        return (random) -> new ItemCost(item, count);
    }

    private Function<RandomSource, ItemCost> toItemCostFunction(RegistrySupplier<Item> item, int count) {
        return (random) -> new ItemCost(item.get(), count);
    }

    public boolean canBuild()
    {
        return this.price != null && this.forSale != null;
    }

    public VillagerTrades.ItemListing build() {
        return (entity, random) -> !this.canBuild() ? null : new MerchantOffer(this.price.apply(random), this.price2.apply(random), this.forSale.apply(random), this.maxTrades, this.xp, this.priceMult);
    }
}
