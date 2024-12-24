package net.redstone233.morehammercraft.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RepairItemRecipe;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.redstone233.morehammercraft.core.items.AbstractDurabilityItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RepairItemRecipe.class)
public class RepairItemRecipeMixin {
    @Inject(method = "findPair", at = @At("RETURN"), cancellable = true)
    private static void prevent(CraftingRecipeInput craftingRecipeInput, CallbackInfoReturnable<Pair<ItemStack, ItemStack>> cir) {
        Pair<ItemStack, ItemStack> pair = cir.getReturnValue();
        if (pair != null) {
            Item item = pair.getFirst().getItem();
            cir.setReturnValue((item.getDefaultStack().getRecipeRemainder() != null && item instanceof AbstractDurabilityItem) ? null : pair);
        }
    }
}
