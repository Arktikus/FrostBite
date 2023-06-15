package me.arktikus.frostbite.entity.client;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.entity.custom.PinguinEntity;
import me.arktikus.frostbite.entity.custom.SharkEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SharkModel extends GeoModel<SharkEntity> {
    @Override
    public Identifier getModelResource(SharkEntity animatable) {
        return new Identifier(FrostBite.MOD_ID, "geo/shark.geo.json");
    }

    @Override
    public Identifier getTextureResource(SharkEntity animatable) {
        return new Identifier(FrostBite.MOD_ID, "textures/entity/shark.png");
    }

    @Override
    public Identifier getAnimationResource(SharkEntity animatable) {
        return new Identifier(FrostBite.MOD_ID, "animations/shark.animation.json");
    }

    @Override
    public void setCustomAnimations(SharkEntity animatable, long instanceId, AnimationState<SharkEntity> animationState) { //TODO MAYBE REMOVE
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }

}