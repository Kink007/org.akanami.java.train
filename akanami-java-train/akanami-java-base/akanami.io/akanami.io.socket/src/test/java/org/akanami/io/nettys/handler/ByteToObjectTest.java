package org.akanami.io.nettys.handler;

import com.sun.xml.internal.ws.policy.AssertionSet;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ByteToObjectTest {

    @Test
    public void testDecode() {
        EmbeddedChannel channel = new EmbeddedChannel(
                //new LengthFieldBasedFrameDecoder(5, 1, 1),
                new ByteToObject());
        //channel.pipeline().addLast();

        byte[] buf1 = {0x01, 0x02, 0x55, 0x03, 0x44};
        //byte[] buf2 = {};
        ByteBuf byteBuf = Unpooled.wrappedBuffer(buf1);

        channel.writeInbound(byteBuf);

        byte[] buff = (byte[]) channel.readInbound();
        Assert.assertEquals(2, buff.length);
        Assert.assertTrue(channel.finish());

        byte[] buff1 = (byte[]) channel.readInbound();
        Assert.assertEquals(3, buff1.length);
        Assert.assertFalse(channel.finish());
    }

    @Test
    public void testLengthFieldBasedFrameDecoder() {
        EmbeddedChannel channel = new EmbeddedChannel(new LengthFieldBasedFrameDecoder(1024, 1, 1, -2, 0));

        byte[] buf1 = {0x01, 0x02, 0x55, 0x03, 0x44};
        //byte[] buf2 = {};
        ByteBuf byteBuf = Unpooled.wrappedBuffer(buf1);

        channel.writeInbound(byteBuf);

        ByteBuf buff = (ByteBuf) channel.readInbound();
        Assert.assertEquals(2, buff.readableBytes());
        Assert.assertTrue(channel.finish());

        ByteBuf buff1 = (ByteBuf) channel.readInbound();
        Assert.assertEquals(3, buff1.readableBytes());
        Assert.assertFalse(channel.finish());
    }
}