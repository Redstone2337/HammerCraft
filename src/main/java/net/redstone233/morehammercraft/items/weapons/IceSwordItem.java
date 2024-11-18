package net.redstone233.morehammercraft.items.weapons;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IceSwordItem extends SwordItem {
    private static final Map<BlockPos, Long> iceBlockTimer = new HashMap<>();

    public IceSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

//    public IceSwordItem(ToolMaterial toolMaterial, Settings settings) {
//        super(toolMaterial, settings);
//    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof MobEntity mob && attacker instanceof PlayerEntity player) {
            spawnFrostBlocks(mob);
            spawnSnowflakeParticles(mob);
            mob.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,500,255,true,false,true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH,200,5,true,false,true));
        } else if (Screen.hasShiftDown() && target instanceof MobEntity mob) {
            BlockPos pos = mob.getBlockPos().add(0, 0, 0);
            mob.teleport(pos.getX(),pos.getY(),pos.getZ(),false);
        }
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,200,4,false,false,true));
        }
        //tick(user.getWorld());
        return ActionResult.SUCCESS;
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1,attacker, EquipmentSlot.MAINHAND);
        stack.damage(1,attacker,EquipmentSlot.OFFHAND);

    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (!Screen.hasAltDown()) {
            tooltip.add(Text.translatable("item.mhc.prospector.tooltip"));
        } else {
            tooltip.add(Text.translatable("item.mhc.ice_sword.alt.tooltip"));
        }
        tooltip.add(Text.translatable("item.mhc.ice_dragon_sword.shift"));
        super.appendTooltip(stack, context, tooltip, type);
    }

    private void spawnFrostBlocks(LivingEntity entity) {
        World world = entity.getWorld();
        if (world.isClient) return; // 确保在服务器端执行

        BlockPos pos = entity.getBlockPos(); // 获取实体的位置

        // 在末影人脚底下、头顶上以及中间的位置各放置一个冰块
        BlockPos[] positions = {
                pos.down(1), // 脚底下
                pos.up(2), // 头顶上
                pos.up(1),  // 中间
                pos.up(0)
        };

        for (BlockPos blockPos : positions) {
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(Blocks.AIR) || blockState.isOf(Blocks.WATER) || blockState.isOf(Blocks.LAVA)) {
                world.setBlockState(blockPos, Blocks.PACKED_ICE.getDefaultState());
                iceBlockTimer.put(blockPos, System.currentTimeMillis() + 10000); // 设置10秒后消失
            }
        }
    }

    // 定时检查并移除冰块
    public static void tick(World world) {
        long currentTime = System.currentTimeMillis();
        for (Map.Entry<BlockPos, Long> entry : iceBlockTimer.entrySet()) {
            if (currentTime >= entry.getValue()) {
                world.setBlockState(entry.getKey(), Blocks.AIR.getDefaultState()); // 将冰块变为空气
                iceBlockTimer.remove(entry.getKey());
            }
        }
    }
    private void spawnSnowflakeParticles(LivingEntity entity) {
        World world = entity.getWorld();
        if (!(world instanceof ServerWorld serverWorld)) return; // 确保在服务器世界中执行
        BlockPos pos = entity.getBlockPos().add(0, -1, 0); // 获取实体脚底下的位置

        // 生成粒子效果
        serverWorld.spawnParticles(ParticleTypes.DRIPPING_WATER, pos.getX(), pos.getY(), pos.getZ(), 10, 0.5, 0.5, 0.5, 0.15);
    }
}
