package me.arktikus.frostbite;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.block.ModFlammableBlockRegistry;
import me.arktikus.frostbite.entity.ModEntities;
import me.arktikus.frostbite.entity.custom.PinguinEntity;
import me.arktikus.frostbite.entity.custom.TigerEntity;
import me.arktikus.frostbite.event.KeyInputHandler;
import me.arktikus.frostbite.event.PlayerTickHandler;
import me.arktikus.frostbite.item.ModItemGroup;
import me.arktikus.frostbite.item.ModItems;
import me.arktikus.frostbite.networking.ModPackets;
import me.arktikus.frostbite.painting.ModPaintings;
import me.arktikus.frostbite.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
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

		ModPaintings.registerPaintings();

		FabricDefaultAttributeRegistry.register(ModEntities.TIGER, TigerEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.PINGUIN, PinguinEntity.setAttributes());

		ModPackets.registerC2SPackets();

		ServerTickEvents.START_SERVER_TICK.register(new PlayerTickHandler());

		LOGGER.info("Initializing FrostBite Mod!");
	}
}