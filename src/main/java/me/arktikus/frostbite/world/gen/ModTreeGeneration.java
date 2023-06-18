/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.world.gen;

import me.arktikus.frostbite.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.GROVE, BiomeKeys.SNOWY_TAIGA, BiomeKeys.ICE_SPIKES),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_ARCTIC_PLACED_KEY);
    }
}
