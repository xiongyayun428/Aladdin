package com.xiongyayun.aladdin.service.user.service.impl;

import com.xiongyayun.aladdin.service.user.service.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 消息推送
 * Provider生产者
 *
 * @author Yayun.Xiong
 * @date 2020/6/20
 */
@Slf4j
@EnableBinding(Source.class)
public class MessageImpl implements Message {
    /**
     * 消息发送管道
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        log.info("==================" + serial);
        return null;
    }
}
