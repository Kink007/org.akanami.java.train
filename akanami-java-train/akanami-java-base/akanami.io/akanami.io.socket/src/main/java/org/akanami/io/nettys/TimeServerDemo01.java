package org.akanami.io.nettys;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/*
    实现一个时间服务器，有客户端连接到服务器后，立刻返回一个时间并断开与客户端的连接
 */
public class TimeServerDemo01 {
    public static final int SERVER_PORT = 10035;

    public static void main(String[] args) {
        new TimeServerDemo01().start();
    }

    public void start() {
        EventLoopGroup acceptGroup = new NioEventLoopGroup();
        EventLoopGroup connectionGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            bootstrap.group(acceptGroup, connectionGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new TimerServerHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture future = bootstrap.bind(SERVER_PORT).sync();

            future.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            acceptGroup.shutdownGracefully();
            connectionGroup.shutdownGracefully();
        }
    }

    class TimerServerHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            final ByteBuf time = ctx.alloc().buffer(4);
            time.writeInt((int)(System.currentTimeMillis() / 1000L + 2208988800L));

            final ChannelFuture future = ctx.writeAndFlush(time);
            future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    assert future == channelFuture;
                    ctx.close();
                }
            });
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            cause.printStackTrace();
            ctx.close();
        }
    }
}
