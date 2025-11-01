package multiteam.gardenarsenal.registries;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.items.*;
import multiteam.gardenarsenal.utils.SkinRarity;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

public class GardenArsenalItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(GardenArsenal.MOD_ID, Registries.ITEM);

    //Vanilla Garden Arsenal - as of v0.3.1
    public static final RegistrySupplier<Item> IRON_ROD = register("iron_rod", (properties) -> new Item(properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));

    public static final RegistrySupplier<Item> COCOA_BEANS_SHELL = register("cocoa_beans_shell", (properties) -> new Item(properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));
    public static final RegistrySupplier<Item> POTATO_GRENADE = register("potato_grenade", (properties) -> new Item(properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));
    public static final RegistrySupplier<Item> BEETROOT_SMOKE = register("beetroot_smoke", (properties) -> new BeetrootSmoke(properties.arch$tab(GardenArsenalCreativeModeTabs.WEAPONS)));
    public static final RegistrySupplier<Item> PROJECTILE_CARROT = register("projectile_carrot", (properties) -> new Item(properties));

    public static final RegistrySupplier<Item> CARROT_RIFLE = register("carrot_rifle", (properties) -> new CarrotRifle(properties.durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));
    public static final RegistrySupplier<Item> POTATO_BAZOOKA = register("potato_bazooka", (properties) -> new PotatoBazooka(properties.durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));
    public static final RegistrySupplier<Item> COCOA_BEAN_SHOTGUN = register("cocoa_bean_shotgun", (properties) -> new CocoaShotgun(properties.durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));
    public static final RegistrySupplier<Item> SEED_PISTOL = register("seed_pistol", (properties) -> new SeedPistol(properties.durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));
    public static final RegistrySupplier<Item> SUGAR_CANE_SNIPER = register("sugar_cane_sniper", (properties) -> new SugarcaneSniper(properties.durability(500).arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));

    public static List<RegistrySupplier<Item>> SKIN_CARDS = new ArrayList<>();

    public static final RegistrySupplier<Item> MACHINE_BLOCK = register("machine_block", (properties) -> new BlockItem(GardenArsenalBlocks.MACHINE_BLOCK.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC).useBlockDescriptionPrefix()));
    public static final RegistrySupplier<Item> TRAP_CAKE = register("trap_cake", (properties) -> new BlockItem(GardenArsenalBlocks.TRAP_CAKE.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC).useBlockDescriptionPrefix()));
    public static final RegistrySupplier<Item> WAR_TACTIC_TABLE = register("war_tactic_table", (properties) -> new BlockItem(GardenArsenalBlocks.WAR_TACTIC_TABLE.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC).useBlockDescriptionPrefix()));
    public static final RegistrySupplier<Item> AMMO_CRATE = register("ammo_crate", (properties) -> new BlockItem(GardenArsenalBlocks.AMMO_CRATE.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC).useBlockDescriptionPrefix()));


    //Makers Shift Update - v0.4
    public static final RegistrySupplier<Item> GLIMMERING_MELON_SEEDS = register("glimmering_melon_seeds", (properties) -> new Item(properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));
    public static final RegistrySupplier<Item> GLIMMERING_REVOLVER = register("glimmering_revolver", (properties) -> new GlimmeringRevolver(properties.arch$tab(GardenArsenalCreativeModeTabs.WEAPONS).durability(500).component(GardenArsenalDataComponents.SKIN.get(), Skins.Default)));

    public static List<RegistrySupplier<Item>> SKIN_CARD_PACKS = new ArrayList<>();

    //Makers Shift Update - v0.5
//    public static final RegistrySupplier<Item> SCRAP_WOOD_PILE = register("scrap_wood_pile", (properties) -> new BlockItem(GardenArsenalBlocks.SCRAP_WOOD_PILE.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> MAKERS_CONCRETE_POWDER_BLOCK = register("makers_concrete_powder", (properties) -> new BlockItem(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER_BLOCK.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> REINFORCED_METAL_BLOCK = register("reinforced_metal_block", (properties) -> new BlockItem(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> INDUSTRIAL_BARRIER_BLOCK = register("industrial_barrier_block", (properties) -> new BlockItem(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> BARRICADE_SURVIVALIST = register("survivalist_barricade", (properties) -> new BlockItem(GardenArsenalBlocks.BARRICADE_SURVIVALIST.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> BARRICADE_MAKER = register("maker_barricade", (properties) -> new BlockItem(GardenArsenalBlocks.BARRICADE_MAKER.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));
//    public static final RegistrySupplier<Item> BARRICADE_INDUSTRIAL = register("industrial_barricade", (properties) -> new BlockItem(GardenArsenalBlocks.BARRICADE_INDUSTRIAL.get(), properties.arch$tab(GardenArsenalCreativeModeTabs.MISC)));

    public static void init() {
        for (Skins skin : Skins.values()) {
            SKIN_CARDS.add(register("skin_card_" + skin.name().toLowerCase(Locale.ENGLISH), (properties) -> new SkinCardItem(skin, properties)));
        }

        SKIN_CARDS = Collections.unmodifiableList(SKIN_CARDS);

        for (SkinRarity rarity : SkinRarity.values()) {
            SKIN_CARD_PACKS.add(register(rarity.name().toLowerCase(Locale.ENGLISH) + "_skin_card_pack", (properties) -> new SkinCardPack(rarity, properties.arch$tab(GardenArsenalCreativeModeTabs.MISC).stacksTo(16))));
        }

        SKIN_CARD_PACKS = Collections.unmodifiableList(SKIN_CARD_PACKS);

        ITEMS.register();
    }

    private static RegistrySupplier<Item> register(String name, Function<Item.Properties, Item> blockFactory) {
        return ITEMS.register(name, () -> blockFactory.apply(new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, GardenArsenal.id(name)))));
    }
}
