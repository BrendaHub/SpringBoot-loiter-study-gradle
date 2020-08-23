package io.netty.example.study.server.codec;

import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 解码处理
 */
public class OrderFrameDecoder extends LengthFieldBasedFrameDecoder {
    public OrderFrameDecoder() {
        // 这里一定要选用这个父类构造器  一个很容易出问题 的坑。
        super(Integer.MAX_VALUE,
                0,
                2,
                0,
                2); // 这个参数很重要， 否则会导到在处理半包或粘包时解析错误
    }
}
