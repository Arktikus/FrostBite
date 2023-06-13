package me.arktikus.frostbite.entity.client;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.entity.custom.PinguinEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PinguinRenderer extends GeoEntityRenderer<PinguinEntity> {
    public PinguinRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PinguinModel());
    }

    @Override
    public Identifier getTextureLocation(PinguinEntity animatable) {
        return new Identifier(FrostBite.MOD_ID, "textures/entity/pinguin.png");
    }

    @Override
    public void render(PinguinEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
