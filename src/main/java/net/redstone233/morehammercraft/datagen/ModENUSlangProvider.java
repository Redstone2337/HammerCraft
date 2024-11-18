package net.redstone233.morehammercraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.redstone233.morehammercraft.effects.ModStatusEffects;
import net.redstone233.morehammercraft.items.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModENUSlangProvider extends FabricLanguageProvider {
    public ModENUSlangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.IRON_CAN,"Iron Can");
        //translationBuilder.add(ModStatusEffects.DRAW_FIRE_ON_ONESELF.value(),"Draw Fire On Oneself");
    }
}
