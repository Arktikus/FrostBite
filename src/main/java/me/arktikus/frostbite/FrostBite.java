package me.arktikus.frostbite;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.item.ModItemGroup;
import me.arktikus.frostbite.item.ModItems;
import net.fabricmc.api.ModInitializer;

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

		LOGGER.info("Initializing FrostBite Mod!");
	}
}