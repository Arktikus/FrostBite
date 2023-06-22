/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.networking;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.networking.packet.DrinkingC2SPacket;
import me.arktikus.frostbite.networking.packet.EnergySyncS2CPacket;
import me.arktikus.frostbite.networking.packet.ExampleC2SPacket;
import me.arktikus.frostbite.networking.packet.ThirstSyncDataS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModPackets {
    public static final Identifier DRINKING_ID = new Identifier(FrostBite.MOD_ID, "drinking");
    public static final Identifier THIRST_SYNC_ID = new Identifier(FrostBite.MOD_ID, "thirst_sync");
    public static final Identifier FROSTBITE_GUI_ID = new Identifier(FrostBite.MOD_ID, "frostbite_gui");

    public static final Identifier ENERGY_SYNC = new Identifier(FrostBite.MOD_ID, "energy_sync");

    public static final Identifier EXAMPLE_ID = new Identifier(FrostBite.MOD_ID, "example");

    public static void registerC2SPackets() {
        //ServerPlayNetworking.registerGlobalReceiver(EXAMPLE_ID, ExampleC2SPacket::receive); - Removed because this was an example
        //ServerPlayNetworking.registerGlobalReceiver(DRINKING_ID, DrinkingC2SPacket::receive); - Removed because this was an example
    }

    public static void registerS2CPackets() {
        //ClientPlayNetworking.registerGlobalReceiver(THIRST_SYNC_ID, ThirstSyncDataS2CPacket::receive); - Removed because this was an example
        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
    }

}
