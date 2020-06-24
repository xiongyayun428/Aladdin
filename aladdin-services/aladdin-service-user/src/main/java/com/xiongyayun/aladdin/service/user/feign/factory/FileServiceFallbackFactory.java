package com.xiongyayun.aladdin.service.user.feign.factory;

import com.xiongyayun.aladdin.service.user.feign.FileService;
import com.xiongyayun.aladdin.service.user.feign.fallback.FileServiceFallback;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * FileServiceFallbackFactory
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/24
 */
@Component
public class FileServiceFallbackFactory implements FallbackFactory<FileService> {
    @Override
    public FileService create(Throwable throwable) {
        FileServiceFallback fallback = new FileServiceFallback();
        return fallback;
    }
}
