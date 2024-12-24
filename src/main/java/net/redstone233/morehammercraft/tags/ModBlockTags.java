package net.redstone233.morehammercraft.tags;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;

public class ModBlockTags {

    public static final TagKey<Block> ORE_LIST = of("ore_list");
    public static final TagKey<Block> BLOCK_LIST = of("mod_block_list");
    public static final TagKey<Block> RUBY_ORES = of("ruby_ores");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoreHammerCraft.MOD_ID,id));
    }

    public static void registerModBlockTags(){
        MoreHammerCraft.LOGGER.info("Registering ModBlockTags");
    }
}
