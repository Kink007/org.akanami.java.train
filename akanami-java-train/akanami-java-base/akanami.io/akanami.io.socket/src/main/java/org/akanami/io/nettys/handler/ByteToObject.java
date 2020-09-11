package org.akanami.io.nettys.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ByteToObject extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() >= 2) {
            int len = (int)in.getByte(in.readerIndex() + 1);
            if (in.readableBytes() >= len) {
                byte[] buff = new byte[len];
                in.readBytes(buff);

                out.add(buff);
            }
        }
    }
}
