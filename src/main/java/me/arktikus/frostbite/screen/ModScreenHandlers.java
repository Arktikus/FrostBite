/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.screen;

import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlers {
    public static ScreenHandlerType<ArktiriumInfusingScreenHandler> ARKTIRIUM_INFUSING_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        ARKTIRIUM_INFUSING_SCREEN_HANDLER = new ScreenHandlerType<>(ArktiriumInfusingScreenHandler::new, FeatureSet.empty()); //TODO - SECOND PARAMETER IS NEW!
    }
}
