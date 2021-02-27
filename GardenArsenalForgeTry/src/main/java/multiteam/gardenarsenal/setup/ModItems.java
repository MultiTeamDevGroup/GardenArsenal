package multiteam.gardenarsenal.setup;

import multiteam.gardenarsenal.GardenArsenalMod;
import multiteam.gardenarsenal.setup.weapons.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;


public class ModItems {
    //Crafting Items
    public static final RegistryObject<Item> IRON_ROD = Registration.ITEMS.register("iron_rod", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));

    //Ammo Items
    public static final RegistryObject<Item> COCOA_BEANS_SHELL = Registration.ITEMS.register("cocoa_beans_shell", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> POTATO_GRANADE = Registration.ITEMS.register("potato_granade", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> BEETROOT_SMOKE = Registration.ITEMS.register("beetroot_smoke", () -> new BeetrootSmoke(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_WEAPONS_TAB)));
    public static final RegistryObject<Item> PROJECTILE_CARROT = Registration.ITEMS.register("projectile_carrot", () -> new Item(new Item.Properties()));

    //Weapon Items
    public static final RegistryObject<Item> CARROT_RIFLE = Registration.ITEMS.register("carrot_rifle", () -> new CarrotRifle(new Item.Properties().maxDamage(500).group(GardenArsenalMod.GARDEN_ARSENAL_WEAPONS_TAB)));
    public static final RegistryObject<Item> POTATO_BAZOOKA = Registration.ITEMS.register("potato_bazooka", () -> new PotatoBazooka(new Item.Properties().maxDamage(500).group(GardenArsenalMod.GARDEN_ARSENAL_WEAPONS_TAB)));
    public static final RegistryObject<Item> COCOA_BEAN_SHOTGUN = Registration.ITEMS.register("cocoa_bean_shotgun", () -> new CocoaShotgun(new Item.Properties().maxDamage(500).group(GardenArsenalMod.GARDEN_ARSENAL_WEAPONS_TAB)));
    public static final RegistryObject<Item> SEED_PISTOL = Registration.ITEMS.register("seed_pistol", () -> new SeedPistol(new Item.Properties().maxDamage(500).group(GardenArsenalMod.GARDEN_ARSENAL_WEAPONS_TAB)));
    public static final RegistryObject<Item> SUGAR_CANE_SNIPER = Registration.ITEMS.register("sugar_cane_sniper", () -> new SugarcaneSniper(new Item.Properties().maxDamage(500).group(GardenArsenalMod.GARDEN_ARSENAL_WEAPONS_TAB)));


    //SkinCards
    public static final RegistryObject<Item> SKIN_CARD0 = Registration.ITEMS.register("skin_card_camo_desert", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD1 = Registration.ITEMS.register("skin_card_camo_end", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD2 = Registration.ITEMS.register("skin_card_camo_forest", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD3 = Registration.ITEMS.register("skin_card_camo_frost", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD4 = Registration.ITEMS.register("skin_card_camo_nether", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD5 = Registration.ITEMS.register("skin_card_metallic_gold", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD6 = Registration.ITEMS.register("skin_card_metallic_iron", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD7 = Registration.ITEMS.register("skin_card_metallic_netherite", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD8 = Registration.ITEMS.register("skin_card_seasonal_christmas", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD9 = Registration.ITEMS.register("skin_card_seasonal_halloween", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD10 = Registration.ITEMS.register("skin_card_special_aquatic", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD11 = Registration.ITEMS.register("skin_card_special_neon", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD15 = Registration.ITEMS.register("skin_card_special_ectoplasm", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD16 = Registration.ITEMS.register("skin_card_special_nerf", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD17 = Registration.ITEMS.register("skin_card_special_rubik", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD12 = Registration.ITEMS.register("skin_card_teams_mcabnormals", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD13 = Registration.ITEMS.register("skin_card_teams_multiteam", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));
    public static final RegistryObject<Item> SKIN_CARD14 = Registration.ITEMS.register("skin_card_teams_vampirestudios", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));

    static void register() {}
}
