package net.redstone233.morehammercraft.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.redstone233.morehammercraft.MoreHammerCraft;

import java.util.Objects;

public class TestCommands {

    private static final String[] PAGE1_HELP = {
            "test version get <value> - Get the mod version",
            "test author get <value> - Get the mod author",
            "test help <page> - Get help on the mod",
            "test run <commands> <value> - Run a command with a boolean value"
    };

    private static final String[] PAGE2_HELP = {
            "test help <page> - Get help on the mod",
            "--The page argument can only be 1 or 2.",
            "test run <commands> <value> - Run a command with a boolean value",
            "--The commands argument can only be 'test' or 'boom'."
    };

    private static String page1Help() {
        StringBuilder builder = new StringBuilder();
        for (String s : PAGE1_HELP) {
            builder.append(s).append("\n");
        }
        return builder.toString();
    }

    private static String page2Help() {
        StringBuilder builder = new StringBuilder();
        for (String s : PAGE2_HELP) {
            builder.append(s).append("\n");
        }
        return builder.toString();
    }




    public static LiteralArgumentBuilder<ServerCommandSource> register() {
        return CommandManager.literal("test")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.literal("version")
                        .then(CommandManager.literal("get")
                                .then(CommandManager.argument("value", BoolArgumentType.bool())
                                .executes(run -> execute(
                                        run.getSource(),
                                        BoolArgumentType.getBool(run, "value")))
                                )
                        )
                )
                .then(CommandManager.literal("author")
                        .then(CommandManager.literal("get")
                                .then(CommandManager.argument("value", BoolArgumentType.bool())
                                .executes(run -> execute1(
                                        run.getSource(),
                                        BoolArgumentType.getBool(run, "value")))
                                )
                        )
                )
                .then(CommandManager.literal("help")
                        .executes(run -> execute(run.getSource()))
                        .then(CommandManager.argument("page", IntegerArgumentType.integer(1,2))
                        .executes(run -> execute(
                                run.getSource(),
                                IntegerArgumentType.getInteger(run, "page"))
                                )

                        )

                )
                .then(CommandManager.literal("run")
                        .then(CommandManager.argument("commands", StringArgumentType.string())
                                .then(CommandManager.argument("value",BoolArgumentType.bool())
                                .executes(run -> execute(
                                        run.getSource(),
                                        StringArgumentType.getString(run, "commands"),
                                        BoolArgumentType.getBool(run, "value")))
                                )
                        )
                );

    }

    private static int execute(ServerCommandSource source, boolean value) {
        if (value) {
            source.sendFeedback(() -> Text.translatable("commands.test.version.get.success", MoreHammerCraft.MOD_VERSION), false);
        } else {
            source.sendError(Text.translatable("commands.test.version.get.fail"));
            return 0;
        }
        return 1;
    }

    private static int execute(ServerCommandSource source) {
        World world = source.getWorld();
        if (!world.isClient()) {
            source.sendError(Text.translatable("commands.test.help.fail"));
            return 0;
        } else {
            source.sendFeedback(() -> Text.translatable("commands.test.help.success", page1Help()), false);
        }
        return 1;
    }

    private static int execute1(ServerCommandSource source, boolean value) {
        if (value) {
            source.sendFeedback(() -> Text.translatable("commands.test.author.get.success", MoreHammerCraft.MOD_AUTHOR), false);
        } else {
            source.sendError(Text.translatable("commands.test.author.get.fail"));
            return 0;
        }
        return 1;
    }

    private static int execute(ServerCommandSource source, int page) throws CommandSyntaxException {
        if (page == 1) {
            source.sendFeedback(() -> Text.translatable("commands.test.help.page1.success", page1Help()), false);
        } else if (page == 2) {
            source.sendFeedback(() -> Text.translatable("commands.test.help.page2.success", page2Help()), false);
        } else if (page >= 3) {
            throw CommandSyntaxFailed.INT_SO_BIG.create();
        } else if (page <= 0){
            throw CommandSyntaxFailed.INT_SO_SMALL.create();
        } else {
            source.sendError(Text.translatable("commands.test.help.page.fail"));
            return 0;
        }
        return 1;
    }

    private static int execute(ServerCommandSource source, String commands, boolean value) {
        if (value) {
            if (Objects.equals(commands, "test")) {
                source.sendFeedback(() -> Text.translatable("commands.test.run.success"), false);
                return 1;
            } else {
                source.sendError(Text.translatable("commands.test.run.fail"));
            }
            if (Objects.equals(commands, "boom")) {
                source.sendFeedback(() -> Text.translatable("commands.test.run.boom.success"), false);
                return 1;
            } else if (!value) {
                source.sendFeedback(() -> Text.translatable("commands.test.run.success"), false);
                return 1;
            } else {
                source.sendError(Text.translatable("commands.test.run.boom.fail"));
                return 0;
            }
        }
        return 1;
    }
}
