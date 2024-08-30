package net.serric.createbaas.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.serric.createbaas.block.ModBlocks;
import net.serric.createbaas.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> TIN_SMELTABLES = List.of(
            ModItems.RAW_TIN,
            ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT,
                1f, 200, "tin_ingot");
        offerBlasting(exporter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT,
                1f, 100, "tin_ingot");

        //exampple 3 by 3 grid recipe
        //offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.TIN_INGOT, RecipeCategory.MISC, ModBlocks.TIN_BLOCK);

        //Example custom shaped recipe
        /*
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.TIN_INGOT, 1)
                .pattern("#R#")
                .pattern("#R#")
                .pattern("#R#")
                .input('R', Items.SADDLE)
                .input('#', Items.GLOW_ITEM_FRAME)
                .criterion(hasItem(ModItems.TIN_INGOT), conditionsFromItem(ModItems.TIN_INGOT))
                .criterion(hasItem(ModItems.RAW_TIN), conditionsFromItem(ModItems.RAW_TIN))
                .offerTo(exporter, new Identifier("createbaas", getRecipeName(ModItems.TIN_INGOT)));
        */
    }
}
