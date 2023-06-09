package me.arktikus.frostbite;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.block.ModFlammableBlockRegistry;
import me.arktikus.frostbite.item.ModItemGroup;
import me.arktikus.frostbite.item.ModItems;
import me.arktikus.frostbite.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FrostBite implements ModInitializer {
	public static final String MOD_ID = "frostbite";
    public static final Logger LOGGER = LoggerFactory.getLogger("frostbite");

	@Override
	public void onInitialize() {
		ModItemGroup.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		ModFlammableBlockRegistry.registerFlammableBlocks();
		StrippableBlockRegistry.register(ModBlocks.RED_MAPLE_LOG, ModBlocks.STRIPPED_RED_MAPLE_LOG); //TRANSFER TO OWN CLASS
		StrippableBlockRegistry.register(ModBlocks.RED_MAPLE_WOOD, ModBlocks.STRIPPED_RED_MAPLE_WOOD); //TRANSFER TO OWN CLASS

		LOGGER.info("Initializing FrostBite Mod!");
	}
}