package net.redstone233.morehammercraft.items.weapons;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.redstone233.morehammercraft.core.until.IsEntityFire;
import net.redstone233.morehammercraft.core.until.TeleportHeight;

import java.util.List;

public class StoneSickleItem extends SwordItem {
    private static double height;
//    private final TeleportHeight teleportHeight = new TeleportHeight();
//    private final IsEntityFire isEntityFire = new IsEntityFire();

    public StoneSickleItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public static double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        StoneSickleItem.height = height;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        BlockPos pos = target.getBlockPos();
//        if (attacker instanceof PlayerEntity && target instanceof LivingEntity livingEntity) {
//            if (Screen.hasControlDown()) {
//                livingEntity.setOnFireFor(300.0f);
//                isEntityFire.setEntityFire(300.0f);
//                isEntityFire.setEntityFire(isEntityFire.getEntityFire());
//                isEntityFire.FireSetFor(target);
//            }
//            if (Screen.hasShiftDown()) {
//                tpSkyUp(target, getHeight());
//                teleportHeight.setHeight(getHeight());
//                teleportHeight.setHeight(teleportHeight.getHeight());
//                teleportHeight.TeleportPos(target);
//            }
//        }
        if (attacker instanceof PlayerEntity player && target instanceof LivingEntity livingEntity) {
            if (Screen.hasControlDown()) {
                livingEntity.setFireTicks(300);
                player.sendMessage(Text.of("已经将目标"+target+"引燃"),true);
            }
            if (Screen.hasShiftDown()) {
                if (!world.isClient()) {
                    double x = pos.getX() + 0.5;
                    double y = pos.getY() + 0.5;
                    double z = pos.getZ() + 0.5;
                    world.addParticle(ParticleTypes.DRIPPING_WATER,x,y,z,0.0,0.0,0.0);
                }
                livingEntity.teleport(target.getX(),target.getY() + getHeight(),target.getZ(),false);
                player.sendMessage(Text.of("已经将目标"+target+"踢上"+getHeight()+"高空"),true);
            }
        }
        return true;
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1,attacker, EquipmentSlot.MAINHAND);
        stack.damage(1,attacker,EquipmentSlot.OFFHAND);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        RegistryWrapper.WrapperLookup wrapperLookup = context.getRegistryLookup();
        if (wrapperLookup != null) {
            tooltip.add(Text.translatable("item.mhc.sickle.tooltip"));
            tooltip.add(Text.translatable("item.mhc.sickle.shift.tooltip",String.valueOf(getHeight())));
        }
        super.appendTooltip(stack, context, tooltip, type);
    }

//    private void tpSkyUp(LivingEntity entity, double height) {
//        if (entity instanceof MobEntity mob) {
//            if (height >= 40) {
//                BlockPos pos = mob.getBlockPos().add(0, -1, 0); // 获取实体脚底下的位置
//                mob.teleport(pos.getX(),pos.getY()+height,pos.getZ(),false);
//            } else {
//                if (entity instanceof PlayerEntity player) {
//                    player.sendMessage(Text.of("高度未达到最"+height+"的要求！"),true);
//                }
//            }
//        }
//    }
}
