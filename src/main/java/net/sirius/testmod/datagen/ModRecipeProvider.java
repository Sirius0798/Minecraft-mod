package net.sirius.testmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.sirius.testmod.TestMod;
import net.sirius.testmod.block.ModBlocks;
import net.sirius.testmod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> SNOWGOOMBA_SMELTABLES = List.of(ModItems.SNOWGOOMBAH.get(),
            ModBlocks.SNOWGOOMBORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, SNOWGOOMBA_SMELTABLES, RecipeCategory.MISC, ModItems.SNOWGOOMBA.get(), 100, 300, "snowgoomba");
        oreSmelting(pWriter, SNOWGOOMBA_SMELTABLES, RecipeCategory.MISC, ModItems.SNOWGOOMBA.get(), 100, 600, "snowgoomba");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SNOWGOOMBLOCK.get())
                .pattern(" S ")
                .pattern("SDS")
                .pattern(" S ")
                .define('S', ModItems.SNOWGOOMBA.get())
                .define('D', Items.DRAGON_EGG)
                .unlockedBy(getHasName(ModItems.SNOWGOOMBA.get()), has(ModItems.SNOWGOOMBA.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR.get())
                .pattern("  S")
                .pattern(" IS")
                .pattern("IC ")
                .define('S', Items.STICK)
                .define('I', Items.IRON_INGOT)
                .define('C', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METAL_DETECTOR_TWO.get())
                .pattern(" D ")
                .pattern("DMD")
                .pattern(" D ")
                .define('D', Items.DIAMOND)
                .define('M', ModItems.METAL_DETECTOR.get())
                .unlockedBy(getHasName(ModItems.METAL_DETECTOR.get()), has(ModItems.METAL_DETECTOR.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SOUND_BLOCK.get())
                .pattern("WWW")
                .pattern("WNW")
                .pattern("WWW")
                .define('W', Items.WHITE_WOOL)
                .define('N', Items.NOTE_BLOCK)
                .unlockedBy(getHasName(Items.NOTE_BLOCK), has(Items.NOTE_BLOCK))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SNOWGOOMBA.get(), 4)
                .requires(ModBlocks.SNOWGOOMBLOCK.get())
                .unlockedBy(getHasName(ModBlocks.SNOWGOOMBLOCK.get()), has(ModBlocks.SNOWGOOMBLOCK.get()))
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
                    .save(pFinishedRecipeConsumer, TestMod.MODID + ":" + (pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
