package me.arktikus.frostbite.world.gen;

import me.arktikus.frostbite.entity.ModEntities;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntityGeneration {
    public static void addSpawns() {
    BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SAVANNA), SpawnGroup.CREATURE,
            ModEntities.TIGER, 35, 1, 2);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SNOWY_TAIGA, BiomeKeys.ICE_SPIKES), SpawnGroup.CREATURE,
                ModEntities.PINGUIN, 35, 3, 7);

        SpawnRestriction.register(ModEntities.TIGER, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);

        //SpawnRestriction.register(ModEntities.PINGUIN, SpawnRestriction.Location.ON_GROUND,
                //Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
