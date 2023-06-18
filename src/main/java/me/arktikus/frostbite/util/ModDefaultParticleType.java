/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.util;

/*
 * Decompiled with CFR 0.2.0 (FabricMC d28b102d).
 */

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import net.minecraft.client.option.GameOptions;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.particle.DefaultParticleType;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;

public class ModDefaultParticleType extends ParticleType<ModDefaultParticleType> implements ParticleEffect {
    private static final ParticleEffect.Factory<ModDefaultParticleType> PARAMETER_FACTORY = new ParticleEffect.Factory<ModDefaultParticleType>() {
        public ModDefaultParticleType read(ParticleType<ModDefaultParticleType> particleType, StringReader stringReader) {
            return (ModDefaultParticleType)particleType;
        }

        public ModDefaultParticleType read(ParticleType<ModDefaultParticleType> particleType, PacketByteBuf packetByteBuf) {
            return (ModDefaultParticleType)particleType;
        }
    };
    private final Codec<ModDefaultParticleType> codec = Codec.unit(this::getType);

    protected ModDefaultParticleType(boolean alwaysShow) {
        super(alwaysShow, PARAMETER_FACTORY);
    }

    public ModDefaultParticleType getType() {
        return this;
    }

    public Codec<ModDefaultParticleType> getCodec() {
        return this.codec;
    }

    public void write(PacketByteBuf buf) {
    }

    public String asString() {
        return Registries.PARTICLE_TYPE.getId(this).toString();
    }
}