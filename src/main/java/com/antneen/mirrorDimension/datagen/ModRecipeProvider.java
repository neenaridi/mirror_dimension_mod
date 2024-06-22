package com.antneen.mirrorDimension.datagen;

import com.antneen.mirrorDimension.Mirror_Dimension;
import com.antneen.mirrorDimension.block.ModBlocks;
import com.antneen.mirrorDimension.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> KYRIUM_SMELTABLES = List.of( ModBlocks.KYRIUM_ORE.get(), ModBlocks.DEEPSLATE_KYRIUM_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, KYRIUM_SMELTABLES, RecipeCategory.MISC, ModItems.KYRIUM.get(), 0.25f, 200, "kyrium");
        oreBlasting(pWriter, KYRIUM_SMELTABLES, RecipeCategory.MISC, ModItems.KYRIUM.get(), 0.25f, 100, "kyrium");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KYRIUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.KYRIUM.get())
                .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KYRIUM_PICKAXE.get())
                        .pattern("###")
                        .pattern(" S ")
                        .pattern(" S ")
                        .define('#', ModItems.KYRIUM.get())
                        .define('S', Items.STICK)
                        .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                        .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KYRIUM_AXE.get())
                .pattern("## ")
                .pattern("#S ")
                .pattern(" S ")
                .define('#', ModItems.KYRIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KYRIUM_SHOVEL.get())
                .pattern(" # ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.KYRIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KYRIUM_HOE.get())
                .pattern("## ")
                .pattern(" S ")
                .pattern(" S ")
                .define('#', ModItems.KYRIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KYRIUM_SWORD.get())
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" S ")
                .define('#', ModItems.KYRIUM.get())
                .define('S', Items.STICK)
                .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                .save(pWriter);

        /* uncomment when armor is implemented
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KYRIUM_HELMET.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.KYRIUM.get())
                .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KYRIUM_CHESTPLATE.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .define('#', ModItems.KYRIUM.get())
                .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KYRIUM_LEGGINGS.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .define('#', ModItems.KYRIUM.get())
                .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KYRIUM_BOOTS.get())
                .pattern("# #")
                .pattern("# #")
                .pattern("   ")
                .define('#', ModItems.KYRIUM.get())
                .unlockedBy(getHasName(ModItems.KYRIUM.get()), has(ModItems.KYRIUM.get()))
                .save(pWriter);
         */

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KYRIUM.get(), 9)
                .requires(ModBlocks.KYRIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.KYRIUM_BLOCK.get()), has(ModBlocks.KYRIUM_BLOCK.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Mirror_Dimension.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
