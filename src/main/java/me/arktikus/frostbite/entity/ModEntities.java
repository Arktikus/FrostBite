package me.arktikus.frostbite.entity;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.entity.custom.PinguinEntity;
import me.arktikus.frostbite.entity.custom.SharkEntity;
import me.arktikus.frostbite.entity.custom.TigerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {

    public static final EntityType<TigerEntity> TIGER = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FrostBite.MOD_ID, "tiger"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TigerEntity::new)
                .dimensions(EntityDimensions.fixed(1.5f, 1.75f)).build());

    public static final EntityType<PinguinEntity> PINGUIN = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FrostBite.MOD_ID, "pinguin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PinguinEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 1.25f)).build());

        public static final EntityType<SharkEntity> SHARK = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(FrostBite.MOD_ID, "shark"), //TODO ??? - Correct?
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SharkEntity::new)
                    .dimensions(EntityDimensions.fixed(2f, 1f)).build());

}
