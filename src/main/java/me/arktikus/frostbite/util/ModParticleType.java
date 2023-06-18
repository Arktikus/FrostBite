package me.arktikus.frostbite.util;

import com.mojang.serialization.Codec;
import net.minecraft.particle.ParticleEffect;

public abstract class ModParticleType<T extends ParticleEffect> {
    private final boolean alwaysShow;
    private final ParticleEffect.Factory<T> parametersFactory;

    /**
     * @param alwaysShow whether this particle type should appear regardless of {@linkplain net.minecraft.client.option.GameOptions#particles particle mode}
     */
    protected ModParticleType(boolean alwaysShow, ParticleEffect.Factory<T> parametersFactory) {
        this.alwaysShow = alwaysShow;
        this.parametersFactory = parametersFactory;
    }

    public boolean shouldAlwaysSpawn() {
        return this.alwaysShow;
    }

    public ParticleEffect.Factory<T> getParametersFactory() {
        return this.parametersFactory;
    }

    public abstract Codec<T> getCodec();
}
