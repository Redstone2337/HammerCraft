package net.redstone233.morehammercraft.core.entity.effects;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;

public record VampireEntityEffect(EnchantmentLevelBasedValue health) implements EnchantmentEntityEffect {
    public static final MapCodec<VampireEntityEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
            EnchantmentLevelBasedValue.CODEC.fieldOf("health").forGetter(VampireEntityEffect::health)
    ).apply(instance, VampireEntityEffect::new));

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (!(user instanceof LivingEntity livingEntity)) return;
        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20,0, false, false,false));
        livingEntity.heal(health.getValue(level));
        Random random = world.getRandom();
        double x = random.nextGaussian() * 0.02;
        double y = random.nextGaussian() * 0.02;
        double z = random.nextGaussian() * 0.02;
       world.spawnParticles(ParticleTypes.HEART, user.getParticleX(1.0), user.getRandomBodyY(), user.getParticleZ(1.0), 1, x, y, z, 0.0);
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
