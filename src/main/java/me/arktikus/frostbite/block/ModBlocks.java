package me.arktikus.frostbite.block;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.block.custom.*;
import me.arktikus.frostbite.item.ModItemGroup;
import me.arktikus.frostbite.sound.ModSounds;
import me.arktikus.frostbite.world.tree.BlueArcticSaplingGenerator;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    //public static final Block CITRINE_BLOCK = registerBlock("arktirium_block",
            //new Block(FabricBlockSettings.copyOf(Material.METAL).strength(4.0f).requiresTool()), ModItemGroup.CITRINE);   | Sadly outdated in the newest VERISON.
    public static final Block ARKTIRIUM_BLOCK = registerBlock("arktirium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(ModSounds.ANIMATED_BLOCK_SOUNDS).strength(4.0f).requiresTool().solid()), ModItemGroup.ARKTIRIUM);

    public static final Block ARKTIRIUM_ORE = registerBlock("arktirium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).strength(4.0f).requiresTool().solid(),
            UniformIntProvider.create(2, 6)), ModItemGroup.ARKTIRIUM);

    public static final Block DEEPSLATE_ARKTIRIUM_ORE = registerBlock("deepslate_arktirium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.create().mapColor(MapColor.IRON_GRAY).strength(6.0f).requiresTool().solid(),
                    UniformIntProvider.create(3, 7)), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_LOG = registerBlock("blue_arctic_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(2.0f).requiresTool()), ModItemGroup.ARKTIRIUM);
    public static final Block BLUE_ARCTIC_WOOD = registerBlock("blue_arctic_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(2.0f).requiresTool()), ModItemGroup.ARKTIRIUM);
    public static final Block STRIPPED_BLUE_ARCTIC_LOG = registerBlock("stripped_blue_arctic_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_LOG).strength(2.0f).requiresTool()), ModItemGroup.ARKTIRIUM);
    public static final Block STRIPPED_BLUE_ARCTIC_WOOD = registerBlock("stripped_blue_arctic_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(2.0f).requiresTool()), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_PLANKS = registerBlock("blue_arctic_planks",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(2.0f).requiresTool()), ModItemGroup.ARKTIRIUM);
    public static final Block BLUE_ARCTIC_LEAVES = registerBlock("blue_arctic_leaves",
            new LeavesBlock(FabricBlockSettings.copyOf(Blocks.OAK_LEAVES).strength(0.3f)), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_SAPLING = registerBlock("blue_arctic_sapling",
            new SaplingBlock(new BlueArcticSaplingGenerator(), FabricBlockSettings.copyOf(Blocks.OAK_SAPLING).strength(4.0f).requiresTool()), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_STAIRS = registerBlock("blue_arctic_stairs",
            new ModStairsBlock(ModBlocks.BLUE_ARCTIC_PLANKS.getDefaultState(),
                    FabricBlockSettings.copyOf(ModBlocks.BLUE_ARCTIC_PLANKS).strength(1.0f).requiresTool()), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_SLAB = registerBlock("blue_arctic_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.BLUE_ARCTIC_PLANKS).strength(1.0f).requiresTool()), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_DOOR = registerBlock("blue_arctic_door",
            new ModDoorBlock(FabricBlockSettings.copyOf(ModBlocks.BLUE_ARCTIC_PLANKS).strength(1.0f).requiresTool().nonOpaque(), BlockSetType.OAK), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_TRAPDOOR = registerBlock("blue_arctic_trapdoor",
            new ModTrapdoorBlock(FabricBlockSettings.copyOf(ModBlocks.BLUE_ARCTIC_PLANKS).strength(1.0f).requiresTool().nonOpaque() ,BlockSetType.OAK), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_BUTTON = registerBlock("blue_arctic_button",
            new ModButtonBlock(FabricBlockSettings.copyOf(ModBlocks.BLUE_ARCTIC_PLANKS).strength(1.0f).requiresTool().noCollision() ,BlockSetType.OAK, 60, false), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_PRESSURE_PLATE = registerBlock("blue_arctic_pressure_plate",
            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(ModBlocks.BLUE_ARCTIC_PLANKS).strength(1.0f).requiresTool() ,BlockSetType.OAK), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_FENCE = registerBlock("blue_arctic_fence",
            new FenceBlock(FabricBlockSettings.copyOf(ModBlocks.BLUE_ARCTIC_PLANKS).strength(1.0f).requiresTool()), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_FENCE_GATE = registerBlock("blue_arctic_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(ModBlocks.BLUE_ARCTIC_PLANKS).strength(1.0f).requiresTool(), WoodType.SPRUCE), ModItemGroup.ARKTIRIUM);

    public static final Block BLUE_ARCTIC_WALL = registerBlock("blue_arctic_wall",
            new WallBlock(FabricBlockSettings.copyOf(ModBlocks.BLUE_ARCTIC_PLANKS).strength(1.0f).requiresTool()), ModItemGroup.ARKTIRIUM);

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

    public static void addBlocksToItemGroup() {
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, ModBlocks.ARKTIRIUM_BLOCK);
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, ModBlocks.BLUE_ARCTIC_LOG);
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, ModBlocks.BLUE_ARCTIC_WOOD);
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, ModBlocks.STRIPPED_BLUE_ARCTIC_LOG);
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, ModBlocks.STRIPPED_BLUE_ARCTIC_WOOD);
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, ModBlocks.BLUE_ARCTIC_PLANKS);

        addToItemGroup(ItemGroups.NATURAL, ModBlocks.ARKTIRIUM_ORE);
        addToItemGroup(ItemGroups.NATURAL, ModBlocks.DEEPSLATE_ARKTIRIUM_ORE);
        addToItemGroup(ItemGroups.NATURAL, ModBlocks.BLUE_ARCTIC_LEAVES);
        addToItemGroup(ItemGroups.NATURAL, ModBlocks.BLUE_ARCTIC_SAPLING);

    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Block block) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
    }

    public static void registerModBlocks() {
        FrostBite.LOGGER.info("Registering Mod Blocks for " + FrostBite.MOD_ID);

        addBlocksToItemGroup();
    }
}
