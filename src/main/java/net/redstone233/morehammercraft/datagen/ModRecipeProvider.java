package net.redstone233.morehammercraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.items.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ICE_DRAGON_SWORD).pattern(" i ").pattern(" i ").pattern(" j ")
                .input('i', ModItems.DEFAULT_INGOT)
                .input('j', Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DEFAULT_INGOT),FabricRecipeProvider.conditionsFromItem(ModItems.DEFAULT_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"ice_dragon_sword"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.DEFAULT_HAMMER).pattern("iii").pattern(" j ").pattern(" j ")
                .input('i',ModItems.DEFAULT_INGOT)
                .input('j',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DEFAULT_INGOT),FabricRecipeProvider.conditionsFromItem(ModItems.DEFAULT_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"default_hammer"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.VAMPIRE_HAMMER).pattern("iii").pattern(" j ").pattern(" j ")
                .input('i',ModItems.VAMPIRE_HAMMER)
                .input('j',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.VAMPIRE_INGOT),FabricRecipeProvider.conditionsFromItem(ModItems.VAMPIRE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"vampire_hammer"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.TALLER_HAMMER).pattern("iii").pattern("iji").pattern(" j ")
                .input('i',ModItems.DEFAULT_INGOT)
                .input('j',Items.STICK)
                .criterion(FabricRecipeProvider.hasItem(ModItems.DEFAULT_INGOT),FabricRecipeProvider.conditionsFromItem(ModItems.DEFAULT_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"taller_hammer"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.DRAGON_CLAW)
                .pattern("AAA")
                .pattern("BCB")
                .pattern("DCD")
                .input('A',Items.NETHERITE_INGOT)
                .input('B',Items.LAVA_BUCKET)
                .input('C',Items.BLAZE_ROD)
                .input('D',Items.ORANGE_DYE)
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT),FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(FabricRecipeProvider.hasItem(Items.LAVA_BUCKET),FabricRecipeProvider.conditionsFromItem(Items.LAVA_BUCKET))
                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_ROD),FabricRecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .criterion(FabricRecipeProvider.hasItem(Items.ORANGE_DYE),FabricRecipeProvider.conditionsFromItem(Items.ORANGE_DYE))
                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"dragon_clay"));
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT,ModItems.SMALL_DRAGON_CLAW)
                .pattern("AAA")
                .pattern("BCB")
                .pattern("DCD")
                .input('A',Items.NETHERITE_SCRAP)
                .input('B',Items.LAVA_BUCKET)
                .input('C',Items.BLAZE_ROD)
                .input('D',Items.ORANGE_DYE)
                .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_SCRAP),FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_SCRAP))
                .criterion(FabricRecipeProvider.hasItem(Items.LAVA_BUCKET),FabricRecipeProvider.conditionsFromItem(Items.LAVA_BUCKET))
                .criterion(FabricRecipeProvider.hasItem(Items.BLAZE_ROD),FabricRecipeProvider.conditionsFromItem(Items.BLAZE_ROD))
                .criterion(FabricRecipeProvider.hasItem(Items.ORANGE_DYE),FabricRecipeProvider.conditionsFromItem(Items.ORANGE_DYE))
                .offerTo(exporter, Identifier.of(MoreHammerCraft.MOD_ID,"three_dragon_clay"));

    }
}
