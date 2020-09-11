package org.akanami.io.nettys.handler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

public class ServerHandlerChainDemo01 {
    public final static int SERVER_PORT = 10046;

    public static void main(String[] args) throws Exception {
        new ServerHandlerChainDemo01().start();
    }

    public void start() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();

        try {
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("first", new ChainFirstHandler());
                            ch.pipeline().addLast("second", new ChainSecondHandler());
                            ch.pipeline().addLast("third", new ChainThirdHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channelFuture = bootstrap.bind(SERVER_PORT).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    class ChainFirstHandler extends ChannelInboundHandlerAdapter {

        ByteBuf localBuffer = Unpooled.compositeBuffer(1024);

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf byteBuf = (ByteBuf) msg;
            //System.out.println("ChainFirstHandler接收消息:" + byteBuf.toString(CharsetUtil.UTF_8));
            localBuffer.writeBytes(byteBuf);

            if (localBuffer.readableBytes() < 12) {
                return;
            }

            boolean fired = false;

            if (localBuffer.readableBytes() > 30) {
                fired = true;
            }

            String s = localBuffer.toString(CharsetUtil.UTF_8);
            System.out.println("接收消息:" + s);

            if (fired) {
                ctx.fireChannelRead(localBuffer);
                localBuffer.clear();
            } else {
                localBuffer.resetReaderIndex();
            }

        }
    }

    class ChainSecondHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf byteBuf = (ByteBuf) msg;
            System.out.println("ChainSecondHandler接收消息:" + byteBuf.toString(CharsetUtil.UTF_8));

            //ctx.fireChannelRead(msg);
        }
    }

    class ChainThirdHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf byteBuf = (ByteBuf) msg;
            System.out.println("ChainSecondHandler接收消息:" + byteBuf.toString(CharsetUtil.UTF_8));

            //ctx.fireChannelRead(msg);
        }
    }
}
