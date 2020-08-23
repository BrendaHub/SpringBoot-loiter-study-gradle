package io.netty.example.study.client;

import com.google.gson.Gson;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.example.study.client.codec.*;
import io.netty.example.study.client.dispatcher.OperationResultFuture;
import io.netty.example.study.client.dispatcher.RequestPendingCenter;
import io.netty.example.study.client.dispatcher.ResponseDispatcherHandler;
import io.netty.example.study.common.OperationResult;
import io.netty.example.study.common.RequestMessage;
import io.netty.example.study.common.order.OrderOperation;
import io.netty.example.study.util.IdUtil;
import io.netty.example.study.util.JsonUtil;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.ExecutionException;

public class ClientV2 {

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);

//        serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
        NioEventLoopGroup group = new NioEventLoopGroup();
        RequestPendingCenter requestPendingCenter = new RequestPendingCenter();

        bootstrap.group(group);
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new OrderFrameDecoder());
                pipeline.addLast(new OrderFrameEncoder());

                pipeline.addLast(new OrderProtocolEncoder());
                pipeline.addLast(new OrderProtocolDecoder());

                pipeline.addLast(new ResponseDispatcherHandler(requestPendingCenter));

                pipeline.addLast(new OperationToRequestMessageEncoder());

                pipeline.addLast(new LoggingHandler(LogLevel.INFO));
            }
        });

        try {
            ChannelFuture sync = bootstrap.connect("127.0.0.1", 8090).sync();
//            // 构造一个消息，并发送
//            RequestMessage requestMessage = new RequestMessage(IdUtil.nextId(), new OrderOperation(1001, "Python Message"));
//            sync.channel().writeAndFlush(requestMessage);
            long streamId = IdUtil.nextId();
//            OrderOperation orderOperation = new OrderOperation(1002, "java Netty");
            RequestMessage requestMessage = new RequestMessage(streamId, new OrderOperation(1003, "Future center"));
            OperationResultFuture operationResultFuture = new OperationResultFuture();
            requestPendingCenter.add(streamId, operationResultFuture);

            // 客户端发送消息一般这么写； 这也属于一个坑
            sync.channel().writeAndFlush(requestMessage);
            // 服务端发送消息一般采用
//            ctx.writeAndFlush(msg);

            /// 打印发送后获取的结果
            OperationResult operationResult = operationResultFuture.get();
            System.out.println("=====================");
            System.out.println(JsonUtil.toJson(operationResult));

            sync.channel().closeFuture().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("new Thread");
            }
        }).start();
    }
}
