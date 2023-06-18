/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.client.gui.hud;

import me.arktikus.frostbite.FrostBite;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.FontStorage;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class FrostBiteHud implements HudRenderCallback {
    private static final Identifier MAIN_PAGE = new Identifier(FrostBite.MOD_ID,
            "textures/gui/main_page.png");

    public static boolean guiStatus = false;

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) {
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        TextRenderer tr = MinecraftClient.getInstance().textRenderer;

        String game_version = client.getGameVersion();
        int fps = client.getCurrentFps();
        String mod_version = FrostBite.MOD_VERSION;
        String mc_version = FrostBite.MC_VERSION;

        if(guiStatus) {
            drawContext.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            drawContext.drawTexture(MAIN_PAGE, x - 128, y / 4, 0, 0, 256, 128, 256, 128);
            drawContext.drawText(tr,"Game Version: " + game_version, x - 112, y / 3 + 30, 1, false);
            drawContext.drawText(tr,"Mod Version: " + mod_version, x - 112, y / 3 + 40, 1, false);
            drawContext.drawText(tr,"MC Version: " + mc_version, x - 112, y / 3 + 50, 1, false);
            drawContext.drawText(tr,"FPS: " + fps, x - 112, y / 3 + 60, 1, false);
            //client.mouse.unlockCursor();
        }
    }
}
