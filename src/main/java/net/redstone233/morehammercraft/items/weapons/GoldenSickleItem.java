package net.redstone233.morehammercraft.items.weapons;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Instrument;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.Texts;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.redstone233.morehammercraft.core.until.IsEntityFireBuilder;
import net.redstone233.morehammercraft.core.until.TeleportHeightBuilder;

import java.awt.*;
import java.util.List;

public class GoldenSickleItem extends SwordItem {
    private static double height;
    TeleportHeightBuilder teleportHeightBuilder = new TeleportHeightBuilder.HeightBuilders()
            .X(0)
            .Y(0)
            .Z(0)
            .Height(getHeight())
            .heightBuilder();
    IsEntityFireBuilder isEntityFireBuilder = new IsEntityFireBuilder.IsFireBuilder()
            .tick(300.0f)
            .fireBuilder();

    public GoldenSickleItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public static double getHeight() {
        return height;
    }

    public static void setHeight(double height) {
        GoldenSickleItem.height = height;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity && target instanceof LivingEntity livingEntity) {
            if (Screen.hasControlDown()) {
                livingEntity.setOnFireFor(300.0f);
                isEntityFireBuilder.FireSetFor(target);
            }
            if (Screen.hasShiftDown()) {
                tpSkyUp(target, getHeight());
                teleportHeightBuilder.TeleportPos(target);
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
            //tooltip.add(Text.translatable("item.mhc.pseudo.tooltip"));
            MutableText mutableText = Text.translatable("item.mhc.pseudo.tooltip");
            Texts.setStyleIfAbsent(mutableText, Style.EMPTY.withColor(Formatting.GOLD));
            tooltip.add(mutableText);
        }
        super.appendTooltip(stack, context, tooltip, type);
    }

    private void tpSkyUp(LivingEntity entity, double height) {
        if (entity instanceof MobEntity mob) {
            if (height >= 40) {
                BlockPos pos = mob.getBlockPos().add(0, -1, 0); // 获取实体脚底下的位置
                mob.teleport(pos.getX(),pos.getY()+height,pos.getZ(),false);
            } else {
                if (entity instanceof PlayerEntity player) {
                    player.sendMessage(Text.of("高度未达到最"+height+"的要求！"),true);
                }
            }
        }
    }
}
