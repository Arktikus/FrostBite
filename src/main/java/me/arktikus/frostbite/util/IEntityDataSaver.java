/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.util;

import net.minecraft.nbt.NbtCompound;

public interface IEntityDataSaver {
    NbtCompound getPersistentData();
}
