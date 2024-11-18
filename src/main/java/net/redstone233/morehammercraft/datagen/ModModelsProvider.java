package net.redstone233.morehammercraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.redstone233.morehammercraft.items.ModItems;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VAMPIRE_TEMPLATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.DEFAULT_TEMPLATE,Models.GENERATED);
        //itemModelGenerator.register(ModItems.SLOWNESS_TEMPLATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.Prospectors,Models.GENERATED);
        itemModelGenerator.register(ModItems.SLOWNESS_TEMPLATE,Models.GENERATED);
        itemModelGenerator.register(ModItems.DEFAULT_INGOT,Models.GENERATED);
        itemModelGenerator.register(ModItems.VAMPIRE_INGOT,Models.GENERATED);
        itemModelGenerator.register(ModItems.SLOWNESS_INGOT,Models.GENERATED);
        itemModelGenerator.register(ModItems.BRICK,Models.GENERATED);
        itemModelGenerator.register(ModItems.WINDOWS,Models.GENERATED);
        itemModelGenerator.register(ModItems.FLYDRAGON,Models.GENERATED);
        itemModelGenerator.register(ModItems.FLYDRAGON_STUDIO,Models.GENERATED);
        itemModelGenerator.register(ModItems.NEW_FOOD,Models.GENERATED);
        itemModelGenerator.register(ModItems.MORE_PAPERS,Models.GENERATED);
        itemModelGenerator.register(ModItems.PAPERS,Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_CAN,Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_COLA,Models.GENERATED);
        itemModelGenerator.register(ModItems.SICKLE_HEAD,Models.GENERATED);
    }
}
