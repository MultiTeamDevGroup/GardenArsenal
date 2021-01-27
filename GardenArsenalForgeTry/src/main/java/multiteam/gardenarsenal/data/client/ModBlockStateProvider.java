package multiteam.gardenarsenal.data.client;

import multiteam.gardenarsenal.setup.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import multiteam.gardenarsenal.GardenArsenalMod;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, GardenArsenalMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void  registerStatesAndModels() {
        simpleBlock(ModBlocks.MACHINE_BLOCK.get());
    }
}
