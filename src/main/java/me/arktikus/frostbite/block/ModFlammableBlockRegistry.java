/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class ModFlammableBlockRegistry {
    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(ModBlocks.BLUE_ARCTIC_LOG, 5, 5);
        registry.add(ModBlocks.BLUE_ARCTIC_WOOD, 5, 5);
        registry.add(ModBlocks.STRIPPED_BLUE_ARCTIC_LOG, 5, 5);
        registry.add(ModBlocks.STRIPPED_BLUE_ARCTIC_WOOD, 5, 5);

        registry.add(ModBlocks.BLUE_ARCTIC_LEAVES, 30, 60);
        registry.add(ModBlocks.BLUE_ARCTIC_PLANKS, 5, 20);

    }
}
