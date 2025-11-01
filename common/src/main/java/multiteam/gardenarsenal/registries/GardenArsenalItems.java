package multiteam.gardenarsenal.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.items.*;
import multiteam.gardenarsenal.utils.SkinRarity;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class GardenArsenalItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.ITEM);

    //Vanilla Garden Arsenal - as of v0.3.1
    public static final RegistrySupplier<Item> IRON_ROD = ITEMS.register("iron_rod", () -> new Item(new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));

    public static final RegistrySupplier<Item> COCOA_BEANS_SHELL = ITEMS.register("cocoa_beans_shell", () -> new Item(new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));
    public static final RegistrySupplier<Item> POTATO_GRENADE = ITEMS.register("potato_grenade", () -> new Item(new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));
    public static final RegistrySupplier<Item> BEETROOT_SMOKE = ITEMS.register("beetroot_smoke", () -> new BeetrootSmoke(new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.WEAPONS)));
    public static final RegistrySupplier<Item> PROJECTILE_CARROT = ITEMS.register("projectile_carrot", () -> new Item(new Item.Properties()));

    public static final RegistrySupplier<Item> CARROT_RIFLE = ITEMS.register("carrot_rifle", () -> new CarrotRifle(new Item.Properties().durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));
    public static final RegistrySupplier<Item> POTATO_BAZOOKA = ITEMS.register("potato_bazooka", () -> new PotatoBazooka(new Item.Properties().durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));
    public static final RegistrySupplier<Item> COCOA_BEAN_SHOTGUN = ITEMS.register("cocoa_bean_shotgun", () -> new CocoaShotgun(new Item.Properties().durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));
    public static final RegistrySupplier<Item> SEED_PISTOL = ITEMS.register("seed_pistol", () -> new SeedPistol(new Item.Properties().durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));
    public static final RegistrySupplier<Item> SUGAR_CANE_SNIPER = ITEMS.register("sugar_cane_sniper", () -> new SugarcaneSniper(new Item.Properties().durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));

    public static List<RegistrySupplier<Item>> SKIN_CARDS = new ArrayList<>();

    public static final RegistrySupplier<Item> MACHINE_BLOCK = ITEMS.register("machine_block", () -> new BlockItem(GardenArsenalBlocks.MACHINE_BLOCK.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC).useBlockDescriptionPrefix()));
    public static final RegistrySupplier<Item> TRAP_CAKE = ITEMS.register("trap_cake", () -> new BlockItem(GardenArsenalBlocks.TRAP_CAKE.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC).useBlockDescriptionPrefix()));
    public static final RegistrySupplier<Item> WAR_TACTIC_TABLE = ITEMS.register("war_tactic_table", () -> new BlockItem(GardenArsenalBlocks.WAR_TACTIC_TABLE.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC).useBlockDescriptionPrefix()));
    public static final RegistrySupplier<Item> AMMO_CRATE = ITEMS.register("ammo_crate", () -> new BlockItem(GardenArsenalBlocks.AMMO_CRATE.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC).useBlockDescriptionPrefix()));


    //Makers Shift Update - v0.4
    public static final RegistrySupplier<Item> GLIMMERING_MELON_SEEDS = ITEMS.register("glimmering_melon_seeds", () -> new Item(new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));
    public static final RegistrySupplier<Item> GLIMMERING_REVOLVER = ITEMS.register("glimmering_revolver", () -> new GlimmeringRevolver(new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).durability(500).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));

    public static List<RegistrySupplier<Item>> SKIN_CARD_PACKS = new ArrayList<>();

    //Makers Shift Update - v0.5
//    public static final RegistrySupplier<Item> SCRAP_WOOD_PILE = ITEMS.register("scrap_wood_pile", () -> new BlockItem(GardenArsenalBlocks.SCRAP_WOOD_PILE.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> MAKERS_CONCRETE_POWDER_BLOCK = ITEMS.register("makers_concrete_powder", () -> new BlockItem(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER_BLOCK.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> REINFORCED_METAL_BLOCK = ITEMS.register("reinforced_metal_block", () -> new BlockItem(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> INDUSTRIAL_BARRIER_BLOCK = ITEMS.register("industrial_barrier_block", () -> new BlockItem(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> BARRICADE_SURVIVALIST = ITEMS.register("survivalist_barricade", () -> new BlockItem(GardenArsenalBlocks.BARRICADE_SURVIVALIST.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> BARRICADE_MAKER = ITEMS.register("maker_barricade", () -> new BlockItem(GardenArsenalBlocks.BARRICADE_MAKER.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> BARRICADE_INDUSTRIAL = ITEMS.register("industrial_barricade", () -> new BlockItem(GardenArsenalBlocks.BARRICADE_INDUSTRIAL.get(), new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC)));

    public static void init() {
        for (Skins skin : Skins.values()) {
            SKIN_CARDS.add(ITEMS.register("skin_card_" + skin.name().toLowerCase(Locale.ENGLISH), () -> new SkinCardItem(skin)));
        }

        SKIN_CARDS = Collections.unmodifiableList(SKIN_CARDS);

        for (SkinRarity rarity : SkinRarity.values()) {
            SKIN_CARD_PACKS.add(ITEMS.register(rarity.name().toLowerCase(Locale.ENGLISH) + "_skin_card_pack", () -> new SkinCardPack(rarity, new Item.Properties().arch$tab(GardenArsenalCreativeModeTabs.MISC).stacksTo(16))));
        }

        SKIN_CARD_PACKS = Collections.unmodifiableList(SKIN_CARD_PACKS);

        ITEMS.register();
    }
}
