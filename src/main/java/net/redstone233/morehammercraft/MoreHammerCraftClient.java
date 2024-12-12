package net.redstone233.morehammercraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.core.gui.screens.ModScreenHandler;
import net.redstone233.morehammercraft.core.gui.screens.PolishMachineScreen;
import net.redstone233.morehammercraft.items.ModItems;


public class MoreHammerCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //KeyBinding shift = KeyBindingHelper.registerKeyBinding(new StickyKeyBinding("key.mhc.shift", GLFW.GLFW_KEY_LEFT_SHIFT,"key.category.info.shift", () -> true));
        FuelRegistryEvents.BUILD.register(Identifier.of(MoreHammerCraft.MOD_ID,"flydragon"),(builder, context) -> {
            builder.add(ModItems.FLYDRAGON,30000);
        });

        HandledScreens.register(ModScreenHandler.POLISHING_MACHINE_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, PolishMachineScreen::new);

        MoreHammerCraft.LOGGER.info(MoreHammerCraft.MOD_ID+"的燃料注册成功！");
    }
}
