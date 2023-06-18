/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
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

        /*
        float yaw = miner.getYaw();
        float pitch = miner.getPitch();

        int damage = miner.getActiveItem().getDamage(); //TODO TEST FIRST
        miner.getActiveItem().setDamage(damage + 8); //TODO TEST FIRST

        if(yaw > -45 && yaw < 45) {
            BlockPos pos1 = new BlockPos(blockX,blockY + 1,blockZ);
            BlockPos pos2 = new BlockPos(blockX,blockY -1,blockZ);
            BlockPos pos3 = new BlockPos(blockX + 1,blockY,blockZ);
            BlockPos pos4 = new BlockPos(blockX - 1,blockY,blockZ);
            BlockPos pos5 = new BlockPos(blockX + 1,blockY + 1,blockZ);
            BlockPos pos6 = new BlockPos(blockX - 1,blockY -1,blockZ);
            BlockPos pos7 = new BlockPos(blockX - 1,blockY +1 ,blockZ);
            BlockPos pos8 = new BlockPos(blockX + 1,blockY - 1,blockZ);

                world.breakBlock(pos1, true);
                world.breakBlock(pos2, true);
                world.breakBlock(pos3, true);
                world.breakBlock(pos4, true);
                world.breakBlock(pos5, true);
                world.breakBlock(pos6, true);
                world.breakBlock(pos7, true);
                world.breakBlock(pos8, true);
        } else if(yaw > 45  && yaw < 135 && pitch < 45 && pitch > -45) {
            BlockPos pos1 = new BlockPos(blockX,blockY + 1,blockZ);
            BlockPos pos2 = new BlockPos(blockX,blockY -1,blockZ);
            BlockPos pos3 = new BlockPos(blockX,blockY,blockZ + 1);
            BlockPos pos4 = new BlockPos(blockX,blockY,blockZ - 1);
            BlockPos pos5 = new BlockPos(blockX,blockY + 1,blockZ + 1);
            BlockPos pos6 = new BlockPos(blockX,blockY -1,blockZ - 1);
            BlockPos pos7 = new BlockPos(blockX,blockY +1 ,blockZ - 1);
            BlockPos pos8 = new BlockPos(blockX,blockY - 1,blockZ + 1);

                world.breakBlock(pos1, true);
                world.breakBlock(pos2, true);
                world.breakBlock(pos3, true);
                world.breakBlock(pos4, true);
                world.breakBlock(pos5, true);
                world.breakBlock(pos6, true);
                world.breakBlock(pos7, true);
                world.breakBlock(pos8, true);
        } else if(yaw > 135 && yaw < 179.9 && pitch < 45 && pitch > -45 || yaw > -179.9 && yaw < -135 && pitch < 45 && pitch > -45) {
            BlockPos pos1 = new BlockPos(blockX,blockY + 1,blockZ);
            BlockPos pos2 = new BlockPos(blockX,blockY -1,blockZ);
            BlockPos pos3 = new BlockPos(blockX + 1,blockY,blockZ);
            BlockPos pos4 = new BlockPos(blockX - 1,blockY,blockZ);
            BlockPos pos5 = new BlockPos(blockX + 1,blockY + 1,blockZ);
            BlockPos pos6 = new BlockPos(blockX - 1,blockY -1,blockZ);
            BlockPos pos7 = new BlockPos(blockX - 1,blockY +1 ,blockZ);
            BlockPos pos8 = new BlockPos(blockX + 1,blockY - 1,blockZ);

                world.breakBlock(pos1, true);
                world.breakBlock(pos2, true);
                world.breakBlock(pos3, true);
                world.breakBlock(pos4, true);
                world.breakBlock(pos5, true);
                world.breakBlock(pos6, true);
                world.breakBlock(pos7, true);
                world.breakBlock(pos8, true);
        } else if(yaw > -135 && yaw < -45 && pitch < 45 && pitch > -45) {
            BlockPos pos1 = new BlockPos(blockX,blockY + 1,blockZ);
            BlockPos pos2 = new BlockPos(blockX,blockY -1,blockZ);
            BlockPos pos3 = new BlockPos(blockX,blockY,blockZ + 1);
            BlockPos pos4 = new BlockPos(blockX,blockY,blockZ - 1);
            BlockPos pos5 = new BlockPos(blockX,blockY + 1,blockZ + 1);
            BlockPos pos6 = new BlockPos(blockX,blockY -1,blockZ - 1);
            BlockPos pos7 = new BlockPos(blockX,blockY +1 ,blockZ - 1);
            BlockPos pos8 = new BlockPos(blockX,blockY - 1,blockZ + 1);

                world.breakBlock(pos1, true);
                world.breakBlock(pos2, true);
                world.breakBlock(pos3, true);
                world.breakBlock(pos4, true);
                world.breakBlock(pos5, true);
                world.breakBlock(pos6, true);
                world.breakBlock(pos7, true);
                world.breakBlock(pos8, true);
            } else if(pitch > 45) {
                BlockPos pos1 = new BlockPos(blockX + 1,blockY,blockZ);
                BlockPos pos2 = new BlockPos(blockX - 1,blockY,blockZ);
                BlockPos pos3 = new BlockPos(blockX,blockY,blockZ + 1);
                BlockPos pos4 = new BlockPos(blockX,blockY,blockZ - 1);
                BlockPos pos5 = new BlockPos(blockX + 1,blockY,blockZ + 1);
                BlockPos pos6 = new BlockPos(blockX - 1,blockY,blockZ - 1);
                BlockPos pos7 = new BlockPos(blockX + 1,blockY,blockZ - 1);
                BlockPos pos8 = new BlockPos(blockX - 1,blockY,blockZ + 1);

                    world.breakBlock(pos1, true);
                    world.breakBlock(pos2, true);
                    world.breakBlock(pos3, true);
                    world.breakBlock(pos4, true);
                    world.breakBlock(pos5, true);
                    world.breakBlock(pos6, true);
                    world.breakBlock(pos7, true);
                    world.breakBlock(pos8, true);
            } else if(pitch < -45) {
                BlockPos pos1 = new BlockPos(blockX + 1,blockY,blockZ);
                BlockPos pos2 = new BlockPos(blockX - 1,blockY,blockZ);
                BlockPos pos3 = new BlockPos(blockX,blockY,blockZ + 1);
                BlockPos pos4 = new BlockPos(blockX,blockY,blockZ - 1);
                BlockPos pos5 = new BlockPos(blockX + 1,blockY,blockZ + 1);
                BlockPos pos6 = new BlockPos(blockX - 1,blockY,blockZ - 1);
                BlockPos pos7 = new BlockPos(blockX + 1,blockY,blockZ - 1);
                BlockPos pos8 = new BlockPos(blockX - 1,blockY,blockZ + 1);

                    world.breakBlock(pos1, true);
                    world.breakBlock(pos2, true);
                    world.breakBlock(pos3, true);
                    world.breakBlock(pos4, true);
                    world.breakBlock(pos5, true);
                    world.breakBlock(pos6, true);
                    world.breakBlock(pos7, true);
                    world.breakBlock(pos8, true);
            } */

        //WORKING SOLUTION!
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
                //miner.sendMessage(Text.literal("Item: " + item + " Damage: " + item.getDamage())); //DEBUG
            }
        });  //EXTREMELY GOOD!

        //getSurroundingBlocks(pos).forEach(e -> world.breakBlock(e, true));

        //return super.postMine(stack, world, state, pos, miner);
        return true;
    }
}
