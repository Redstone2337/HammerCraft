package net.redstone233.morehammercraft;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.redstone233.morehammercraft.datagen.*;
import net.redstone233.morehammercraft.tags.ModItemTags;

public class MoreHammerCraftDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModblockTagsProvider::new);
		pack.addProvider(ModItemTagsProvider::new);
		pack.addProvider(ModModelsProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		//pack.addProvider(ModENUSlangProvider::new);
	}
}
