/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.recipe;

import me.arktikus.frostbite.FrostBite;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(FrostBite.MOD_ID, ArktiriumInfusingRecipe.Serializer.ID),
                ArktiriumInfusingRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(FrostBite.MOD_ID, ArktiriumInfusingRecipe.Type.ID),
                ArktiriumInfusingRecipe.Type.INSTANCE);

    }
}
