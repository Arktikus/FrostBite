/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.networking.packet;

import me.arktikus.frostbite.util.IEntityDataSaver;
import me.arktikus.frostbite.util.ThirstData;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

public class DrinkingC2SPacket {
    private static final String MESSAGE_DRINKING_WATER = "message.frostbite.drank_water";
    private static final String MESSAGE_NO_WATER_NEARBY = "message.frostbite.no_water";

    public static void receive(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender) {
        // Everything here happens ONLY on the server!
        ServerWorld serverWorld = player.getServerWorld();
        if(isWaterAroundThem(player, serverWorld, 2)) {
            player.sendMessage(Text.translatable(MESSAGE_DRINKING_WATER).fillStyle(Style.EMPTY.withColor(Formatting.AQUA)));
            serverWorld.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,
                    0.5f, serverWorld.random.nextFloat() * 0.1F + 0.9F);

            ThirstData.addThirst(((IEntityDataSaver) player), 1);

            player.sendMessage(Text.literal("Thirst: " + ((IEntityDataSaver) player).getPersistentData().getInt("thirst"))
                    .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)));


        } else {
            player.sendMessage(Text.translatable(MESSAGE_NO_WATER_NEARBY).fillStyle(Style.EMPTY.withColor(Formatting.RED)));

            player.sendMessage(Text.literal("Thirst: " + ((IEntityDataSaver) player).getPersistentData().getInt("thirst"))
                    .fillStyle(Style.EMPTY.withColor(Formatting.DARK_AQUA)));

            ThirstData.syncThirst(((IEntityDataSaver) player).getPersistentData().getInt("thirst"), player);
        }
    }

    private static boolean isWaterAroundThem(ServerPlayerEntity player, ServerWorld serverWorld, int size) {
        return BlockPos.stream(player.getBoundingBox().expand(size))
                .map(serverWorld::getBlockState).filter(state -> state.isOf(Blocks.WATER)).toArray().length > 0;
    }
}
