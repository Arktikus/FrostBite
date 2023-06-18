/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.fluid;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.fluid.custom.OilFluid;
import me.arktikus.frostbite.item.ModItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static FlowableFluid STILL_OIL;
    public static FlowableFluid FLOWING_OIL;
    public static Block OIL_BLOCK;
    public static Item OIL_BUCKET;

    public static void register() {
        STILL_OIL = Registry.register(Registries.FLUID,
                new Identifier(FrostBite.MOD_ID, "oil"), new OilFluid.Still());
        FLOWING_OIL = Registry.register(Registries.FLUID,
                new Identifier(FrostBite.MOD_ID, "flowing_oil"), new OilFluid.Flowing());

        OIL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(FrostBite.MOD_ID, "oil_block"),
                new FluidBlock(ModFluids.STILL_OIL, FabricBlockSettings.copyOf(Blocks.WATER)){ });
        OIL_BUCKET = Registry.register(Registries.ITEM, new Identifier(FrostBite.MOD_ID, "oil_bucket"),
                new BucketItem(ModFluids.STILL_OIL, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

        addItemsToItemGroup();
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ModItemGroup.ARKTIRIUM, OIL_BUCKET);

        //addToItemGroup(ItemGroups.NATURAL, ModFluids.OIL_BLOCK);
    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Block block) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
    }
}
