package com.xiongyayun.aladdin.service.user.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FileService
 *
 * @author: <a href="mailto:xiongyayun428@163.com">Yayun.Xiong</a>
 * @date: 2020/6/17
 */
@FeignClient(name = "aladdin-service-file",
        fallback = FileServiceFallback.class,
        configuration = FileServiceConfiguration.class)
public interface FileService {

    /**
     * download
     * @param fileId
     * @return
     */
    @GetMapping("/file/download/{fileId}")
    String download(@PathVariable("fileId") String fileId);
}
