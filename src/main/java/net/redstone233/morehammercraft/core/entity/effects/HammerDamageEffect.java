package net.redstone233.morehammercraft.core.entity.effects;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.RecordBuilder;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.items.funcitem.DefaultHammer;

public record HammerDamageEffect(int damage, EnchantmentLevelBasedValue level) implements EnchantmentEntityEffect {
    public static final MapCodec<HammerDamageEffect> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.INT.fieldOf("damage").forGetter(HammerDamageEffect::damage),
                    EnchantmentLevelBasedValue.CODEC.fieldOf("level").forGetter(HammerDamageEffect::level)
            ).apply(instance, HammerDamageEffect::new));

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (!(user instanceof PlayerEntity player)) return;
        if (level <= 0) {
           player.sendMessage(Text.of("§cYou don't have enough experience to use this enchantment."), true);
            MoreHammerCraft.LOGGER.warn("Player {} tried to use HammerDamageEffect with level {} but has not enough experience.", player.getName(), level);
        } else if (level > 3) {
            player.sendMessage(Text.of("§cYou have too much experience to use this enchantment."), true);
            MoreHammerCraft.LOGGER.warn("Player {} tried to use HammerDamageEffect with level {} but has too much experience.", player.getName(), level);
        } else {
            DefaultHammer.setAttackDamageModifierValue(damage * level);
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
