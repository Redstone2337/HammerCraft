package net.redstone233.morehammercraft.core.chat;

import net.minecraft.entity.player.PlayerEntity;
import net.redstone233.morehammercraft.core.api.MembershipAPI;

import java.util.Arrays;
import java.util.UUID;

public class MembershipSystem implements MembershipAPI {
    private static boolean isMembers;
    private static int memberExperience = 0;
    private static int memberLevel = 0;
    private static UUID[] memberLists;
    private static PlayerEntity player;

    public static boolean isIsMember() {
        return isMembers;
    }

    public static void setMemberLists(UUID[] memberLists) {
        MembershipSystem.memberLists = memberLists;
    }

    public static void addMemberLists(UUID playerUUID) {
        memberLists = Arrays.copyOf(memberLists, memberLists.length + 1);
        memberLists[memberLists.length - 1] = playerUUID;
    }

    public static void setPlayer(PlayerEntity player) {
        MembershipSystem.player = player;
    }

    @Override
    public void setMember(UUID playerUUID, boolean isMember) {
        isMembers = isMember;
    }

    @Override
    public UUID[] getMemberList() {
//        return new UUID[0];
        return memberLists;
    }

    @Override
    public int getMemberExperience(UUID playerUUID) {
        return memberExperience;
    }

    @Override
    public void addMemberExperience(UUID playerUUID, int amount) {
        memberExperience += amount;
    }

    @Override
    public int getMemberLevel(UUID playerUUID) {
        return memberLevel;
    }

    @Override
    public void addMemberLevel(UUID playerUUID, int amount) {
         memberLevel += amount;
    }

    public static void setMemberExperience(int amount) {
        memberExperience = amount;
    }

    public static void init() {
        MembershipSystem.addMemberLists(player.getUuid());;
        isMembers = true;
    }
}
