package net.redstone233.morehammercraft.core.gui.screens;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.data.PolishMachineData;

public class ModScreenHandler {
    public static final ScreenHandlerType<PolishingMachineScreenHandler> POLISHING_MACHINE_SCREEN_HANDLER_SCREEN_HANDLER_TYPE =
            /*Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MoreHammerCraft.MOD_ID,"conversion_table"),*/
                    new ExtendedScreenHandlerType<>(PolishingMachineScreenHandler::new, PolishMachineData.CODEC);


    public static void register() {
        Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MoreHammerCraft.MOD_ID,"conversion_table"),POLISHING_MACHINE_SCREEN_HANDLER_SCREEN_HANDLER_TYPE);
    }
}
