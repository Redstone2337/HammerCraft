package net.redstone233.morehammercraft.effects.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.World;

import java.util.Random;

public class BlueFireEffect extends StatusEffect {

    public BlueFireEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x00BFFF);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
//        if (world.isClient()) {
//            if (!entity.isOnFire() && entity instanceof LivingEntity) {
//                entity.setOnFireFor(20 * (amplifier + 1));
//                entity.setFireTicks(20 * (amplifier + 1));
//                entity.setOnFire(true);
//                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER, 20 * (amplifier + 1),amplifier,true,false,false));
//            }
//        }
        if (!world.isClient()) {
            if (entity instanceof LivingEntity livingEntity) {
                if (!livingEntity.isOnFire()) {
                    livingEntity.setFireTicks(20 * (amplifier) + 1);
                    livingEntity.setFireTicks(20 * (amplifier) + 1);
                }
                if (entity instanceof PlayerEntity player) {
                    if (getRandom(1,10) >= 1 && getRandom(1,10) <= 9) {
                       player.sendMessage(Text.of(livingEntity.getName()+"这次很幸运，没有中招。"),true);
                    } else if (getRandom(1,10) == 10) {
                        player.sendMessage(Text.of("很遗憾，这次"+livingEntity.getName()+"中招了。"),true);
                        livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,300,amplifier,false,false,true));
                    }
                }
            }
        }
        return true;
    }

    private int getRandom(int min,int max) {
        Random random = new Random();
        return min  + random.nextInt(max);
    }

    // @Override
    // public void onApplied(LivingEntity entity, int amplifier) {
         // if (!entity.isOnFire()) {
             // entity.clearStatusEffects();
         // }
         // super.onApplied(entity, amplifier);
     // }

}
