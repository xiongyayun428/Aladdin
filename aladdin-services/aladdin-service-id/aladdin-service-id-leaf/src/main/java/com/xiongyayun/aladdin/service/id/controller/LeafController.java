package com.xiongyayun.aladdin.service.id.controller;

import com.sankuai.inf.leaf.service.SegmentService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UidGeneratorController
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/28
 */
@RestController
public class LeafController {
    @Resource
    private SegmentService segmentService;

//    @GetMapping("/getUID")
//    public long getUID() {
//        return segmentService.;
//    }
//
//    @GetMapping("/parseUID/{uid}")
//    public String parseUID(@PathVariable("uid") long uid) {
//        return uidGeneratorService.parseUID(uid);
//    }
}
