package me.arktikus.frostbite.data;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.item.ModItems;
import me.arktikus.frostbite.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import software.bernie.shadowed.eliotlash.mclib.math.functions.classic.Mod;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModItems.RAW_ARKTIRIUM), RecipeCategory.MISC, ModItems.ARKTIRIUM,
                0.7f, 200, "citrine");
        offerBlasting(exporter, List.of(ModItems.RAW_ARKTIRIUM), RecipeCategory.MISC, ModItems.ARKTIRIUM,
                0.7f, 100, "citrine");

        //TODO - Further Testing needed

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.BLUE_ARCTIC_PLANKS, 4)
                        .input(ModTags.Items.BLUE_ARCTIC_LOGS)
                                .group("planks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_ARCTIC_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ARCTIC_LOG))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_ARCTIC_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ARCTIC_WOOD))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_BLUE_ARCTIC_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_BLUE_ARCTIC_LOG))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.STRIPPED_BLUE_ARCTIC_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.STRIPPED_BLUE_ARCTIC_WOOD))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_ARCTIC_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ARCTIC_PLANKS))
                        .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModBlocks.BLUE_ARCTIC_PLANKS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLUE_ARCTIC_STICK, 4)
                        .pattern("#")
                        .pattern("#")
                .input('#', ModBlocks.BLUE_ARCTIC_PLANKS)
                                .group("sticks")
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_ARCTIC_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ARCTIC_LOG))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_ARCTIC_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ARCTIC_WOOD))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_ARCTIC_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ARCTIC_PLANKS))
                        .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(ModItems.BLUE_ARCTIC_STICK)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Blocks.CRAFTING_TABLE)
                        .pattern("##")
                        .pattern("##")
                .input('#', ModTags.Items.PLANKS)
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_ARCTIC_LOG),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ARCTIC_LOG))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_ARCTIC_WOOD),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ARCTIC_WOOD))
                .criterion(FabricRecipeProvider.hasItem(ModBlocks.BLUE_ARCTIC_PLANKS),
                        FabricRecipeProvider.conditionsFromItem(ModBlocks.BLUE_ARCTIC_PLANKS))
                        .offerTo(exporter, new Identifier(FabricRecipeProvider.getRecipeName(Blocks.CRAFTING_TABLE)));

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ARKTIRIUM, RecipeCategory.MISC,
                ModBlocks.ARKTIRIUM_BLOCK);
    }
}
