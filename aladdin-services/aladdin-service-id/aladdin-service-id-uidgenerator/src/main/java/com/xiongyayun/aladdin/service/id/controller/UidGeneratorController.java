package com.xiongyayun.aladdin.service.id.controller;

import com.xiongyayun.aladdin.service.id.service.UidGeneratorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UidGeneratorController
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/28
 */
@RestController
public class UidGeneratorController {
    @Resource
    private UidGeneratorService uidGeneratorService;

    @GetMapping("/getUID")
    public long getUID() {
        return uidGeneratorService.getUID();
    }

    @GetMapping("/parseUID/{uid}")
    public String parseUID(@PathVariable("uid") long uid) {
        return uidGeneratorService.parseUID(uid);
    }
}
