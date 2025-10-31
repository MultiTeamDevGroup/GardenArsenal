package multiteam.gardenarsenal.fabric.datagen;

import multiteam.gardenarsenal.registries.GardenArsenalItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        tag(ConventionalItemTags.VILLAGER_JOB_SITES).add(
                reverseLookup(GardenArsenalItems.AMMO_CRATE.get()),
                reverseLookup(GardenArsenalItems.WAR_TACTIC_TABLE.get())
        );

        tag(ConventionalItemTags.RODS).add(
                reverseLookup(GardenArsenalItems.IRON_ROD.get())
        );
    }
}
