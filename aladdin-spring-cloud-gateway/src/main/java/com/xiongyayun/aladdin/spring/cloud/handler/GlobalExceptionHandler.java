//package com.xiongyayun.aladdin.spring.cloud.handler;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.xiongyayun.aladdin.common.util.CommonResult;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.io.buffer.DataBufferFactory;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
//import reactor.core.publisher.Mono;
//
///**
// * 网关异常通用处理器，只作用在webflux 环境下 , 优先级低于 {@link ResponseStatusExceptionHandler} 执行
// *
// * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
// * @date: 2020/6/18
// */
//@Slf4j
//@Order(-1)
//@Configuration
//@RequiredArgsConstructor
//public class GlobalExceptionHandler implements ErrorWebExceptionHandler {
//    private final ObjectMapper objectMapper;
//
//    @Override
//    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
//        ServerHttpResponse response = exchange.getResponse();
//
//        if (response.isCommitted()) {
//            return Mono.error(ex);
//        }
//
//        // header set
//        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//        if (ex instanceof ResponseStatusException) {
//            response.setStatusCode(((ResponseStatusException) ex).getStatus());
//        }
//
//        return response
//                .writeWith(Mono.fromSupplier(() -> {
//                    DataBufferFactory bufferFactory = response.bufferFactory();
//                    try {
//                        return bufferFactory.wrap(objectMapper.writeValueAsBytes(CommonResult.failed(ex.getMessage())));
//                    } catch (JsonProcessingException e) {
//                        log.error("Error writing response", ex);
//                        return bufferFactory.wrap(new byte[0]);
//                    }
//                }));
//    }
//
//}