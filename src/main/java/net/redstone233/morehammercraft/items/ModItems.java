package net.redstone233.morehammercraft.items;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.components.ModConsumableComponents;
import net.redstone233.morehammercraft.components.ModFoodComponents;
import net.redstone233.morehammercraft.items.funcitem.*;
import net.redstone233.morehammercraft.items.weapons.*;

import java.util.function.Function;

public class ModItems {
//
//    public static final Item DEFAULT_TEMPLATE = registerModItems("default_template",new Item(new Item.Settings().maxCount(64)));
//    public static final Item VAMPIRE_TEMPLATE = registerModItems("vampire_template",new Item(new Item.Settings().maxCount(64)));
//    public static final Item SLOWNESS_TEMPLATE = registerModItems("slowness_template",new Item(new Item.Settings().maxCount(64)));
//
//    public static final Item DEFAULT_TEST = register("test",Item::new,new Item.Settings());
//    public static final Item TEST = register("test1",BrickItem::new, new Item.Settings());
//    public static final Item TEST1 = register("wooden_sword", (settings) -> new IceSwordItem(ToolMaterial.WOOD, 3.0F, -2.4F, settings));
//
//    public static final Item VAMPIRE_INGOT = registerModItems("vampire_ingot",new Item(new Item.Settings().maxCount(64)));
//    public static final Item SLOWNESS_INGOT = registerModItems("slowness_ingot",new Item(new Item.Settings().maxCount(64)));
//    public static final Item DEFAULT_INGOT = registerModItems("default_ingot",new Item(new Item.Settings().maxCount(64)));
//
//    public static final Item FLYDRAGON_STUDIO = registerModItems("flydragon_studio",new Item(new Item.Settings().food(ModFoodComponents.FLYDRAGON, ModConsumableComponents.FLYDRAGON).maxCount(64)));
//    public static final Item NEW_FOOD = registerModItems("new_food",new Item(new Item.Settings().food(ModFoodComponents.NEW_FOOD,ModConsumableComponents.NEW_FOOD).maxCount(64)));
//    public static final Item MORE_PAPERS = registerModItems("more_papers", new Item(new Item.Settings().food(ModFoodComponents.MORE_PAPERS,ModConsumableComponents.MORE_PAPERS).maxCount(64)));
//    public static final Item PAPERS = registerModItems("papers",new Item(new Item.Settings().food(ModFoodComponents.PAPERS,ModConsumableComponents.PAPERS).maxCount(64)));
//    public static final Item IRON_CAN = registerModItems("iron_can",new Item(new Item.Settings().maxCount(64)));
//    public static final Item IRON_COLA = registerModItems("iron_cola",new ColaItem(new Item.Settings().maxCount(32)));
//
//    public static final Item ICE_DRAGON_SWORD = registerModItems(
//            "ice_dragon_sword",new IceDragonSword(ModToolMaterial.DEFAULT,5,2.0F,new Item.Settings()
//                    .maxDamage(70000)
//            ));
//    public static final Item ICE_SWORD = registerModItems(
//            "ice_sword", new IceSwordItem(ModToolMaterial.VAMPIRE,5,2.0F,new Item.Settings()
//                    //.attributeModifiers(IceSwordItem.createAttributeModifiers(ModToolMaterials.VAMPIRE,5,2.0f))
//                    .maxDamage(70000)
//    ));
//
//    public static final Item WINDOWS = registerModItems("windows",new WindowsItem(new Item.Settings().maxCount(64)
//            .maxDamage(100)
//            .component(DataComponentTypes.TOOL,WindowsItem.createToolComponent())
//            .attributeModifiers(WindowsItem.createAttributeModifiers())
//    ));
//
//    public static final Item BRICK = registerModItems("brick",new BrickItem(new Item.Settings()
//            .maxDamage(288000)
//            .component(DataComponentTypes.TOOL,BrickItem.createToolComponent())
//            .attributeModifiers(BrickItem.createAttributeModifiers())
//    ));
//    public static final Item VAMPIRE_HAMMER = registerModItems("vampire_hammer",new VampireHammer(new Item.Settings()
//            .maxDamage(50000)
//            .component(DataComponentTypes.TOOL,VampireHammer.createToolComponent())
//            .attributeModifiers(VampireHammer.createAttributeModifiers())
//    ));
//    public static final Item DEFAULT_HAMMER = registerModItems("default_hammer",new DefaultHammer(new Item.Settings()
//            .maxDamage(28800)
//            .component(DataComponentTypes.TOOL,DefaultHammer.createToolComponent())
//            .attributeModifiers(DefaultHammer.createAttributeModifiers())
//    ));
//    public static final Item TALLER_HAMMER = registerModItems("taller_hammer",new Item(new Item.Settings()
//            .maxDamage(30000)
//            .component(DataComponentTypes.TOOL,TallerHammer.createToolComponent())
//            .attributeModifiers(TallerHammer.createAttributeModifiers())
//    ));
//    public static final Item SLOWNESS_HAMMER = registerModItems("slowness_hammer",new Item(new Item.Settings()
//            .maxDamage(30000)
//            .component(DataComponentTypes.TOOL, SlownessHammer.createToolComponent())
//            .attributeModifiers(SlownessHammer.createAttributeModifiers())
//    ));
//
//    public static final Item Prospectors = registerModItems("prospector",new Prospector(new Item.Settings()
//            .maxDamage(3000)
//            .component(DataComponentTypes.TOOL,Prospector.createToolComponent())
//            .attributeModifiers(Prospector.createAttributeModifiers())
//    ));
//    public static final Item FLYDRAGON = registerModItems("flydragon",new FlydargonItem(new Item.Settings()
//            .maxCount(48)
//            .maxDamage(40)
//            .component(DataComponentTypes.TOOL,FlydargonItem.createToolComponent())
//            .attributeModifiers(FlydargonItem.createAttributeModifiers())
//    ));
//    public static final Item DRAGON_CLAW = registerModItems("turu",new DragonClawItem(new Item.Settings()
//            .maxDamage(50000)
//            .component(DataComponentTypes.TOOL,DragonClawItem.createToolComponent())
//            .attributeModifiers(DragonClawItem.createAttributeModifiers())
//    ));
//
//
//
//    public static final Item LEFT_HAMMER = registerModItems("left_hammer",new LeftHammerItem(new Item.Settings()
//            .maxDamage(30000)
//            .component(DataComponentTypes.TOOL,LeftHammerItem.createToolComponent())
//            .attributeModifiers(LeftHammerItem.createAttributeModifiers())
//    ));
//    public static final Item RIGHT_HAMMER = registerModItems("right_hammer",new RightHammerItem(new Item.Settings()
//            .maxDamage(30000)
//            .component(DataComponentTypes.TOOL,RightHammerItem.createToolComponent())
//            .attributeModifiers(RightHammerItem.createAttributeModifiers())
//    ));
//    public static final Item SMALL_DRAGON_CLAW = registerModItems("three_dragon_claw",new SmallDragonClawItem(new Item.Settings()
//            .maxDamage(45000)
//            .component(DataComponentTypes.TOOL,SmallDragonClawItem.createToolComponent())
//            .attributeModifiers(SmallDragonClawItem.createAttributeModifiers())
//    ));

    public static final Item DEFAULT_TEMPLATE = register("default_template", Item::new, new Item.Settings().maxCount(64));
    public static final Item VAMPIRE_TEMPLATE = register("vampire_template", Item::new, new Item.Settings().maxCount(64));
    public static final Item SLOWNESS_TEMPLATE = register("slowness_template",Item::new, new Item.Settings().maxCount(64));

    // public static final Item DEFAULT_TEST = register("test",Item::new,new Item.Settings());
    // public static final Item TEST = register("test1",BrickItem::new, new Item.Settings());
    // public static final Item TEST1 = register("wooden_sword", (settings) -> new IceSwordItem(ToolMaterial.WOOD, 3.0F, -2.4F, settings));

    public static final Item VAMPIRE_INGOT = register("vampire_ingot",Item::new,new Item.Settings().maxCount(64));
    public static final Item SLOWNESS_INGOT = register("slowness_ingot",Item::new,new Item.Settings().maxCount(64));
    public static final Item DEFAULT_INGOT = register("default_ingot",Item::new,new Item.Settings().maxCount(64));

    public static final Item FLYDRAGON_STUDIO = register("flydragon_studio",Item::new,new Item.Settings().food(ModFoodComponents.FLYDRAGON, ModConsumableComponents.FLYDRAGON).maxCount(64));
    public static final Item NEW_FOOD = register("new_food",Item::new,new Item.Settings().food(ModFoodComponents.NEW_FOOD,ModConsumableComponents.NEW_FOOD).maxCount(64));
    public static final Item MORE_PAPERS = register("more_papers", Item::new,new Item.Settings().food(ModFoodComponents.MORE_PAPERS,ModConsumableComponents.MORE_PAPERS).maxCount(64));
    public static final Item PAPERS = register("papers",Item::new,new Item.Settings().food(ModFoodComponents.PAPERS,ModConsumableComponents.PAPERS).maxCount(64));
    public static final Item IRON_CAN = register("iron_can",Item::new,new Item.Settings().maxCount(64));
    public static final Item IRON_COLA = register("iron_cola",ColaItem::new, new Item.Settings().maxCount(32).food(ModFoodComponents.COLA,ModConsumableComponents.COLA));

    public static final Item ICE_DRAGON_SWORD = register(
            "ice_dragon_sword",
            (settings) -> new IceDragonSword(ModToolMaterial.DEFAULT,5,2.0F,
                    settings.maxDamage(70000)
            ));
    public static final Item ICE_SWORD = register(
            "ice_sword",
            (settings) -> new IceSwordItem(ModToolMaterial.VAMPIRE,5,2.0F,
                    settings.maxDamage(70000)
            ));

//    public static final Item WOODEN_SICKLE = register("wooden_sickle", WoodenSickleItem::new,new Item.Settings()
//            .maxDamage(30000)
//            .component(DataComponentTypes.TOOL,WoodenSickleItem.createToolComponent())
//            .attributeModifiers(WoodenSickleItem.createAttributeModifiers())
//    );

    public static final Item WOODEN_SICKLE = register(
            "wooden_sickle",
            (settings) -> new WoodenSickleItem(ToolMaterial.WOOD,3,2,
                    settings.maxDamage(3020)
            ));

//    public static final Item WOODEN_SICKLES = register(
//       "wooden_sickle",
//            (settings) -> new WoodenSickleItem(ToolMaterial.WOOD,3,2,
//                settings.maxDamage(3020)
//        ));

    public static final Item STONE_SICKLE = register(
            "stone_sickle",
            (settings) -> new StoneSickleItem(ToolMaterial.STONE,5,2.5f,
                    settings.maxDamage(4096)
            ));

    public static final Item IRON_SICKLE = register(
            "iron_sickle",
            (settings) -> new IronSickleItem(ToolMaterial.IRON,7,3.0f,
                    settings.maxDamage(5100)
            ));

    public static final Item GOLD_SICKLE = register(
            "pseudo_golden_sickle",
            (settings) -> new GoldenSickleItem(ToolMaterial.GOLD,9,3.5f,
                    settings.maxDamage(6000)
            ));

    public static final Item DIAMOND_SICKLE = register(
            "diamond_sickle",
            (settings) -> new DiamondSickleItem(ToolMaterial.DIAMOND,11,4.0f,
                    settings.maxDamage(6570)
            ));

    public static final Item NETHERITE_SICKLE = register(
            "pseudo_netherite_sickle",
            (settings) -> new NetheriteSickleItem(ToolMaterial.NETHERITE,13,4.5f,
                    settings.maxDamage(7000)
            ));

    public static final Item WINDOWS = register("windows",WindowsItem::new, new Item.Settings().maxCount(64)
            .maxDamage(100)
            .component(DataComponentTypes.TOOL,WindowsItem.createToolComponent())
            .attributeModifiers(WindowsItem.createAttributeModifiers())
    );

    public static final Item BRICK = register("brick",BrickItem::new, new Item.Settings()
            .maxDamage(288000)
            .component(DataComponentTypes.TOOL,BrickItem.createToolComponent())
            .attributeModifiers(BrickItem.createAttributeModifiers())
    );
    public static final Item VAMPIRE_HAMMER = register("vampire_hammer",VampireHammer::new, new Item.Settings()
            .maxDamage(50000)
            .component(DataComponentTypes.TOOL,VampireHammer.createToolComponent())
            .attributeModifiers(VampireHammer.createAttributeModifiers())
    );
    public static final Item DEFAULT_HAMMER = register("default_hammer",DefaultHammer::new,new Item.Settings()
            .maxDamage(28800)
            .component(DataComponentTypes.TOOL,DefaultHammer.createToolComponent())
            .attributeModifiers(DefaultHammer.createAttributeModifiers())
    );
    public static final Item TALLER_HAMMER = register("taller_hammer",TallerHammer::new, new Item.Settings()
            .maxDamage(30000)
            .component(DataComponentTypes.TOOL,TallerHammer.createToolComponent())
            .attributeModifiers(TallerHammer.createAttributeModifiers())
    );
    public static final Item SLOWNESS_HAMMER = register("slowness_hammer",SlownessHammer::new, new Item.Settings()
            .maxDamage(30000)
            .component(DataComponentTypes.TOOL, SlownessHammer.createToolComponent())
            .attributeModifiers(SlownessHammer.createAttributeModifiers())
    );

    public static final Item Prospectors = register("prospector",Prospector::new, new Item.Settings()
            .maxDamage(3000)
            .component(DataComponentTypes.TOOL,Prospector.createToolComponent())
            .attributeModifiers(Prospector.createAttributeModifiers())
    );
    public static final Item FLYDRAGON = register("flydragon",FlydargonItem::new, new Item.Settings()
            .maxCount(48)
            .maxDamage(40)
            .component(DataComponentTypes.TOOL,FlydargonItem.createToolComponent())
            .attributeModifiers(FlydargonItem.createAttributeModifiers())
    );
    public static final Item DRAGON_CLAW = register("turu",DragonClawItem::new, new Item.Settings()
            .maxDamage(50000)
            .component(DataComponentTypes.TOOL,DragonClawItem.createToolComponent())
            .attributeModifiers(DragonClawItem.createAttributeModifiers())
    );



    public static final Item LEFT_HAMMER = register("left_hammer",LeftHammerItem::new, new Item.Settings()
            .maxDamage(30000)
            .component(DataComponentTypes.TOOL,LeftHammerItem.createToolComponent())
            .attributeModifiers(LeftHammerItem.createAttributeModifiers())
    );
    public static final Item RIGHT_HAMMER = register("right_hammer",RightHammerItem::new, new Item.Settings()
            .maxDamage(30000)
            .component(DataComponentTypes.TOOL,RightHammerItem.createToolComponent())
            .attributeModifiers(RightHammerItem.createAttributeModifiers())
    );
    public static final Item SMALL_DRAGON_CLAW = register("three_dragon_claw",SmallDragonClawItem::new, new Item.Settings()
            .maxDamage(45000)
            .component(DataComponentTypes.TOOL,SmallDragonClawItem.createToolComponent())
            .attributeModifiers(SmallDragonClawItem.createAttributeModifiers())
    );

    public static final Item SICKLE_HEAD = register("sickle_head",Item::new,new Item.Settings().maxCount(16));

    // Iron can

    private static Item registerModItems(String id,Item item){
        //return Registry.register(Registries.ITEM, RegistryKey.of(Registries.ITEM.getKey(), Identifier.ofVanilla(id)), item);
        return Registry.register(Registries.ITEM, Identifier.of(MoreHammerCraft.MOD_ID,id), item);
    }

    private static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreHammerCraft.MOD_ID, id));
        return Items.register(registryKey, factory, settings);
    }

    private static Item register(String id, Function<Item.Settings, Item> factory) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreHammerCraft.MOD_ID, id));
        return Items.register(registryKey, factory, new Item.Settings());
    }


    public static void registerItems() {
        TallerHammer.setAttackSpeedModifierValue(2.5f);
        TallerHammer.setAttackDamageModifierValue(5);
        WoodenSickleItem.setHeight(100.0f);
        StoneSickleItem.setHeight(150.0f);
        IronSickleItem.setHeight(200.0f);
        GoldenSickleItem.setHeight(250.0f);
        DiamondSickleItem.setHeight(300.0f);
        NetheriteSickleItem.setHeight(400.0f);
        ModConsumableComponents.register();
        ModFoodComponents.register();
    }
}
