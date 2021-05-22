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
        int color = 0;
        switch (skin){
            case "Default":
                color = commonColor; //0
                break;
            case "camo_desert":
                color = commonColor; //1
                break;
            case "camo_end":
                color = commonColor; //2
                break;
            case "camo_forest":
                color = commonColor; //3
                break;
            case "camo_frost":
                color = commonColor; //4
                break;
            case "camo_nether":
                color = commonColor; //5
                break;
            case "metallic_gold":
                color = uncommonColor; //6
                break;
            case "metallic_iron":
                color = uncommonColor; //7
                break;
            case "metallic_netherite":
                color = epicColor; //8
                break;
            case "seasonal_christmas":
                color = rareColor; //9
                break;
            case "seasonal_halloween":
                color = rareColor; //10
                break;
            case "special_aquatic":
                color = rareColor; //11
                break;
            case "special_neon":
                color = legendaryColor; //12
                break;
            case "special_ectoplasm":
                color = epicColor; //13
                break;
            case "special_nerf":
                color = legendaryColor; //14
                break;
            case "special_rubik":
                color = epicColor; //15
                break;
            case "teams_mcabnormals":
                color = mythicalColor; //16
                break;
            case "teams_multiteam":
                color = mythicalColor; //17
                break;
        }
        return TextColor.fromRgb(color);
    }

    public static TextColor getRarityColorByRarity(String skin){
        int color = 0;
        switch (skin){
            case "common":
                color = commonColor;
                break;
            case "uncommon":
                color = uncommonColor;
                break;
            case "rare":
                color = rareColor;
                break;
            case "epic":
                color = epicColor;
                break;
            case "legendary":
                color = legendaryColor;
                break;
            case "mythical":
                color = mythicalColor;
                break;
        }
        return TextColor.fromRgb(color);
    }
}
