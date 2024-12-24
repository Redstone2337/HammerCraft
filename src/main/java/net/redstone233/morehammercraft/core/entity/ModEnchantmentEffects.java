package net.redstone233.morehammercraft.core.entity;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.core.entity.effects.HammerDamageEffect;
import net.redstone233.morehammercraft.core.entity.effects.HammerSpeedEffect;
import net.redstone233.morehammercraft.core.entity.effects.VampireEntityEffect;

public class ModEnchantmentEffects {

    private static void registerEnchantmentEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        //TODO: Implement enchantment effects
        Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(MoreHammerCraft.MOD_ID, name),codec);
    }

    public static void register() {
        //TODO: Implement enchantment effects
        registerEnchantmentEffect("vampire", VampireEntityEffect.CODEC);
        registerEnchantmentEffect("hammer_speed", HammerSpeedEffect.CODEC);
        registerEnchantmentEffect("hammer_damage", HammerDamageEffect.CODEC);
        MoreHammerCraft.LOGGER.info("Registered enchantment effects for More Hammer Craft successfully.");
    }
}
