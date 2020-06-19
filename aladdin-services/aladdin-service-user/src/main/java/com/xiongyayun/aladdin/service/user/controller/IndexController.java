package com.xiongyayun.aladdin.service.user.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/18
 */
@Slf4j
@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
