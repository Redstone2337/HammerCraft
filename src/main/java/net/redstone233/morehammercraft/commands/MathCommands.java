package net.redstone233.morehammercraft.commands;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class MathCommands {

    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("math")
                .requires(src -> src.hasPermissionLevel(2))
                .then(CommandManager.literal("multiply")
                        .then(CommandManager.argument("value1", IntegerArgumentType.integer())
                                .then(CommandManager.argument("value2", IntegerArgumentType.integer())
                                .executes(run -> execute(
                                        run.getSource(),
                                        IntegerArgumentType.getInteger(run, "value1"),
                                        IntegerArgumentType.getInteger(run, "value2")))
                                )
                        )
                )
                .then(CommandManager.literal("divide")
                        .then(CommandManager.argument("value1", IntegerArgumentType.integer())
                                .then(CommandManager.argument("value2", IntegerArgumentType.integer())
                                .executes(run -> execute2(
                                        run.getSource(),
                                        IntegerArgumentType.getInteger(run, "value1"),
                                        IntegerArgumentType.getInteger(run, "value2")))
                                )
                        )
                )
                .then(CommandManager.literal("add")
                        .then(CommandManager.argument("value1", IntegerArgumentType.integer())
                                .then(CommandManager.argument("value2", IntegerArgumentType.integer())
                                .executes(run -> execute3(
                                        run.getSource(),
                                        IntegerArgumentType.getInteger(run, "value1"),
                                        IntegerArgumentType.getInteger(run, "value2")))
                                )
                        )
                )
                .then(CommandManager.literal("remove")
                        .then(CommandManager.argument("value1", IntegerArgumentType.integer())
                                .then(CommandManager.argument("value2", IntegerArgumentType.integer())
                                .executes(run -> execute4(
                                        run.getSource(),
                                        IntegerArgumentType.getInteger(run, "value1"),
                                        IntegerArgumentType.getInteger(run, "value2")))
                                )
                        )
                )
                .then(CommandManager.literal("power")
                        .then(CommandManager.argument("value1", IntegerArgumentType.integer())
                                .then(CommandManager.argument("value2", IntegerArgumentType.integer())
                                .executes(run -> execute5(
                                        run.getSource(),
                                        IntegerArgumentType.getInteger(run, "value1"),
                                        IntegerArgumentType.getInteger(run, "value2")))
                                )
                        )
                )
                .then(CommandManager.literal("mod")
                        .then(CommandManager.argument("value1", IntegerArgumentType.integer())
                                .then(CommandManager.argument("value2", IntegerArgumentType.integer())
                                .executes(run -> execute6(
                                        run.getSource(),
                                        IntegerArgumentType.getInteger(run, "value1"),
                                        IntegerArgumentType.getInteger(run, "value2")))
                                )
                        )
                )
                .then(CommandManager.literal("abs")
                        .then(CommandManager.argument("value", IntegerArgumentType.integer())
                        .executes(run -> execute7(
                                    run.getSource(),
                                    IntegerArgumentType.getInteger(run, "value"))
                            )
                        )
                )
                .then(CommandManager.literal("floor")
                        .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> execute8(
                                        run.getSource(),
                                        DoubleArgumentType.getDouble(run, "value"))
                                )
                        )
                )
                .then(CommandManager.literal("ceil")
                        .then(CommandManager.argument("value", DoubleArgumentType.doubleArg()))
                        .executes(run -> execute9(
                                        run.getSource(),
                                        DoubleArgumentType.getDouble(run, "value")
                                )
                        )
                )
                .then(CommandManager.literal("round")
                        .then(CommandManager.argument("value", FloatArgumentType.floatArg())
                        .executes(run -> execute10(
                                        run.getSource(),
                                        FloatArgumentType.getFloat(run, "value"))
                                )
                        )
                )
                .then(CommandManager.literal("sin")
                        .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> execute11(
                                        run.getSource(),
                                        DoubleArgumentType.getDouble(run, "value"))
                                )
                        )
                )
                .then(CommandManager.literal("cos")
                        .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> execute12(
                                        run.getSource(),
                                        DoubleArgumentType.getDouble(run, "value"))
                                )
                        )
                )
                .then(CommandManager.literal("tan")
                        .then(CommandManager.argument("value", DoubleArgumentType.doubleArg())
                        .executes(run -> execute13(
                                        run.getSource(),
                                        DoubleArgumentType.getDouble(run, "value"))
                                )
                        )
                );
    }

    private static int execute(ServerCommandSource source,int value1,int value2) throws CommandSyntaxException {
        if (value1 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value2 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value1 < 0 && value2 < 0) {
            throw CommandSyntaxFailed.NOT_AT_INT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.multiply.result", value1, value2, value1 * value2), false);
        }
        return value1 * value2;
    }

    private static int execute2(ServerCommandSource source,int value1,int value2) throws CommandSyntaxException {
        if (value1 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value2 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value1 < 0 && value2 < 0) {
            throw CommandSyntaxFailed.NOT_AT_INT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.divide.result", value1, value2, value1 * value2), false);
        }
        return value1 / value2;
    }

    private static int execute3(ServerCommandSource source,int value1,int value2) throws CommandSyntaxException {
        if (value1 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value2 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value1 < 0 && value2 < 0) {
            throw CommandSyntaxFailed.NOT_AT_INT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.add.result", value1, value2, value1 + value2), false);
        }
        return value1 + value2;
    }

    private static int execute4(ServerCommandSource source,int value1,int value2) throws CommandSyntaxException {
        if (value1 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value2 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value1 < 0 && value2 < 0) {
            throw CommandSyntaxFailed.NOT_AT_INT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.remove.result", value1, value2, value1 - value2), false);
        }
        return value1 - value2;
    }

    private static int execute5(ServerCommandSource source,int value1,int value2) throws CommandSyntaxException {
        if (value1 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value2 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value1 < 0 && value2 < 0) {
            throw CommandSyntaxFailed.NOT_AT_INT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.power.result", value1, value2, value1 ^ value2), false);
        }
        return value1 ^ value2;
    }

    private static int execute6(ServerCommandSource source,int value1,int value2) throws CommandSyntaxException {
        if (value1 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else if (value2 == 0) {
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.mod.result", value1, value2, value1 % value2), false);
        }
        return value1 % value2;
    }

    private static int execute7(ServerCommandSource source,int value) throws CommandSyntaxException {
        if (value == 0) {
            throw CommandSyntaxFailed.NOT_AT_INT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.abs.result", value, Math.abs(value)), false);
        }
        return Math.abs(value);
    }

    private static int execute8(ServerCommandSource source,double value) throws CommandSyntaxException {
        if (value == 0) {
            throw CommandSyntaxFailed.NOT_AT_DOUBLE.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.floor.result", value, Math.floor(value)), false);
        }
        return (int) Math.floor(value);
    }

    private static int execute9(ServerCommandSource source,double value) throws CommandSyntaxException {
        if (value == 0) {
            throw CommandSyntaxFailed.NOT_AT_INT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.ceil.result", value, Math.ceil(value)), false);
        }
        return (int) Math.ceil(value);
    }

    private static int execute10(ServerCommandSource source,float value) throws CommandSyntaxException {
        if (value == 0) {
            throw CommandSyntaxFailed.NOT_AT_FLOAT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.round.result", value, Math.round(value)), false);
        }
        return Math.round(value);
    }

    private static int execute11(ServerCommandSource source,double value) throws CommandSyntaxException {
        if (value == 0) {
            throw CommandSyntaxFailed.NOT_AT_DOUBLE.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.sin.result", value, Math.sin(value)), false);
        }
        return (int) Math.sin(value);
    }

    private static int execute12(ServerCommandSource source,double value) throws CommandSyntaxException {
        if (value == 0) {
            throw CommandSyntaxFailed.NOT_AT_FLOAT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.cos.result", value, Math.cos(value)), false);
        }
        return (int) Math.cos(value);
    }

    private static int execute13(ServerCommandSource source,double value) throws CommandSyntaxException {
        if (value == 0) {
            throw CommandSyntaxFailed.NOT_AT_FLOAT.create();
        } else {
            source.sendFeedback(() -> Text.translatable("command.mch.tan.result", value, Math.tan(value)), false);
        }
        return (int) Math.tan(value);
    }

}
