package io.netty.example.study.common;

import io.netty.example.study.common.auth.AuthOperation;
import io.netty.example.study.common.auth.AuthOperationResult;
import io.netty.example.study.common.keepalive.KeepaliveOperation;
import io.netty.example.study.common.keepalive.KeepaliveOperationResult;
import io.netty.example.study.common.order.OrderOperation;
import io.netty.example.study.common.order.OrderOperationResult;
import lombok.Getter;

import java.util.function.Predicate;

//@Getter
public enum OperationType {

    AUTH(1,AuthOperation.class, AuthOperationResult.class),
    KEEPALIVE(2, KeepaliveOperation.class, KeepaliveOperationResult.class),
    ORDER(3, OrderOperation.class, OrderOperationResult.class);

    public int getOpCode() {
        return opCode;
    }

    public Class<? extends Operation> getOperationClazz() {
        return operationClazz;
    }

    public Class<? extends OperationResult> getOperationResultClazz() {
        return operationResultClazz;
    }

    private int opCode;
    private Class<? extends Operation> operationClazz;
    private Class<? extends OperationResult> operationResultClazz;

    OperationType(int opCode, Class<? extends Operation> operationClazz,
                  Class<? extends OperationResult> responseClass) {
        this.opCode = opCode;
        this.operationClazz = operationClazz;
        this.operationResultClazz = responseClass;
    }

    public static OperationType fromOpCode(int type) {
        return getoperationType(requestType -> requestType.opCode == type);
    }

    public static OperationType fromOperation(Operation operation) {
        return getoperationType(requestType -> requestType.operationClazz == operation.getClass());
    }

    private static OperationType getoperationType(Predicate<OperationType> predicate) {
        OperationType[] values = values();
        for(OperationType operationType: values) {
            if (predicate.test(operationType)) {
                return operationType;
            }
        }
        throw  new AssertionError("no found type");
    }

}
