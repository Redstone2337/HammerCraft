package net.redstone233.morehammercraft.core.until;

import net.minecraft.item.ItemStack;

public class SmithingRemainderHandler {
    public static final ThreadLocal<ItemStack> REMAINDER_STACK = new ThreadLocal<>();
}
