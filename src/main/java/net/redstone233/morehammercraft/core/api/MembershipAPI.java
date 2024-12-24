package net.redstone233.morehammercraft.core.api;

import java.util.UUID;

/**
 * 会员管理接口，用于处理玩家的会员相关操作。
 */
public interface MembershipAPI {

    /**
     * 检查指定的玩家是否为会员。
     *
     * @param playerUUID 玩家的唯一标识符
     * @return 如果玩家是会员，则返回true；否则返回false
     */
    default boolean isMember(UUID playerUUID) {
        return false;
    }

    /**
     * 设置指定玩家的会员状态。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param isMember 会员状态，true表示是会员，false表示不是
     */
    void setMember(UUID playerUUID, boolean isMember);

    /**
     * 获取当前所有会员的列表。
     *
     * @return 包含所有会员UUID的数组
     */
    UUID[] getMemberList();

    /**
     * 获取指定会员的经验值。
     *
     * @param playerUUID 玩家的唯一标识符
     * @return 当前会员的经验值
     */
    int getMemberExperience(UUID playerUUID);

    /**
     * 向指定会员增加经验值。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param amount 要增加的经验值数量
     */
    void addMemberExperience(UUID playerUUID, int amount);
       /**
     * 获取指定会员的等级。
     *
     * @param playerUUID 玩家的唯一标识符
     * @return 当前会员的等级
     */
    int getMemberLevel(UUID playerUUID);
    /**
     * 向指定会员增加等级。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param amount 要增加的等级数量
     */
    void addMemberLevel(UUID playerUUID, int amount);

    /**
     * 检查指定的玩家是否为VIP。
     *
     * @param playerUUID 玩家的唯一标识符
     * @return 如果玩家是VIP，则返回true；否则返回false
     */
    default boolean isVIP(UUID playerUUID) {
        return false;
    }
    /**
     * 设置指定玩家的VIP状态。
     *
     * @param playerUUID 玩家的唯一标识符
     * @param isVIP VIP状态，true表示是VIP，false表示不是
     */
    default void setVIP(UUID playerUUID, boolean isVIP) {
    }
}




