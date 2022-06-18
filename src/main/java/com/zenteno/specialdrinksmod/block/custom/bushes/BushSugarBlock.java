
package com.zenteno.specialdrinksmod.block.custom.bushes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class BushSugarBlock extends Block implements IPlantable {
    public static final IntegerProperty AGE;
    private static final VoxelShape BUSHLING_SHAPE;
    private static final VoxelShape GROWING_SHAPE;

    public BushSugarBlock(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(AGE, 0));
    }


    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        if (p_220053_1_.get(AGE) == 0) {
            return BUSHLING_SHAPE;
        } else {
            return p_220053_1_.get(AGE) < 3 ? GROWING_SHAPE : super.getShape(p_220053_1_, p_220053_2_, p_220053_3_, p_220053_4_);
        }
    }

    public boolean ticksRandomly(BlockState p_149653_1_) {
        return (Integer)p_149653_1_.get(AGE) < 3;
    }

    public void randomTick(BlockState p_225542_1_, ServerWorld p_225542_2_, BlockPos p_225542_3_, Random p_225542_4_) {
        int i = (Integer)p_225542_1_.get(AGE);
        if (i < 3 && p_225542_2_.getLightSubtracted(p_225542_3_.up(), 0) >= 9 && ForgeHooks.onCropsGrowPre(p_225542_2_, p_225542_3_, p_225542_1_, p_225542_4_.nextInt(5) == 0)) {
            p_225542_2_.setBlockState(p_225542_3_, (BlockState)p_225542_1_.with(AGE, i + 1), 2);
            ForgeHooks.onCropsGrowPost(p_225542_2_, p_225542_3_, p_225542_1_);
        }

    }

    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockState blockstate = worldIn.getBlockState(pos.down());
        return blockstate.matchesBlock(Blocks.SAND);
    }

    public ActionResultType onBlockActivated(BlockState p_225533_1_, World p_225533_2_, BlockPos p_225533_3_, PlayerEntity p_225533_4_, Hand p_225533_5_, BlockRayTraceResult p_225533_6_) {
        int i = (Integer)p_225533_1_.get(AGE);
        boolean flag = i == 3;
        if (!flag) {
            return ActionResultType.FAIL;
        } else if (i > 1) {
            int j = 0 + p_225533_2_.rand.nextInt(1);
            spawnAsEntity(p_225533_2_, p_225533_3_, new ItemStack(Items.SUGAR_CANE.getItem(), j + (flag ? 2 : 0)));
            p_225533_2_.playSound((PlayerEntity)null, p_225533_3_, SoundEvents.BLOCK_GRASS_HIT, SoundCategory.BLOCKS, 1.0F, 0.8F + p_225533_2_.rand.nextFloat() * 0.4F);
            p_225533_2_.setBlockState(p_225533_3_, (BlockState)p_225533_1_.with(AGE, 1), 2);
            return ActionResultType.func_233537_a_(p_225533_2_.isRemote);
        } else {
            return super.onBlockActivated(p_225533_1_, p_225533_2_, p_225533_3_, p_225533_4_, p_225533_5_, p_225533_6_);
        }
    }

    protected void fillStateContainer(Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(new Property[]{AGE});
    }

    public boolean canGrow(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return (Integer)p_176473_3_.get(AGE) < 3;
    }

    public boolean canUseBonemeal(World world, Random random, BlockPos blockPos, BlockState blockState) {
        return false;
    }

    public void grow(ServerWorld p_225535_1_, Random p_225535_2_, BlockPos p_225535_3_, BlockState p_225535_4_) {
        int i = Math.min(3, (Integer)p_225535_4_.get(AGE) + 1);
        p_225535_1_.setBlockState(p_225535_3_, (BlockState)p_225535_4_.with(AGE, i), 2);
    }

    static {
        AGE = BlockStateProperties.AGE_0_3;
        BUSHLING_SHAPE = Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D);
        GROWING_SHAPE = Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        return getDefaultState();
    }
}
