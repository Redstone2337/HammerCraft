package net.redstone233.morehammercraft.datagen;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.blocks.ModBlocks;
import net.redstone233.morehammercraft.items.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup,recipeExporter) {
            @Override
            public void generate() {
                //ShapedRecipeJsonBuilder.create((RegistryWrapper<Item>)ModItems.ICE_DRAGON_SWORD,RecipeCategory.COMBAT)
                //Wooden
                createShaped(RecipeCategory.COMBAT,ModItems.WOODEN_SICKLE,1)
                        .pattern("ABA")
                        .pattern("CDE")
                        .pattern("CDE")
                        .input('A', ItemTags.PLANKS)
                        .input('B',ModItems.SICKLE_HEAD)
                        .input('C',Items.BLAZE_ROD)
                        .input('D',Items.STICK)
                        .input('E',Items.BREEZE_ROD).criterion("has_planks",conditionsFromTag(ItemTags.PLANKS))
                        .offerTo(recipeExporter);
                                //.offerTo(recipeExporter,Identifier.of(MoreHammerCraft.MOD_ID,"wooden_sickle"));
                //Stone
                createShaped(RecipeCategory.COMBAT,ModItems.STONE_SICKLE,1)
                        .pattern("ABA")
                        .pattern("CDE")
                        .pattern("CDE")
                        .input('A', ItemTags.STONE_TOOL_MATERIALS)
                        .input('B',ModItems.SICKLE_HEAD)
                        .input('C',Items.BLAZE_ROD)
                        .input('D',Items.STICK)
                        .input('E',Items.BREEZE_ROD).criterion("has_stones",conditionsFromTag(ItemTags.STONE_TOOL_MATERIALS))
                        .offerTo(recipeExporter);
                //Iron
                createShaped(RecipeCategory.COMBAT,ModItems.IRON_SICKLE,1)
                        .pattern("ABA")
                        .pattern("CDE")
                        .pattern("CDE")
                        .input('A', ItemTags.IRON_TOOL_MATERIALS)
                        .input('B',ModItems.SICKLE_HEAD)
                        .input('C',Items.BLAZE_ROD)
                        .input('D',Items.STICK)
                        .input('E',Items.BREEZE_ROD).criterion("has_iron_ingots",conditionsFromTag(ItemTags.IRON_TOOL_MATERIALS))
                        .offerTo(recipeExporter);
                //Golden
                createShaped(RecipeCategory.COMBAT,ModItems.GOLD_SICKLE,1)
                        .pattern("ABA")
                        .pattern("CDE")
                        .pattern("CDE")
                        .input('A', ItemTags.GOLD_TOOL_MATERIALS)
                        .input('B',ModItems.SICKLE_HEAD)
                        .input('C',Items.BLAZE_ROD)
                        .input('D',Items.STICK)
                        .input('E',Items.BREEZE_ROD).criterion("has_gold_ingots",conditionsFromTag(ItemTags.GOLD_TOOL_MATERIALS))
                        .offerTo(recipeExporter);
                //Diamond
                createShaped(RecipeCategory.COMBAT,ModItems.DIAMOND_SICKLE,1)
                        .pattern("ABA")
                        .pattern("CDE")
                        .pattern("CDE")
                        .input('A', ItemTags.DIAMOND_TOOL_MATERIALS)
                        .input('B',ModItems.SICKLE_HEAD)
                        .input('C',Items.BLAZE_ROD)
                        .input('D',Items.STICK)
                        .input('E',Items.BREEZE_ROD).criterion("has_diamonds",conditionsFromTag(ItemTags.DIAMOND_TOOL_MATERIALS))
                        .offerTo(recipeExporter);
                //Netherite
                createShaped(RecipeCategory.COMBAT,ModItems.NETHERITE_SICKLE,1)
                        .pattern("ABA")
                        .pattern("CDE")
                        .pattern("CDE")
                        .input('A', ItemTags.NETHERITE_TOOL_MATERIALS)
                        .input('B',ModItems.SICKLE_HEAD)
                        .input('C',Items.BLAZE_ROD)
                        .input('D',Items.STICK)
                        .input('E',Items.BREEZE_ROD).criterion("has_netherites",conditionsFromTag(ItemTags.NETHERITE_TOOL_MATERIALS))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.MISC,ModItems.SICKLE_HEAD,1)
                        .pattern("AAA")
                        .pattern("  A")
                        .pattern("  A")
                        .input('A',Items.IRON_INGOT).criterion("has_iron_ingot",conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.COMBAT,ModItems.DEFAULT_HAMMER,1)
                        .pattern("ACA")
                        .pattern(" B ")
                        .pattern(" B ")
                        .input('A', ModItems.DEFAULT_INGOT)
                        .input('B', Items.BLAZE_ROD)
                        .input('C', Blocks.IRON_BLOCK)
                        .criterion("has_default_ingot",conditionsFromItem(ModItems.DEFAULT_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.COMBAT,ModItems.ICE_DRAGON_SWORD,1)
                        .pattern("AAA")
                        .pattern(" B ")
                        .pattern(" B ")
                        .input('A', ModItems.DEFAULT_INGOT)
                        .input('B', Items.BLAZE_ROD)
                        .criterion("has_default_ingot",conditionsFromItem(ModItems.DEFAULT_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.COMBAT,ModItems.VAMPIRE_HAMMER,1)
                        .pattern("AAA")
                        .pattern(" B ")
                        .pattern(" B ")
                        .input('A', ModItems.VAMPIRE_INGOT)
                        .input('B', Items.BLAZE_ROD)
                        .criterion("has_vampire_ingot",conditionsFromItem(ModItems.VAMPIRE_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.COMBAT,ModItems.TALLER_HAMMER,1)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern(" B ")
                        .input('A', ModItems.DEFAULT_INGOT)
                        .input('B', Items.BLAZE_ROD)
                        .criterion("has_default_ingot",conditionsFromItem(ModItems.DEFAULT_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.COMBAT,ModItems.DRAGON_CLAW,1)
                        .pattern("AAA")
                        .pattern("BCB")
                        .pattern("DCD")
                        .input('A',Items.NETHERITE_INGOT)
                        .input('B',Items.LAVA_BUCKET)
                        .input('C',Items.BLAZE_ROD)
                        .input('D',Items.ORANGE_DYE)
                        .criterion("has_netherite_ingot",conditionsFromItem(Items.NETHERITE_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.COMBAT,ModItems.SMALL_DRAGON_CLAW,1)
                        .pattern("AAA")
                        .pattern("BCB")
                        .pattern("DCD")
                        .input('A',Items.NETHERITE_SCRAP)
                        .input('B',Items.LAVA_BUCKET)
                        .input('C',Items.BLAZE_ROD)
                        .input('D',Items.ORANGE_DYE)
                        .criterion("has_netherite_scrap",conditionsFromItem(Items.NETHERITE_SCRAP))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.MISC, ModBlocks.POLISH_MACHINE,1)
                        .pattern("AAA")
                        .pattern("ABA")
                        .pattern("AAA")
                        .input('A',ModItems.FLYDRAGON)
                        .input('B',Items.CRAFTER)
                        .criterion("has_crafter",conditionsFromItem(Items.CRAFTER))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.FOOD,ModItems.PAPERS)
                        .pattern("AAA")
                        .pattern("A A")
                        .pattern("BBB")
                        .input('A',Items.PAPER)
                        .input('B',Items.WHEAT)
                        .criterion("has_paper",conditionsFromItem(Items.PAPER))
                        .offerTo(recipeExporter);
                createShapeless(RecipeCategory.FOOD,ModItems.MORE_PAPERS,1)
                        .input(DefaultCustomIngredients.any(
                                Ingredient.ofItem(ModItems.PAPERS),
                                Ingredient.ofItem(ModItems.IRON_COLA),
                                Ingredient.ofItem(Items.PAPER),
                                Ingredient.ofItem(Items.WATER_BUCKET)))
                        .criterion("has_iron_cola",conditionsFromItem(ModItems.IRON_COLA)).offerTo(recipeExporter);
                createShapeless(RecipeCategory.FOOD,ModItems.IRON_COLA,1)
                        .input(DefaultCustomIngredients.any(
                                Ingredient.ofItem(ModItems.IRON_CAN),
                                Ingredient.ofItem(Items.RED_DYE),
                                Ingredient.ofItem(Items.BLUE_DYE),
                                Ingredient.ofItem(Items.IRON_INGOT)))
                        .criterion("has_iron_can",conditionsFromItem(ModItems.IRON_CAN)).offerTo(recipeExporter);
                createShapeless(RecipeCategory.MISC,ModItems.RUBY)
                        .input(DefaultCustomIngredients.any(Ingredient.ofItem(ModBlocks.RUBY_ORE)))
                        .input(DefaultCustomIngredients.any(Ingredient.ofItem(ModItems.HAMMER_CRAFTING)))
                        .criterion("has_ruby_ore",conditionsFromItem(ModBlocks.RUBY_ORE)).offerTo(recipeExporter);
//                createShapeless(RecipeCategory.MISC,ModItems.IRON_COLA,1)
//                        .input(DefaultCustomIngredients.any(
//                                Ingredient.ofItems(ModItems.IRON_CAN),
//                                Ingredient.ofItems((ItemConvertible) Potions.WATER),
//                                Ingredient.ofItems(Items.IRON_INGOT)))
//                        .criterion("has_iron_can",conditionsFromItem(ModItems.IRON_CAN)).offerTo(recipeExporter);

//                createShapeless(RecipeCategory.MISC, Items.GOLD_BLOCK)
//                        .input(DefaultCustomIngredients.any(Ingredient.ofItems(Items.GOLDEN_PICKAXE), Ingredient.ofItems(Items.GOLDEN_SHOVEL)))
//                        .criterion("has_pickaxe", conditionsFromItem(Items.GOLDEN_PICKAXE))
//                        .criterion("has_shovel", conditionsFromItem(Items.GOLDEN_SHOVEL))
//                        .offerTo(recipeExporter);
//
//                createShapeless(RecipeCategory.MISC, Items.BEACON)
//                        .input(DefaultCustomIngredients.difference(
//                                DefaultCustomIngredients.any(
//                                        ingredientFromTag(ItemTags.BEACON_PAYMENT_ITEMS),
//                                        Ingredient.ofItems(Items.COPPER_INGOT)),
//                                Ingredient.ofItems(Items.IRON_INGOT, Items.GOLD_INGOT, Items.DIAMOND)))
//                        .criterion("has_payment", conditionsFromTag(ItemTags.BEACON_PAYMENT_ITEMS))
//                        .offerTo(recipeExporter);

                //Iron Can
                createShaped(RecipeCategory.MISC,ModItems.IRON_CAN)
                        .pattern("AAA")
                        .pattern("A A")
                        .pattern("B B")
                        .input('A',Items.IRON_INGOT)
                        .input('B',Items.BLAZE_POWDER)
                        .criterion("has_blaze_power",conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS,ModBlocks.RUBY_BLOCK)
                        .pattern("AAA")
                        .pattern("AAA")
                        .pattern("AAA")
                        .input('A',ModItems.RUBY)
                        .criterion("has_ruby",conditionsFromItem(ModItems.RUBY))
                        .offerTo(recipeExporter);
                createShaped(RecipeCategory.MISC,ModBlocks.RUBY_WALL)
                        .pattern("###")
                        .pattern("###")
                        .input('#',ModBlocks.RUBY_BLOCK)
                        .criterion("has_ruby_block",conditionsFromItem(ModBlocks.RUBY_BLOCK))
                        .offerTo(recipeExporter);
                createStairsRecipe(ModBlocks.RUBY_STAIRS,Ingredient.ofItem(ModItems.RUBY)).criterion("has_ruby_block",conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(recipeExporter);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS,ModBlocks.RUBY_SLAB,Ingredient.ofItem(ModItems.RUBY)).criterion("has_ruby_block",conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(recipeExporter);
                createButtonRecipe(ModBlocks.RUBY_BUTTON,Ingredient.ofItem(ModItems.RUBY)).criterion("has_ruby_block",conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(recipeExporter);
                createDoorRecipe(ModBlocks.RUBY_DOOR,Ingredient.ofItem(ModItems.RUBY)).criterion("has_ruby_block",conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(recipeExporter);
                createTrapdoorRecipe(ModBlocks.RUBY_TRAPDOOR,Ingredient.ofItem(ModItems.RUBY)).criterion("has_ruby_block",conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(recipeExporter);
                createFenceRecipe(ModBlocks.RUBY_FENCE,Ingredient.ofItem(ModItems.RUBY)).criterion("has_ruby_block",conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(recipeExporter);
                createFenceGateRecipe(ModBlocks.RUBY_FENCE_GATE,Ingredient.ofItem(ModItems.RUBY)).criterion("has_ruby_block",conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(recipeExporter);
                createPressurePlateRecipe(RecipeCategory.REDSTONE,ModBlocks.RUBY_PRESSURE_PLATE,Ingredient.ofItem(ModItems.RUBY)).criterion("has_ruby_block",conditionsFromItem(ModBlocks.RUBY_BLOCK)).offerTo(recipeExporter);
            }
        };
    }

//    @Override
//    public void generate(RecipeExporter exporter) {
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ICE_DRAGON_SWORD)
//        .pattern(" i ")
//        .pattern(" i ")
//        .pattern(" j ")
//                .input('i', ModItems.DEFAULT_INGOT)
//                .input('j', Items.STICK)
//                .criterion(FabricRecipeProvider.hasItem(ModItems.DEFAULT_INGOT),FabricRecipeProvider.conditionsFromItem(ModItems.DEFAULT_INGOT))
//                .criterion(FabricRecipeProvider.hasItem(Items.STICK),FabricRecipeProvider.conditionsFromItem(Items.STICK))
//                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"ice_dragon_sword"));
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.DEFAULT_HAMMER).pattern("iii").pattern(" j ").pattern(" j ")
//                .input('i',ModItems.DEFAULT_INGOT)
//                .input('j',Items.STICK)
//                .criterion(FabricRecipeProvider.hasItem(ModItems.DEFAULT_INGOT),FabricRecipeProvider.conditionsFromItem(ModItems.DEFAULT_INGOT))
//                .criterion(FabricRecipeProvider.hasItem(Items.STICK),FabricRecipeProvider.conditionsFromItem(Items.STICK))
//                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"default_hammer"));
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.VAMPIRE_HAMMER).pattern("iii").pattern(" j ").pattern(" j ")
//                .input('i',ModItems.VAMPIRE_HAMMER)
//                .input('j',Items.STICK)
//                .criterion(FabricRecipeProvider.hasItem(ModItems.VAMPIRE_INGOT),FabricRecipeProvider.conditionsFromItem(ModItems.VAMPIRE_INGOT))
//                .criterion(FabricRecipeProvider.hasItem(Items.STICK),FabricRecipeProvider.conditionsFromItem(Items.STICK))
//                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"vampire_hammer"));
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.TALLER_HAMMER).pattern("iii").pattern("iji").pattern(" j ")
//                .input('i',ModItems.DEFAULT_INGOT)
//                .input('j',Items.STICK)
//                .criterion(FabricRecipeProvider.hasItem(ModItems.DEFAULT_INGOT),FabricRecipeProvider.conditionsFromItem(ModItems.DEFAULT_INGOT))
//                .criterion(FabricRecipeProvider.hasItem(Items.STICK),FabricRecipeProvider.conditionsFromItem(Items.STICK))
//                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"taller_hammer"));
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.DRAGON_CLAW)
//                .pattern("AAA")
//                .pattern("BCB")
//                .pattern("DCD")
//                .input('A',Items.NETHERITE_INGOT)
//                .input('B',Items.LAVA_BUCKET)
//                .input('C',Items.BLAZE_ROD)
//                .input('D',Items.ORANGE_DYE)
//                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT),FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
//                .criterion(FabricRecipeProvider.hasItem(Items.LAVA_BUCKET),FabricRecipeProvider.conditionsFromItem(Items.LAVA_BUCKET))
//                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_ROD),FabricRecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
//                .criterion(FabricRecipeProvider.hasItem(Items.ORANGE_DYE),FabricRecipeProvider.conditionsFromItem(Items.ORANGE_DYE))
//                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"dragon_clay"));
//        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SMALL_DRAGON_CLAW)
//                .pattern("AAA")
//                .pattern("BCB")
//                .pattern("DCD")
//                .input('A',Items.NETHERITE_SCRAP)
//                .input('B',Items.LAVA_BUCKET)
//                .input('C',Items.BLAZE_ROD)
//                .input('D',Items.ORANGE_DYE)
//                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SCRAP),FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SCRAP))
//                .criterion(FabricRecipeProvider.hasItem(Items.LAVA_BUCKET),FabricRecipeProvider.conditionsFromItem(Items.LAVA_BUCKET))
//                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_ROD),FabricRecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
//                .criterion(FabricRecipeProvider.hasItem(Items.ORANGE_DYE),FabricRecipeProvider.conditionsFromItem(Items.ORANGE_DYE))
//                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"three_dragon_clay"));


    @Override
    public String getName() {
        return "Register Recipes";
    }
}
