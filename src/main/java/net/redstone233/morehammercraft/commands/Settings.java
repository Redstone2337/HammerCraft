package net.redstone233.morehammercraft.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.redstone233.morehammercraft.items.funcitem.DefaultHammer;
import net.redstone233.morehammercraft.items.funcitem.Prospector;
import net.redstone233.morehammercraft.items.funcitem.VampireHammer;

public class Settings {
    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("settings").requires(src -> src.hasPermissionLevel(4))
                .then(CommandManager.literal("hammer")
                        .then(CommandManager.literal("set")
                                .then(CommandManager.literal("heal")
                                        .then(CommandManager.argument("heal", DoubleArgumentType.doubleArg())
                                                .executes(run -> setHealth(run.getSource(),DoubleArgumentType.getDouble(run,"heal")))
                                        )
                                )
                                .then(CommandManager.literal("damage")
                                        .then(CommandManager.argument("damage", DoubleArgumentType.doubleArg())
                                                .executes(run -> setDamage(run.getSource(),DoubleArgumentType.getDouble(run,"damage")))
                                        )
                                )
                                .then(CommandManager.literal("speed")
                                        .then(CommandManager.argument("speed", FloatArgumentType.floatArg())
                                                .executes(run -> setAttackSpeed(run.getSource(),FloatArgumentType.getFloat(run,"speed")))
                                        )
                                )
                        )
                        .then(CommandManager.literal("get")
                                .then(CommandManager.literal("heal")
                                        .then(CommandManager.argument("value", BoolArgumentType.bool())
                                                .executes(run -> getHeal(run.getSource(),BoolArgumentType.getBool(run,"value")))
                                        )
                                )
                                .then(CommandManager.literal("damage")
                                        .then(CommandManager.argument("value", BoolArgumentType.bool())
                                                .executes(run -> getDamage(run.getSource(),BoolArgumentType.getBool(run,"value")))
                                        )
                                )
                                .then(CommandManager.literal("speed")
                                        .then(CommandManager.argument("value", BoolArgumentType.bool())
                                                .executes(run -> getSpeed(run.getSource(),BoolArgumentType.getBool(run,"value")))
                                        )
                                )
                        )
                )
                .then(CommandManager.literal("prospector")
                        .then(CommandManager.literal("set")
                                .then(CommandManager.literal("x")
                                        .then(CommandManager.argument("x", IntegerArgumentType.integer(1,64))
                                                .executes(run -> setX(run.getSource(),IntegerArgumentType.getInteger(run,"x")))
                                        )
                                )
                                .then(CommandManager.literal("z")
                                        .then(CommandManager.argument("z", IntegerArgumentType.integer(1,64))
                                                .executes(run -> setZ(run.getSource(),IntegerArgumentType.getInteger(run,"z")))
                                        )
                                )
                        )
                        .then(CommandManager.literal("get")
                                .then(CommandManager.literal("x")
                                        .then(CommandManager.argument("value", BoolArgumentType.bool())
                                                .executes(run -> getX(run.getSource(),BoolArgumentType.getBool(run,"value")))
                                        )
                                )
                                .then(CommandManager.literal("z")
                                        .then(CommandManager.argument("value", BoolArgumentType.bool())
                                                .executes(run -> geZ(run.getSource(),BoolArgumentType.getBool(run,"value")))
                                        )
                                )
                        )

                )
                .then(CommandManager.literal("default")
                        .then(CommandManager.literal("set")
                                .then(CommandManager.literal("damage")
                                        .then(CommandManager.argument("damage", IntegerArgumentType.integer())
                                                .executes(run -> setDefultDamage(run.getSource(),IntegerArgumentType.getInteger(run,"damage")))
                                        )
                                )
                                .then(CommandManager.literal("speed")
                                        .then(CommandManager.argument("speed", FloatArgumentType.floatArg())
                                                .executes(run -> setDefultSpeed(run.getSource(),FloatArgumentType.getFloat(run,"speed")))
                                        )
                                )
                        )
                        .then(CommandManager.literal("get")
                                .then(CommandManager.literal("damage")
                                        .then(CommandManager.argument("value", BoolArgumentType.bool())
                                                .executes(run -> getDefultDamage(run.getSource(),BoolArgumentType.getBool(run,"value")))
                                        )
                                )
                                .then(CommandManager.literal("speed")
                                        .then(CommandManager.argument("value", BoolArgumentType.bool())
                                                .executes(run -> getDefultSpeed(run.getSource(),BoolArgumentType.getBool(run,"value")))
                                        )
                                )
                        )

                );
    }

    private static int setHealth(ServerCommandSource source,double heal) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
            if (heal > 0 && heal < 255) {
                VampireHammer.setHealAmount(heal);
                source.sendFeedback(() -> Text.translatable("commands.settings.hammer.health.success","Health ",heal),true);
                return (int) heal;
            } else if (heal < 0) {
                throw CommandSyntaxFailed.DOUBLE_SO_SMALL.create();
            } else if (heal > 255) {
                throw CommandSyntaxFailed.DOUBLE_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int setDamage(ServerCommandSource source,double damage) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
            if (damage > 0 && damage < 255) {
                VampireHammer.setAttackDamageModifierValue((int) damage);
                source.sendFeedback(() -> Text.translatable("commands.settings.hammer.damage.success","Damage ",VampireHammer.getAttackDamageModifierValue()),true);
                return (int) damage;
            } else if (damage < 0) {
                throw CommandSyntaxFailed.DOUBLE_SO_SMALL.create();
            } else if (damage > 255) {
                throw CommandSyntaxFailed.DOUBLE_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int setAttackSpeed(ServerCommandSource source,float speed) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
            if (speed > 0 && speed < 100) {
                VampireHammer.setAttackSpeedModifierValue(speed);
                source.sendFeedback(() -> Text.translatable("commands.settings.hammer.speed.success",VampireHammer.getAttackSpeedModifierValue()),true);
            } else if (speed < 0) {
                throw CommandSyntaxFailed.FLOAT_SO_SMALL.create();
            } else if (speed > 100) {
                throw CommandSyntaxFailed.FLOAT_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int getHeal(ServerCommandSource source,boolean value) {
        if (source instanceof ServerCommandSource) {
           if (value) {
            source.sendFeedback(() -> Text.translatable("commands.settings.get.success","Health ",VampireHammer.getHealAmounts()),true);
           } else {
               source.sendError(Text.translatable("commands.settings.fail"));
               return 0;
           }
        }
        return 1;
    }

    private static int getDamage(ServerCommandSource source,boolean value) {
        if (source instanceof ServerCommandSource) {
                if (value) {
                    source.sendFeedback(() -> Text.translatable("commands.settings.get.success","Damage ",VampireHammer.getAttackDamageModifierValue()),true);
                } else {
                    source.sendError(Text.translatable("commands.settings.fail"));
                    return 0;
                }
        }
        return 1;
    }

    private static int getSpeed(ServerCommandSource source,boolean value) {
        if (source instanceof ServerCommandSource) {
            if (value) {
                source.sendFeedback(() -> Text.translatable("commands.settings.get.success","Speed ",VampireHammer.getAttackSpeedModifierValue()),true);
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int setX(ServerCommandSource source, int x) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
            if (x > 0 && x <= 64) {
                Prospector.setFoundBlockPos(x,Prospector.k1);
                source.sendFeedback(() -> Text.translatable("commands.settings.prospector.x.success",x),true);
                return x;
            } else if (x <= 0) {
                throw CommandSyntaxFailed.INT_SO_SMALL.create();
            } else if (x > 64) {
                throw CommandSyntaxFailed.INT_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int setZ(ServerCommandSource source, int z) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
            if (z > 0 && z <= 64) {
                Prospector.setFoundBlockPos(Prospector.j1,z);
                source.sendFeedback(() -> Text.translatable("commands.settings.prospector.z.success",z),true);
                return z;
            } else if (z <= 0) {
                throw CommandSyntaxFailed.INT_SO_SMALL.create();
            } else if (z > 64) {
                throw CommandSyntaxFailed.INT_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }
    private static int geZ(ServerCommandSource source,boolean value) {
        if (source instanceof ServerCommandSource) {
            if (value) {
                source.sendFeedback(() -> Text.translatable("commands.settings.get.success","X ",Prospector.j1),true);
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int getX(ServerCommandSource source,boolean value) {
        if (source instanceof ServerCommandSource) {
            if (value) {
                source.sendFeedback(() -> Text.translatable("commands.settings.get.success","Z ",Prospector.k1),true);
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int setDefultDamage(ServerCommandSource source,int damage) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
            if (damage > 0 && damage < 500) {
                DefaultHammer.setAttackDamageModifierValue(damage);
                source.sendFeedback(() -> Text.translatable("commands.settings.hammer.damage.success","Damage ",damage),true);
                return damage;
            } else if (damage <= 0) {
                throw CommandSyntaxFailed.INT_SO_SMALL.create();
            } else if (damage > 500) {
                throw CommandSyntaxFailed.INT_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int setDefultSpeed(ServerCommandSource source,float speed) throws CommandSyntaxException {
        if (source instanceof ServerCommandSource) {
                if (speed > 0 && speed < 100) {
                    DefaultHammer.setAttackSpeedModifierValue(speed);
                source.sendFeedback(() -> Text.translatable("commands.settings.hammer.speed.success","Speed  ",speed),true);
                return (int) speed;
            } else if (speed <= 0) {
                throw CommandSyntaxFailed.FLOAT_SO_SMALL.create();
            } else if (speed >100) {
                throw CommandSyntaxFailed.FLOAT_SO_BIG.create();
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    public static int getDefultDamage(ServerCommandSource source,boolean value) {
        if (source instanceof ServerCommandSource) {
            if (value) {
               int a = DefaultHammer.getAttackDamageModifierValue();
                source.sendFeedback(() -> Text.translatable("commands.settings.get.success",a),true);
                return a;
            } else {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }

    private static int getDefultSpeed(ServerCommandSource source,boolean value) {
        if (source instanceof ServerCommandSource) {
            if (value) {
                float a = DefaultHammer.getAttackSpeedModifierValue();
                source.sendFeedback(() -> Text.translatable("commands.settings.get.success",a),true);
                return (int) a;
            } else  {
                source.sendError(Text.translatable("commands.settings.fail"));
                return 0;
            }
        }
        return 1;
    }
}
