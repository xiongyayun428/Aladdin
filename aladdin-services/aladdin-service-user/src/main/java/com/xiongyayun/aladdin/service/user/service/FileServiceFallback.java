package com.xiongyayun.aladdin.service.user.service;

/**
 * FileServiceFallback
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/17
 */
public class FileServiceFallback implements FileService {
    @Override
    public String download(String fileId) {
        return "download fallback";
    }
}
