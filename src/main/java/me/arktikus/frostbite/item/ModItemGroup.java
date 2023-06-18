/*
 * Copyright (C) 2023 Sören Wedig - All Rights Reserved
 */

package me.arktikus.frostbite.item;

import me.arktikus.frostbite.FrostBite;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final RegistryKey<ItemGroup> ARKTIRIUM = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(FrostBite.MOD_ID, "arktirium"));

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, ARKTIRIUM, FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModItems.ARKTIRIUM))
                .displayName(Text.translatable("itemgroup.arktirium"))
                .build());
    }
}
