package net.redstone233.morehammercraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.redstone233.morehammercraft.items.ModItems;
import net.redstone233.morehammercraft.tags.ModItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends FabricTagProvider.ItemTagProvider {


    public ModItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModItemTags.TEMPLATE_LIST)
                .add(ModItems.DEFAULT_TEMPLATE)
                .add(ModItems.SLOWNESS_TEMPLATE)
                .add(ModItems.VAMPIRE_TEMPLATE);
        getOrCreateTagBuilder(ModItemTags.HAMMER_LIST)
                .add(ModItems.DEFAULT_HAMMER)
                .add(ModItems.VAMPIRE_HAMMER)
                .add(ModItems.SLOWNESS_HAMMER)
                .add(ModItems.TALLER_HAMMER)
                .add(ModItems.LEFT_HAMMER)
                .add(ModItems.RIGHT_HAMMER);
        getOrCreateTagBuilder(ModItemTags.INGOT_LIST)
                .add(ModItems.DEFAULT_INGOT)
                .add(ModItems.SLOWNESS_INGOT)
                .add(ModItems.VAMPIRE_INGOT);
    }
}
