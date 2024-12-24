package net.redstone233.morehammercraft.core.until;

import java.util.HashMap;
import java.util.UUID;

import java.util.HashMap;
import java.util.UUID;

public class MembershipManager {
    private static final HashMap<UUID, Integer> playerExperience = new HashMap<>();
    private static final HashMap<UUID, Integer> playerMembershipLevels = new HashMap<>();

    // 当前等级所需的经验初始值
    private static final int INITIAL_COST = 100;

    public void addExperience(UUID playerUUID, int amount) {
        int currentExperience = playerExperience.getOrDefault(playerUUID, 0);
        playerExperience.put(playerUUID, currentExperience + amount);

        // 检查并提升会员等级
        updateMembershipLevel(playerUUID);
    }

    private void updateMembershipLevel(UUID playerUUID) {
        int experience = playerExperience.get(playerUUID);

        // 计算需要的经验，每个等级的经验是上一个等级的 20 倍
        int requiredExperience = INITIAL_COST;
        int level = 0;

        // 更新会员等级
        while (experience >= requiredExperience) {
            level++;
            experience -= requiredExperience;
            requiredExperience *= 20; // 下一等级所需经验是当前的 20 倍
        }

        playerMembershipLevels.put(playerUUID, level);
    }

    public int getMembershipLevel(UUID playerUUID) {
        return playerMembershipLevels.getOrDefault(playerUUID, 0);
    }

    public int getExperience(UUID playerUUID) {
        return playerExperience.getOrDefault(playerUUID, 0);
    }
}


