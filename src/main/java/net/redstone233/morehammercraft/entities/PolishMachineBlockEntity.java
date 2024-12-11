package net.redstone233.morehammercraft.entities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.redstone233.morehammercraft.core.entity.impl.ImplementedInventory;
import net.redstone233.morehammercraft.core.gui.screens.PolishingMachineScreenHandler;
import net.redstone233.morehammercraft.core.recipe.PolishMachineRecipe;
import net.redstone233.morehammercraft.data.PolishMachineData;
import net.redstone233.morehammercraft.items.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PolishMachineBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<PolishMachineData>, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2,ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;

    private int progress = 0;
    private int maxProgress = 72;

    public PolishMachineBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.POLISH_MACHINE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> PolishMachineBlockEntity.this.progress;
                    case 1 -> PolishMachineBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> PolishMachineBlockEntity.this.progress = value;
                    case 1 -> PolishMachineBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.mhc.conversion_table.gui");
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new PolishingMachineScreenHandler(syncId,playerInventory,this.propertyDelegate,this);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    public PolishMachineData getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return new PolishMachineData(pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.writeNbt(nbt, registries);
        Inventories.writeNbt(nbt,this.inventory,false,registries);
        nbt.putInt("conversion_table",progress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registries) {
        super.readNbt(nbt, registries);
        Inventories.readNbt(nbt,this.inventory,registries);
        progress = nbt.getInt("conversion_table");
    }

    @Override
    public int getMaxCountPerStack() {
        return 64;
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            return;
        }
        if (isOutputSlotAvailable()) {
            if (hasRecipe()) {
                this.increaseCraftProgress();
                markDirty(world,pos,state);

                if (hasCraftingFinished()) {
                    createItem();
                    resetProgress();
                } else {
                    resetProgress();
                }
            } else {
                resetProgress();
                markDirty(world,pos,state);
            }
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void createItem() {
//        ItemStack result = new ItemStack(ModItems.DEFAULT_HAMMER);
//        this.setStack(OUTPUT_SLOT,new ItemStack(result.getItem(), getStack(OUTPUT_SLOT).getCount() + result.getCount()));
        Optional<RecipeEntry<PolishMachineRecipe>> recipe = getCurrentRecipe();
        this.setStack(OUTPUT_SLOT,new ItemStack(recipe.get().value().getResult().getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult().getCount()));

        this.removeStack(INPUT_SLOT,1);
    }

    private Optional<RecipeEntry<PolishMachineRecipe>> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inventory.setStack(i,this.getStack(i));
        }
        return getWorld().getServer().getRecipeManager().getFirstMatch(PolishMachineRecipe.Type.INSTANCE,
                new SingleStackRecipeInput(inventory.getStack(INPUT_SLOT)),getWorld());
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
//        ItemStack result = new ItemStack(ModItems.DEFAULT_HAMMER);
//        boolean hasInput = getStack(INPUT_SLOT).getItem() == Items.MACE;
//        return hasInput && canInsertAmountIntoSlot(result) && canInsertIntoSlot(result.getItem());
        Optional<RecipeEntry<PolishMachineRecipe>> recipe = getCurrentRecipe();
        recipe.ifPresent(polishMachineRecipeRecipeEntry -> this.maxProgress += polishMachineRecipeRecipeEntry.value().getMakeTime());
        return recipe.isPresent() && canInsertAmountIntoSlot(recipe.get().value().getResult()) &&
                canInsertIntoSlot(recipe.get().value().getResult().getItem());
    }

    private boolean canInsertIntoSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == item;
    }

    private boolean canInsertAmountIntoSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= this.getMaxCountPerStack();
    }

    private boolean isOutputSlotAvailable() {
       return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() <= this.getMaxCountPerStack();
    }
}
