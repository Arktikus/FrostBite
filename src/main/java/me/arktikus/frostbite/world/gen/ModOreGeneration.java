/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.world.gen;

import me.arktikus.frostbite.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.ARKTIRIUM_ORE_PLACED_KEY);
    }
}
