package org.akanami.io.nettys.chat;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChatServerHandler01 extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[客户端"+channel.remoteAddress()+"开始连接]");
        channelGroup.add(channel);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[客户端" + channel.remoteAddress() + "上线]");

        ByteBuf byteBuf = Unpooled.copiedBuffer("[客户端" + channel.remoteAddress() + "上线]", CharsetUtil.UTF_8);
        channelGroup.writeAndFlush(byteBuf);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println("[客户端" + channel.remoteAddress() + "下线]");

        ByteBuf byteBuf = Unpooled.copiedBuffer("[客户端" + channel.remoteAddress() + "下线]", CharsetUtil.UTF_8);
        channelGroup.writeAndFlush(byteBuf);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        System.out.println("[客户端" + ctx.channel().remoteAddress() + "发送消息]" + s);
    }
}
