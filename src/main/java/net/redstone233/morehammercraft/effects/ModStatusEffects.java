package net.redstone233.morehammercraft.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.effects.potion.*;
import net.redstone233.morehammercraft.Until.CustomEffectDurationCalculator;

public class ModStatusEffects {

    //public static final RegistryEntry<StatusEffect> DRAW_FIRE_ON_ONESELF = register("fire_on_oneself",new FireEffects(new CustomEffectDurationCalculator()));
    //public static final RegistryEntry<StatusEffect> DRAW_FIRE_ON_TWOSELF = register("fire_on_twoself",new TwoFireEffects(new CustomEffectDurationCalculator()))

    public static final RegistryEntry<StatusEffect> FIRE_STATUS_EFFECT = register("fire", new FireEffect());
    //public static final RegistryEntry<StatusEffect> GREAT_FIRE_STATUS = register("great_fire_on_oneself",new GreatFireEffect());
    //public static final RegistryEntry<StatusEffect> GOOD_FIRE_STATUS = register("good_fire_on_oneself", new GoodFireEffect());
    
    public static final RegistryEntry<StatusEffect> BLUE_FIRE_STATUS_EFFECT = register("blue_fire", new BlueFireEffect());
    //public static final RegistryEntry<StatusEffect> GREAT_BLUE_FIRE_STATUS = register("blue_great_fire_on_oneself",new GreatBlueFireEffect());
    //public static final RegistryEntry<StatusEffect> GOOD_BLUE_FIRE_STATUS = register("blue_good_fire_on_oneself", new GoodBlueFireEffect());

    public static final RegistryEntry<StatusEffect> EXP_EFFECT = register("experience",  new ExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    //public static final RegistryEntry<StatusEffect> GOOD_EXP_EFFECT = register("good_experience",  new GoodExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    //public static final RegistryEntry<StatusEffect> GREAT_EXP_EFFECT = register("great_experience",  new GreatExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    //public static final RegistryEntry<StatusEffect> BETTER_EXP_EFFECT = register("better_experience",  new BetterExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));
    //public static final RegistryEntry<StatusEffect> BEST_EXP_EFFECT = register("best_experience",  new BestExpEffect(StatusEffectCategory.BENEFICIAL,0x98D982));

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MoreHammerCraft.MOD_ID,id), statusEffect);
    }

    public static void registerStatusEffects() {

    }
}
;