package com.zenteno.specialdrinksmod.world.gen;

import com.google.common.collect.ImmutableList;
import com.zenteno.specialdrinksmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> CEREZO =
            register("cerezo", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.CEREZO.get().getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.HOJASCEREZO.get().getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                            new StraightTrunkPlacer(4, 3, 3),
                            new TwoLayerFeature(1, 0, 1)).setIgnoreVines().build())));


    public static final ConfiguredFeature<?, ?> PLANTABURBUJA_CONFIG = Feature.FLOWER.withConfiguration((
                    new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.PLANTABURBUJA.get().getDefaultState()),
                            SimpleBlockPlacer.PLACER)).tries(1).build())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(1);



    public static final ConfiguredFeature<?, ?> FLORORO_CONFIG = Feature.FLOWER.withConfiguration((
                    new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ModBlocks.FLORORO.get().getDefaultState()),
                            SimpleBlockPlacer.PLACER)).tries(1).build())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(1);

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key,
                                                                                 ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }
}