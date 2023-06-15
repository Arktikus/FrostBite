package me.arktikus.frostbite.item;

import me.arktikus.frostbite.FrostBite;
import me.arktikus.frostbite.entity.ModEntities;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item ARKTIRIUM = registerItem("arktirium",
            new Item(new FabricItemSettings()));
    public static final Item RAW_ARKTIRIUM = registerItem("raw_arktirium",
            new Item(new FabricItemSettings()));

    public static final Item TIGER_SPAWN_EGG = registerItem("tiger_spawn_egg",
            new SpawnEggItem(ModEntities.TIGER, 0xD57E36, 0x1D0D00,
                    new FabricItemSettings()));

    public static final Item PINGUIN_SPAWN_EGG = registerItem("pinguin_spawn_egg",
            new SpawnEggItem(ModEntities.PINGUIN, 0x091238, 0x000000,
                    new FabricItemSettings()));

        public static final Item SHARK_SPAWN_EGG = registerItem("shark_spawn_egg",
            new SpawnEggItem(ModEntities.SHARK, 0x096238, 0x000532,
                    new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(FrostBite.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(ItemGroups.INGREDIENTS, ARKTIRIUM);
        addToItemGroup(ItemGroups.INGREDIENTS, RAW_ARKTIRIUM);

        addToItemGroup(ModItemGroup.ARKTIRIUM, ARKTIRIUM);
        addToItemGroup(ModItemGroup.ARKTIRIUM, RAW_ARKTIRIUM);

        addToItemGroup(ModItemGroup.ARKTIRIUM, TIGER_SPAWN_EGG);
        addToItemGroup(ModItemGroup.ARKTIRIUM, PINGUIN_SPAWN_EGG);
        addToItemGroup(ModItemGroup.ARKTIRIUM, SHARK_SPAWN_EGG);
    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        FrostBite.LOGGER.info("Registering Mod Items for " + FrostBite.MOD_ID);

        addItemsToItemGroup();
    }
}
