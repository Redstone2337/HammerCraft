package net.redstone233.morehammercraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.redstone233.morehammercraft.items.ModItems;
import net.redstone233.morehammercraft.tags.ModItemTags;

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
        getOrCreateTagBuilder(ModItemTags.FUNCTION_LIST)
                .add(ModItems.RUBY)
                .add(ModItems.PROSPECTOR)
                .add(ModItems.BRICK)
                .add(ModItems.FLYDRAGON_STUDIO)
                .add(ModItems.WINDOWS)
                .add(ModItems.FLYDRAGON)
                .add(ModItems.ICE_SWORD)
                .add(ModItems.ICE_DRAGON_SWORD)
                .add(ModItems.DRAGON_CLAW)
                .add(ModItems.SMALL_DRAGON_CLAW)
                .add(ModItems.SICKLE_HEAD);
        getOrCreateTagBuilder(ModItemTags.SICKLE_LIST)
                .add(ModItems.WOODEN_SICKLE)
                .add(ModItems.STONE_SICKLE)
                .add(ModItems.IRON_SICKLE)
                .add(ModItems.GOLD_SICKLE)
                .add(ModItems.DIAMOND_SICKLE)
                .add(ModItems.NETHERITE_SICKLE);
    }
}
