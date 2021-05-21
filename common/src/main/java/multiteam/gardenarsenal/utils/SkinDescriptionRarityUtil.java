package multiteam.gardenarsenal.utils;

import net.minecraft.network.chat.TextColor;

public class SkinDescriptionRarityUtil {

    public static int commonColor = 14540253;
    public static int uncommonColor = 2066191;
    public static int rareColor = 2909434;
    public static int epicColor = 9849850;
    public static int legendaryColor = 16559363;
    public static int mythicalColor = 16393225;

    public static TextColor getRarityColor(String skin){
        int color = 0;
        switch (skin){
            case "Default":
                color = commonColor;
                break;
            case "camo_desert":
                color = commonColor;
                break;
            case "camo_end":
                color = commonColor;
                break;
            case "camo_forest":
                color = commonColor;
                break;
            case "camo_frost":
                color = commonColor;
                break;
            case "camo_nether":
                color = commonColor;
                break;
            case "metallic_gold":
                color = rareColor;
                break;
            case "metallic_iron":
                color = uncommonColor;
                break;
            case "metallic_netherite":
                color = epicColor;
                break;
            case "seasonal_christmas":
                color = rareColor;
                break;
            case "seasonal_halloween":
                color = rareColor;
                break;
            case "special_aquatic":
                color = rareColor;
                break;
            case "special_neon":
                color = legendaryColor;
                break;
            case "special_ectoplasm":
                color = legendaryColor;
                break;
            case "special_nerf":
                color = legendaryColor;
                break;
            case "special_rubik":
                color = legendaryColor;
                break;
            case "teams_mcabnormals":
                color = mythicalColor;
                break;
            case "teams_multiteam":
                color = mythicalColor;
                break;
            case "teams_vampirestudios":
                color = mythicalColor;
                break;
        }
        return TextColor.fromRgb(color);
    }
}
