package net.redstone233.morehammercraft.blocks;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.stream.Stream;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.<Block, BlockFamily>newHashMap();

    public static final BlockFamily HAMMER_FAMILY = register(ModBlocks.RUBY_BLOCK)
            .stairs(ModBlocks.RUBY_STAIRS)
            .slab(ModBlocks.RUBY_SLAB)
            .button(ModBlocks.RUBY_BUTTON)
            .pressurePlate(ModBlocks.RUBY_PRESSURE_PLATE)
            .fence(ModBlocks.RUBY_FENCE)
            .fenceGate(ModBlocks.RUBY_FENCE_GATE)
            .wall(ModBlocks.RUBY_WALL)
            .door(ModBlocks.RUBY_DOOR)
            .trapdoor(ModBlocks.RUBY_TRAPDOOR)
            .unlockCriterionName("has_ruby_block")
            .build();

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = (BlockFamily)BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }
}
