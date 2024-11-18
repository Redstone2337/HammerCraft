package net.redstone233.morehammercraft.items.funcitem;

import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Predicate;

public class DragonClawItem extends Item {
    private static final int ATTACK_DAMAGE_MODIFIER_VALUE = 5;
    private static final float ATTACK_SPEED_MODIFIER_VALUE = -1.5F;
    private static final float MINING_SPEED_MULTIPLIER = 1.0F;

    public DragonClawItem(Settings settings) {
        super(settings);
    }

//    public static AttributeModifiersComponent createAttributeModifiers() {
//        return AttributeModifiersComponent.builder()
//                .add(
//                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
//                        new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, ATTACK_DAMAGE_MODIFIER_VALUE, EntityAttributeModifier.Operation.ADD_VALUE),
//                        AttributeModifierSlot.MAINHAND
//                )
//                .add(
//                        EntityAttributes.GENERIC_ATTACK_SPEED,
//                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, ATTACK_SPEED_MODIFIER_VALUE*MINING_SPEED_MULTIPLIER, EntityAttributeModifier.Operation.ADD_VALUE),
//                        AttributeModifierSlot.MAINHAND
//                )
//                .build();
//    }
//
//    public static ToolComponent createToolComponent() {
//        return new ToolComponent(List.of(), ATTACK_SPEED_MODIFIER_VALUE*MINING_SPEED_MULTIPLIER, 2);
//    }
//
//    @Override
//    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        ServerWorld serverWorld = (ServerWorld)attacker.getWorld();
//        if (attacker instanceof PlayerEntity){
//           // target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,200,1,false,false,false));
//           // target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,200,0,false,false,false));
//            if (attacker.getMainHandStack().getItem() == this) {
//                target.setOnFireFor(200F);
//                spawnLavaSplashParticles(serverWorld,target);
//            }
//            knockbackNearbyEntities((World) serverWorld, (PlayerEntity) attacker,target);
//        }
//        return true;
//    }
//
//    @Override
//    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
//        if (user != null && hand == Hand.MAIN_HAND){
//            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,10,1,true,true,true));
//            return ActionResult.SUCCESS;
//        }
//        return super.useOnEntity(stack, user, entity, hand);
//    }
//
//    @Override
//    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
//        return !miner.isCreative();
//    }
//
//    @Override
//    public int getEnchantability() {
//        return 15;
//    }
//
//    private static void knockbackNearbyEntities(World world, PlayerEntity player, Entity attacked) {
//        world.syncWorldEvent(WorldEvents.SMASH_ATTACK, attacked.getSteppingPos(), 750);
//        world.getEntitiesByClass(LivingEntity.class, attacked.getBoundingBox().expand(3.5), getKnockbackPredicate(player, attacked)).forEach(entity -> {
//            Vec3d vec3d = entity.getPos().subtract(attacked.getPos());
//            double d = getKnockback(player, entity, vec3d);
//            Vec3d vec3d2 = vec3d.normalize().multiply(d);
//            if (d > 0.0) {
//                entity.addVelocity(vec3d2.x, 0.7F, vec3d2.z);
//                if (entity instanceof ServerPlayerEntity serverPlayerEntity) {
//                    serverPlayerEntity.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(serverPlayerEntity));
//                }
//            }
//        });
//    }
//
//    @Override
//    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
//        if (damageSource.getSource() instanceof LivingEntity livingEntity) {
//            if (!shouldDealAdditionalDamage(livingEntity)) {
//                return 0.0F;
//            } else {
//                float h = livingEntity.fallDistance;
//                if (h >= 1.0f) {
//                    return (float) (ATTACK_DAMAGE_MODIFIER_VALUE * 1.5);
//                }
//            }
//        } else {
//            return 0.0f;
//        }
//        return ATTACK_DAMAGE_MODIFIER_VALUE;
//    }
//
//    @Override
//    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
//        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
//        if (shouldDealAdditionalDamage(attacker)) {
//            attacker.onLanding();
//        }
//    }
//
//    private static Predicate<LivingEntity> getKnockbackPredicate(PlayerEntity player, Entity attacked) {
//        return entity -> {
//            boolean bl;
//            boolean bl2;
//            boolean bl3;
//            boolean var10000;
//            label62: {
//                bl = !entity.isSpectator();
//                bl2 = entity != player && entity != attacked;
//                bl3 = !player.isTeammate(entity);
//                if (entity instanceof TameableEntity tameableEntity && tameableEntity.isTamed() && player.getUuid().equals(tameableEntity.getOwnerUuid())) {
//                    var10000 = true;
//                    break label62;
//                }
//
//                var10000 = false;
//            }
//
//            boolean bl4;
//            label55: {
//                bl4 = !var10000;
//                if (entity instanceof ArmorStandEntity armorStandEntity && armorStandEntity.isMarker()) {
//                    var10000 = false;
//                    break label55;
//                }
//
//                var10000 = true;
//            }
//
//            boolean bl5 = var10000;
//            boolean bl6 = attacked.squaredDistanceTo(entity) <= Math.pow(3.5, 2.0);
//            return bl && bl2 && bl3 && bl4 && bl5 && bl6;
//        };
//    }
//
//    private static double getKnockback(PlayerEntity player, LivingEntity attacked, Vec3d distance) {
//        return (3.5 - distance.length())
//                * 0.7F
//                * (double)(player.fallDistance > 5.0F ? 2 : 1)
//                * (1.0 - attacked.getAttributeValue(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE));
//    }
//
//    public static boolean shouldDealAdditionalDamage(LivingEntity attacker) {
//        return attacker.fallDistance > 1.5F && !attacker.isFallFlying();
//    }
public static AttributeModifiersComponent createAttributeModifiers() {
    return AttributeModifiersComponent.builder()
            .add(
                    EntityAttributes.ATTACK_DAMAGE,
                    new EntityAttributeModifier(BASE_ATTACK_DAMAGE_MODIFIER_ID, ATTACK_DAMAGE_MODIFIER_VALUE,
                            EntityAttributeModifier.Operation.ADD_VALUE
                    ),
                    AttributeModifierSlot.MAINHAND
            )
            .add(
                    EntityAttributes.ATTACK_SPEED,
                    new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, ATTACK_SPEED_MODIFIER_VALUE*MINING_SPEED_MULTIPLIER,
                            EntityAttributeModifier.Operation.ADD_VALUE
                    ),
                    AttributeModifierSlot.MAINHAND
            )
            .build();
}

    public static ToolComponent createToolComponent() {
        return new ToolComponent(List.of(), 1.0F, 2);
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ServerWorld serverWorld = (ServerWorld)attacker.getWorld();
        if (attacker instanceof PlayerEntity){
            // target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,200,1,false,false,false));
            // target.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,200,0,false,false,false));
            if (attacker.getMainHandStack().getItem() == this) {
                target.setOnFireFor(200F);
                spawnLavaSplashParticles(serverWorld, target);
            }
            knockbackNearbyEntities(serverWorld, attacker, target);
        }

        return true;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (user != null && hand == Hand.MAIN_HAND){
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WITHER,10,1,true,true,true));
            return ActionResult.SUCCESS;
        }
        return super.useOnEntity(stack, user, entity, hand);
    }

    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
        if (shouldDealAdditionalDamage(attacker)) {
            attacker.onLanding();
        }

    }

    public float getBonusAttackDamage(Entity target, float baseAttackDamage, DamageSource damageSource) {
        Entity var5 = damageSource.getSource();
        if (var5 instanceof LivingEntity livingEntity) {
            if (!shouldDealAdditionalDamage(livingEntity)) {
                return 0.0F;
            } else {
                float h = livingEntity.fallDistance;
                float i;
                if (h <= 1.0F) {
                    i = ATTACK_DAMAGE_MODIFIER_VALUE * h;
                } else {
                    i = 0;
                }

                World var10 = livingEntity.getWorld();
                if (var10 instanceof ServerWorld) {
                    ServerWorld serverWorld = (ServerWorld)var10;
                    return i + EnchantmentHelper.getSmashDamagePerFallenBlock(serverWorld, livingEntity.getWeaponStack(), target, damageSource, 0.0F) * h;
                } else {
                    return i;
                }
            }
        } else {
            return 0.0F;
        }
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

    public static boolean shouldDealAdditionalDamage(LivingEntity attacker) {
        return attacker.fallDistance > 1.5F && !attacker.isGliding();
    }

    @Nullable
    public DamageSource getDamageSource(LivingEntity user) {
        return shouldDealAdditionalDamage(user) ? user.getDamageSources().maceSmash(user) : super.getDamageSource(user);
    }
    private void spawnLavaSplashParticles(World world, LivingEntity target) {
        double radius = 1.5; // 粒子扩散半径
        int numberOfParticles = 20; // 粒子数量
        for (int i = 0; i < numberOfParticles; i++) {
            double x = target.getX() + (world.random.nextDouble() - 0.5) * radius;
            double y = target.getY() + world.random.nextDouble() * radius;
            double z = target.getZ() + (world.random.nextDouble() - 0.5) * radius;
            //ParticleEffect particle = new ParticleEffect(ParticleTypes.DRIPPING_LAVA, x, y, z);
            // particle.setVelocity(world.random.nextGaussian() * 0.1, world.random.nextGaussian() * 0.1, world.random.nextGaussian() * 0.1);
            //world.addParticle(particle, particle.x, particle.y, particle.z, particle.velocityX, particle.velocityY, particle.velocityZ);
            world.addParticle(ParticleTypes.DRIPPING_LAVA,target.getX(),-1,target.getZ(),x,y,z);
        }
    }

}

