package multiteam.gardenarsenal.blocks;

import multiteam.gardenarsenal.registries.GardenArsenalBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BarricadeBlock extends Block {

    private static final VoxelShape SHAPE_SURVIVALIST_NORTH = Shapes.or( box(0.0d, 0.0d, 5.0d, 16.0d, 16.0d, 7.0d), box(0.0d, 0.0d, 7.0d, 16.0d, 5.0d, 12.0d));
    private static final VoxelShape SHAPE_SURVIVALIST_WEST = Shapes.or( box(0.0d, 0.0d, 5.0d, 16.0d, 16.0d, 7.0d), box(0.0d, 0.0d, 7.0d, 16.0d, 5.0d, 12.0d));
    private static final VoxelShape SHAPE_SURVIVALIST_SOUTH = Shapes.or( box(0.0d, 0.0d, 5.0d, 16.0d, 16.0d, 7.0d), box(0.0d, 0.0d, 7.0d, 16.0d, 5.0d, 12.0d));
    private static final VoxelShape SHAPE_SURVIVALIST_EAST = Shapes.or( box(0.0d, 0.0d, 5.0d, 16.0d, 16.0d, 7.0d), box(0.0d, 0.0d, 7.0d, 16.0d, 5.0d, 12.0d));
    private static final VoxelShape SHAPE_MAKER = box(0d, 0d, 5d, 16d, 16d, 11d);
    private static final VoxelShape SHAPE_MAKER_SIDEWAYS = box(5d, 0d, 0d, 11d, 16d, 16d);
    private static final VoxelShape SHAPE_INDUSTRIAL = Shapes.or( box(0.0d, 0.0d, 3.0d, 16.0d, 2.0d, 13.0d), box(0.0d, 2.0d, 4.0d, 16.0d, 14.0d, 12.0d), box(0.0d, 14.0d, 3.0d, 16.0d, 16.0d, 13.0d));
    private static final VoxelShape SHAPE_INDUSTRIAL_SIDEWAYS = Shapes.or( box(3.0d, 0.0d, 0.0d, 13.0d, 2.0d, 16.0d), box(4.0d, 2.0d, 0.0d, 12.0d, 14.0d, 16.0d), box(3.0d, 14.0d, 0.0d, 13.0d, 16.0d, 16.0d));

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public BarricadeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return this.defaultBlockState().setValue(FACING, blockPlaceContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
        BlockState thisBlock = blockGetter.getBlockState(pos);
        /**if (thisBlock.getBlock() == GardenArsenalBlocks.BARRICADE_SURVIVALIST.get()) {
            return switch (thisBlock.getValue(FACING)) {
                case EAST -> SHAPE_SURVIVALIST_EAST;
                case DOWN, UP, NORTH -> SHAPE_SURVIVALIST_NORTH;
                case SOUTH -> SHAPE_SURVIVALIST_SOUTH;
                case WEST -> SHAPE_SURVIVALIST_WEST;
            };
        } else if (thisBlock.getBlock() == GardenArsenalBlocks.BARRICADE_MAKER.get()) {
            return switch (thisBlock.getValue(FACING)) {
                case NORTH, SOUTH, UP, DOWN -> SHAPE_MAKER;
                case WEST, EAST -> SHAPE_MAKER_SIDEWAYS;
            };
        } if (thisBlock.getBlock() == GardenArsenalBlocks.BARRICADE_INDUSTRIAL.get()) {
            return switch (thisBlock.getValue(FACING)) {
                case NORTH, SOUTH, UP, DOWN -> SHAPE_INDUSTRIAL;
                case WEST, EAST -> SHAPE_INDUSTRIAL_SIDEWAYS;
            };
        }**/
        return SHAPE_INDUSTRIAL;
    }

}
