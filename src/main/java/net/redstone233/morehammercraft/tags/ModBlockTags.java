package net.redstone233.morehammercraft.tags;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;

public class ModBlockTags {

    public static final TagKey<Block> ORE_LIST = of("ore_list");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoreHammerCraft.MOD_ID,id));
    }

    public static void registerModBlockTags(){

    }
}
