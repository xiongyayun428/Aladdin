package com.xiongyayun.aladdin.service.file.service;

import java.io.File;

/**
 * FileService
 *
 * @author Yayun.Xiong
 * @date 2020/6/14
 */
public interface FileService {

    /**
     * 文件预览或下载
     * @param file
     * @param download
     */
    void content(File file, Boolean download);

    /**
     * 文件下载
     * @param file
     */
    void download(File file);

    /**
     * 文件批量下载
     * @param files
     * @param zipName
     */
    void download(File[] files, String zipName);

    /**
     * 文件预览
     * @param file
     */
    void preview(File file);
}
