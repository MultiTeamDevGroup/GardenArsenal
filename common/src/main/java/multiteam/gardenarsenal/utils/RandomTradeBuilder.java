package multiteam.gardenarsenal.utils;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.Random;
import java.util.function.Function;

public class RandomTradeBuilder {

    private Function<Random, ItemStack> price;
    private Function<Random, ItemStack> price2;
    private Function<Random, ItemStack> forSale;

    private final int maxTrades;
    private final int xp;
    private final float priceMult;

    private boolean rare;

    public RandomTradeBuilder(int maxTrades, int xp, float priceMult) {
        this.maxTrades = maxTrades;
        this.xp = xp;
        this.priceMult = priceMult;

        this.price = null;
        this.price2 = random -> ItemStack.EMPTY;
        this.forSale = null;
        this.rare = false;
    }

    public RandomTradeBuilder setPrice(Function<Random, ItemStack> price) {
        this.price = price;
        return this;
    }

    public RandomTradeBuilder setPrice(Item item, int min, int max) {
        return this.setPrice(toFunction(item, min, max));
    }

    public RandomTradeBuilder setPrice2(Function<Random, ItemStack> price) {
        this.price2 = price;
        return this;
    }

    public RandomTradeBuilder setPrice2(Item item, int min, int max) {
        return this.setPrice2(toFunction(item, min, max));
    }

    public RandomTradeBuilder setForSale(Function<Random, ItemStack> forSale) {
        this.forSale = forSale;
        return this;
    }

    public RandomTradeBuilder setForSale(RegistrySupplier<Item> item, int min, int max) {
        return this.setForSale(toFunction(item, min, max));
    }

    public RandomTradeBuilder setEmeraldPrice(int count) {
        return this.setPrice(toFunction(Items.EMERALD, count));
    }

    public RandomTradeBuilder setEmeraldPriceFor(int emeralds, Item item, int count) {
        this.setEmeraldPrice(emeralds);
        return this.setForSale(toFunction(item, count));
    }

    public RandomTradeBuilder setEmeraldPriceFor(int emeralds, Item item) {
        return this.setEmeraldPriceFor(emeralds, item, 1);
    }

    public RandomTradeBuilder setEmeraldPrice(int min, int max) {
        return this.setPrice(Items.EMERALD, min, max);
    }

    public RandomTradeBuilder setEmeraldPriceFor(int min, int max, Item item, int count) {
        this.setEmeraldPrice(min, max);
        return this.setForSale(toFunction(item, count));
    }

    public RandomTradeBuilder setEmeraldPriceFor(int min, int max, Item item) {
        return this.setEmeraldPriceFor(min, max, item, 1);
    }

    public RandomTradeBuilder setRare() {
        this.rare = true;
        return this;
    }

    private Function<Random, ItemStack> toFunction(Item item, int min, int max) {
        return (random) -> new ItemStack(item, random.nextInt(max) + min);
    }

    private Function<Random, ItemStack> toFunction(RegistrySupplier<Item> item, int min, int max) {
        return (random) -> new ItemStack(item.get(), random.nextInt(max) + min);
    }

    private Function<Random, ItemStack> toFunction(Item item, int count) {
        return (random) -> new ItemStack(item, count);
    }

    private Function<Random, ItemStack> toFunction(RegistrySupplier<Item> item, int count) {
        return (random) -> new ItemStack(item.get(), count);
    }

    public boolean canBuild()
    {
        return this.price != null && this.forSale != null;
    }

    public VillagerTrades.ItemListing build() {
        return (entity, random) -> !this.canBuild() ? null : new MerchantOffer(this.price.apply(random), this.price2.apply(random), this.forSale.apply(random), this.maxTrades, this.xp, this.priceMult);
    }
}
