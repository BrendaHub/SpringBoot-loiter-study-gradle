package io.netty.example.study.server.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.ResponseMessage;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

/**
 * 订单协议编码
 */
public class OrderProtocolEncoder extends MessageToMessageEncoder<ResponseMessage> {
    @Override
    protected void encode(ChannelHandlerContext ctx, ResponseMessage responseMessage, List<Object> out) throws Exception {
        // 通过上下文创建一个byteBuf  分配buffer 也是一个坑 ， 推荐这种字法，从上下文中创建
        ByteBuf buffer = ctx.alloc().buffer();
        // 这里是自己定义了一个bytebuffer, 在底层处理堆内堆处内存时会存在隐患， 不建议这个创建ByteBuf；
        ByteBuf buffer1 = ByteBufAllocator.DEFAULT.buffer();
        // 将请求内容进行编码
        responseMessage.encode(buffer);
        // 添加到响应的集合中
        out.add(buffer);
    }
}
