package org.akanami.io.nettys.mutiplethread;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;

public class OverLimitClientDemo01 {
    public static final String SERVER_ADDRESS = "127.0.0.1";
    public static final int SERVER_PORT = 12409;

    public static void main(String[] args) {
        for(int i = 0; i < 20; i++) {
            new Thread(() -> {
                new OverLimitClientDemo01().start();
            }).start();
        }

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        EventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap bootstrap = new Bootstrap();

        try {
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new LimitClientChannelInboundHandlerAdapter());
                        }
                    })
                    .option(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channelFuture = bootstrap.connect(SERVER_ADDRESS, SERVER_PORT).sync();
            channelFuture.channel().close().sync();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class LimitClientChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println("客户端" + Thread.currentThread().getName() + "发送消息");
            ByteBuf buff = Unpooled.directBuffer(1024);
            buff.writeBytes("hello fro client ".getBytes());

            ctx.writeAndFlush(buff);
            ctx.close();
        }
    }
}
