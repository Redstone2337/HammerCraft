package net.redstone233.morehammercraft.entities;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.redstone233.morehammercraft.MoreHammerCraft;
import net.redstone233.morehammercraft.blocks.ModBlocks;

public class ModBlockEntities {

    public static final BlockEntityType<PolishMachineBlockEntity> POLISH_MACHINE = create("conversion_table",FabricBlockEntityTypeBuilder.create(PolishMachineBlockEntity::new,ModBlocks.POLISH_MACHINE).build());

    private static <T extends BlockEntityType<?>> T create(String id, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoreHammerCraft.MOD_ID,id),blockEntityType);
    }

    public static void registerModBlockEntities() {
        MoreHammerCraft.LOGGER.info("注册"+MoreHammerCraft.MOD_ID+"的方块实体成功！");
    }
}
