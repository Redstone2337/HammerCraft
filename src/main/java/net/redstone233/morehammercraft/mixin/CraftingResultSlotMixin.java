package net.redstone233.morehammercraft.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.CraftingResultSlot;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CraftingResultSlot.class)
public class CraftingResultSlotMixin {
    @Inject(method = "onTakeItem", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/screen/slot/CraftingResultSlot;getRecipeRemainders(Lnet/minecraft/recipe/input/CraftingRecipeInput;Lnet/minecraft/world/World;)Lnet/minecraft/util/collection/DefaultedList;"))
    private void removeNonDurabilityTools(PlayerEntity player, ItemStack stack, CallbackInfo ci, @Local LocalRef<DefaultedList<ItemStack>> defaultedListLocalRef) {
        Item checkItem = null;
        DefaultedList<ItemStack> defaultedList = defaultedListLocalRef.get();
        int length = defaultedList.size();
        boolean isRepair = false;
        for (ItemStack itemStack : defaultedList) {
            if (itemStack.equals(ItemStack.EMPTY)) continue;
            if (checkItem == null) {
                checkItem = itemStack.getItem();
            }
            if (itemStack.isOf(checkItem)) {
                if (isRepair) {
                    isRepair = false;
                    break;
                }
                isRepair = true;
            }
        }
        if (isRepair) {
            defaultedListLocalRef.set(DefaultedList.ofSize(length, ItemStack.EMPTY));
        }
    }
}
