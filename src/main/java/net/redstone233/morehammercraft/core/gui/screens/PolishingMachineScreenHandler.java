package net.redstone233.morehammercraft.core.gui.screens;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.redstone233.morehammercraft.data.PolishMachineData;
import net.redstone233.morehammercraft.entities.PolishMachineBlockEntity;
import org.jetbrains.annotations.Nullable;

public class PolishingMachineScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private PropertyDelegate propertyDelegate;
    private PolishMachineBlockEntity blockEntity;

    public PolishingMachineScreenHandler(int syncId, PlayerInventory playerInventory, PropertyDelegate propertyDelegate, BlockEntity blockEntity) {
        super(ModScreenHandler.POLISHING_MACHINE_SCREEN_HANDLER_SCREEN_HANDLER_TYPE, syncId);
        checkSize((Inventory) blockEntity,2);
        this.inventory = (Inventory) blockEntity;
        this.propertyDelegate = propertyDelegate;
        this.blockEntity = (PolishMachineBlockEntity) blockEntity;
        inventory.onOpen(playerInventory.player);

        this.propertyDelegate = propertyDelegate;
        this.blockEntity = (PolishMachineBlockEntity) blockEntity;

        this.addSlot(new Slot(inventory,0,80,11));
        this.addSlot(new Slot(inventory,0,80,59));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(propertyDelegate);
    }

    public PolishingMachineScreenHandler(int syncId, PlayerInventory playerInventory, PolishMachineData data) {
        this(syncId,playerInventory,new ArrayPropertyDelegate(2),playerInventory.player.getWorld().getBlockEntity(data.pos()));
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(playerInventory,i,8 + i * 18,142));
        }
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory,j + i * 9 + 9, 8 + j * 18,84 + i *18));
            }
        }
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack stack = ItemStack.EMPTY;
        Slot invSlot = this.slots.get(slot);
        if (invSlot != null && invSlot.hasStack()) {
            ItemStack originalStack = invSlot.getStack();
            stack = originalStack.copy();
            if (slot < this.inventory.size()) {
                if (!this.insertItem(originalStack,this.inventory.size(),this.slots.size(),true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack,0,this.slots.size(),false)) {
                return ItemStack.EMPTY;
            }
            if (originalStack.isEmpty()) {
                invSlot.setStack(ItemStack.EMPTY);
            } else {
                invSlot.markDirty();
            }
        }
        return stack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public boolean isRaining() {
        return blockEntity.getWorld().isRaining();
    }

    public int getScaledProgress() {
        int progress = propertyDelegate.get(0);
        int maxProgress = propertyDelegate.get(1);
        int progressArrowSize = 26;
        return maxProgress != 0 && progress != 0 ? progress * progressArrowSize / maxProgress : 0;
    }
}
