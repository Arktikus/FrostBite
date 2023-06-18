package me.arktikus.frostbite.entity.custom;

import me.arktikus.frostbite.entity.ModEntities;
import me.arktikus.frostbite.entity.ModEntityType;
import me.arktikus.frostbite.sound.ModSounds;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class PinguinEntity extends AnimalEntity implements GeoEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public PinguinEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new FleeEntityGoal<PolarBearEntity>(this, PolarBearEntity.class, 8.0f, 1.6, 1.4));
        this.goalSelector.add(3, new EscapeDangerGoal(this, 1.0));
        this.goalSelector.add(4, new AnimalMateGoal(this, 1.0));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 0.75f, 1));

        this.goalSelector.add(7, new PinguinEntity.FollowParentGoal(this, 1.25));

        this.goalSelector.add(8, new LookAroundGoal(this));
    }

    /*
    @Override
    @Nullable
    public PinguinEntity createChild(ServerWorld serverWorld, PassiveEntity passiveEntity) {
        PinguinEntity pinguinEntity = ModEntityType.PINGUIN.create(serverWorld);
        return pinguinEntity;
    } */

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.PINGUIN.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if(geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.pinguin.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.pinguin.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    class FollowParentGoal
            extends net.minecraft.entity.ai.goal.FollowParentGoal {
        private final PinguinEntity pinguin;

        public FollowParentGoal(PinguinEntity pinguin, double speed) {
            super(pinguin, speed);
            this.pinguin = pinguin;
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.ENTITY_PINGUIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.ENTITY_PINGUIN_DEATH;
    }

    /*@Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_COW_AMBIENT;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15f, 1.0f);
    }

    @Override
    protected float getSoundVolume() {
        return 0.4f;
    }

    */

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
