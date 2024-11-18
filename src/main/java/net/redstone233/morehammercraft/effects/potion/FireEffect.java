package net.redstone233.morehammercraft.effects.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class FireEffect extends StatusEffect {

    public FireEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xFF8247);
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
//            }
//        }
        if (entity instanceof LivingEntity livingEntity) {
            if (!livingEntity.isOnFire()) {
                livingEntity.setOnFireFor(20.0f * (amplifier) + 1);
                livingEntity.setFireTicks(20 * (amplifier) + 1);
            }
        }
        return true;
    }

     // @Override
     // public void onApplied(LivingEntity entity, int amplifier) {
         // if (!entity.isOnFire()) {
             // entity.clearStatusEffects();
         // }
         // super.onApplied(entity, amplifier);
     // }

}
