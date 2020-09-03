package org.akanami.io.nettys;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class ServerDemo01 {

    final static int SERVER_PORT = 10032;

    public static void main(String[] args) throws InterruptedException {
        final ByteBuf buf = Unpooled.unreleasableBuffer(
                    Unpooled.copiedBuffer("Hi!\r\n", Charset.forName("UTF-8")));

        EventLoopGroup group = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();

        b.group(group)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(SERVER_PORT))
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline()
                                .addLast(new ChannelInboundHandlerAdapter() {
                                    @Override
                                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                        ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
                                    }
                                });
                    }
                });
        ChannelFuture f = b.bind().sync();
        f.channel().closeFuture().sync();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
