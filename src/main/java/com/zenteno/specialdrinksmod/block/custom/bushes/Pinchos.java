package com.zenteno.specialdrinksmod.block.custom.bushes;

import com.zenteno.specialdrinksmod.block.custom.bushes.BushBlocks.BushBlockPinchos;
import com.zenteno.specialdrinksmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ForgeHooks;

import java.util.Random;

public class Pinchos extends BushBlockPinchos implements IGrowable {
    public static final IntegerProperty AGE;
    private static final VoxelShape BUSHLING_SHAPE;
    private static final VoxelShape GROWING_SHAPE;


    public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return state.matchesBlock(Blocks.NETHERRACK);
    }


    public Pinchos(Properties p_i49971_1_) {
        super(p_i49971_1_);
        this.setDefaultState((BlockState)((BlockState)this.stateContainer.getBaseState()).with(AGE, 0));
    }

    public ItemStack getItem(IBlockReader p_185473_1_, BlockPos p_185473_2_, BlockState p_185473_3_) {
        return new ItemStack(ModItems.BURBUJAVISION.get());
    }

    public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        if ((Integer)p_220053_1_.get(AGE) == 0) {
            return BUSHLING_SHAPE;
        } else {
            return (Integer)p_220053_1_.get(AGE) < 3 ? GROWING_SHAPE : super.getShape(p_220053_1_, p_220053_2_, p_220053_3_, p_220053_4_);
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

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
        VoxelShape lvt_5_1_ = this.getShape(p_180655_1_, p_180655_2_, p_180655_3_, ISelectionContext.dummy());
        Vector3d lvt_6_1_ = lvt_5_1_.getBoundingBox().getCenter();
        double lvt_7_1_ = (double)p_180655_3_.getX() + lvt_6_1_.x;
        double lvt_9_1_ = (double)p_180655_3_.getZ() + lvt_6_1_.z;

        for(int lvt_11_1_ = 0; lvt_11_1_ < 3; ++lvt_11_1_) {
            if (p_180655_4_.nextBoolean()) {
                p_180655_2_.addParticle(ParticleTypes.SMOKE, lvt_7_1_ + p_180655_4_.nextDouble() / 5.0, (double)p_180655_3_.getY() + (0.5 - p_180655_4_.nextDouble()), lvt_9_1_ + p_180655_4_.nextDouble() / 5.0, 0.0, 0.0, 0.0);
            }
        }

    }


    public void onEntityCollision(BlockState p_196262_1_, World p_196262_2_, BlockPos p_196262_3_, Entity p_196262_4_) {
        if (p_196262_4_ instanceof LivingEntity && p_196262_4_.getType() != EntityType.FOX && p_196262_4_.getType() != EntityType.BEE) {
            p_196262_4_.setMotionMultiplier(p_196262_1_, new Vector3d(0.800000011920929D, 0.75D, 0.800000011920929D));
            if (!p_196262_2_.isRemote && (Integer)p_196262_1_.get(AGE) > 0 && (p_196262_4_.lastTickPosX != p_196262_4_.getPosX() || p_196262_4_.lastTickPosZ != p_196262_4_.getPosZ())) {
                double d0 = Math.abs(p_196262_4_.getPosX() - p_196262_4_.lastTickPosX);
                double d1 = Math.abs(p_196262_4_.getPosZ() - p_196262_4_.lastTickPosZ);
                if (d0 >= 0.003000000026077032D || d1 >= 0.003000000026077032D) {
                    p_196262_4_.attackEntityFrom(DamageSource.GENERIC, 5.0F);
                }
            }
        }

    }





    protected void fillStateContainer(Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(new Property[]{AGE});
    }

    public boolean canGrow(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return (Integer)p_176473_3_.get(AGE) < 3;
    }

    public boolean canUseBonemeal(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, BlockState p_180670_4_) {
        return true;
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
}
