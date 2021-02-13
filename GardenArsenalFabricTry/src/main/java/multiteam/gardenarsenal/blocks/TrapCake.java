package multiteam.gardenarsenal.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class TrapCake extends CakeBlock {
    public TrapCake(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            world.createExplosion(null, pos.getX(), pos.getY(), pos.getZ(), 4, Explosion.DestructionType.DESTROY);
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }
}
