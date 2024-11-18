package net.redstone233.morehammercraft.mixin;

import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.redstone233.morehammercraft.items.ModItems;
import net.redstone233.morehammercraft.potions.ModPotions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BrewingRecipeRegistry.class)
public class BrewingRecipeRegistryMixin {

    @Inject(method = "registerDefaults", at = @At("RETURN"))
    private static void registerDefaults(BrewingRecipeRegistry.Builder builder, CallbackInfo ci) {
        // Fire Potions
        builder.registerPotionRecipe(Potions.AWKWARD, ModItems.FLYDRAGON, ModPotions.FIRE_POTION);
        builder.registerPotionRecipe(ModPotions.FIRE_POTION, Items.REDSTONE,ModPotions.GOOD_FIRE_POTION);
        builder.registerPotionRecipe(ModPotions.GOOD_FIRE_POTION, ModItems.DEFAULT_TEMPLATE, ModPotions.GREAT_FIRE_POTION);
        // Blue Fire
        builder.registerPotionRecipe(ModPotions.FIRE_POTION,ModItems.IRON_COLA,ModPotions.BLUE_FIRE_POTION);
        builder.registerPotionRecipe(ModPotions.BLUE_FIRE_POTION,Items.REDSTONE,ModPotions.GOOD_BLUE_FIRE_POTION);
        builder.registerPotionRecipe(ModPotions.GOOD_BLUE_FIRE_POTION,ModItems.WINDOWS,ModPotions.GREAT_BLUE_FIRE_POTION);
    // Exp Potions
        builder.registerPotionRecipe(Potions.AWKWARD,Items.EXPERIENCE_BOTTLE,ModPotions.EXP_POTION);
        builder.registerPotionRecipe(ModPotions.EXP_POTION,Items.EXPERIENCE_BOTTLE,ModPotions.GOOD_EXP_POTION);
        builder.registerPotionRecipe(ModPotions.GOOD_EXP_POTION,ModItems.FLYDRAGON_STUDIO,ModPotions.GREAT_EXP_POTION);
        builder.registerPotionRecipe(ModPotions.GREAT_EXP_POTION,Items.REDSTONE,ModPotions.BETTER_EXP_POTION);
        builder.registerPotionRecipe(ModPotions.BETTER_EXP_POTION,ModItems.FLYDRAGON,ModPotions.BEST_EXP_POTION);
    }
}
