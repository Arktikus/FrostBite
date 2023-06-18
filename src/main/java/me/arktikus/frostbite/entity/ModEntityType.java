/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.entity;

import me.arktikus.frostbite.entity.custom.PinguinEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntityType {
    public static final EntityType<PinguinEntity> PINGUIN = ModEntityType.register("pinguin", EntityType.Builder.create(PinguinEntity::new, SpawnGroup.CREATURE).setDimensions(0.75f, 1.25f));

    private static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> type) {
        return Registry.register(Registries.ENTITY_TYPE, id, type.build(id));
    }
}
