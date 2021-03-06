package com.xiongyayun.aladdin.service.file.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.xiongyayun.aladdin.service.file.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * FileController
 *
 * @author Yayun.Xiong
 * @date 2020/6/14
 */
@Slf4j
@RestController
@RequestMapping("/file")
@RefreshScope
public class FileController {
    @Resource
    private FileService fileService;

    @GetMapping("/test{fileId}")
    public String test(@PathVariable("fileId") String fileId, @RequestParam(value = "download", required = false) Boolean download) {
        return "FileController test";
    }

    /**
     * 文件预览或下载
     * @param fileId
     * @param download
     */
    @GetMapping("/{fileId}")
    public void content(@PathVariable("fileId") String fileId, @RequestParam(value = "download", required = false) Boolean download) {
        this.fileService.content(getFileById(fileId), download);
    }

    @GetMapping("/download/{fileId}")
    @SentinelResource("download/id")
    public void download(@PathVariable("fileId") String fileId) {
        this.fileService.download(getFileById(fileId));
    }

    @GetMapping("/download")
    @SentinelResource("download")
    public void download(@RequestParam("fileId") String[] fileIds, @RequestParam(value = "zipName", defaultValue = "xxx") String zipName) {
        this.fileService.download(getFileByIds(fileIds), zipName);
    }

    @GetMapping("/preview/{fileId}")
    @SentinelResource("preview")
    public void preview(@PathVariable("fileId") String fileId) {
        this.fileService.preview(getFileById(fileId));
    }

    public File getFileById(String fileId) {
        return new File("/Users/xyy/Desktop/B41A8371.jpg");
    }
    public File[] getFileByIds(String[] fileIds) {
        return new File[]{new File("/Users/xyy/Desktop/B41A8371.jpg")};
    }


    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        // 保存文件并创建UploadFile上传记录
//        return super.uploadFile(file, Dictionary.class, request);
    }

}
