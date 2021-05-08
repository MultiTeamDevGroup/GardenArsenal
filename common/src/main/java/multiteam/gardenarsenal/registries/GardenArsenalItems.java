package multiteam.gardenarsenal.registries;

import me.shedaniel.architectury.registry.CreativeTabs;
import me.shedaniel.architectury.registry.DeferredRegister;
import me.shedaniel.architectury.registry.RegistrySupplier;
import multiteam.gardenarsenal.GardenArsenal;
import multiteam.gardenarsenal.items.*;
import multiteam.gardenarsenal.utils.Skins;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
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


    public static final RegistrySupplier<Item> IRON_ROD = ITEMS.register("iron_rod", () -> new Item(new Item.Properties().tab(MISC)));

    public static final RegistrySupplier<Item> COCOA_BEANS_SHELL = ITEMS.register("cocoa_beans_shell", () -> new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> POTATO_GRENADE = ITEMS.register("potato_grenade", () -> new Item(new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> BEETROOT_SMOKE = ITEMS.register("beetroot_smoke", () -> new BeetrootSmoke(new Item.Properties().tab(WEAPONS)));
    public static final RegistrySupplier<Item> PROJECTILE_CARROT = ITEMS.register("projectile_carrot", () -> new Item(new Item.Properties()));

    public static final RegistrySupplier<Item> CARROT_RIFLE = ITEMS.register("carrot_rifle", () -> new CarrotRifle(new Item.Properties().tab(WEAPONS).stacksTo(1)));
    public static final RegistrySupplier<Item> POTATO_BAZOOKA = ITEMS.register("potato_bazooka", () -> new PotatoBazooka(new Item.Properties().tab(WEAPONS).stacksTo(1)));
    public static final RegistrySupplier<Item> COCOA_BEAN_SHOTGUN = ITEMS.register("cocoa_bean_shotgun", () -> new CocoaShotgun(new Item.Properties().tab(WEAPONS).stacksTo(1)));
    public static final RegistrySupplier<Item> SEED_PISTOL = ITEMS.register("seed_pistol", () -> new SeedPistol(new Item.Properties().tab(WEAPONS).stacksTo(1)));
    public static final RegistrySupplier<Item> SUGAR_CANE_SNIPER = ITEMS.register("sugar_cane_sniper", () -> new SugarcaneSniper(new Item.Properties().tab(WEAPONS).stacksTo(1)));

    public static List<RegistrySupplier<Item>> SKIN_CARDS = new ArrayList<>();

    public static final RegistrySupplier<Item> MACHINE_BLOCK = ITEMS.register("machine_block", () -> new BlockItem(GardenArsenalBlocks.MACHINE_BLOCK.get(), new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> TRAP_CAKE = ITEMS.register("trap_cake", () -> new BlockItem(GardenArsenalBlocks.TRAP_CAKE.get(), new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> WAR_TACTIC_TABLE = ITEMS.register("war_tactic_table", () -> new BlockItem(GardenArsenalBlocks.WAR_TACTIC_TABLE.get(), new Item.Properties().tab(MISC)));
    public static final RegistrySupplier<Item> AMMO_CRATE = ITEMS.register("ammo_crate", () -> new BlockItem(GardenArsenalBlocks.AMMO_CRATE.get(), new Item.Properties().tab(MISC)));

    public static void init() {
        for (Skins skin : Skins.values()) {
            SKIN_CARDS.add(ITEMS.register("skin_card_" + skin.name().toLowerCase(Locale.ENGLISH), () -> new SkinCardItem(skin)));
        }

        List<RegistrySupplier<Item>> list = Collections.unmodifiableList(SKIN_CARDS);
        SKIN_CARDS = list;

        ITEMS.register();
    }
}
