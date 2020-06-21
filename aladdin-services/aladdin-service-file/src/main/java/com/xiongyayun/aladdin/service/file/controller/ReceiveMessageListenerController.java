package com.xiongyayun.aladdin.service.file.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * ReceiveMessageListenerController
 *
 * @author Yayun.Xiong
 * @date 2020/6/20
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者接收到消息：" + message.getPayload());
    }
}
