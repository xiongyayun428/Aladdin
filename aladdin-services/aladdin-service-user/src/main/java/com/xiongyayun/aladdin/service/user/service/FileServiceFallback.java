package com.xiongyayun.aladdin.service.user.service;

import org.springframework.stereotype.Component;

/**
 * 定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/17
 */
@Component
public class FileServiceFallback implements FileService {
    @Override
    public String download(String fileId) {
        return "download fallback";
    }
}
