package net.redstone233.morehammercraft.core.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;

public class ModRecipeTypes {
    public static void register() {
        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MoreHammerCraft.MOD_ID,PolishMachineRecipe.Serializer.ID),
                PolishMachineRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE,Identifier.of(MoreHammerCraft.MOD_ID,PolishMachineRecipe.Type.ID),
                PolishMachineRecipe.Type.INSTANCE);
    }
}
