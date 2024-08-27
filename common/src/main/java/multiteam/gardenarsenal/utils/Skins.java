package multiteam.gardenarsenal.utils;

import com.mojang.serialization.Codec;
import dev.architectury.registry.registries.RegistrySupplier;
import io.netty.buffer.ByteBuf;
import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.function.Consumer;
import java.util.function.IntFunction;

public enum Skins implements StringRepresentable, TooltipProvider {
    Default(0, "Default", SkinRarity.common),
    camo_desert(1, "camo_desert", SkinRarity.common),
    camo_end(2, "camo_end", SkinRarity.common),
    camo_forest(3, "camo_forest", SkinRarity.common),
    camo_frost(4, "camo_frost", SkinRarity.common),
    camo_nether(5, "camo_nether", SkinRarity.common),
    metallic_gold(6, "metallic_gold", SkinRarity.uncommon),
    metallic_iron(7, "metallic_iron", SkinRarity.uncommon),
    metallic_copper(8, "metallic_copper", SkinRarity.uncommon),
    metallic_netherite(9, "metallic_netherite", SkinRarity.epic),
    seasonal_christmas(10, "seasonal_christmas", SkinRarity.rare),
    seasonal_halloween(11, "seasonal_halloween", SkinRarity.rare),
    special_aquatic(12, "special_aquatic", SkinRarity.rare),
    special_neon(13, "special_neon", SkinRarity.legendary),
    teams_mcabnormals(14, "teams_mcabnormals", SkinRarity.mythical),
    teams_multiteam(15, "teams_multiteam", SkinRarity.mythical),
    teams_vampirestudios(16, "teams_vampirestudios", SkinRarity.mythical, new RegistrySupplier[]{}), // Don't apply to any skin
    special_ectoplasm(17, "special_ectoplasm", SkinRarity.epic),
    special_nerf(18, "special_nerf", SkinRarity.legendary),
    special_rubik(19, "special_rubik", SkinRarity.epic),
    exclusive_pistols(20, "exclusive_pistols", SkinRarity.mythical, GardenArsenalItems.GLIMMERING_REVOLVER),
    special_goat(21, "special_goat", SkinRarity.epic)
    ;

    public static final Codec<Skins> CODEC = StringRepresentable.fromValues(Skins::values);
    public static final IntFunction<Skins> BY_ID = ByIdMap.continuous(arg -> arg.id, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StreamCodec<ByteBuf, Skins> STREAM_CODEC = ByteBufCodecs.idMapper(BY_ID, arg -> arg.id);

    private int id;
    private String name;

    private SkinRarity rarity;
    private RegistrySupplier<Item>[] weapons;

    Skins(int id, String name, SkinRarity rarity) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.weapons = new RegistrySupplier[] {
                GardenArsenalItems.CARROT_RIFLE,
                GardenArsenalItems.POTATO_BAZOOKA,
                GardenArsenalItems.COCOA_BEAN_SHOTGUN,
                GardenArsenalItems.SEED_PISTOL,
                GardenArsenalItems.SUGAR_CANE_SNIPER,
                GardenArsenalItems.GLIMMERING_REVOLVER
        };
    }

    Skins(int id, String name, SkinRarity rarity, RegistrySupplier<Item>... weapons) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.weapons = weapons;
    }

    public RegistrySupplier<Item>[] getWeapons() {
        return weapons;
    }

    public SkinRarity getRarity() {
        return rarity;
    }

    public RegistrySupplier<Item> getItem() {
        return GardenArsenalItems.SKIN_CARDS.get(this.ordinal());
    }

    public boolean canApplySkin(Item weapon) {
        for (RegistrySupplier<Item> arm : this.weapons) {
            if (arm.get() == weapon) return true;
        }
        return false;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }

    @Override
    public void addToTooltip(Item.TooltipContext tooltipContext, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        consumer.accept(Component.translatable("tooltip.gardenarsenal.skin." + this.name)
                .withStyle(Style.EMPTY.withColor(this.getRarity().getTextColor())));
    }
}
