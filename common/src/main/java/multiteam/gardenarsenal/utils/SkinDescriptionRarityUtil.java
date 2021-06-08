package multiteam.gardenarsenal.utils;

import net.minecraft.network.chat.TextColor;

public class SkinDescriptionRarityUtil {

    public static int commonColor = 14540253;
    public static int uncommonColor = 2066191;
    public static int rareColor = 2909434;
    public static int epicColor = 9849850;
    public static int legendaryColor = 16559363;
    public static int mythicalColor = 16393225;

    public static TextColor getRarityColorBySkin(String skin){
        int color = switch (skin) {
            case "Default" -> commonColor; //0
            case "camo_desert" -> commonColor; //1
            case "camo_end" -> commonColor; //2
            case "camo_forest" -> commonColor; //3
            case "camo_frost" -> commonColor; //4
            case "camo_nether" -> commonColor; //5
            case "metallic_gold" -> uncommonColor; //6
            case "metallic_iron" -> uncommonColor; //7
            case "metallic_netherite" -> epicColor; //8
            case "seasonal_christmas" -> rareColor; //9
            case "seasonal_halloween" -> rareColor; //10
            case "special_aquatic" -> rareColor; //11
            case "special_neon" -> legendaryColor; //12
            case "special_ectoplasm" -> epicColor; //13
            case "special_nerf" -> legendaryColor; //14
            case "special_rubik" -> epicColor; //15
            case "teams_mcabnormals" -> mythicalColor; //16
            case "teams_multiteam" -> mythicalColor;
            default -> 0; //17
        };
        return TextColor.fromRgb(color);
    }

    public static TextColor getRarityColorByRarity(String skin){
        int color = switch (skin) {
            case "common" -> commonColor;
            case "uncommon" -> uncommonColor;
            case "rare" -> rareColor;
            case "epic" -> epicColor;
            case "legendary" -> legendaryColor;
            case "mythical" -> mythicalColor;
            default -> 0;
        };
        return TextColor.fromRgb(color);
    }
}
