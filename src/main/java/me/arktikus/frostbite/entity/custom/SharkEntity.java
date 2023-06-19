/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.entity.custom;

import me.arktikus.frostbite.entity.ModEntities;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;
import java.util.function.Predicate;

public class SharkEntity extends AnimalEntity implements GeoEntity {
        private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    protected WanderAroundGoal wanderGoal;
    public static final int MAX_AIR = 800;

        public SharkEntity(EntityType<? extends AnimalEntity> entityType, World world) {
            //super(entityType, world);
            super((EntityType<? extends AnimalEntity>)entityType, world);
            this.experiencePoints = 10;
            this.setPathfindingPenalty(PathNodeType.WATER, 10.0f);
            this.moveControl = new SharkEntity.SharkMoveControl(this);
            this.setAir(this.getMaxAir());
        }

        public static DefaultAttributeContainer.Builder setAttributes() {
            return AnimalEntity.createMobAttributes()
                    .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                    .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.5f)
                    .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.5f)
                    .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35f);
        }

        @Override
        protected void initGoals() {
            //GoToWalkTargetGoal goToWalkTargetGoal = new GoToWalkTargetGoal(this, 1.0);
            //this.wanderGoal = new WanderAroundGoal(this, 1.0, 80);
            this.goalSelector.add(1, new SharkEntity.AttackGoal(this));
            //this.goalSelector.add(2, goToWalkTargetGoal);
            //this.goalSelector.add(3, this.wanderGoal);
            this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
            this.goalSelector.add(5, new LookAroundGoal(this));
            this.goalSelector.add(4, new WanderAroundGoal(this, 1.0f));
            //this.wanderGoal.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
            //goToWalkTargetGoal.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
            //this.targetSelector.add(2, new SharkEntity.TargetGoal<PlayerEntity>(this, PlayerEntity.class));
            this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
            this.targetSelector.add(2, new ActiveTargetGoal<>(this, MerchantEntity.class, true));
            this.targetSelector.add(1, new ActiveTargetGoal<>(this, FishEntity.class, true));
        }

    @Override
    protected EntityNavigation createNavigation(World world) {
        return new SwimNavigation(this, world);
    }

    @Override
    public boolean canBreatheInWater() {
        return true;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.AQUATIC;
    }

        @Override
        public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
            controllerRegistrar.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
        }

        private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
            if(geoAnimatableAnimationState.isMoving()) {
                geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.shark.swim", Animation.LoopType.LOOP));
                return PlayState.CONTINUE;
            }

            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.shark.idle", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

    static class SharkMoveControl
            extends MoveControl {
        private final SharkEntity shark;

        public SharkMoveControl(SharkEntity shark) {
            super(shark);
            this.shark = shark;
        }
    }

    static class TargetGoal<T extends LivingEntity>
            extends ActiveTargetGoal<T> {
        public TargetGoal(SharkEntity shark, Class<T> targetEntityClass) {
            super((MobEntity)shark, targetEntityClass, true);
        }

        @Override
        public boolean canStart() {
            return super.canStart();
        }
    }

    static class AttackGoal
            extends MeleeAttackGoal {
        public AttackGoal(SharkEntity shark) {
            super(shark, 1.0, true);
        }

        @Override
        public boolean canStart() {
            return super.canStart() && !this.mob.hasPassengers();
        }

        @Override
        public boolean shouldContinue() {
            return super.shouldContinue();
        }

        @Override
        protected double getSquaredMaxAttackDistance(LivingEntity entity) {
            return 2.0f + entity.getWidth();
        }
    }

    @Override
    public int getMinAmbientSoundDelay() {
        return 160;
    } //TODO TEMP SOUNDS

    @Override
    protected SoundEvent getAmbientSound() {
        return this.isInsideWaterOrBubbleColumn() ? SoundEvents.ENTITY_GUARDIAN_AMBIENT : SoundEvents.ENTITY_GUARDIAN_AMBIENT_LAND;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return this.isInsideWaterOrBubbleColumn() ? SoundEvents.ENTITY_GUARDIAN_HURT : SoundEvents.ENTITY_GUARDIAN_HURT_LAND;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return this.isInsideWaterOrBubbleColumn() ? SoundEvents.ENTITY_GUARDIAN_DEATH : SoundEvents.ENTITY_GUARDIAN_DEATH_LAND;
    }


    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        if (world.getFluidState(pos).isIn(FluidTags.WATER)) {
            return 10.0f + world.getPhototaxisFavor(pos);
        }
        return super.getPathfindingFavor(pos, world);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
    }

    @Override
    public void travel(Vec3d movementInput) {
        if (this.isLogicalSideForUpdatingMovement() && this.isTouchingWater()) {
            this.updateVelocity(0.1f, movementInput);
            this.move(MovementType.SELF, this.getVelocity());
            this.setVelocity(this.getVelocity().multiply(0.9));
            if (this.getTarget() == null) {
                this.setVelocity(this.getVelocity().add(0.0, -0.005, 0.0));
            }
        } else {
            super.travel(movementInput);
        }
    }

    static class SharkTargetPredicate
            implements Predicate<LivingEntity> {
        private final SharkEntity owner;

        public SharkTargetPredicate(SharkEntity owner) {
            this.owner = owner;
        }

        @Override
        public boolean test(@Nullable LivingEntity livingEntity) {
            return (livingEntity instanceof PlayerEntity || livingEntity instanceof SquidEntity || livingEntity instanceof AxolotlEntity) && livingEntity.squaredDistanceTo(this.owner) > 9.0;
        }
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_GUARDIAN_FLOP;
    }

        @Override
        public AnimatableInstanceCache getAnimatableInstanceCache() {
            return cache;
        }
    }