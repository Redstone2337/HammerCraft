package net.redstone233.morehammercraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.blocks.ModBlocks;
import net.redstone233.morehammercraft.commands.BoomCommands;
import net.redstone233.morehammercraft.commands.InfoCommands;
import net.redstone233.morehammercraft.commands.Settings;
import net.redstone233.morehammercraft.commands.SlownessCommand;
import net.redstone233.morehammercraft.core.gui.screens.ModScreenHandler;
import net.redstone233.morehammercraft.core.recipe.ModRecipeTypes;
import net.redstone233.morehammercraft.effects.ModStatusEffects;
import net.redstone233.morehammercraft.entities.ModBlockEntities;
import net.redstone233.morehammercraft.items.ModItemGroups;
import net.redstone233.morehammercraft.items.ModItems;
import net.redstone233.morehammercraft.potions.ModPotions;
import net.redstone233.morehammercraft.tags.ModBlockTags;
import net.redstone233.morehammercraft.tags.ModItemTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreHammerCraft implements ModInitializer {
	public static final String MOD_ID = "mhc";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItemGroups.registerModItemGroups();
		ModItems.registerItems();
        ModBlockTags.registerModBlockTags();
		ModItemTags.registerModItemTags();
		ModStatusEffects.registerStatusEffects();
		ModPotions.registerModPotions();
		ModBlockEntities.registerModBlockEntities();
		ModBlocks.register();
		ModScreenHandler.register();
		ModRecipeTypes.register();
        LOGGER.info("Hello Fabric world!");
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
			//dispatcher.register(ConfigCmd.register());
			//dispatcher.register(JsonInfo.register());
			//dispatcher.register(TomlCmd.register());
			dispatcher.register(Settings.register());
			dispatcher.register(SlownessCommand.register());
			dispatcher.register(BoomCommands.register());
			dispatcher.register(InfoCommands.register());
		});
//		FuelRegistryEvents.BUILD.register(Identifier.of(MOD_ID,"flydragon"),(builder, context) -> {
//			builder.add(ModItems.FLYDRAGON,30000);
//		});
	}
}