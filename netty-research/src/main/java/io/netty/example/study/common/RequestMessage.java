package io.netty.example.study.common;

public class RequestMessage extends Message<Operation>{

    @Override
    public Class getMessageBodyDecodeClass(int opCode) {

        return OperationType.fromOpCode(opCode).getOperationClazz();
//        return (Class<Operation>) OperationType.fromOpCode(opCode).getOperationClazz();
    }

    public RequestMessage() {}

    public RequestMessage(Long streamId, Operation operation) {
        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setStreamId(streamId);
        messageHeader.setOpCode(OperationType.fromOperation(operation).getOpCode());
        this.setMessageHeader(messageHeader);
        this.setMessageBody(operation);
    }
}
