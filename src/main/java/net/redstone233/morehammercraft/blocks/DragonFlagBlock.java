package net.redstone233.morehammercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

import static net.minecraft.item.Item.BASE_ATTACK_DAMAGE_MODIFIER_ID;
import static net.minecraft.item.Item.BASE_ATTACK_SPEED_MODIFIER_ID;

public class DragonFlagBlock extends Block {
    private static final int ATTACK_DAMAGE_MODIFIER_VALUE = 299;
    private static final float ATTACK_SPEED_MODIFIER_VALUE = 5.5F;

    public DragonFlagBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,200,5,false,false,true));
            world.addParticle(ParticleTypes.DRIPPING_WATER,player.getX(),player.getY() - 1,player.getZ(),0.0,0.0,0.0);
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        entity.setFireTicks(100);
        if (entity instanceof PlayerEntity player) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,60,4));
        } else if (entity instanceof ZombieEntity zom) {
            zom.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,60,5,false,false,true));
        }
        super.onEntityLand(world, entity);
    }
}
