package org.akanami.io.nettys.mutiplethread;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.NettyRuntime;

import java.util.concurrent.TimeUnit;

public class OverLimitServerDemo01 {
    public static final int SERVER_PORT = 12409;

    public static void main(String[] args) {
        System.out.println("CPU:" + NettyRuntime.availableProcessors());
        new OverLimitServerDemo01().start();
    }

    public void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new DelayReplayChannelInboundHandlerAdapter(5000));
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channelFuture = bootstrap.bind(SERVER_PORT).sync();

            System.out.println("端口绑定完成");
            channelFuture.channel().closeFuture().sync();
            System.out.println("程序运行完毕，开始退出");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class DelayReplayChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {
        private int milliSecond;

        public DelayReplayChannelInboundHandlerAdapter(int milliSecond) {
            this.milliSecond = milliSecond;
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) {
            try {

                ByteBuf buff = (ByteBuf) msg;

                if(buff.isReadable()) {
                    System.out.println(buff.getClass());

                    byte[] buffer = new byte[buff.readableBytes()];
                    buff.readBytes(buffer);

                    System.out.println("线程" + Thread.currentThread().getName() + "接收消息:" + new String(buffer));
                }


                TimeUnit.MILLISECONDS.sleep(this.milliSecond);
                //ctx.writeAndFlush(msg);
                ctx.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
