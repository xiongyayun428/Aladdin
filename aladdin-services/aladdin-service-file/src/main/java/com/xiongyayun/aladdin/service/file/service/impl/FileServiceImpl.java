package com.xiongyayun.aladdin.service.file.service.impl;

import com.xiongyayun.aladdin.service.file.service.FileService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.springframework.stereotype.Service;
import org.xml.sax.ContentHandler;

import java.io.*;

/**
 * FileServiceImpl
 *
 * @author Yayun.Xiong
 * @date 2020/6/14
 */
@Slf4j
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
        System.out.println("-------download-----");
        Tika tika = new Tika();
        try {
            tika.detect(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件批量下载
     *
     * @param files
     * @param zipName
     */
    @Override
    public void download(File[] files, String zipName) {
        System.out.println("-------download--2---");
    }

    /**
     * 文件预览
     *
     * @param file
     */
    @Override
    public void preview(File file) {
        System.out.println("-------preview-----");
    }

    private static String getMimeType(File file) {
        if (file.isDirectory()) {
            log.warn("the target is a directory");
            return null;
        }
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            is = new FileInputStream(file);
            bis = new BufferedInputStream(is);
            AutoDetectParser parser = new AutoDetectParser();
            Detector detector = parser.getDetector();
            Metadata metadata = new Metadata();
            metadata.add(Metadata.RESOURCE_NAME_KEY, file.getName());
            MediaType mediaType = detector.detect(bis, metadata);
            System.out.println(mediaType.getSubtype());
            System.out.println(mediaType.getType());
            return mediaType.toString();
        } catch (Exception e) {
            log.error("getMimeType is error" + e.getMessage(), e);
            return null;
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException ee) {}
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ee) {}
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        File file = new File("/Users/xyy/Pictures/xiong");
        InputStream is = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(is);

        String mimeType = getMimeType(file);
        System.out.println(mimeType);
        System.out.println("------------------");
        Tika tika = new Tika();
        System.out.println(tika.detect(file));
        System.out.println("+++++++++++++++++");

        TikaConfig tikaConfig = new TikaConfig();
        Metadata metadata = new Metadata();
        metadata.set(Metadata.RESOURCE_NAME_KEY, file.getName());
        MediaType mimetype = tikaConfig.getDetector().detect(bis, metadata);
        System.out.println(mimetype.toString());
        System.out.println("-------------");

        Parser parser= new AutoDetectParser();
        int writerHandler =-1;
        ContentHandler contentHandler= new BodyContentHandler(writerHandler);
        metadata= new Metadata();
        parser.parse(bis, contentHandler, metadata, new ParseContext());
        String mt = metadata.get(Metadata.CONTENT_TYPE);
        System.out.println("File Attachment: "+file.getName()+" MimeType is: "+mt);
    }

}
