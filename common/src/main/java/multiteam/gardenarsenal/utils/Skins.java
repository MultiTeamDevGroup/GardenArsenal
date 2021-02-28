package multiteam.gardenarsenal.utils;

public enum Skins {
    Default(1,1),
    camo_desert(1,1),
    camo_end(1,1),
    camo_forest(1,1),
    camo_frost(1,1),
    camo_nether(1,1),
    metallic_gold(2,3),
    metallic_iron(1,2),
    metallic_netherite(3,4),
    seasonal_christmas(2,3),
    seasonal_halloween(2,3),
    special_aquatic(2,3),
    special_neon(4,5),
    special_ectoplasm(5,6),
    special_nerf(5,6),
    special_rubik(5,6),
    teams_mcabnormals(4,5),
    teams_multiteam(4,5),
    teams_vampirestudios(4,5);

    private int tradeLevel;
    private int price;

    Skins(int tradeLevel, int price) {
        this.tradeLevel = tradeLevel;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getTradeLevel() {
        return tradeLevel;
    }
}
