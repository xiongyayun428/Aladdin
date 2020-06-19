package com.xiongyayun.aladdin.service.user.service;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Feign配置类，可以自定义Feign的Encoder、Decoder、LogLevel、Contract
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/19
 */
@Configuration
public class FileServiceConfiguration {
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
