package net.redstone233.morehammercraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;

import java.util.function.Function;

public class ModBlocks {

    public static final Block POLISH_MACHINE = register("conversion_table",PolishMachine::new,
            AbstractBlock.Settings.create().strength(5.0f,4.5f));

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(MoreHammerCraft.MOD_ID,id));
        final Block block = Blocks.register(registryKey,factory,settings);
        Items.register(block);
        return block;
    }

    public static void register() {

    }
}
