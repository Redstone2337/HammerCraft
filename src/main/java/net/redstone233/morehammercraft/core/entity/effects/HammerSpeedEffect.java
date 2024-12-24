package net.redstone233.morehammercraft.core.entity.effects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.items.funcitem.DefaultHammer;

public record HammerSpeedEffect(float speed, EnchantmentLevelBasedValue level) implements EnchantmentEntityEffect {
    public static final MapCodec<HammerSpeedEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.FLOAT.fieldOf("speed").forGetter(HammerSpeedEffect::speed),
                    EnchantmentLevelBasedValue.CODEC.fieldOf("level").forGetter(HammerSpeedEffect::level)
            ).apply(instance, HammerSpeedEffect::new));


    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (!(user instanceof PlayerEntity player)) return;
        if (level > 3) {
            player.sendMessage(Text.of("§cYou can't use this enchantment on a hammer with more than 3 levels."), true);
            MoreHammerCraft.LOGGER.warn("Player {} tried to use a hammer with more than 3 levels.", player.getName());
        } else if (level <= 0) {
            player.sendMessage(Text.of("§cYou can't use this enchantment on a hammer with 0 levels."), true);
            MoreHammerCraft.LOGGER.warn("Player {} tried to use a hammer with 0 levels.", player.getName());
        } else {
            DefaultHammer.setAttackSpeedModifierValue(speed * level);
        }
    }
        @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
