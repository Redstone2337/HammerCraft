package net.redstone233.morehammercraft.commands;

import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import net.minecraft.text.Text;

public class CommandSyntaxFailed {
    public static final SimpleCommandExceptionType NOT_AT_DOUBLE = new SimpleCommandExceptionType(Text.translatable("command.mch.double.fail"));
    public static final SimpleCommandExceptionType DOUBLE_SO_BIG = new SimpleCommandExceptionType(Text.translatable("command.mch.double.big"));
    public static final SimpleCommandExceptionType DOUBLE_SO_SMALL = new SimpleCommandExceptionType(Text.translatable("command.mch.double.small"));
    public static final SimpleCommandExceptionType NOT_AT_INT = new SimpleCommandExceptionType(Text.translatable("command.mch.int.fail"));
    public static final SimpleCommandExceptionType INT_SO_BIG = new SimpleCommandExceptionType(Text.translatable("command.mch.int.big"));
    public static final SimpleCommandExceptionType INT_SO_BIGGISET = new SimpleCommandExceptionType(Text.translatable("command.mch.int.biggiset"));
    public static final SimpleCommandExceptionType INT_SO_SMALL = new SimpleCommandExceptionType(Text.translatable("command.mch.int.small"));
    public static final SimpleCommandExceptionType NOT_AT_FLOAT = new SimpleCommandExceptionType(Text.translatable("command.mch.float.fail"));
    public static final SimpleCommandExceptionType FLOAT_SO_BIG = new SimpleCommandExceptionType(Text.translatable("command.mch.float.big"));
    public static final SimpleCommandExceptionType FLOAT_SO_SMALL = new SimpleCommandExceptionType(Text.translatable("command.mch.float.small"));
}

