package net.redstone233.morehammercraft.Until;

public class CustomEffectDurationCalculator implements DurationCalculator {
    @Override
    public int calculateDuration(int amplifier, float durationModifier) {
        if (amplifier > 255) {
            amplifier = 255; // 确保等级不会超过255
        }
        int duration = 200; // 基础持续时间，单位为tick
        for (int i = 0; i < amplifier; i++) {
            duration = (int) (duration * 1.5);
        }
        return (int) (duration * durationModifier);
    }
}
