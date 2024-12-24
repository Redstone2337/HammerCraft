package net.redstone233.morehammercraft.Until;

/**
 * Created by Redstone233 on 12/10/2019.
 */
public interface DurationCalculator {
    /**
     * 计算持续时间
     * @param amplifier 强度等级
     * @param durationModifier 持续时间加成
     * @return 持续时间（秒）
     */
    int calculateDuration(int amplifier, float durationModifier);
}
