package net.redstone233.morehammercraft.effects.potion;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BlueFireEffect extends StatusEffect {

    public BlueFireEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x00BFFF);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.isOnFire()) {
            entity.setOnFireFor(20 * (amplifier + 1));
            entity.setFireTicks(20 * (amplifier + 1));
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
