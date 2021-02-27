package multiteam.gardenarsenal.registries;

import me.shedaniel.architectury.registry.CreativeTabs;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.items.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class GardenArsenalItems {

    public static final CreativeModeTab WEAPONS = CreativeTabs.create(new ResourceLocation(GardenArsenal.MOD_ID, "weapons"), new Supplier<ItemStack>() {
        @Override
        public ItemStack get() {
            return new ItemStack(CARROT_RIFLE.get());
        }
    });
    public static final CreativeModeTab MISC = CreativeTabs.create(new ResourceLocation(GardenArsenal.MOD_ID, "misc"), new Supplier<ItemStack>() {
        @Override
        public ItemStack get() {
            return new ItemStack(PROJECTILE_CARROT.get());
        }
    });

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(GardenArsenal.MOD_ID, Registry.ITEM_REGISTRY);


    public static final RegistrySupplier<Item> IRON_ROD = ITEMS.register("iron_rod", () ->
            new Item(new Item.Properties().tab(MISC)));

    public static final RegistrySupplier<Item> COCOA_BEANS_SHELL = ITEMS.register("cocoa_beans_shell", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> POTATO_GRENADE = ITEMS.register("potato_grenade", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> BEETROOT_SMOKE = ITEMS.register("beetroot_smoke", () ->
            new BeetrootSmoke(new Item.Properties().tab(WEAPONS)));
    public static final RegistrySupplier<Item> PROJECTILE_CARROT = ITEMS.register("projectile_carrot", () ->
            new Item(new Item.Properties()));

    public static final RegistrySupplier<Item> CARROT_RIFLE = ITEMS.register("carrot_rifle", () ->
            new CarrotRifle(new Item.Properties().tab(WEAPONS)));
    public static final RegistrySupplier<Item> POTATO_BAZOOKA = ITEMS.register("potato_bazooka", () ->
            new PotatoBazooka(new Item.Properties().tab(WEAPONS)));
    public static final RegistrySupplier<Item> COCOA_BEAN_SHOTGUN = ITEMS.register("cocoa_bean_shotgun", () ->
            new CocoaShotgun(new Item.Properties().tab(WEAPONS)));
    public static final RegistrySupplier<Item> SEED_PISTOL = ITEMS.register("seed_pistol", () ->
            new SeedPistol(new Item.Properties().tab(WEAPONS)));
    public static final RegistrySupplier<Item> SUGAR_CANE_SNIPER = ITEMS.register("sugar_cane_sniper", () ->
            new SugarcaneSniper(new Item.Properties().tab(WEAPONS)));

    public static final RegistrySupplier<Item> SKIN_DESERT = ITEMS.register("skin_card_camo_desert", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_END = ITEMS.register("skin_card_camo_end", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_FOREST = ITEMS.register("skin_card_camo_forest", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_FROST = ITEMS.register("skin_card_camo_frost", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_NETHER = ITEMS.register("skin_card_camo_nether", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_GOLD = ITEMS.register("skin_card_metallic_gold", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_IRON = ITEMS.register("skin_card_metallic_iron", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_NETHERITE = ITEMS.register("skin_card_metallic_netherite", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_CHRISTMAS = ITEMS.register("skin_card_seasonal_christmas", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_HALLOWEEN = ITEMS.register("skin_card_seasonal_halloween", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_AQUATIC = ITEMS.register("skin_card_special_aquatic", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_NEON = ITEMS.register("skin_card_special_neon", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_MCABNORMALS = ITEMS.register("skin_card_teams_mcabnormals", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_MULTITEAM = ITEMS.register("skin_card_teams_multiteam", () ->
            new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> SKIN_VAMPIRESTUDIOS = ITEMS.register("skin_card_teams_vampirestudios", () ->
            new Item(new Item.Properties().tab(MISC)));

    public static final RegistrySupplier<Item> MACHINE_BLOCK = ITEMS.register("machine_block",
            () -> new BlockItem(GardenArsenalBlocks.MACHINE_BLOCK.get(), new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> TRAP_CAKE = ITEMS.register("trap_cake",
            () -> new BlockItem(GardenArsenalBlocks.TRAP_CAKE.get(), new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> GARDEN_SOLDIER_COMMANDER_POI = ITEMS.register("garden_soldier_commander_poi",
            () -> new BlockItem(GardenArsenalBlocks.GARDEN_SOLDIER_COMMANDER_POI.get(), new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> GARDEN_SOLDIER_POI = ITEMS.register("garden_soldier_poi",
            () -> new BlockItem(GardenArsenalBlocks.GARDEN_SOLDIER_POI.get(), new Item.Properties().tab(MISC)));

    public static void init() {
        ITEMS.register();
    }
}
