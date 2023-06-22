/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.block.entity;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntities {
    public static BlockEntityType<ArktiriumInfusingBlockEntity> ARKTIRIUM_INFUSING_STATION;

    public static void registerBlockEntities() {
        ARKTIRIUM_INFUSING_STATION = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(FrostBite.MOD_ID, "arktirium_infusing_station"),
                FabricBlockEntityTypeBuilder.create(ArktiriumInfusingBlockEntity::new,
                        ModBlocks.ARKTIRIUM_INFUSING_STATION).build(null));

        EnergyStorage.SIDED.registerForBlockEntity(((blockEntity, direction) -> blockEntity.energyStorage), ARKTIRIUM_INFUSING_STATION); //TODO - Maybe wrong place? MIDDLE MOUSE.
    }
}
