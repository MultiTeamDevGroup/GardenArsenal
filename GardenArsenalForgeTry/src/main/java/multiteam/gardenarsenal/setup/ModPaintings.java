package multiteam.gardenarsenal.setup;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;

public class ModPaintings {

    public static RegistryObject<PaintingType> PAINTING_BLUEPRINT_RIFLE = Registration.PAINTINGS.register("blueprint_carrot_rifle_by_lta",()-> new PaintingType(80, 48));
    public static RegistryObject<PaintingType> PAINTING_BLUEPRINT_SHOTGUN = Registration.PAINTINGS.register("blueprint_cocoabean_shotgun_by_lta",()-> new PaintingType(80, 48));
    public static RegistryObject<PaintingType> PAINTING_BLUEPRINT_BAZOOKA = Registration.PAINTINGS.register("blueprint_potato_bazooka_by_lta",()-> new PaintingType(80, 48));
    public static RegistryObject<PaintingType> PAINTING_BLUEPRINT_PISTOL = Registration.PAINTINGS.register("blueprint_seed_pistol_by_lta",()-> new PaintingType(80, 48));
    public static RegistryObject<PaintingType> PAINTING_BLUEPRINT_SNIPER = Registration.PAINTINGS.register("blueprint_sugar_cane_sniper_by_lta",()-> new PaintingType(80, 48));

    public static void register() {}
}
