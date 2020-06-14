package com.xiongyayun.aladdin.service.file.service.impl;

import com.xiongyayun.aladdin.service.file.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * FileServiceImpl
 *
 * @author Yayun.Xiong
 * @date 2020/6/14
 */
@Service
public class FileServiceImpl implements FileService {
    /**
     * 文件预览或下载
     *
     * @param file
     * @param download
     */
    @Override
    public void content(File file, Boolean download) {
//        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//        response.setContentType(new MimetypesFileTypeMap().getContentType(file)));
//        String fileName = file.getFileName() + "." + file.getFileSuffix();
//        try {
//            if (download != null && download) {
//                response.addHeader("Content-Disposition", "attachment; filename=" + new StringBuffer().append(URLEncoder.encode(fileName, "utf-8")));
//            } else {
//                response.addHeader("Content-Disposition", "inline; filename=" + new StringBuffer().append(URLEncoder.encode(fileName, "utf-8")));
//            }
//            @Cleanup OutputStream os = response.getOutputStream();
//            os.write(file.getFileData());
//            os.flush();
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw new HljinkeException("E33335", "渲染错误");
//        }
    }

    /**
     * 文件下载
     *
     * @param file
     */
    @Override
    public void download(File file) {

    }

    /**
     * 文件批量下载
     *
     * @param files
     * @param zipName
     */
    @Override
    public void download(File[] files, String zipName) {

    }

    /**
     * 文件预览
     *
     * @param file
     */
    @Override
    public void preview(File file) {

    }
}
