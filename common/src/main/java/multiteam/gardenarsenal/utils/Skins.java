package multiteam.gardenarsenal.utils;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.world.item.Item;

public enum Skins {
    Default(1,1, SkinRarity.common),
    camo_desert(1,1, SkinRarity.common),
    camo_end(1,1, SkinRarity.common),
    camo_forest(1,1, SkinRarity.common),
    camo_frost(1,1, SkinRarity.common),
    camo_nether(1,1, SkinRarity.common),
    metallic_gold(2,3, SkinRarity.uncommon),
    metallic_iron(1,2, SkinRarity.uncommon),
    metallic_copper(1,2, SkinRarity.uncommon),
    metallic_netherite(3,4, SkinRarity.epic),
    seasonal_christmas(2,3, SkinRarity.rare),
    seasonal_halloween(2,3, SkinRarity.rare),
    special_aquatic(2,3, SkinRarity.rare),
    special_neon(4,5, SkinRarity.legendary),
    teams_mcabnormals(4,5, SkinRarity.mythical),
    teams_multiteam(4,5, SkinRarity.mythical),
    teams_vampirestudios(4,5, SkinRarity.mythical, new RegistrySupplier[]{}), // Don't apply to any skin
    special_ectoplasm(5,6, SkinRarity.epic),
    special_nerf(5,6, SkinRarity.legendary),
    special_rubik(5,6, SkinRarity.epic),
    exclusive_pistols(4,5, SkinRarity.mythical, GardenArsenalItems.GLIMMERING_REVOLVER)
    ;

    // Not used anymore, moved to SkinRarity.
    private int tradeLevel;
    private int price;

    private SkinRarity rarity;
    private RegistrySupplier<Item>[] weapons;

    Skins(int tradeLevel, int price, SkinRarity rarity) {
        this.tradeLevel = tradeLevel;
        this.price = price;
        this.rarity = rarity;
        this.weapons = new RegistrySupplier[] {
                GardenArsenalItems.CARROT_RIFLE,
                GardenArsenalItems.POTATO_BAZOOKA,
                GardenArsenalItems.COCOA_BEAN_SHOTGUN,
                GardenArsenalItems.SEED_PISTOL,
                GardenArsenalItems.SUGAR_CANE_SNIPER,
                GardenArsenalItems.GLIMMERING_REVOLVER
        };
    }

    Skins(int tradeLevel, int price, SkinRarity rarity, RegistrySupplier<Item>... weapons) {
        this.tradeLevel = tradeLevel;
        this.price = price;
        this.rarity = rarity;
        this.weapons = weapons;
    }

    public RegistrySupplier<Item>[] getWeapons() {
        return weapons;
    }

    public int getPrice() {
        return price;
    }

    public int getTradeLevel() {
        return tradeLevel;
    }

    public SkinRarity getRarity() {
        return rarity;
    }

    public RegistrySupplier<Item> getItem() {
        return GardenArsenalItems.SKIN_CARDS.get(this.ordinal());
    }

    public boolean canApplySkin(Item weapon) {
        for (RegistrySupplier<Item> arm : this.weapons) {
            if (arm.get() == weapon) return true;
        }
        return false;
    }
}
