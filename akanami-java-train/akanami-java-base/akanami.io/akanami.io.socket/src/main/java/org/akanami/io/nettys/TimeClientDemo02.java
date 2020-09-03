package org.akanami.io.nettys;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.net.InetSocketAddress;
import java.util.Date;
import java.util.List;

public class TimeClientDemo02 {
    public static final int SERVER_PORT = 10035;

    public static void main(String[] args) {
        new TimeClientDemo02().start();
    }

    public void start() {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new UnixTimeDecoder())
                                    .addLast(new TimeClientHandler());
                        }
                    });

            InetSocketAddress address = new InetSocketAddress(SERVER_PORT);
            ChannelFuture f = b.connect(address).sync();

            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }
    }

    class UnixTimeDecoder extends ByteToMessageDecoder {
        @Override
        protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
            if(internalBuffer().readableBytes() < 4)
                return;

            list.add(new UnixTime(internalBuffer().readUnsignedInt()));
        }
    }

    class UnixTime {
        private final long value;

        public UnixTime() {
            this(System.currentTimeMillis() / 1000L + 2208988800L);
        }

        public UnixTime(long value) {
            this.value = value;
        }

        public long value() {
            return value;
        }

        @Override
        public String toString() {
            return new Date((value() - 2208988800L) * 1000L).toString();
        }
    }

    class TimeClientHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            UnixTime m = (UnixTime)msg;
            if(m != null) {
                System.out.println(m);
            } else {
                System.out.println("receive is null");
            }
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }
}
