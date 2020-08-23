package io.netty.example.study.common.order;

import io.netty.example.study.common.Operation;
import io.netty.example.study.common.OperationResult;
import lombok.Data;

@Data
public class OrderOperation extends Operation {

    private int tableId;
    private String dish;

    public OrderOperation(int tableId, String dish) {
        this.tableId = tableId;
        this.dish = dish;
    }

    @Override
    public OperationResult execute() {
        System.out.println("order is executing startup with order Request : " + toString());
        // execute order logic
        System.out.println("order is executing complete");
        OrderOperationResult orderOperatinResult = new OrderOperationResult(tableId, dish, true);
        return orderOperatinResult;
    }
}
