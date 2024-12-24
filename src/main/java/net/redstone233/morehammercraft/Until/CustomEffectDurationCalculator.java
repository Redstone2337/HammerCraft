package net.redstone233.morehammercraft.Until;

/**
 * 自定义效果持续时间计算器
 */
public class CustomEffectDurationCalculator implements DurationCalculator {
    /**
     * 计算效果持续时间
     *
     * @param amplifier       效果等级
     * @param durationModifier 持续时间修正系数
     * @return 效果持续时间，单位为tick
     */
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
