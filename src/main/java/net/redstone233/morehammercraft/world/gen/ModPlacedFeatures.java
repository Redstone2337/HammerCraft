package net.redstone233.morehammercraft.world.gen;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.core.worlds.ModOrePlacedFeatures;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> OVERWORLD_RUBY_ORE_KEY = of("overworld_ruby_ore");
    public static final RegistryKey<PlacedFeature> NETHER_RUBY_ORE_KEY = of("nether_ruby_ore");
    public static final RegistryKey<PlacedFeature> END_RUBY_ORE_KEY = of("overworld_emerald_ore");

    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MoreHammerCraft.MOD_ID, id));
    }

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        RegistryEntryLookup<ConfiguredFeature<?,?>> featureRegistry = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        register(featureRegisterable, OVERWORLD_RUBY_ORE_KEY, featureRegistry.getOrThrow(ModConfiguredFeatures.RUBY_ORE_OVERWORLD),
               ModOrePlacedFeatures.modifiersWithCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(featureRegisterable, NETHER_RUBY_ORE_KEY, featureRegistry.getOrThrow(ModConfiguredFeatures.RUBY_ORE_NETHER),
               ModOrePlacedFeatures.modifiersWithCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(featureRegisterable, END_RUBY_ORE_KEY, featureRegistry.getOrThrow(ModConfiguredFeatures.RUBY_ORE_END),
               ModOrePlacedFeatures.modifiersWithCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
    }

    public static void register(
            Registerable<PlacedFeature> featureRegisterable,
            RegistryKey<PlacedFeature> key,
            RegistryEntry<ConfiguredFeature<?, ?>> feature,
            List<PlacementModifier> modifiers
    ) {
        featureRegisterable.register(key, new PlacedFeature(feature, List.copyOf(modifiers)));
    }
}
