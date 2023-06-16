package me.arktikus.frostbite.data;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ARKTIRIUM_BLOCK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ARKTIRIUM_ORE);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DEEPSLATE_ARKTIRIUM_ORE);

        blockStateModelGenerator.registerLog(ModBlocks.BLUE_ARCTIC_LOG).log(ModBlocks.BLUE_ARCTIC_LOG).wood(ModBlocks.BLUE_ARCTIC_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_BLUE_ARCTIC_LOG).log(ModBlocks.STRIPPED_BLUE_ARCTIC_LOG).wood(ModBlocks.STRIPPED_BLUE_ARCTIC_WOOD);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLUE_ARCTIC_PLANKS).stairs(ModBlocks.BLUE_ARCTIC_STAIRS).slab(ModBlocks.BLUE_ARCTIC_SLAB);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BLUE_ARCTIC_LEAVES);

        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.BLUE_ARCTIC_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerDoor(ModBlocks.BLUE_ARCTIC_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BLUE_ARCTIC_TRAPDOOR);

        blockStateModelGenerator.registerParentedItemModel(ModItems.TIGER_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.PINGUIN_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        blockStateModelGenerator.registerParentedItemModel(ModItems.SHARK_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ARKTIRIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ARKTIRIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_ARCTIC_STICK, Models.GENERATED);

    }
}
