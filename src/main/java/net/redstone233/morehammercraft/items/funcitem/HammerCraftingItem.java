package net.redstone233.morehammercraft.items.funcitem;

import net.minecraft.item.Item;
import net.redstone233.morehammercraft.core.items.AbstractDurabilityItem;

public class HammerCraftingItem extends Item implements AbstractDurabilityItem {
    public HammerCraftingItem(Item.Settings settings) {
        super(settings.maxDamage(128));
    }
}
