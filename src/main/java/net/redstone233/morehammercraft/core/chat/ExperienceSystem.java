package net.redstone233.morehammercraft.core.chat;

import net.minecraft.entity.player.PlayerEntity;
import net.redstone233.morehammercraft.core.api.ExperienceAPI;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class ExperienceSystem implements ExperienceAPI {
    private static int experience = 0;
    private static int level = 0;
    private static int taskCount = 0;
    private static int taskReward = 0;
    private static String taskNames = "";
    private static String[] taskNamesArrays;
    @Nullable
    private static PlayerEntity player;
    @Nullable
    private static UUID playerUUID;

    private static void initializePlayerUUID() {
        if (player != null) {
            playerUUID = player.getUuid();
        } else {
            // 处理 player 为 null 的情况，比如赋予默认值或抛出异常
            playerUUID = UUID.randomUUID(); // 或者根据你的逻辑处理
        }
    }

    public static @Nullable UUID getPlayerUUID() {
        return playerUUID;
    }

    public static void setPlayer(@Nullable PlayerEntity player) {
        ExperienceSystem.player = player;
    }

    public static int getTaskReward() {
        return taskReward;
    }

    public static int getTaskCount() {
        return taskCount;
    }

    public static String[] getTaskNamesArray() {
        return taskNamesArrays;
    }

    @Override
    public boolean hasCompletedTask(UUID playerUUID, String taskName) {
//        return ExperienceAPI.super.hasCompletedTask(playerUUID, taskName);
        initializePlayerUUID();
        taskNamesArrays = taskNames.split(",");
        for (String name : taskNamesArrays) {
            if (name.equals(taskName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getExperience(UUID playerUUID) {
        return experience;
    }

    @Override
    public void addExperience(UUID playerUUID, int amount) {
        experience += amount;
    }

    @Override
    public void removeExperience(UUID playerUUID, int amount) {
        experience -= amount;
    }

    @Override
    public void setExperience(UUID playerUUID, int amount) {
        experience = amount;
    }

    @Override
    public int getLevel(UUID playerUUID) {
        return level;
    }

    @Override
    public void setLevel(UUID playerUUID, int level) {
        ExperienceSystem.level = level;
    }

    @Override
    public void completeTask(UUID playerUUID, String taskName, int reward) {;
        taskNames += taskName + ",";
        taskReward = reward;
        taskCount++;
    }

    public static void init() {
        // 注册监听器，监听玩家经验值变化，并更新系统数据
    }
}
