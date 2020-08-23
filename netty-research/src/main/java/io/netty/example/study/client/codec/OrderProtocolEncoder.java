package io.netty.example.study.client.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.study.common.RequestMessage;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 订单协议编码
 */
public class OrderProtocolEncoder extends MessageToMessageEncoder<RequestMessage> {
    @Override
    protected void encode(ChannelHandlerContext ctx, RequestMessage requestMessage, List<Object> out) throws Exception {
        // 通过上下文创建一个byteBuf
        ByteBuf buffer = ctx.alloc().buffer();
        // 将请求内容进行编码
        requestMessage.encode(buffer);
        // 添加到响应的集合中
        out.add(buffer);
    }
}
