package net.redstone233.morehammercraft.components;

import net.minecraft.component.type.FoodComponent;
import net.redstone233.morehammercraft.MoreHammerCraft;

public class ModFoodComponents {
    public static final FoodComponent FLYDRAGON = new FoodComponent.Builder().nutrition(10).saturationModifier(1.0f).build();

    public static final FoodComponent NEW_FOOD = new FoodComponent.Builder().nutrition(6).saturationModifier(6.0F).build();

    public static final FoodComponent MORE_PAPERS = new FoodComponent.Builder().nutrition(4).saturationModifier(1.0f).build();

    public static final FoodComponent PAPERS = new FoodComponent.Builder().nutrition(2).saturationModifier(1.0f).build();

    public static final FoodComponent COLA = new FoodComponent.Builder().nutrition(8).saturationModifier(0.2F).alwaysEdible().build();

    public static void register() {
        MoreHammerCraft.LOGGER.info("注册"+MoreHammerCraft.MOD_ID+"的模组食物组件成功！");
    }
}
