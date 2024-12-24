package net.redstone233.morehammercraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.redstone233.morehammercraft.MoreHammerCraft;

import java.util.function.Function;

public class ModBlocks {

    public static final Block POLISH_MACHINE = register("conversion_table",PolishMachine::new,
            AbstractBlock.Settings.create().mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BIT).requiresTool().strength(5.0f,4.5f));
    public static final Block DRAGON_FLAG_BLOCK = register("dragon_flag",DragonFlagBlock::new,
            DragonFlagBlock.Settings.create().mapColor(MapColor.BLUE).instrument(NoteBlockInstrument.HARP).requiresTool().strength(4.0f,5.0f));
    public static final Block RUBY_ORE = register(
            "ruby_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings),
            AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(3.0F, 3.0F)
    );
        public static final Block DEEPSLATE_RUBY_ORE = register(
            "deepslate_ruby_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 7), settings),
            AbstractBlock.Settings.copy(RUBY_ORE.getDefaultState().getBlock()).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE)
    );
    public static final Block RUBY_BLOCK = register(
            "ruby_block",
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.BRIGHT_RED)
                    .instrument(NoteBlockInstrument.BIT)
                    .requiresTool()
                    .strength(5.0F, 6.0F)
                    .sounds(BlockSoundGroup.METAL)
    );

    public static final Block RUBY_STAIRS = register(
            "ruby_stairs",
            settings -> new StairsBlock(RUBY_BLOCK.getDefaultState(), settings),
            AbstractBlock.Settings.copy(RUBY_BLOCK.getDefaultState().getBlock()).mapColor(MapColor.BRIGHT_RED).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)
    );

    public static final Block RUBY_SLAB = register(
            "ruby_slab",
            SlabBlock::new,
            AbstractBlock.Settings.copy(RUBY_BLOCK.getDefaultState().getBlock()).mapColor(MapColor.BRIGHT_RED).strength(5.0F, 6.0F).sounds(BlockSoundGroup.METAL)
    );

   public static final Block RUBY_BUTTON = register(
            "ruby_button",
            settings -> new ButtonBlock(BlockSetType.IRON,40,settings),
           AbstractBlock.Settings.copy(RUBY_BLOCK.getDefaultState().getBlock()).mapColor(MapColor.BRIGHT_RED).strength(0.5F, 0.5F).sounds(BlockSoundGroup.METAL)
   );

   public static final Block RUBY_PRESSURE_PLATE = register(
            "ruby_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.copy(RUBY_BLOCK.getDefaultState().getBlock()).mapColor(MapColor.BRIGHT_RED).strength(0.5F, 0.5F).sounds(BlockSoundGroup.METAL)
   );

   public static final Block RUBY_FENCE = register(
            "ruby_fence",
            FenceBlock::new,
            AbstractBlock.Settings.copy(RUBY_BLOCK.getDefaultState().getBlock()).mapColor(MapColor.BRIGHT_RED).strength(2.0F, 3.0F).sounds(BlockSoundGroup.METAL)
   );

   public static final Block RUBY_FENCE_GATE = register(
            "ruby_fence_gate",
            settings -> new FenceGateBlock(WoodType.DARK_OAK, settings),
            AbstractBlock.Settings.copy(RUBY_BLOCK.getDefaultState().getBlock()).mapColor(MapColor.BRIGHT_RED).strength(2.0F, 3.0F).sounds(BlockSoundGroup.METAL)
   );

   public static final Block RUBY_WALL = register(
            "ruby_wall",
            WallBlock::new,
            AbstractBlock.Settings.copy(RUBY_BLOCK.getDefaultState().getBlock()).mapColor(MapColor.BRIGHT_RED).strength(2.0F, 3.0F).sounds(BlockSoundGroup.METAL)
   );

   public static final Block RUBY_DOOR = register(
            "ruby_door",
            settings -> new DoorBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.copy(RUBY_BLOCK.getDefaultState().getBlock()).mapColor(MapColor.BRIGHT_RED).strength(3.0F).sounds(BlockSoundGroup.METAL)
   );

   public static final Block RUBY_TRAPDOOR = register(
            "ruby_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.IRON, settings),
            AbstractBlock.Settings.copy(RUBY_BLOCK.getDefaultState().getBlock()).mapColor(MapColor.BRIGHT_RED).strength(3.0F).sounds(BlockSoundGroup.METAL)
   );

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(MoreHammerCraft.MOD_ID,id));
        final Block block = Blocks.register(registryKey,factory,settings);
        Items.register(block);
        return block;
    }

    private static Block register(String id, AbstractBlock.Settings settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK,Identifier.of(MoreHammerCraft.MOD_ID,id));
        final Block block = Blocks.register(registryKey,Block::new,settings);
        Items.register(block);
        return block;
    }

    public static void register() {
        MoreHammerCraft.LOGGER.info("Registering blocks for HammerCraft mod successful!");
    }
}
