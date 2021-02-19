package multiteam.gardenarsenal.setup.entitys.villager;
import com.google.common.collect.ImmutableSet;
import multiteam.gardenarsenal.setup.ModBlocks;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.Items;
import net.minecraft.util.SoundEvents;
import net.minecraft.village.PointOfInterestType;

public class GardenSoldierCommanderProfession extends VillagerProfession {

    public GardenSoldierCommanderProfession( PointOfInterestType poiType) {
        super("garden_soldier_commander", poiType, ImmutableSet.of(Items.GOLD_INGOT), ImmutableSet.of(ModBlocks.MACHINE_BLOCK.get()), SoundEvents.BLOCK_METAL_PLACE);
    }

}
