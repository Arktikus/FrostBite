package me.arktikus.frostbite;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.client.ThirstHudOverlay;
import me.arktikus.frostbite.client.gui.hud.FrostBiteHud;
import me.arktikus.frostbite.entity.ModEntities;
import me.arktikus.frostbite.entity.client.PinguinRenderer;
import me.arktikus.frostbite.entity.client.SharkRenderer;
import me.arktikus.frostbite.entity.client.TigerRenderer;
import me.arktikus.frostbite.event.KeyInputHandler;
import me.arktikus.frostbite.fluid.ModFluids;
import me.arktikus.frostbite.networking.ModPackets;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

public class FrostBiteClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_ARCTIC_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_ARCTIC_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_ARCTIC_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLUE_ARCTIC_TRAPDOOR, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.TIGER, TigerRenderer::new);
        EntityRendererRegistry.register(ModEntities.PINGUIN, PinguinRenderer::new);
        EntityRendererRegistry.register(ModEntities.SHARK, SharkRenderer::new);

        ModPackets.registerS2CPackets();

        //HudRenderCallback.EVENT.register(new ThirstHudOverlay()); - Removed because this was an example
        HudRenderCallback.EVENT.register(new FrostBiteHud());

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_OIL, ModFluids.FLOWING_OIL,
                new SimpleFluidRenderHandler(
                        new Identifier("frostbite:block/oil_still"), //TODO MAYBE ADD OWN TEXTURE
                        new Identifier("frostbite:block/oil_flow"), //TODO MAYBE ADD OWN TEXTURE
                        new Identifier("frostbite:block/oil_overlay"),
                        0xFF383838 //TODO CHANGE VALUE
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_OIL, ModFluids.FLOWING_OIL);

        KeyInputHandler.register();
    }
}
