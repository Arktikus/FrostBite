/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.entity.custom;

import me.arktikus.frostbite.entity.ModEntities;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.MoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.ai.pathing.SwimNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

public class SharkEntity extends HostileEntity implements GeoEntity {
        private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    protected WanderAroundGoal wanderGoal;

        public SharkEntity(EntityType<? extends HostileEntity> entityType, World world) {
            super(entityType, world);
            this.experiencePoints = 10;
            this.setPathfindingPenalty(PathNodeType.WATER, 0.0f);
            this.moveControl = new SharkEntity.SharkMoveControl(this);
        }

        public static DefaultAttributeContainer.Builder setAttributes() {
            return AnimalEntity.createMobAttributes()
                    .add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0D)
                    .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2.5f)
                    .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.5f)
                    .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.45f);
        }

        @Override
        protected void initGoals() {
            GoToWalkTargetGoal goToWalkTargetGoal = new GoToWalkTargetGoal(this, 1.0);
            this.wanderGoal = new WanderAroundGoal(this, 1.0, 80);
            this.goalSelector.add(4, goToWalkTargetGoal);
            this.goalSelector.add(6, this.wanderGoal);
            this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
            this.goalSelector.add(7, new LookAtEntityGoal(this, GuardianEntity.class, 12.0f, 0.01f));
            this.goalSelector.add(8, new LookAroundGoal(this));
            this.wanderGoal.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
            goToWalkTargetGoal.setControls(EnumSet.of(Goal.Control.MOVE, Goal.Control.LOOK));
            this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
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

        @Nullable
        public HostileEntity createChild(ServerWorld world, HostileEntity entity) {
            return ModEntities.SHARK.create(world); //TODO ???
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

    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_GUARDIAN_FLOP;
    }

        @Override
        public AnimatableInstanceCache getAnimatableInstanceCache() {
            return cache;
        }
    }
