package com.loiter.juc;

import lombok.Getter;

@Getter
public enum Dist {
    DEON( 1000, "DENOVALUE"),
    OPEN(10002, "OPENDID"),
    CLOSE(10002, "CLOSE");

    private Integer code;
    private String message;

     Dist(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
