package net.redstone233.morehammercraft.components;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.item.consume.UseAction;
import net.minecraft.sound.SoundEvents;
import net.redstone233.morehammercraft.MoreHammerCraft;

import java.util.List;

public class ModConsumableComponents {
    public static final ConsumableComponent FLYDRAGON;
    public static final ConsumableComponent NEW_FOOD;
    public static final ConsumableComponent MORE_PAPERS;
    public static final ConsumableComponent PAPERS;
    public static final ConsumableComponent COLA;

    public ModConsumableComponents() {
    }

    public static ConsumableComponent.Builder food() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.EAT).sound(SoundEvents.ENTITY_GENERIC_EAT).consumeParticles(true);
    }

    public static ConsumableComponent.Builder drink() {
        return ConsumableComponent.builder().consumeSeconds(1.6F).useAction(UseAction.DRINK).sound(SoundEvents.ENTITY_GENERIC_DRINK).consumeParticles(false);
    }

    static {
        //FLYDRAGON = food().consumeEffect(new ApplyEffectsConsumeEffect(List.of(new StatusEffectInstance(StatusEffects.CONDUIT_POWER,600,1)))).consumeEffect().build();
        FLYDRAGON = food()
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER,600,4),1.0F))
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,600,5),1.0F))
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION,600,6),0.1F))
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.GLOWING,600,7),0.9F))
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600,8),1.0F))
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.WITHER,600,0),0.09F))
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HUNGER,600,1),0.05F))
                //.consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER,600,1),1.0F))
                .build();
        NEW_FOOD = food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,1200,3))).build();
        COLA = drink().consumeSeconds(2.0F).sound(SoundEvents.ENTITY_GENERIC_DRINK).build();
        MORE_PAPERS = food()
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SATURATION,600,4),0.3F))
                .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600,4),0.1F))
                .build();
        PAPERS = food().consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.SATURATION,600,4),0.5F)).build();
    }

    public static void register() {
        MoreHammerCraft.LOGGER.info("注册"+MoreHammerCraft.MOD_ID+"食物属性组件成功！");
    }
}
