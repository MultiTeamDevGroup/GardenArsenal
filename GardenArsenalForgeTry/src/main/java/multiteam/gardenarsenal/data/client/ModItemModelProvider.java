package multiteam.gardenarsenal.data.client;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import multiteam.gardenarsenal.GardenArsenalMod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper){
        super(generator, GardenArsenalMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("machine_block", modLoc("block/machine_block"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "iron_rod");
        builder(itemGenerated, "cocoa_beans_shell");

        //skin cards
        builder(itemGenerated, "skin_card_camo_desert");
        builder(itemGenerated, "skin_card_camo_end");
        builder(itemGenerated, "skin_card_camo_forest");
        builder(itemGenerated, "skin_card_camo_frost");
        builder(itemGenerated, "skin_card_camo_nether");
        builder(itemGenerated, "skin_card_metallic_gold");
        builder(itemGenerated, "skin_card_metallic_iron");
        builder(itemGenerated, "skin_card_metallic_netherite");
        builder(itemGenerated, "skin_card_seasonal_christmas");
        builder(itemGenerated, "skin_card_seasonal_halloween");
        builder(itemGenerated, "skin_card_special_aquatic");
        builder(itemGenerated, "skin_card_special_neon");
        builder(itemGenerated, "skin_card_teams_mcabnormals");
        builder(itemGenerated, "skin_card_teams_multiteam");
        builder(itemGenerated, "skin_card_teams_vampirestudios");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/"+name);
    }
}
