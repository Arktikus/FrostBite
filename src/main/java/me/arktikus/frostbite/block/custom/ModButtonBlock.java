/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.block.custom;

import net.minecraft.block.BlockSetType;
import net.minecraft.block.ButtonBlock;

public class ModButtonBlock extends ButtonBlock {
    public ModButtonBlock(Settings settings, BlockSetType blockSetType, int pressTicks, boolean wooden) {
        super(settings, blockSetType, pressTicks, wooden);
    }
}
