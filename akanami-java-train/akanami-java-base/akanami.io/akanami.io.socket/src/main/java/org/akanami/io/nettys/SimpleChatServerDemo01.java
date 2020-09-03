package org.akanami.io.nettys;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.concurrent.GlobalEventExecutor;

public class SimpleChatServerDemo01 {
    public static final int SERVER_PORT = 10036;

    public static void main(String[] args) {
        new SimpleChatServerDemo01().start();
    }

    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap(); // (2)
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class) // (3)
                    .childHandler(new SimpleChatServerInitializer())  //(4)
                    .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                    .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

            System.out.println("SimpleChatServer 启动了");

            // 绑定端口，开始接收进来的连接
            ChannelFuture f = b.bind(SERVER_PORT).sync(); // (7)

            // 等待服务器  socket 关闭 。
            // 在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();

            System.out.println("SimpleChatServer 关闭了");
        }
    }

    static class SimpleChatServerInitializer extends ChannelInitializer<SocketChannel> {
        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline()
                    .addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()))
                    .addLast("decoder", new StringDecoder())
                    .addLast("encoder", new StringEncoder())
                    .addLast("handler", new SimpleChatServerHandler());

            System.out.println("SimpleChatClient:" + socketChannel.remoteAddress() + "连接上");
        }
    }

    static class SimpleChatServerHandler extends SimpleChannelInboundHandler<String> {
        public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            Channel incoming = ctx.channel();
            for (Channel channel : channels) {
                channel.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 加入\n");
            }
            channels.add(incoming);
        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            Channel incoming = ctx.channel();
            for (Channel channel : channels) {
                channel.writeAndFlush("[SERVER] - " + incoming.remoteAddress() + " 退出\n");
            }
            channels.remove(incoming);
        }

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
            Channel incoming = channelHandlerContext.channel();
            for (Channel channel : channels) {
                if (channel != incoming) {
                    channel.writeAndFlush("[" + incoming.remoteAddress() + "]" + s + "\n");
                } else {
                    channel.writeAndFlush("[you]" + s + "\n");
                }
            }
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            Channel incoming = ctx.channel();
            System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "在线");
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            Channel incoming = ctx.channel();
            System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "掉线");
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            Channel incoming = ctx.channel();
            System.out.println("SimpleChatClient:" + incoming.remoteAddress() + "异常");
            // 当出现异常就关闭连接
            cause.printStackTrace();
            ctx.close();
        }
    }
}
