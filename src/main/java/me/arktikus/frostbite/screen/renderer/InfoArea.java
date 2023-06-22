/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.screen.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.Rect2i;
import net.minecraft.client.gui.DrawContext;


public abstract class InfoArea extends DrawContext {
    protected final Rect2i area;
    protected final VertexConsumerProvider vertexConsumers;
    protected final MinecraftClient client;

    protected InfoArea(MinecraftClient client, VertexConsumerProvider.Immediate vertexConsumerProvider, Rect2i area) {
        super(client, vertexConsumerProvider);
        this.area = area;
        this.vertexConsumers = vertexConsumerProvider;
        this.client = client;
    }

    public abstract void draw(DrawContext context);
}