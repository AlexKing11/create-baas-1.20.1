package net.serric.createbaas.fluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.serric.createbaas.block.ModBlocks;

import java.util.Optional;

public abstract class AcidFluid extends BaseFluid {

    @Override
    public Fluid getStill() {
        return ModFluids.STILL_ACID;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_ACID;
    }


    @Override
    public Item getBucketItem() {
        return Items.AIR;
    }

    @Override
    public void randomDisplayTick(World world, BlockPos pos, FluidState state, Random random) {
        BlockPos blockPos = pos.up();
        if (world.getBlockState(blockPos).isAir() && !world.getBlockState(blockPos).isOpaqueFullCube(world, blockPos)) {
            if (random.nextInt(4) == 0) {
                double d = (double)pos.getX() + random.nextDouble();
                double e = (double)pos.getY() + 0.8;
                double f = (double)pos.getZ() + random.nextDouble();
                world.addParticle(ParticleTypes.BUBBLE, d, e, f, 0.0, 0.3, 0.0);
                world.playSound(d, e, f, SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP, SoundCategory.BLOCKS, 0.65F + random.nextFloat() * 0.2F, 0.4F + random.nextFloat() * 0.3F, false);
            }
        }
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        this.playExtinguishEvent(world, pos);
    }

    private void playExtinguishEvent(WorldAccess world, BlockPos pos) {
        world.syncWorldEvent(WorldEvents.LAVA_EXTINGUISHED, pos, 0);
    }

    @Override
    public Optional<SoundEvent> getBucketFillSound() {
        return Optional.of(SoundEvents.ENTITY_ITEM_BREAK);
    }

    @Override
    public int getTickRate(WorldView worldView) {
        return 10;
    }



    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        // getBlockStateLevel converts the LEVEL_1_8 of the fluid state to the LEVEL_15 the fluid block uses
        return ModBlocks.ACID.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    public static class Flowing extends AcidFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends AcidFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }

}
