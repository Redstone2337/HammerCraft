package net.redstone233.morehammercraft.tags;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;

public class ModItemTags {

    public static final TagKey<Item> TEMPLATE_LIST = of("template_list");
    public static final TagKey<Item> HAMMER_LIST = of("hammer_list");
    public static final TagKey<Item> INGOT_LIST = of("ingot_list");
    public static final TagKey<Item> FUNCTION_LIST = of("function_list");
    public static final TagKey<Item> SICKLE_LIST = of("sickle_list");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(MoreHammerCraft.MOD_ID,id));
    }

    public static void registerModItemTags() {
        MoreHammerCraft.LOGGER.info("Registering mod item tags");
    }
}
