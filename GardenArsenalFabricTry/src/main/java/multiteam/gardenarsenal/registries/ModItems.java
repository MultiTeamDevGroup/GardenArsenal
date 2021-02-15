package multiteam.gardenarsenal.registries;

import multiteam.gardenarsenal.items.*;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import static multiteam.gardenarsenal.GardenArsenal.*;

public class ModItems {

    public static Item IRON_ROD = register("iron_rod", new Item(new Item.Settings().group(MISC)));

    public static Item COCOA_BEANS_SHELL = register("cocoa_beans_shell", new Item(new Item.Settings().group(MISC)));
    public static Item POTATO_GRENADE = register("potato_grenade", new Item(new Item.Settings().group(MISC)));
    public static Item BEETROOT_SMOKE = register("beetroot_smoke", new Item(new Item.Settings().group(WEAPONS)));
    public static Item PROJECTILE_CARROT = register("projectile_carrot", new Item(new Item.Settings()));

    public static Item CARROT_RIFLE = register("carrot_rifle", new CarrotRifle(new Item.Settings().group(WEAPONS)));
    public static Item POTATO_BAZOOKA = register("potato_bazooka", new PotatoBazooka(new Item.Settings().group(WEAPONS)));
    public static Item COCOA_BEAN_SHOTGUN = register("cocoa_bean_shotgun", new CocoaShotgun(new Item.Settings().group(WEAPONS)));
    public static Item SEED_PISTOL = register("seed_pistol", new SeedPistol(new Item.Settings().group(WEAPONS)));
    public static Item SUGAR_CANE_SNIPER = register("sugar_cane_sniper", new SugarcaneSniper(new Item.Settings().group(WEAPONS)));

    public static Item SKIN_CARD_DESERT = register("skin_card_camo_desert", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_END = register("skin_card_camo_end", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_FOREST = register("skin_card_camo_forest", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_FROST = register("skin_card_camo_frost", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_NETHER = register("skin_card_camo_nether", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_GOLD = register("skin_card_metalic_gold", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_IRON = register("skin_card_metalic_iron", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_NETHERITE = register("skin_card_metalic_netherite", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_CHRISTMAS = register("skin_card_seasonal_christmas", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_HALLOWEEN = register("skin_card_seasonal_halloween", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_AQUATIC = register("skin_card_special_aquatic", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_NEON = register("skin_card_special_neon", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_MCABNORMALS = register("skin_card_teams_mcabnormals", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_MULTITEAM = register("skin_card_teams_multiteam", new Item(new Item.Settings().group(MISC)));
    public static Item SKIN_CARD_VAMPIRESTUDIOS = register("skin_card_teams_vampirestudios", new Item(new Item.Settings().group(MISC)));

    public static void init() {}

    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, id(name), item);
    }
}
