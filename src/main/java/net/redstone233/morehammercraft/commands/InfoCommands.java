package net.redstone233.morehammercraft.commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
//import net.redstone233.builder.morebuilders.ExperienceSystemBuilder;

public class InfoCommands {
    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("info")
                .requires(src -> src.hasPermissionLevel(4))
                .then(CommandManager.argument("target",EntityArgumentType.player())
                        .then(CommandManager.literal("get")
                                .then(CommandManager.literal("level")
                                        .executes(run -> execute(
                                                run.getSource(),
                                                run.getSource().getPlayer()
                                        ))
                                )
                                .then(CommandManager.literal("experience")
                                        .executes(run -> execute1(
                                                run.getSource(),
                                                run.getSource().getPlayer()
                                        ))
                                )
                                .then(CommandManager.literal("multiplier")
                                        .executes(run -> execute2(
                                                run.getSource(),
                                                run.getSource().getPlayer()
                                        ))
                                )
                                .then(CommandManager.literal("next")
                                        .executes(run -> execute3(
                                                run.getSource(),
                                                run.getSource().getPlayer()
                                        ))
                                )
                        )
                        .then(CommandManager.literal("set")
                                .then(CommandManager.literal("level")
                                        .then(CommandManager.argument("lvl", IntegerArgumentType.integer(1))
                                                .executes(run -> execute(
                                                        run.getSource(),
                                                        run.getSource().getPlayer(),
                                                        IntegerArgumentType.getInteger(run,"lvl")
                                                ))
                                        )
                                )
                                .then(CommandManager.literal("experience")
                                        .then(CommandManager.argument("exp",IntegerArgumentType.integer(1))
                                                .executes(run -> execute1(
                                                        run.getSource(),
                                                        run.getSource().getPlayer(),
                                                        IntegerArgumentType.getInteger(run,"exp")
                                                ))
                                        )
                                )
                                .then(CommandManager.literal("multiplier")
                                        .then(CommandManager.argument("multiplier", DoubleArgumentType.doubleArg(1))
                                                .executes(run -> execute(
                                                        run.getSource(),
                                                        run.getSource().getPlayer(),
                                                        DoubleArgumentType.getDouble(run,"multiplier")
                                                ))
                                        )
                                )
                                .then(CommandManager.literal("next")
                                        .then(CommandManager.argument("next",IntegerArgumentType.integer(1))
                                                .executes(run -> execute2(
                                                        run.getSource(),
                                                        run.getSource().getPlayer(),
                                                        IntegerArgumentType.getInteger(run,"next")
                                                ))
                                        )
                                )
                        )
                );
    }

    private static final int level = 1;
    private static final int experience = 100;
    private static final double experienceMultiplier = 1.5;

    private static int execute(ServerCommandSource source, PlayerEntity player) {
        if (source instanceof ServerCommandSource) {
            if (player != null) {
               /* ExperienceSystemBuilder experienceSystemBuilder = new ExperienceSystemBuilder.Builder()
                        .experience(experience)
                        .level(level)
                        .experienceMultiplier(experienceMultiplier)
                        .build();
                String lvl = String.valueOf(experienceSystemBuilder.getLevel());
                //String exp = String.valueOf(experienceSystemBuilder.getExperience());
                String next = String.valueOf(experienceSystemBuilder.getExperienceToNextLevel());*/
                source.sendFeedback(() -> Text.translatable("commands.info.success"/*,player.getName(),lvl,next*/),true);
                //return experienceSystemBuilder.getLevel();
            } else {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int execute1(ServerCommandSource source, PlayerEntity player) {
        if (source instanceof ServerCommandSource) {
            if (player != null) {
               /* ExperienceSystemBuilder experienceSystemBuilder = new ExperienceSystemBuilder.Builder()
                        .experience(experience)
                        .level(level)
                        .experienceMultiplier(experienceMultiplier)
                        .build();
                String lvl = String.valueOf(experienceSystemBuilder.getLevel());
                String exp = String.valueOf(experienceSystemBuilder.getExperience());
                String next = String.valueOf(experienceSystemBuilder.getExperienceToNextLevel());*/
                source.sendFeedback(() -> Text.translatable("commands.info.success"/*,player.getName(),lvl,exp,next*/),true);
                //return experienceSystemBuilder.getExperience();
            } else {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int execute2(ServerCommandSource source, PlayerEntity player) {
        if (source instanceof ServerCommandSource) {
            if (player != null) {
                /*ExperienceSystemBuilder experienceSystemBuilder = new ExperienceSystemBuilder.Builder()
                        .experience(experience)
                        .level(level)
                        .experienceMultiplier(experienceMultiplier)
                        .build();
                String lvl = String.valueOf(experienceSystemBuilder.getLevel());
                String exp = String.valueOf(experienceSystemBuilder.getExperience());
                String next = String.valueOf(experienceSystemBuilder.getExperienceToNextLevel());*/
                source.sendFeedback(() -> Text.translatable("commands.info.success"/*,player.getName(),lvl,exp,next*/),true);
                //return (int) experienceSystemBuilder.getExperienceMultiplier();
            } else {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int execute3(ServerCommandSource source, PlayerEntity player) {
        if (source instanceof ServerCommandSource) {
            if (player != null) {
               /* ExperienceSystemBuilder experienceSystemBuilder = new ExperienceSystemBuilder.Builder()
                        .experience(experience)
                        .level(level)
                        .experienceMultiplier(experienceMultiplier)
                        .build();
                String lvl = String.valueOf(experienceSystemBuilder.getLevel());
                String exp = String.valueOf(experienceSystemBuilder.getExperience());
                String next = String.valueOf(experienceSystemBuilder.getExperienceToNextLevel());*/
                source.sendFeedback(() -> Text.translatable("commands.info.success"/*,player.getName(),lvl,next*/),true);
                //return experienceSystemBuilder.getExperienceToNextLevel();
            } else {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int execute(ServerCommandSource source, PlayerEntity player, int levels) {
        if (source instanceof ServerCommandSource) {
            if (player != null) {
                /*ExperienceSystemBuilder experienceSystemBuilder = new ExperienceSystemBuilder.Builder()
                        .experience(experience)
                        .level(levels)
                        .experienceMultiplier(experienceMultiplier)
                        .build();*/
                source.sendFeedback(() -> Text.translatable("commands.info.set.success"/*,levels*/),true);
                //return experienceSystemBuilder.getLevel();
            } else {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int execute1(ServerCommandSource source, PlayerEntity player, int experiences) {
        if (source instanceof ServerCommandSource) {
            if (player != null) {
                /*ExperienceSystemBuilder experienceSystemBuilder = new ExperienceSystemBuilder.Builder()
                        .experience(experiences)
                        .level(level)
                        .experienceMultiplier(experienceMultiplier)
                        .build();*/
                source.sendFeedback(() -> Text.translatable("commands.info.set.success"/*,experiences*/),true);
                //return experienceSystemBuilder.getExperience();
            } else {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int execute(ServerCommandSource source, PlayerEntity player, double experienceMultipliers) {
        if (source instanceof ServerCommandSource) {
            if (player != null) {
                /*ExperienceSystemBuilder experienceSystemBuilder = new ExperienceSystemBuilder.Builder()
                        .experience(experience)
                        .level(level)
                        .experienceMultiplier(experienceMultipliers)
                        .build();*/
                source.sendFeedback(() -> Text.translatable("commands.info.set.success"/*,String.valueOf(experienceSystemBuilder.getExperienceMultiplier())*/),true);
                //return experienceSystemBuilder.getExperience();
            } else {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int execute2(ServerCommandSource source, PlayerEntity player, int experienceToNextLevel) {
        if (source instanceof ServerCommandSource) {
            if (player != null) {
                /*ExperienceSystemBuilder experienceSystemBuilder = new ExperienceSystemBuilder.Builder()
                        .experience(experience)
                        .level(level)
                        .experienceMultiplier(experienceMultiplier)
                        .experienceToNextLevel(experienceToNextLevel)
                        .build();*/
                source.sendFeedback(() -> Text.translatable("commands.info.set.success"/*,String.valueOf(experienceToNextLevel)*/),true);
                //return experienceSystemBuilder.getExperience();
            } else {
                source.sendError(Text.translatable("commands.info.fail"));
                return 0;
            }
        }
        return 1;
    }
}
