package net.redstone233.morehammercraft.items;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent FLYDRAGON = new FoodComponent.Builder().nutrition(10).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER,600,4),1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE,600,5),1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION,600,6),0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.GLOWING,600,7),0.9f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,600,8),1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.WITHER,100,0),0.09f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER,100,1),0.05f)
            .build();

    public static final FoodComponent NEW_FOOD = new FoodComponent.Builder().nutrition(6).saturationModifier(6.0F)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,100,1),1.0F)
            .build();

    public static final FoodComponent MORE_PAPERS = new FoodComponent.Builder().nutrition(4).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,500,4),0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE,300,4),0.1f)
            .build();

    public static final FoodComponent PAPERS = new FoodComponent.Builder().nutrition(2).saturationModifier(1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION,500,4),0.5f)
            .build();
}
