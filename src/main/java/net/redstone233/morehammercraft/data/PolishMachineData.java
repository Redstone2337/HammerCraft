package net.redstone233.morehammercraft.data;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;
import net.redstone233.morehammercraft.network.BlockPosPayload;

public record PolishMachineData(BlockPos pos) implements BlockPosPayload {
    public static final PacketCodec<RegistryByteBuf, PolishMachineData> CODEC =
            PacketCodec.tuple(BlockPos.PACKET_CODEC,PolishMachineData::pos,PolishMachineData::new);
}
