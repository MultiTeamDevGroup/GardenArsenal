package multiteam.gardenarsenal.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class TrapCake extends CakeBlock {
    private static final MapCodec<CakeBlock> CODEC = simpleCodec(TrapCake::new);
    public TrapCake(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            level.explode(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(), 4, Level.ExplosionInteraction.NONE);
        }
        return super.useWithoutItem(blockState, level, blockPos, player, blockHitResult);
    }

    @Override
    public MapCodec<CakeBlock> codec() {
        return CODEC;
    }
}
