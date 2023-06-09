package me.arktikus.frostbite;

import me.arktikus.frostbite.data.ModLootTableGenerator;
import me.arktikus.frostbite.data.ModModelProvider;
import me.arktikus.frostbite.data.ModRecipeGenerator;
import me.arktikus.frostbite.data.ModWorldGenerator;
import me.arktikus.frostbite.world.ModConfiguredFeatures;
import me.arktikus.frostbite.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class FrostBiteDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModLootTableGenerator::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeGenerator::new);
		pack.addProvider(ModWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}
}
