/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.block.custom;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.PressurePlateBlock;

public class ModPressurePlateBlock extends PressurePlateBlock {
    public ModPressurePlateBlock(ActivationRule type, Settings settings, BlockSetType blockSetType) {
        super(type, settings, blockSetType);
    }
}
