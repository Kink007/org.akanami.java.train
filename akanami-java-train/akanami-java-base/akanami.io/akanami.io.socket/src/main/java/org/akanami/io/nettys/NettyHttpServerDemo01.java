package org.akanami.io.nettys;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.util.AsciiString;

public class NettyHttpServerDemo01 {

    static final int SERVER_PORT = 10033;

    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        System.out.println("initChannel socketChannel:" + socketChannel);

                        socketChannel.pipeline()
                                .addLast("decoder", new HttpRequestDecoder())
                                .addLast("encoder", new HttpResponseEncoder())
                                .addLast("aggregator", new HttpObjectAggregator(512 * 1024))
                                .addLast("handler", new HttpHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE);

        bootstrap.bind(SERVER_PORT).sync();
    }

    static class HttpHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
        private AsciiString contentType = HttpHeaderValues.TEXT_PLAIN;


        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest) throws Exception {
            System.out.println("class:" + fullHttpRequest.getClass().getName());
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer("test".getBytes()));

            HttpHeaders headers = response.headers();
            headers.add(HttpHeaderNames.CONTENT_TYPE, contentType + "; charset=UTF-8");
            headers.add(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
            headers.add(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);

            channelHandlerContext.write(response);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            System.out.println("channelReadComplete");
            super.channelReadComplete(ctx);
            ctx.flush();
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            //super.exceptionCaught(ctx, cause);
            System.out.println("exceptionCaught");
            if (cause != null) cause.printStackTrace();
            if (ctx != null) ctx.close();
        }
    }
}
