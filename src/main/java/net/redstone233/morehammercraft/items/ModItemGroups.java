package net.redstone233.morehammercraft.items;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.blocks.ModBlocks;
import net.redstone233.morehammercraft.potions.ModPotions;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> MORE_HAMMERS = register("more_hammers");
    public static final RegistryKey<ItemGroup> MORE_TEMPLATE = register("more_template");
    public static final RegistryKey<ItemGroup> FUNCTION_ITEMS = register("function_items");
    public static final RegistryKey<ItemGroup> INGREDIENTS = register("ingredients");
    public static final RegistryKey<ItemGroup> ZHENGHUO = register("zhn_item");
    public static final RegistryKey<ItemGroup> FOODS = register("food");
    public static final RegistryKey<ItemGroup> NATURAL_BLOCKS = register("mod_natural_block");
    public static final RegistryKey<ItemGroup> BUILDING_BLOCKS = register("building_block");

    private static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(MoreHammerCraft.MOD_ID, id));
    }

    public static void registerModItemGroups(){
        Registry.register(Registries.ITEM_GROUP,ModItemGroups.MORE_TEMPLATE,
                ItemGroup.create(ItemGroup.Row.TOP,0)
                        .displayName(Text.translatable("itemGroup.mhc.more_template"))
                        .icon(() -> new ItemStack(ModItems.DEFAULT_TEMPLATE)).entries((displayContext, entries) -> {
                            entries.add(ModItems.DEFAULT_TEMPLATE);
                            entries.add(ModItems.VAMPIRE_TEMPLATE);
                            entries.add(ModItems.SLOWNESS_TEMPLATE);
                        }).build());
        Registry.register(Registries.ITEM_GROUP,ModItemGroups.MORE_HAMMERS,
                ItemGroup.create(ItemGroup.Row.TOP,0)
                        .displayName(Text.translatable("itemGroup.mhc.more_hammers"))
                        .icon(() -> new ItemStack(ModItems.DEFAULT_HAMMER)).entries((displayContext, entries) -> {
                            entries.add(ModItems.VAMPIRE_HAMMER);
                            entries.add(ModItems.DEFAULT_HAMMER);
                            entries.add(ModItems.TALLER_HAMMER);
                            entries.add(ModItems.SLOWNESS_HAMMER);
                            entries.add(ModItems.LEFT_HAMMER);
                            entries.add(ModItems.RIGHT_HAMMER);
                        }).build());
        Registry.register(Registries.ITEM_GROUP,ModItemGroups.FUNCTION_ITEMS,
                ItemGroup.create(ItemGroup.Row.TOP,0)
                        .displayName(Text.translatable("itemGroup.mhc.function_items"))
                        .icon(() -> new ItemStack(ModItems.PROSPECTOR)).entries((displayContext, entries) -> {
                            entries.add(ModItems.VAMPIRE_HAMMER);
                            entries.add(ModItems.SLOWNESS_HAMMER);
                            entries.add(ModItems.PROSPECTOR);
                            entries.add(ModItems.DRAGON_CLAW);
                            entries.add(ModItems.WOODEN_SICKLE);
                            entries.add(ModItems.SMALL_DRAGON_CLAW);
                            entries.add(ModItems.ICE_DRAGON_SWORD);
                            entries.add(ModItems.ICE_SWORD);
                            //entries.add(ModItems.SICKLE_HEAD);
                            entries.add(ModItems.STONE_SICKLE);
                            entries.add(ModItems.IRON_SICKLE);
                            entries.add(ModItems.GOLD_SICKLE);
                            entries.add(ModItems.DIAMOND_SICKLE);
                            entries.add(ModItems.NETHERITE_SICKLE);
                            entries.add(ModBlocks.RUBY_BUTTON);
                            entries.add(ModBlocks.RUBY_DOOR);
                            entries.add(ModBlocks.RUBY_TRAPDOOR);
                            entries.add(ModBlocks.RUBY_PRESSURE_PLATE);
                            entries.add(ModBlocks.POLISH_MACHINE);
                            entries.add(ModBlocks.DRAGON_FLAG_BLOCK);
                            entries.add(ModItems.HAMMER_CRAFTING);
                        }).build());
        Registry.register(Registries.ITEM_GROUP,ModItemGroups.INGREDIENTS,
                ItemGroup.create(ItemGroup.Row.TOP,0)
                        .displayName(Text.translatable("itemGroup.mhc.ingredients"))
                        .icon(() -> new ItemStack(ModItems.DEFAULT_INGOT)).entries((displayContext, entries) -> {
                            entries.add(ModItems.DEFAULT_INGOT);
                            entries.add(ModItems.SLOWNESS_INGOT);
                            entries.add(ModItems.VAMPIRE_INGOT);
                            entries.add(ModItems.IRON_CAN);
                            entries.add(ModItems.SICKLE_HEAD);
                            entries.add(ModItems.RUBY);
                        }).build());
        Registry.register(Registries.ITEM_GROUP,ModItemGroups.ZHENGHUO,
                ItemGroup.create(ItemGroup.Row.TOP,0)
                        .displayName(Text.translatable("itemGroup.mhc.zhenghuo"))
                        .icon(() -> new ItemStack(ModItems.FLYDRAGON)).entries((displayContext, entries) -> {
                            entries.add(ModItems.FLYDRAGON);
                            entries.add(ModItems.FLYDRAGON_STUDIO);
                            entries.add(ModItems.WINDOWS);
                            entries.add(ModItems.BRICK);
                        }).build());
        Registry.register(Registries.ITEM_GROUP,ModItemGroups.FOODS,
                ItemGroup.create(ItemGroup.Row.TOP,0)
                        .displayName(Text.translatable("itemGroup.mhc.food"))
                        .icon(() -> new ItemStack(ModItems.FLYDRAGON_STUDIO)).entries((displayContext, entries) -> {
                            entries.add(ModItems.NEW_FOOD);
                            entries.add(ModItems.FLYDRAGON_STUDIO);
                            entries.add(ModItems.MORE_PAPERS);
                            entries.add(ModItems.PAPERS);
                            entries.add(ModItems.IRON_COLA);
                            //entries.add((ItemConvertible) ModPotions.FIRE_ON_ONESELF);
                        }).build());
        Registry.register(Registries.ITEM_GROUP,ModItemGroups.NATURAL_BLOCKS,
                ItemGroup.create(ItemGroup.Row.TOP,0)
                        .displayName(Text.translatable("itemGroup.mhc.natural_block"))
                        .icon(() -> new ItemStack(ModBlocks.RUBY_ORE)).entries((displayContext, entries) -> {
                            entries.add(ModBlocks.RUBY_ORE);
                            entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
//                            entries.add(ModItems.FLYDRAGON_STUDIO);
//                            entries.add(ModItems.MORE_PAPERS);
//                            entries.add(ModItems.PAPERS);
//                            entries.add(ModItems.IRON_COLA);
                            //entries.add((ItemConvertible) ModPotions.FIRE_ON_ONESELF);
                        }).build());
        Registry.register(Registries.ITEM_GROUP,ModItemGroups.BUILDING_BLOCKS,
                ItemGroup.create(ItemGroup.Row.TOP,0)
                        .displayName(Text.translatable("itemGroup.mhc.building_block"))
                        .icon(() -> new ItemStack(ModBlocks.RUBY_BLOCK)).entries((displayContext, entries) -> {
                            entries.add(ModBlocks.RUBY_WALL);
                            entries.add(ModBlocks.RUBY_STAIRS);
                            entries.add(ModBlocks.RUBY_SLAB);
                            entries.add(ModBlocks.RUBY_BUTTON);
                            entries.add(ModBlocks.RUBY_DOOR);
                            entries.add(ModBlocks.RUBY_TRAPDOOR);
                            entries.add(ModBlocks.RUBY_PRESSURE_PLATE);;
                            entries.add(ModBlocks.RUBY_BLOCK);
                        }).build());
    }


}
