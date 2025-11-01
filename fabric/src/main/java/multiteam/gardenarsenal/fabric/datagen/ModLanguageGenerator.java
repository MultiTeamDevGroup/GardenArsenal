package multiteam.gardenarsenal.fabric.datagen;

import dev.architectury.registry.registries.RegistrySupplier;
import multiteam.gardenarsenal.registries.*;
import multiteam.gardenarsenal.utils.SkinRarity;
import multiteam.gardenarsenal.utils.Skins;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.CompletableFuture;

public class ModLanguageGenerator extends FabricLanguageProvider {
    protected ModLanguageGenerator(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        // Item Groups
        translationBuilder.add(GardenArsenalCreativeModeTabs.WEAPONS.getKey(), "Garden Arsenal - Weapons");
        translationBuilder.add(GardenArsenalCreativeModeTabs.MISC.getKey(), "Garden Arsenal - Misc");

        // Items
        translationBuilder.add(GardenArsenalItems.IRON_ROD.get(), "Iron Rod");
        translationBuilder.add(GardenArsenalItems.COCOA_BEANS_SHELL.get(), "Cocoa Beans Shell");
        translationBuilder.add(GardenArsenalItems.GLIMMERING_MELON_SEEDS.get(), "Glimmering Melon Seeds");

        for (var skinPack : GardenArsenalItems.SKIN_CARD_PACKS) {
            translationBuilder.add(skinPack.get(), "Skin Card Pack");
        }

        for (var skin : Skins.values()) {
            translationBuilder.add(skin.getItem().get(), getSkinName(skin) + " Skin Card");
        }

        translationBuilder.add(GardenArsenalItems.CARROT_RIFLE.get(), "Carrot Rifle");
        translationBuilder.add(
                getWeaponTooltipKey(GardenArsenalItems.CARROT_RIFLE),
                "Rapidly fires carrots"
        );
        translationBuilder.add(GardenArsenalItems.POTATO_BAZOOKA.get(), "Potato Bazooka");
        translationBuilder.add(
                getWeaponTooltipKey(GardenArsenalItems.POTATO_BAZOOKA),
                "Fires §lexplosive §rpotatoes"
        );
        translationBuilder.add(GardenArsenalItems.COCOA_BEAN_SHOTGUN.get(), "Cocoa Bean Shotgun");
        translationBuilder.add(
                getWeaponTooltipKey(GardenArsenalItems.COCOA_BEAN_SHOTGUN),
                "Fires several beans at once"
        );
        translationBuilder.add(GardenArsenalItems.SEED_PISTOL.get(), "Wheat-Seed Pistol");
        translationBuilder.add(
                getWeaponTooltipKey(GardenArsenalItems.SEED_PISTOL),
                "Shoots seeds"
        );
        translationBuilder.add(GardenArsenalItems.SUGAR_CANE_SNIPER.get(), "Sugar Cane Sniper");
        translationBuilder.add(
                getWeaponTooltipKey(GardenArsenalItems.SUGAR_CANE_SNIPER),
                "Slow and steady wins the race. High precision sugar canes."
        );
        translationBuilder.add(GardenArsenalItems.PROJECTILE_CARROT.get(), "§6Garden Arsenal Carrot");
        translationBuilder.add(GardenArsenalItems.POTATO_GRENADE.get(), "Potato Grenade");
        translationBuilder.add(GardenArsenalItems.BEETROOT_SMOKE.get(), "Beetroot Smoke");
        translationBuilder.add(
                getWeaponTooltipKey(GardenArsenalItems.BEETROOT_SMOKE),
                "Makes a cloud of blindness on impact"
        );
        translationBuilder.add(GardenArsenalItems.GLIMMERING_REVOLVER.get(), "Glimmering Revolver");
        translationBuilder.add(
                getWeaponTooltipKey(GardenArsenalItems.GLIMMERING_REVOLVER),
                "Revolves around shiny seeds. Can fire up to 6 shots, then needs reloading"
        );

        // Blocks
        translationBuilder.add(GardenArsenalBlocks.MACHINE_BLOCK.get(), "Machine Block");
        translationBuilder.add(GardenArsenalBlocks.TRAP_CAKE.get(), "Trap Cake");
        translationBuilder.add(GardenArsenalBlocks.WAR_TACTIC_TABLE.get(), "War Tactic Table");
        translationBuilder.add(GardenArsenalBlocks.AMMO_CRATE.get(), "Ammo Crate");
        // Makers Shift Update - v0.5
//        translationBuilder.add(GardenArsenalBlocks.SURVIVALIST_BARRICADE.get(), "Survivalist Barricade");
//        translationBuilder.add(GardenArsenalBlocks.MAKER_BARRICADE.get(), "Makers Barricade");
//        translationBuilder.add(GardenArsenalBlocks.INDUSTRIAL_BARRICADE.get(), "Industrial Barricade");
//        translationBuilder.add(GardenArsenalBlocks.SCRAP_WOOD_PILE.get(), "Scrap Wood Pile");
//        translationBuilder.add(GardenArsenalBlocks.MAKERS_CONCRETE_POWDER.get(), "Makers' Concrete Powder");
//        translationBuilder.add(GardenArsenalBlocks.REINFORCED_METAL_BLOCK.get(), "Reinforced Metal Block");
//        translationBuilder.add(GardenArsenalBlocks.INDUSTRIAL_BARRIER_BLOCK.get(), "Industrial Barrier Block");

        // Skins
        translationBuilder.add(getSkinKey(Skins.Default), "Default");
        translationBuilder.add(getSkinKey(Skins.camo_desert), "Desert - Camouflage");
        translationBuilder.add(getSkinKey(Skins.camo_end), "End - Camouflage");
        translationBuilder.add(getSkinKey(Skins.camo_forest), "Forest - Camouflage");
        translationBuilder.add(getSkinKey(Skins.camo_frost), "Frost - Camouflage");
        translationBuilder.add(getSkinKey(Skins.camo_nether), "Nether - Camouflage");
        translationBuilder.add(getSkinKey(Skins.metallic_gold), "Gold - Metallic - Aurum");
        translationBuilder.add(getSkinKey(Skins.metallic_iron), "Iron - Metallic");
        translationBuilder.add(getSkinKey(Skins.metallic_copper), "Copper - Metallic");
        translationBuilder.add(getSkinKey(Skins.metallic_netherite), "Netherite - Metallic");
        translationBuilder.add(getSkinKey(Skins.seasonal_christmas), "Christmas - Seasonal");
        translationBuilder.add(getSkinKey(Skins.seasonal_halloween), "Halloween - Seasonal");
        translationBuilder.add(getSkinKey(Skins.special_aquatic), "Aquatic - Special");
        translationBuilder.add(getSkinKey(Skins.special_neon), "Neon - Special");
        translationBuilder.add(getSkinKey(Skins.special_ectoplasm), "Ectoplasm - Special");
        translationBuilder.add(getSkinKey(Skins.special_nerf), "Nerf - Special");
        translationBuilder.add(getSkinKey(Skins.special_rubik), "Rubik - Special");
        translationBuilder.add(getSkinKey(Skins.teams_mcabnormals), "MCAbnormals - Branded");
        translationBuilder.add(getSkinKey(Skins.teams_multiteam), "MultiTeam - Branded");
        translationBuilder.add(getSkinKey(Skins.teams_vampirestudios), "VampireStudios - Branded");
        translationBuilder.add(getSkinKey(Skins.exclusive_pistols), "Pistols - Exclusive");
        translationBuilder.add(getSkinKey(Skins.special_goat), "Goat - Special");

        for (SkinRarity rarity : SkinRarity.values()) {
            translationBuilder.add("rarity.gardenarsenal." + rarity.name(), StringUtils.capitalize(rarity.name()));
        }

        translationBuilder.add(getProfessionKey(GardenArsenalProfessions.GARDEN_SOLDIER), "Garden Soldier");
        translationBuilder.add(getProfessionKey(GardenArsenalProfessions.GARDEN_SOLDIER_COMMANDER), "Garden Soldier Commander");

        translationBuilder.add("modmenu.descriptionTranslation.gardenarsenal",
                "Garden Arsenal is mod made by MultiTeam; Its all about guns and weapons that shoot vegetables and edible stuff.\n\nEverything from v0.1.0 and v0.2.0 is here, on a new minecraft version!\nFresh and new all hand-written code, combined with all the new and remade assets!\n\nTo be apart of our community, join the discord server!");
        translationBuilder.add("modmenu.summaryTranslation.gardenarsenal", "Adds weapons shooting vegetables and edibles.");

        translationBuilder.add(getKey(GardenArsenalPaintingVariants.PAINTING_BLUEPRINT_SNIPER) + ".title", "Sugar cane sniper blueprint");
        translationBuilder.add(getKey(GardenArsenalPaintingVariants.PAINTING_BLUEPRINT_PISTOL) + ".title", "Seed pistol blueprint");
        translationBuilder.add(getKey(GardenArsenalPaintingVariants.PAINTING_BLUEPRINT_BAZOOKA) + ".title", "Potato bazooka blueprint");
        translationBuilder.add(getKey(GardenArsenalPaintingVariants.PAINTING_BLUEPRINT_SHOTGUN) + ".title", "Cocoa bean shotgun blueprint");
        translationBuilder.add(getKey(GardenArsenalPaintingVariants.PAINTING_BLUEPRINT_RIFLE) + ".title", "Carrot rifle blueprint");

        for (ResourceKey<PaintingVariant> key : GardenArsenalPaintingVariants.PAINTINGS) {
            translationBuilder.add(getKey(key) + ".author", "LTA");
        }
    }

    private String getSkinName(Skins skin) {
        return switch (skin) {
            case Default -> "Default";
            case camo_desert -> "Desert-Camouflage";
            case camo_end -> "End-Camouflage";
            case camo_forest -> "Forest-Camouflage";
            case camo_frost -> "Frosted-Camouflage";
            case camo_nether -> "Nether-Camouflage";
            case metallic_gold -> "Gold Metallic";
            case metallic_iron -> "Iron Metallic";
            case metallic_copper -> "Copper Metallic";
            case metallic_netherite -> "Netherite Metallic";
            case seasonal_christmas -> "Christmas";
            case seasonal_halloween -> "Halloween";
            case special_aquatic -> "Aquatic";
            case special_neon -> "Neon";
            case teams_mcabnormals -> "MCAbnormals Branded";
            case teams_multiteam -> "MultiTeam Branded";
            case teams_vampirestudios -> "VampireStudios Branded";
            case special_ectoplasm -> "Ectoplasm";
            case special_nerf -> "Nerf";
            case special_rubik -> "Rubik";
            case exclusive_pistols -> "Pistols Exclusive";
            case special_goat -> "Goat";
        };
    }

    private String getWeaponTooltipKey(RegistrySupplier<Item> item) {
        var key = item.getId();
        return "tooltip." + key.getNamespace() + "." + key.getPath().replace('/', '.') + "_desc";
    }

    private String getSkinKey(Skins skin) {
        return "tooltip.gardenarsenal.skin." + skin.name();
    }

    private String getProfessionKey(RegistrySupplier<VillagerProfession> profession) {
        return "entity.minecraft.villager." + profession.getId().toLanguageKey();
    }

    private String getKey(ResourceKey<PaintingVariant> key) {
        return "painting." + key.location().toLanguageKey();
    }
}
