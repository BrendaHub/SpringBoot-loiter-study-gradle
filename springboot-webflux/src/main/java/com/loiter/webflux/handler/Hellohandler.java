package com.loiter.webflux.handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
public class Hellohandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
        String hello="Hello, world!";
        Mono<ServerResponse> mono = ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromObject(hello));
        return mono;
    }
}
