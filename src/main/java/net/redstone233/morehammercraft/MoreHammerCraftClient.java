package net.redstone233.morehammercraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.items.ModItems;


public class MoreHammerCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //KeyBinding shift = KeyBindingHelper.registerKeyBinding(new StickyKeyBinding("key.mhc.shift", GLFW.GLFW_KEY_LEFT_SHIFT,"key.category.info.shift", () -> true));
        FuelRegistryEvents.BUILD.register(Identifier.of(MoreHammerCraft.MOD_ID,"flydragon"),(builder, context) -> {
            builder.add(ModItems.FLYDRAGON,30000);
        });
        MoreHammerCraft.LOGGER.info("燃料注册成功！");
    }
}
