/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.event;

import me.arktikus.frostbite.client.gui.hud.FrostBiteHud;
import me.arktikus.frostbite.networking.ModPackets;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_FROSTBITE = "key.category.frostbite";
    public static final String KEY_DRINK_WATER = "key.frostbite.drink_water";

    public static final String KEY_OPEN_GUI = "key.frostbite.opengui";

    public static KeyBinding drinkingKey;
    public static KeyBinding openGUIKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            /*if(drinkingKey.wasPressed()) {
                // This happens when key GOT pressed.
                //client.player.sendMessage(Text.translatable("Hello, you pressed the Key!"));
                //ClientPlayNetworking.send(ModPackets.EXAMPLE_ID, PacketByteBufs.create());
                ClientPlayNetworking.send(ModPackets.DRINKING_ID, PacketByteBufs.create());
            } Removed because this was an example */

            if(openGUIKey.wasPressed()) {
                if(!FrostBiteHud.guiStatus) {
                    client.player.sendMessage(Text.translatable("Opening FrostBite GUI..."));
                    FrostBiteHud.guiStatus = true;
                } else {
                    client.player.sendMessage(Text.translatable("Closing FrostBite GUI..."));
                    FrostBiteHud.guiStatus = false;
                    client.mouse.lockCursor();
                }
            }
        });
    }

    public static void register() {
        /* drinkingKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_DRINK_WATER,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                KEY_CATEGORY_FROSTBITE
        )); Removed because this was an example */

        openGUIKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_OPEN_GUI,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                KEY_CATEGORY_FROSTBITE
        ));

        registerKeyInputs();
    }
}
