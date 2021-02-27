package multiteam.gardenarsenal.setup;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class SkinItemPropertyGetter implements IItemPropertyGetter
{
	@Override
	public float call(ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity entity)
	{
		if (stack.getTag() == null)
			return 0;
		String skin = stack.getTag().getString("skinType");
		switch (skin)
		{
			case "Default":
			default:
				return 0;
			case "camo_desert":
				return 1;
			case "camo_end":
				return 2;
			case "camo_forest":
				return 3;
			case "camo_frost":
				return 4;
			case "camo_nether":
				return 5;
			case "metallic_gold":
				return 6;
			case "metallic_iron":
				return 7;
			case "metallic_netherite":
				return 8;
			case "seasonal_christmas":
				return 9;
			case "seasonal_halloween":
				return 10;
			case "special_aquatic":
				return 11;
			case "special_neon":
				return 12;
			case "teams_mcabnormals":
				return 13;
			case "teams_multiteam":
				return 14;
			case "teams_vampirestudios":
				return 15;
			case "special_ectoplasm":
				return 16;
			case "special_nerf":
				return 17;
			case "special_rubik":
				return 18;
			// continue
		}
	}
}
