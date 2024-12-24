package net.redstone233.morehammercraft.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.argument.BlockPosArgumentType;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BoomCommands {
    private static final float FLUE = 5.0F;
    private static final boolean FIRE = false;
    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("boom").requires(src -> src.hasPermissionLevel(4))
                .then(CommandManager.argument("targets", EntityArgumentType.entity())
                        .then(CommandManager.argument("SpawnPos", BlockPosArgumentType.blockPos())
                                .then(CommandManager.argument("isFire", BoolArgumentType.bool())
                                        .then(CommandManager.argument("flue", FloatArgumentType.floatArg(FLUE,20.0F))
                                                .then(CommandManager.literal("BLOCK")
                                                        .executes(run -> execute(
                                                                run.getSource(),
                                                                (LivingEntity) EntityArgumentType.getEntity(run,"targets"),
                                                                BlockPosArgumentType.getBlockPos(run,"SpawnPos"),
                                                                BoolArgumentType.getBool(run,"isFire"),
                                                                FloatArgumentType.getFloat(run,"flue")
                                                        ))
                                                )
                                                .then(CommandManager.literal("MOB")
                                                        .executes(run -> execute1(
                                                                run.getSource(),
                                                                (LivingEntity) EntityArgumentType.getEntity(run,"targets"),
                                                                BlockPosArgumentType.getBlockPos(run,"SpawnPos"),
                                                                BoolArgumentType.getBool(run,"isFire"),
                                                                FloatArgumentType.getFloat(run,"flue")
                                                        ))
                                                )
                                                .then(CommandManager.literal("TNT")
                                                        .executes(run -> execute2(
                                                                run.getSource(),
                                                                (LivingEntity) EntityArgumentType.getEntity(run,"targets"),
                                                                BlockPosArgumentType.getBlockPos(run,"SpawnPos"),
                                                                BoolArgumentType.getBool(run,"isFire"),
                                                                FloatArgumentType.getFloat(run,"flue")
                                                        ))
                                                )
                                                .then(CommandManager.literal("TRIGGER")
                                                        .executes(run -> execute3(
                                                                run.getSource(),
                                                                (LivingEntity) EntityArgumentType.getEntity(run,"targets"),
                                                                BlockPosArgumentType.getBlockPos(run,"SpawnPos"),
                                                                BoolArgumentType.getBool(run,"isFire"),
                                                                FloatArgumentType.getFloat(run,"flue")
                                                        ))
                                                )
                                                .then(CommandManager.literal("NONE")
                                                        .executes(run -> execute4(
                                                                run.getSource(),
                                                                (LivingEntity) EntityArgumentType.getEntity(run,"targets"),
                                                                BlockPosArgumentType.getBlockPos(run,"SpawnPos"),
                                                                BoolArgumentType.getBool(run,"isFire"),
                                                                FloatArgumentType.getFloat(run,"flue")
                                                        ))
                                                )
                                        )
                                )
                        )
                );
    }

    private static int execute(ServerCommandSource source, LivingEntity entity, BlockPos pos, boolean createFire, float flue) throws CommandSyntaxException {
        World world = source.getWorld();
        if (source instanceof ServerCommandSource) {
            if (entity == null && createFire) {
                if (flue > 0 && flue < 20) {
                    world.createExplosion(entity,pos.getX(),pos.getY(),pos.getZ(),flue,createFire, World.ExplosionSourceType.BLOCK);
                    source.sendFeedback(() -> Text.translatable("commands.boom.success",pos.getX(),pos.getY(),pos.getZ()),true);
                    return (int) flue;
                } else if (flue > 0) {
                    throw CommandSyntaxFailed.FLOAT_SO_SMALL.create();
                } else if (flue < 20) {
                    throw CommandSyntaxFailed.INT_SO_BIG.create();
                } else {
                    source.sendError(Text.translatable("commands.boom.fail"));
                    return 0;
                }
            }
        }
        return 1;
    }

    private static int execute1(ServerCommandSource source, LivingEntity entity, BlockPos pos, boolean createFire, float flue) throws CommandSyntaxException {
        World world = source.getWorld();
        if (source instanceof ServerCommandSource) {
            if (entity == null && createFire) {
                if (flue > 0 && flue < 20) {
                    world.createExplosion(entity,pos.getX(),pos.getY(),pos.getZ(),flue,createFire, World.ExplosionSourceType.MOB);
                    source.sendFeedback(() -> Text.translatable("commands.boom.success",pos.getX(),pos.getY(),pos.getZ()),true);
                    return (int) flue;
                } else if (flue > 0) {
                    throw CommandSyntaxFailed.FLOAT_SO_SMALL.create();
                } else if (flue < 20) {
                    throw CommandSyntaxFailed.INT_SO_BIG.create();
                } else {
                    source.sendError(Text.translatable("commands.boom.fail"));
                    return 0;
                }
            }
        }
        return 1;
    }

    private static int execute2(ServerCommandSource source, LivingEntity entity, BlockPos pos, boolean createFire, float flue) throws CommandSyntaxException {
        World world = source.getWorld();
        if (source instanceof ServerCommandSource) {
            if (entity == null && createFire) {
                if (flue > 0 && flue < 20) {
                    world.createExplosion(entity,pos.getX(),pos.getY(),pos.getZ(),flue,createFire, World.ExplosionSourceType.TNT);
                    source.sendFeedback(() -> Text.translatable("commands.boom.success",pos.getX(),pos.getY(),pos.getZ()),true);
                    return (int) flue;
                } else if (flue > 0) {
                    throw CommandSyntaxFailed.FLOAT_SO_SMALL.create();
                } else if (flue < 20) {
                    throw CommandSyntaxFailed.INT_SO_BIG.create();
                } else {
                    source.sendError(Text.translatable("commands.boom.fail"));
                    return 0;
                }
            }
        }
        return 1;
    }

    private static int execute3(ServerCommandSource source, LivingEntity entity, BlockPos pos, boolean createFire, float flue) throws CommandSyntaxException {
        World world = source.getWorld();
        if (source instanceof ServerCommandSource) {
            if (entity == null && createFire) {
                if (flue > 0 && flue < 20) {
                    world.createExplosion(entity,pos.getX(),pos.getY(),pos.getZ(),flue,createFire, World.ExplosionSourceType.TRIGGER);
                    source.sendFeedback(() -> Text.translatable("commands.boom.success",pos.getX(),pos.getY(),pos.getZ()),true);
                    return (int) flue;
                } else if (flue > 0) {
                    throw CommandSyntaxFailed.FLOAT_SO_SMALL.create();
                } else if (flue < 20) {
                    throw CommandSyntaxFailed.INT_SO_BIG.create();
                } else {
                    source.sendError(Text.translatable("commands.boom.fail"));
                    return 0;
                }
            }
        }
        return 1;
    }

    private static int execute4(ServerCommandSource source, LivingEntity entity, BlockPos pos, boolean createFire, float flue) throws CommandSyntaxException {
        World world = source.getWorld();
        if (source instanceof ServerCommandSource) {
            if (entity == null && createFire) {
                if (flue > 0 && flue < 20) {
                    world.createExplosion(entity,pos.getX(),pos.getY(),pos.getZ(),flue,createFire, World.ExplosionSourceType.NONE);
                    source.sendFeedback(() -> Text.translatable("commands.boom.success",pos.getX(),pos.getY(),pos.getZ()),true);
                } else if (flue > 0) {
                    throw CommandSyntaxFailed.FLOAT_SO_SMALL.create();
                } else if (flue < 20) {
                    throw CommandSyntaxFailed.INT_SO_BIG.create();
                } else {
                    source.sendError(Text.translatable("commands.boom.fail"));
                    return 0;
                }
            }
        }
        return 1;
    }
}
