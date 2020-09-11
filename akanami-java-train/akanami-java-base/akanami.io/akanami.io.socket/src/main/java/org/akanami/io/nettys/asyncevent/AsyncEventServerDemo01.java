package org.akanami.io.nettys.asyncevent;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.CharsetUtil;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AsyncEventServerDemo01 {

    public static final int SERVER_PORT = 10043;

    public static void main(String[] args) {
        new AsyncEventServerDemo01().start();
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
                            socketChannel.pipeline().addLast(new AsyncTaskQueueChannelHandler());
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            ChannelFuture channelFuture = bootstrap.bind(SERVER_PORT).sync();

            channelFuture.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture cf)  {
                    try {
                        if (cf.isDone()) {
                            System.out.println("监听端口完成");
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            channelFuture.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class AsyncTaskQueueChannelHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void channelActive(ChannelHandlerContext ctx) {

            try {
                //定时执行器
                //ctx.channel().eventLoop().schedule(() -> {    //这种方法只执行一次
                ctx.channel().eventLoop().scheduleAtFixedRate(() -> {   //这种方法可以执行多次
                    ByteBuf scheduleMsg = Unpooled.copiedBuffer("hello from schedule server", CharsetUtil.UTF_8);
                    ctx.writeAndFlush(scheduleMsg);
                    System.out.println("定时任务");
                },1, 1, TimeUnit.SECONDS);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf byteBuf = (ByteBuf)msg;
            String s = byteBuf.toString(CharsetUtil.UTF_8);
            System.out.println("接收消息:" + s);
            ctx.writeAndFlush(msg);

            //eventLoop 内置一个 taskQueue 用于异步执行返回

            ctx.channel().eventLoop().execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    ByteBuf returnMsg = Unpooled.copiedBuffer("hello from server", CharsetUtil.UTF_8);
                    ctx.writeAndFlush(returnMsg);
                    System.out.println("发送返回结果1" + new Date().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            //这里如果执行第二次，则实际等待时间为接收时间 + 30秒，
            //taskQueue 可以认为是单线程的 taskQueue, 需要考虑之前的 10秒 + 这次的 20秒  = 30秒
            ctx.channel().eventLoop().execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(20);
                    ByteBuf returnMsg = Unpooled.copiedBuffer("hello from server", CharsetUtil.UTF_8);
                    ctx.writeAndFlush(returnMsg);
                    System.out.println("发送返回结果2" + new Date().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            //定时执行器
            //ctx.channel().eventLoop().schedule()
        }
    }
}
