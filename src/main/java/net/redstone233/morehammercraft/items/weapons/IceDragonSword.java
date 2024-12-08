package net.redstone233.morehammercraft.items.weapons;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class IceDragonSword extends SwordItem {
    private static final Map<BlockPos, Long> iceBlockTimer = new HashMap<>();

    public IceDragonSword(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

//    public IceDragonSword(ToolMaterial toolMaterial, Settings settings) {
//        super(toolMaterial, settings);
//    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof MobEntity mob && attacker instanceof PlayerEntity player) {
            spawnFrostBlocks(mob);
            spawnSnowflakeParticles(mob);
            mob.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,600,255,true,false,true));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,200,4,true,false,true));
        } else if (!Screen.hasShiftDown() && attacker instanceof PlayerEntity player) {
            BlockPos pos = target.getBlockPos().add(0, 0, 0);
            target.teleport(pos.getX(),pos.getY(),pos.getZ(),false);
            knockbackNearbyEntities(player.getWorld(),player,target);
        }
        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,200,4,false,false,true));
            if (!entity.isOnFire()) {
                entity.setOnFireFor(200.0f);
            }
        } else if (entity instanceof MobEntity mob) {
            mob.setOnFireFor(200.0f);
            //mob.setOnFireForTicks(200);
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
        super.appendTooltip(stack, context, tooltip, type);
        if (!Screen.hasAltDown()) {
            tooltip.add(Text.translatable("item.mhc.prospector.tooltip"));
        } else {
            tooltip.add(Text.translatable("item.mhc.ice_dragon_sword.alt.tooltip"));
        }
        tooltip.add(Text.translatable("item.mhc.ice_dragon_sword.shift"));
    }

    private static void knockbackNearbyEntities(World world, Entity attacker, Entity attacked) {
        world.syncWorldEvent(2013, attacked.getSteppingPos(), 750);
        world.getEntitiesByClass(LivingEntity.class, attacked.getBoundingBox().expand(3.5), getKnockbackPredicate(attacker, attacked)).forEach((entity) -> {
            Vec3d vec3d = entity.getPos().subtract(attacked.getPos());
            double d = getKnockback(attacker, entity, vec3d);
            Vec3d vec3d2 = vec3d.normalize().multiply(d);
            if (d > 0.0) {
                entity.addVelocity(vec3d2.x, 0.699999988079071, vec3d2.z);
                if (entity instanceof ServerPlayerEntity) {
                    ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity)entity;
                    serverPlayerEntity.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayerEntity));
                }
            }

        });
    }

    private static Predicate<LivingEntity> getKnockbackPredicate(Entity attacker, Entity attacked) {
        return (entity) -> {
            boolean var10000;
            boolean bl;
            boolean bl2;
            boolean bl3;
            label62: {
                bl = !entity.isSpectator();
                bl2 = entity != attacker && entity != attacked;
                bl3 = !attacker.isTeammate(entity);
                if (entity instanceof TameableEntity tameableEntity) {
                    if (tameableEntity.isTamed() && attacker.getUuid().equals(tameableEntity.getOwnerUuid())) {
                        var10000 = true;
                        break label62;
                    }
                }

                var10000 = false;
            }

            boolean bl4;
            label55: {
                bl4 = !var10000;
                if (entity instanceof ArmorStandEntity armorStandEntity) {
                    if (armorStandEntity.isMarker()) {
                        var10000 = false;
                        break label55;
                    }
                }

                var10000 = true;
            }

            boolean bl5 = var10000;
            boolean bl6 = attacked.squaredDistanceTo(entity) <= Math.pow(3.5, 2.0);
            return bl && bl2 && bl3 && bl4 && bl5 && bl6;
        };
    }

    private static double getKnockback(Entity attacker, LivingEntity attacked, Vec3d distance) {
        return (3.5 - distance.length()) * 0.699999988079071 * (double)(attacker.fallDistance > 5.0F ? 2 : 1) * (1.0 - attacked.getAttributeValue(EntityAttributes.KNOCKBACK_RESISTANCE));
    }

    private void spawnFrostBlocks(LivingEntity entity) {
        World world = entity.getWorld();
        if (world.isClient) return; // 确保在服务器端执行

        BlockPos pos = entity.getBlockPos(); // 获取实体的位置

        // 在末影人脚底下、头顶上以及中间的位置各放置一个冰块
        BlockPos[] positions = {
                pos.down(0), // 脚底下
                pos.up(2), // 头顶上
                pos.up(1),// 中间
                pos.up(0)
        };

        for (BlockPos blockPos : positions) {
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.isOf(Blocks.AIR) || blockState.isOf(Blocks.WATER) || blockState.isOf(Blocks.LAVA)) {
                world.setBlockState(blockPos, Blocks.PACKED_ICE.getDefaultState());
                //iceBlockTimer.put(blockPos, System.currentTimeMillis() + 10000); // 设置10秒后消失
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
        //entity.teleport(pos.getX(),0.0d, pos.getZ(),false);
        // 生成粒子效果
        serverWorld.spawnParticles(ParticleTypes.DRIPPING_WATER, pos.getX(), pos.getY(), pos.getZ(), 10, 0.5, 0.5, 0.5, 0.15);
    }
}
