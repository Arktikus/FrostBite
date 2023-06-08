package me.arktikus.frostbite.block;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    //public static final Block CITRINE_BLOCK = registerBlock("citrine_block",
            //new Block(FabricBlockSettings.copyOf(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.CITRINE);   | Sadly outdated in the newest VERISON.
    public static final Block CITRINE_BLOCK = registerBlock("citrine_block",
            new Block(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).strength(4.0f).requiresTool().solid()), ModItemGroup.CITRINE);

    public static final Block CITRINE_ORE = registerBlock("citrine_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).strength(4.0f).requiresTool().solid(),
            UniformIntProvider.create(2, 6)), ModItemGroup.CITRINE);

    public static final Block CITRINE_DEEPSLATE_ORE = registerBlock("citrine_deepslate_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).strength(6.0f).requiresTool().solid(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.CITRINE);

    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(FrostBite.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(FrostBite.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));

        return item;
    }

    public static void registerModBlocks() {
        FrostBite.LOGGER.info("Registering Mod Blocks for " + FrostBite.MOD_ID);
    }
}
