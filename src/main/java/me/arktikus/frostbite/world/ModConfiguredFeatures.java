/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.world;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_ARCTIC_KEY = registerKey("blue_arctic");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ARKTIRIUM_ORE_KEY = registerKey("arktirium_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldArktiriumOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ARKTIRIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_ARKTIRIUM_ORE.getDefaultState()));

        register(context, BLUE_ARCTIC_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BLUE_ARCTIC_LOG),
                new StraightTrunkPlacer(5, 6, 3), // ChatGPT said: The 5 (represented by i) corresponds to the base height of the tree trunk. It determines the number of blocks the trunk will extend upwards from the ground. The 6 (represented by j) is the height randomization value. It specifies the maximum additional height that can be randomly added to the base height of the trunk. In this case, it means the trunk's final height can vary by up to 6 blocks more than the base height. The 3 (represented by k) is the tapering value, which determines how much the tree trunk narrows as it extends upwards. A higher value will result in a more gradual tapering effect.
                BlockStateProvider.of(ModBlocks.BLUE_ARCTIC_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 4), //ConstantIntProvider.create(2): This parameter likely determines the radius or spread of the foliage blobs. A higher value would result in larger and more spread-out foliage clusters, while a lower value would lead to smaller and more compact foliage clusters. ConstantIntProvider.create(0): This parameter could represent an offset or additional randomness applied to the foliage placement. A non-zero value would introduce some random variation in the positioning of the foliage within the specified range.
                new TwoLayersFeatureSize(1, 0, 2)).build()); //The first parameter 1: This parameter likely represents the base height or size of the tree feature. It determines the minimum number of layers or blocks the tree will have in height. The second parameter 0: This parameter could indicate an additional randomization or variability in the height of the tree feature. A non-zero value would introduce some random variation to the height, allowing the tree to generate with a slightly different height each time. The third parameter 2: This parameter may represent the radius or spread of the tree feature. It determines the extent of the tree's canopy or foliage clusters horizontally. A higher value would result in a wider or more spread-out canopy, while a lower value would lead to a more compact canopy.

        register(context, ARKTIRIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldArktiriumOres, 4)); //ROUGH CHUNK SIZE
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(FrostBite.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
