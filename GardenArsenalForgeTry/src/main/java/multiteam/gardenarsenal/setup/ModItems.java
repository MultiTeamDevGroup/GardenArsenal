package multiteam.gardenarsenal.setup;

import multiteam.gardenarsenal.GardenArsenalMod;
import multiteam.gardenarsenal.setup.weapons.CarrotRifle;
import multiteam.gardenarsenal.setup.weapons.PotatoBazooka;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    //Crafting Items
    public static final RegistryObject<Item> IRON_ROD = Registration.ITEMS.register("iron_rod", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));

    //Ammo Items
    public static final RegistryObject<Item> COCOA_BEANS_SHELL = Registration.ITEMS.register("cocoa_beans_shell", () -> new Item(new Item.Properties().group(GardenArsenalMod.GARDEN_ARSENAL_MISC_TAB)));

    //Weapon Items
    public static final RegistryObject<Item> CARROT_RIFLE = Registration.ITEMS.register("carrot_rifle", () -> new CarrotRifle(new Item.Properties().maxDamage(500).group(GardenArsenalMod.GARDEN_ARSENAL_WEAPONS_TAB)));
    public static final RegistryObject<Item> POTATO_BAZOOKA = Registration.ITEMS.register("potato_bazooka", () -> new PotatoBazooka(new Item.Properties().maxDamage(500).group(GardenArsenalMod.GARDEN_ARSENAL_WEAPONS_TAB)));

    static void register() {}
}
