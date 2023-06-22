/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class ModHammer extends PickaxeItem {
    public ModHammer(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        int blockX = pos.getX();
        int blockY = pos.getY();
        int blockZ = pos.getZ();

        Vec3i offset = switch (((BlockHitResult) miner.raycast(4, 0, false)).getSide().getAxis()) {
            case X -> new Vec3i(0, 1, 1);
            case Y -> new Vec3i(1, 0, 1);
            case Z -> new Vec3i(1, 1, 0);
        };

        BlockPos.iterateOutwards(pos, offset.getX(), offset.getY(), offset.getZ()).forEach(e -> {
            if (isSuitableFor(world.getBlockState(e))) {
                world.breakBlock(e, true);

                ItemStack item = miner.getStackInHand(Hand.MAIN_HAND);
                item.setDamage(item.getDamage() + 1);
            }
        });
        return true;
    }
}
