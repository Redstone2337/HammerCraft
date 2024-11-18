package net.redstone233.morehammercraft.potions;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.effects.ModStatusEffects;

public class ModPotions {

    // public static final RegistryEntry<Potion> FIRE_ON_ONESELF = register(
            // "fire_on_oneself",new Potion("fire_on_oneself",new StatusEffectInstance(ModStatusEffects.DRAW_FIRE_ON_ONESELF,6000))
    // );
    // public static final RegistryEntry<Potion> FIRE_ON_TWOSELF = register(
            // "fire_on_twoself", new Potion("fire_on_twoself", new StatusEffectInstance(ModStatusEffects.DRAW_FIRE_ON_TWOSELF,6000))
    // );

    public static final RegistryEntry<Potion> FIRE_POTION = register("fire_on_oneself", 
        new Potion("fire", new StatusEffectInstance(ModStatusEffects.FIRE_STATUS_EFFECT,1600)));
    
    public static final RegistryEntry<Potion> GREAT_FIRE_POTION = register("great_fire_on_oneself", 
        new Potion("fire", new StatusEffectInstance(ModStatusEffects.FIRE_STATUS_EFFECT,1400,1)));

    public static final RegistryEntry<Potion> GOOD_FIRE_POTION = register("good_fire_on_oneself", 
        new Potion("fire", new StatusEffectInstance(ModStatusEffects.FIRE_STATUS_EFFECT,1200,2)));

    public static final RegistryEntry<Potion> BLUE_FIRE_POTION = register("blue_fire_on_oneself", 
        new Potion("blue_fire", new StatusEffectInstance(ModStatusEffects.BLUE_FIRE_STATUS_EFFECT,1600)));
    
    public static final RegistryEntry<Potion> GREAT_BLUE_FIRE_POTION = register("great_blue_fire_on_oneself", 
        new Potion("blue_fire", new StatusEffectInstance(ModStatusEffects.BLUE_FIRE_STATUS_EFFECT,1400,1)));

    public static final RegistryEntry<Potion> GOOD_BLUE_FIRE_POTION = register("good_blue_fire_on_oneself", 
        new Potion("blue_fire", new StatusEffectInstance(ModStatusEffects.BLUE_FIRE_STATUS_EFFECT,1200,2)));

    public static final RegistryEntry<Potion> EXP_POTION = register("experience", 
        new Potion("experience", new StatusEffectInstance(ModStatusEffects.EXP_EFFECT,2000)));

    public static final RegistryEntry<Potion> GOOD_EXP_POTION = register("good_experience", 
        new Potion("experience",new StatusEffectInstance(ModStatusEffects.EXP_EFFECT,1800,1)));

    public static final RegistryEntry<Potion> GREAT_EXP_POTION = register("great_experience", 
        new Potion("experience",new StatusEffectInstance(ModStatusEffects.EXP_EFFECT,1600,2)));

    public static final RegistryEntry<Potion> BETTER_EXP_POTION = register("better_experience", 
        new Potion("experience",new StatusEffectInstance(ModStatusEffects.EXP_EFFECT,1400,3)));

    public static final RegistryEntry<Potion> BEST_EXP_POTION = register("best_experience", 
        new Potion("experience",new StatusEffectInstance(ModStatusEffects.EXP_EFFECT,1200,4)));


    private static RegistryEntry<Potion> register(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(MoreHammerCraft.MOD_ID,name), potion);
    }

    public static void registerModPotions() {

    }
}
