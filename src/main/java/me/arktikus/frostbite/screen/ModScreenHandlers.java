/*
 * Copyright (C) 2023 Sören Wedig
 */

package me.arktikus.frostbite.screen;

import me.arktikus.frostbite.FrostBite;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<ArktiriumInfusingScreenHandler> ARKTIRIUM_INFUSING_SCREEN_HANDLER =
            new ExtendedScreenHandlerType<>(ArktiriumInfusingScreenHandler::new);

    public static void registerAllScreenHandlers() {
        Registry.register(Registries.SCREEN_HANDLER, new Identifier(FrostBite.MOD_ID, "arktirium_infusing"),
                ARKTIRIUM_INFUSING_SCREEN_HANDLER);
    }
}
