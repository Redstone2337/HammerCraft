package net.redstone233.morehammercraft.items;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.items.funcitem.*;
import net.redstone233.morehammercraft.items.weapons.IceDragonSword;
import net.redstone233.morehammercraft.items.weapons.IceSwordItem;

public class ModItems {

    public static final Item DEFAULT_TEMPLATE = registerModItems("default_template",new Item(new Item.Settings().maxCount(64)));
    public static final Item VAMPIRE_TEMPLATE = registerModItems("vampire_template",new Item(new Item.Settings().maxCount(64)));
    public static final Item SLOWNESS_TEMPLATE = registerModItems("slowness_template",new Item(new Item.Settings().maxCount(64)));

    public static final Item VAMPIRE_INGOT = registerModItems("vampire_ingot",new Item(new Item.Settings().maxCount(64)));
    public static final Item SLOWNESS_INGOT = registerModItems("slowness_ingot",new Item(new Item.Settings().maxCount(64)));
    public static final Item DEFAULT_INGOT = registerModItems("default_ingot",new Item(new Item.Settings().maxCount(64)));

    public static final Item FLYDRAGON_STUDIO = registerModItems("flydragon_studio",new Item(new Item.Settings().food(ModFoodComponents.FLYDRAGON).maxCount(64)));
    public static final Item NEW_FOOD = registerModItems("new_food",new Item(new Item.Settings().food(ModFoodComponents.NEW_FOOD).maxCount(64)));
    public static final Item MORE_PAPERS = registerModItems("more_papers", new Item(new Item.Settings().food(ModFoodComponents.MORE_PAPERS).maxCount(64)));
    public static final Item PAPERS = registerModItems("papers",new Item(new Item.Settings().food(ModFoodComponents.PAPERS).maxCount(64)));
    public static final Item IRON_CAN = registerModItems("iron_can",new Item(new Item.Settings().maxCount(64)));
    public static final Item IRON_COLA = registerModItems("iron_cola",new ColaItem(new Item.Settings().maxCount(32)));

    public static final Item ICE_DRAGON_SWORD = registerModItems(
            "ice_dragon_sword",new IceDragonSword(ModToolMaterials.DEFAULT,new Item.Settings()
                    .attributeModifiers(IceDragonSword.createAttributeModifiers(ModToolMaterials.DEFAULT,5,2.0f))
                    .maxDamage(70000)
            ));
    public static final Item ICE_SWORD = registerModItems(
            "ice_sword", new IceSwordItem(ModToolMaterials.VAMPIRE,new Item.Settings()
                    .attributeModifiers(IceSwordItem.createAttributeModifiers(ModToolMaterials.VAMPIRE,5,2.0f))
                    .maxDamage(70000)
    ));

    public static final Item WINDOWS = registerModItems("windows",new WindowsItem(new Item.Settings().maxCount(64)
            .maxDamage(100)
            .component(DataComponentTypes.TOOL,WindowsItem.createToolComponent())
            .attributeModifiers(WindowsItem.createAttributeModifiers())
    ));

    public static final Item BRICK = registerModItems("brick",new BrickItem(new Item.Settings()
            .maxDamage(288000)
            .component(DataComponentTypes.TOOL,BrickItem.createToolComponent())
            .attributeModifiers(BrickItem.createAttributeModifiers())
    ));
    public static final Item VAMPIRE_HAMMER = registerModItems("vampire_hammer",new VampireHammer(new Item.Settings()
            .maxDamage(50000)
            .component(DataComponentTypes.TOOL,VampireHammer.createToolComponent())
            .attributeModifiers(VampireHammer.createAttributeModifiers())
    ));
    public static final Item DEFAULT_HAMMER = registerModItems("default_hammer",new DefaultHammer(new Item.Settings()
            .maxDamage(28800)
            .component(DataComponentTypes.TOOL,DefaultHammer.createToolComponent())
            .attributeModifiers(DefaultHammer.createAttributeModifiers())
    ));
    public static final Item TALLER_HAMMER = registerModItems("taller_hammer",new Item(new Item.Settings()
            .maxDamage(30000)
            .component(DataComponentTypes.TOOL,TallerHammer.createToolComponent())
            .attributeModifiers(TallerHammer.createAttributeModifiers())
    ));
    public static final Item SLOWNESS_HAMMER = registerModItems("slowness_hammer",new Item(new Item.Settings()
            .maxDamage(30000)
            .component(DataComponentTypes.TOOL, SlownessHammer.createToolComponent())
            .attributeModifiers(SlownessHammer.createAttributeModifiers())
    ));

    public static final Item Prospectors = registerModItems("prospector",new Prospector(new Item.Settings()
            .maxDamage(3000)
            .component(DataComponentTypes.TOOL,Prospector.createToolComponent())
            .attributeModifiers(Prospector.createAttributeModifiers())
    ));
    public static final Item FLYDRAGON = registerModItems("flydragon",new FlydargonItem(new Item.Settings()
            .maxCount(48)
            .maxDamage(40)
            .component(DataComponentTypes.TOOL,FlydargonItem.createToolComponent())
            .attributeModifiers(FlydargonItem.createAttributeModifiers())
    ));
    public static final Item DRAGON_CLAW = registerModItems("turu",new DragonClawItem(new Item.Settings()
            .maxDamage(50000)
            .component(DataComponentTypes.TOOL,DragonClawItem.createToolComponent())
            .attributeModifiers(DragonClawItem.createAttributeModifiers())
    ));



    public static final Item LEFT_HAMMER = registerModItems("left_hammer",new LeftHammerItem(new Item.Settings()
            .maxDamage(30000)
            .component(DataComponentTypes.TOOL,LeftHammerItem.createToolComponent())
            .attributeModifiers(LeftHammerItem.createAttributeModifiers())
    ));
    public static final Item RIGHT_HAMMER = registerModItems("right_hammer",new RightHammerItem(new Item.Settings()
            .maxDamage(30000)
            .component(DataComponentTypes.TOOL,RightHammerItem.createToolComponent())
            .attributeModifiers(RightHammerItem.createAttributeModifiers())
    ));
    public static final Item SMALL_DRAGON_CLAW = registerModItems("three_dragon_claw",new SmallDragonClawItem(new Item.Settings()
            .maxDamage(45000)
            .component(DataComponentTypes.TOOL,SmallDragonClawItem.createToolComponent())
            .attributeModifiers(SmallDragonClawItem.createAttributeModifiers())
    ));

    // Iron can

    private static Item registerModItems(String id,Item item){
        //return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.ofVanilla(id)), item);
        return Registry.register(Registries.ITEM, Identifier.of(MoreHammerCraft.MOD_ID,id), item);
    }


    public static void registerItems() {
        TallerHammer.setAttackSpeedModifierValue(2.5f);
        TallerHammer.setAttackDamageModifierValue(5);
    }
}
