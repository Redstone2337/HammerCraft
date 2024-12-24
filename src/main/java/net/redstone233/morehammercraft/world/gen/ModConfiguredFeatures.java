package net.redstone233.morehammercraft.world.gen;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.blocks.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> RUBY_ORE_OVERWORLD = of("ruby_ore_overworld");
    public static final RegistryKey<ConfiguredFeature<?,?>> RUBY_ORE_NETHER = of("ruby_ore_nether");
    public static final RegistryKey<ConfiguredFeature<?,?>> RUBY_ORE_END = of("ruby_ore_end");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        RuleTest stoneReplace = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplace = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplace = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplace = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldTargets = List.of(
                OreFeatureConfig.createTarget(stoneReplace, ModBlocks.RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(deepslateReplace, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherTargets = List.of(
                OreFeatureConfig.createTarget(netherReplace, ModBlocks.RUBY_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endTargets = List.of(
                OreFeatureConfig.createTarget(endReplace, ModBlocks.RUBY_ORE.getDefaultState()));
        register(featureRegisterable, RUBY_ORE_OVERWORLD, Feature.ORE, new OreFeatureConfig(overworldTargets, 8));
        register(featureRegisterable, RUBY_ORE_NETHER, Feature.ORE, new OreFeatureConfig(netherTargets, 8));
        register(featureRegisterable, RUBY_ORE_END, Feature.ORE, new OreFeatureConfig(endTargets, 8));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MoreHammerCraft.MOD_ID, id));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC config
    ) {
        registerable.register(key, new ConfiguredFeature<FC, F>(feature, config));
    }
}
