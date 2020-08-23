package io.netty.example.study.common.auth;

import io.netty.example.study.common.Operation;
import io.netty.example.study.common.OperationResult;
import lombok.Data;
import lombok.extern.java.Log;

@Data
@Log(topic="AuthOperationLog")
public class AuthOperation extends Operation {

    private final String userName;
    private final String password;

    public AuthOperation(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


    @Override
    public OperationResult execute() {
        if ("admin".equalsIgnoreCase(this.userName)) {
            AuthOperationResult orderResponse = new AuthOperationResult(true);
            return orderResponse;
        }

        return new AuthOperationResult(false);
    }
}
