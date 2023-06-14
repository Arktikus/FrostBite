package me.arktikus.frostbite;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.entity.ModEntities;
import me.arktikus.frostbite.entity.client.PinguinRenderer;
import me.arktikus.frostbite.entity.client.TigerRenderer;
import me.arktikus.frostbite.event.KeyInputHandler;
import me.arktikus.frostbite.networking.ModPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class FrostBiteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MAPLE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RED_MAPLE_SAPLING, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
        EntityRendererRegistry.register(ModEntities.PINGUIN, PinguinRenderer::new);

        ModPackets.registerS2CPackets();

        KeyInputHandler.register();
    }
}
