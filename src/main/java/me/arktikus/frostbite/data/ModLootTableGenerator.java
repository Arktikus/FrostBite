/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.data;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableGenerator extends FabricBlockLootTableProvider {
    //private static final LootCondition.Builder WITH_SILK_TOUCH_OR_SHEARS = WITH_SHEARS.or(WITH_SILK_TOUCH);
    public ModLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    /*
    public LootTable.Builder stickDrops(Block leaves, Item drop, float ... chance) {
        return BlockLootTableGenerator.dropsWithSilkTouchOrShears(leaves, ((LeafEntry.Builder)this.addSurvivesExplosionCondition(leaves, ItemEntry.builder(drop))).conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, chance))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f)).conditionally(WITH_SILK_TOUCH_OR_SHEARS).with((LootPoolEntry.Builder<?>)((LeafEntry.Builder)this.applyExplosionDecay(leaves, ItemEntry.builder(ModItems.BLUE_ARCTIC_STICK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f))))).conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, chance))));
    } */

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

        addDrop(ModBlocks.BLUE_ARCTIC_LEAVES, leavesDrops(ModBlocks.BLUE_ARCTIC_LEAVES, ModBlocks.BLUE_ARCTIC_SAPLING, 0.02f));
        //addDrop(ModBlocks.BLUE_ARCTIC_LEAVES, stickDrops(ModBlocks.BLUE_ARCTIC_LEAVES, ModItems.BLUE_ARCTIC_STICK, 0.01f));

        //BlockLootTableGenerator.dropsWithSilkTouch(ModBlocks.BLUE_ARCTIC_LEAVES, ((LeafEntry.Builder)this.addSurvivesExplosionCondition(ModBlocks.BLUE_ARCTIC_LEAVES, ItemEntry.builder(ModItems.BLUE_ARCTIC_STICK))).conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.01f))).pool(LootPool.builder().rolls(ConstantLootNumberProvider.create(1.0f)).conditionally(WITH_SILK_TOUCH_OR_SHEARS).with((LootPoolEntry.Builder<?>)((LeafEntry.Builder)this.applyExplosionDecay(ModBlocks.BLUE_ARCTIC_LEAVES, ItemEntry.builder(ModItems.BLUE_ARCTIC_STICK).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)))).conditionally(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.01f)))));

        //addDrop(ModBlocks.BLUE_ARCTIC_LEAVES, oakLeavesDrops(ModBlocks.BLUE_ARCTIC_LEAVES, ModBlocks.BLUE_ARCTIC_SAPLING, 0.03f));
    }
}
