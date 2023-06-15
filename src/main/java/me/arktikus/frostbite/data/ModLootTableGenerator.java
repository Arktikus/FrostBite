package me.arktikus.frostbite.data;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.ARKTIRIUM_BLOCK);

        addDrop(ModBlocks.ARKTIRIUM_ORE, oreDrops(ModBlocks.ARKTIRIUM_ORE, ModItems.RAW_ARKTIRIUM));
        addDrop(ModBlocks.DEEPSLATE_ARKTIRIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_ARKTIRIUM_ORE, ModItems.RAW_ARKTIRIUM));

        addDrop(ModBlocks.BLUE_ARCTIC_LOG);
        addDrop(ModBlocks.STRIPPED_BLUE_ARCTIC_LOG);
        addDrop(ModBlocks.BLUE_ARCTIC_WOOD);
        addDrop(ModBlocks.STRIPPED_BLUE_ARCTIC_WOOD);

        addDrop(ModBlocks.BLUE_ARCTIC_PLANKS);
        addDrop(ModBlocks.BLUE_ARCTIC_SAPLING);

        //addDrop(ModBlocks.BLUE_ARCTIC_LEAVES, leavesDrops(ModBlocks.BLUE_ARCTIC_LEAVES, ModBlocks.BLUE_ARCTIC_SAPLING, 0.2f)); //TODO Don't know the difference
        addDrop(ModBlocks.BLUE_ARCTIC_LEAVES, oakLeavesDrops(ModBlocks.BLUE_ARCTIC_LEAVES, ModBlocks.BLUE_ARCTIC_SAPLING, 0.03f)); //TODO Don't know the difference
    }
}
