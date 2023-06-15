package me.arktikus.frostbite.data;

import me.arktikus.frostbite.block.ModBlocks;
import me.arktikus.frostbite.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, List.of(ModItems.RAW_ARKTIRIUM), RecipeCategory.MISC, ModItems.RAW_ARKTIRIUM,
                0.7f, 200, "citrine");
        offerBlasting(exporter, List.of(ModItems.RAW_ARKTIRIUM), RecipeCategory.MISC, ModItems.RAW_ARKTIRIUM,
                0.7f, 100, "citrine");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ARKTIRIUM, RecipeCategory.MISC,
                ModBlocks.ARKTIRIUM_BLOCK);
    }
}
