/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

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

/*
 * This file contains code derived from or based on code
 * that is licensed under the MIT License (MIT).
 *
 * MIT License
 *
 * Copyright (c) 2021 GeckoThePecko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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
                    .dimensions(EntityDimensions.fixed(1.15f, 1f)).build());

}
