package net.redstone233.morehammercraft.core.events;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.redstone233.morehammercraft.core.until.MembershipManager;

import java.util.UUID;

public class TradeEventListener {
    private final MembershipManager membershipManager;

    public TradeEventListener(MembershipManager membershipManager) {
        this.membershipManager = membershipManager;

        UseItemCallback.EVENT.register((player, world, hand) -> {
            if (!world.isClient && player instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                // 检查玩家与村民交易的物品
                if (isTradingEmerald(serverPlayer)) {
                    // 增加经验
                    UUID playerUUID = serverPlayer.getUuid();
                    membershipManager.addExperience(playerUUID, 100);

                    // 提醒玩家
                    serverPlayer.sendMessage(Text.of("你获得了"+membershipManager.getExperience(playerUUID)+"会员经验，当前会员等级为: " + membershipManager.getMembershipLevel(playerUUID)), false);
                }
            }
            return ActionResult.PASS;
        });
    }

    private boolean isTradingEmerald(ServerPlayerEntity player) {
        return player.getMainHandStack().isOf(Items.EMERALD);
        // 这里可以添加检查玩家最近的交易是否涉及到绿宝石的逻辑
        // 由于交易的具体实现较复杂，这里仅做示例
        // 你需要添加实际逻辑来判断玩家是否与村民成功交易绿宝石
//        return true; // 这里默认返回 true，请根据实际逻辑进行修改
    }
}

