package me.arktikus.frostbite.util;

import com.mojang.serialization.Codec;
import net.minecraft.particle.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.Function;

public class ModParticleTypes {
    //public static final DefaultParticleType DRIPPING_LAVA = ModParticleTypes.register("dripping_lava", false);
    //public static final DefaultParticleType FALLING_LAVA = ModParticleTypes.register("falling_lava", false);
    //public static final DefaultParticleType LANDING_LAVA = ModParticleTypes.register("landing_lava", false);
    public static final ModDefaultParticleType DRIPPING_OIL = ModParticleTypes.register("dripping_oil", false);
    //public static final DefaultParticleType FALLING_WATER = ModParticleTypes.register("falling_water", false);

    private static ModDefaultParticleType register(String name, boolean alwaysShow) {
        return Registry.register(Registries.PARTICLE_TYPE, name, new ModDefaultParticleType(alwaysShow));
    }

    private static <T extends ParticleEffect> ParticleType<T> register(String name, boolean alwaysShow, ParticleEffect.Factory<T> factory, final Function<ParticleType<T>, Codec<T>> codecGetter) {
        return Registry.register(Registries.PARTICLE_TYPE, name, new ParticleType<T>(alwaysShow, factory){

            @Override
            public Codec<T> getCodec() {
                return (Codec)codecGetter.apply(this);
            }
        });
    }
}
