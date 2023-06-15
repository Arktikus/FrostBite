package me.arktikus.frostbite.client;

import com.mojang.blaze3d.systems.RenderSystem;
import me.arktikus.frostbite.FrostBite;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class ThirstHudOverlay implements HudRenderCallback {
    private static final Identifier FILLED_THIRST = new Identifier(FrostBite.MOD_ID,
            "textures/thirst/filled_thirst.png");
    private static final Identifier EMPTY_THIRST = new Identifier(FrostBite.MOD_ID,
            "textures/thirst/empty_thirst.png");

    private static final Identifier matrixStack = new Identifier(FrostBite.MOD_ID);

    @Override
    public void onHudRender(DrawContext drawContext, float tickDelta) { //TODO - BROKEN BECAUSE OF CHANGES. HERE SHOULD BE MatrixStick matrixStack.
        int x = 0;
        int y = 0;
        MinecraftClient client = MinecraftClient.getInstance();

        if(client != null) {
            int width = client.getWindow().getScaledWidth();
            int height = client.getWindow().getScaledHeight();

            x = width / 2;
            y = height;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_THIRST);
        for(int i = 0; i < 10; i++) { // TODO - THERE SHOULD BE DrawableHelper.drawTexture | https://www.youtube.com/watch?v=5oEjsFBoGAk | Minute 2.14
            drawContext.drawTexture(matrixStack, x - 94 + (i * 9), y - 54, 0, 0, 12, 12, 12, 12);
        }

    }
}
