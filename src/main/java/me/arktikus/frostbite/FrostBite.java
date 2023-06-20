/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.block.ModFlammableBlockRegistry;
import me.arktikus.frostbite.block.entity.ModBlockEntities;
import me.arktikus.frostbite.entity.ModEntities;
import me.arktikus.frostbite.entity.custom.PinguinEntity;
import me.arktikus.frostbite.entity.custom.SharkEntity;
import me.arktikus.frostbite.entity.custom.TigerEntity;
import me.arktikus.frostbite.item.ModItemGroup;
import me.arktikus.frostbite.item.ModItems;
import me.arktikus.frostbite.networking.ModPackets;
import me.arktikus.frostbite.painting.ModPaintings;
import me.arktikus.frostbite.recipe.ModRecipes;
import me.arktikus.frostbite.screen.ModScreenHandlers;
import me.arktikus.frostbite.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrostBite implements ModInitializer {
	public static final String MOD_ID = "frostbite";

	public static final String MOD_VERSION = "0.0.2";
	public static final String MC_VERSION = "1.20.1";

    public static final Logger LOGGER = LoggerFactory.getLogger("frostbite");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		ModFlammableBlockRegistry.registerFlammableBlocks();
		StrippableBlockRegistry.register(ModBlocks.BLUE_ARCTIC_LOG, ModBlocks.STRIPPED_BLUE_ARCTIC_LOG); //TRANSFER TO OWN CLASS
		StrippableBlockRegistry.register(ModBlocks.BLUE_ARCTIC_WOOD, ModBlocks.STRIPPED_BLUE_ARCTIC_WOOD); //TRANSFER TO OWN CLASS

		ModPaintings.registerPaintings();

		FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.PINGUIN, PinguinEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.SHARK, SharkEntity.setAttributes());

		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerAllScreenHandlers();

		ModRecipes.registerRecipes();

		ModPackets.registerC2SPackets();
		ModPackets.registerS2CPackets();

		//ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler()); - Removed because this was an example
		//ClientPlayConnectionEvents.JOIN.register(new PlayerJoinHandler()); - Removed because this was an example

		LOGGER.info("Initializing FrostBite Mod!");
	}
}