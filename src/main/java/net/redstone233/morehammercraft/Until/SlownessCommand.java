package net.redstone233.morehammercraft.commands;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.redstone233.morehammercraft.items.funcitem.SlownessHammer;

public class SlownessCommand {
    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("slowness")
                .requires(src -> src.hasPermissionLevel(4))
                .then(
                        CommandManager.literal("set")
                            .then(
                                CommandManager.literal("damage")
                                    .then(
                                        CommandManager.argument("damage", IntegerArgumentType.integer(1,500))
                                    )
                                        .executes(
                                                run -> execute(
                                                    run.getSource(),
                                                        IntegerArgumentType.getInteger(run,"damage")
                                                )
                                        )
                                )
                                .then(
                                        CommandManager.literal("speed")
                                                .then(
                                                        CommandManager.argument("speed", FloatArgumentType.floatArg())
                                                )
                                                .executes(
                                                        run -> execute(
                                                                run.getSource(),
                                                                FloatArgumentType.getFloat(run,"speed")
                                                        )
                                                )
                                )
                                .then(
                                        CommandManager.literal("effect")
                                                .then(
                                                        CommandManager.argument("duration", IntegerArgumentType.integer(30))
                                                                .then(CommandManager.argument("amplifier",IntegerArgumentType.integer(1,255))
                                                                        .executes(run -> execute(
                                                                                run.getSource(),
                                                                                IntegerArgumentType.getInteger(run,"duration"),
                                                                                IntegerArgumentType.getInteger(run,"amplifier")
                                                                            )
                                                                        )
                                                                )
                                                )
                                )
                );
    }

    private static int execute(ServerCommandSource source,int damage) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
            if (damage > 0 && damage <= 500) {
                SlownessHammer.setAttackDamageModifierValue(damage);
                source.sendFeedback(() -> Text.translatable("commands.slowness.success",SlownessHammer.getAttackDamageModifierValue()),true);
                return damage;
            } else if (damage <= 0) {
                throw CommandSyntaxFailed.INT_SO_SMALL.create();
            } else if (damage >= 501) {
                throw CommandSyntaxFailed.FLOAT_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.slowness.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int execute(ServerCommandSource source,float speed) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
            if (speed > 0 && speed <= 100) {
                SlownessHammer.setAttackSpeedModifierValue(speed);
                source.sendFeedback(() -> Text.translatable("commands.slowness.success",SlownessHammer.getAttackSpeedModifierValue()),true);
                return (int) speed;
            } else if (speed >= 0) {
                throw CommandSyntaxFailed.FLOAT_SO_SMALL.create();
            } else if (speed <= 101) {
                throw CommandSyntaxFailed.FLOAT_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.slowness.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int execute(ServerCommandSource source,int duration,int amplifier) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
            if (duration > 0 && duration <= 240) {
                SlownessHammer.setDuration(duration);
                source.sendFeedback(() -> Text.translatable("commands.slowness.success",SlownessHammer.getDuration()),true);
                return duration;
            } else if (duration < 0) {
                throw CommandSyntaxFailed.INT_SO_BIG.create();
            } else if (duration >= 241) {
                throw CommandSyntaxFailed.DOUBLE_SO_BIG.create();
            } else if (amplifier > 0 && amplifier <= 255) {
                SlownessHammer.setAmplifier(amplifier);
                source.sendFeedback(() -> Text.translatable("commands.slowness.success",SlownessHammer.getAmplifier()),true);
                return amplifier;
            } else if (amplifier > 0) {
                throw CommandSyntaxFailed.INT_SO_SMALL.create();
            } else if (amplifier >= 256) {
                throw CommandSyntaxFailed.INT_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.slowness.fail"));
                return 0;
            }
        }
        return 1;
    }

}
