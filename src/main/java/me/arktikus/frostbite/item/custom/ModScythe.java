/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class ModScythe extends HoeItem {
    public ModScythe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        float yaw = attacker.getYaw();
        float pitch = attacker.getPitch();

        if(yaw >= -40 && yaw <= 40) {
            target.takeKnockback(1, 0, -5);
        } else if(yaw >= 40 && yaw <= 135) {
            target.takeKnockback(1, 5, 0);
        } else if(yaw >= 135 && yaw <= 179.9 || yaw >= -179.9 && yaw <= -135) {
            target.takeKnockback(1, 0, 5);
        } else if(yaw >= -135 && yaw <= -45) {
            target.takeKnockback(1, -5, 0);
        }

        //attacker.getWorld().addParticle(ParticleTypes.FLAME, target.getX(), target.getY(), target.getZ(), 1, 1, 1);
        attacker.getServer().getWorld(attacker.getWorld().getRegistryKey()).spawnParticles(ParticleTypes.FLAME, target.getX(), target.getY(), target.getZ(), 10, 1, 1, 1, 1);
        attacker.getServer().getWorld(attacker.getWorld().getRegistryKey()).playSound(null, target.getBlockPos(), SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.PLAYERS, 0.7f, 0.4f);

        return true;
    }
}
