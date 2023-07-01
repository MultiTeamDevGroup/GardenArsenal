package multiteam.gardenarsenal.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TrapCake extends CakeBlock {
    public TrapCake(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand interactionHand, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            level.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 4, Level.ExplosionInteraction.NONE);
        }
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
}
