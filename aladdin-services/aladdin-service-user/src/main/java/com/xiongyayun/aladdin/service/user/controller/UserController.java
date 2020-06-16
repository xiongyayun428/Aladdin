package com.xiongyayun.aladdin.service.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xiongyayun.aladdin.service.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UserController
 *
 * @author Yayun.Xiong
 * @date 2020/6/14
 */
@Slf4j
@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {
    @Resource
    private UserService userService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/get")
    @SentinelResource("get")
    public String get() {
        return "UserController get >" + serverPort;
    }

}
