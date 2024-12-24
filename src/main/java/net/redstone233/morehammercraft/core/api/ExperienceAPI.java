package net.redstone233.morehammercraft.core.api;

import java.util.UUID;

/**
 * 经验管理接口，用于处理玩家的经验和任务相关操作。
 */
public interface ExperienceAPI {

    /**
     * 获取指定玩家的当前经验值。
     *
     * @param playerUUID 玩家的唯一标识符
     * @return 当前经验值
     */
    int getExperience(UUID playerUUID);

    /**
     * 向指定玩家增加经验值。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param amount 要增加的经验值数量
     */
    void addExperience(UUID playerUUID, int amount);

    /**
     * 从指定玩家移除经验值。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param amount 要移除的经验值数量
     */
    void removeExperience(UUID playerUUID, int amount);

    /**
     * 设置指定玩家的经验值。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param amount 要设置的经验值数量
     */
    void setExperience(UUID playerUUID, int amount);

    /**
     * 获取指定玩家的经验等级。
     *
     * @param playerUUID 玩家的唯一标识符
     * @return 当前经验等级
     */
    int getLevel(UUID playerUUID);

    /**
     * 设置指定玩家的经验等级。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param level 要设置的经验等级
     */
    void setLevel(UUID playerUUID, int level);

    /**
     * 新增任务给指定玩家并根据成功完成的任务给予经验值奖励。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param taskName 任务名称
     * @param reward 任务完成后奖励的经验值
     */
    void completeTask(UUID playerUUID, String taskName, int reward);

    /**
     * 检查指定玩家是否完成了某个任务。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param taskName 任务名称
     * @return 如果玩家完成了任务，则返回true；否则返回false
     */
    default boolean hasCompletedTask(UUID playerUUID, String taskName) {
        // 默认实现返回false，如果需要具体逻辑，需在实现类中覆盖
        return false;
    }
}



