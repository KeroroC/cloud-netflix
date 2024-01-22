package com.keroro;

import com.keroro.web.feign.UploadService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;

/**
 * @author wangpeng
 * @since 2024年01月22日 23:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UploadTest {

    Logger logger = LoggerFactory.getLogger(UploadTest.class);

    @Autowired
    private UploadService uploadService;

    @Test
    public void testHandleFileUpload() {
        File file = new File("src/main/resources/upload.txt");
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("file", MediaType.TEXT_PLAIN_VALUE, true, file.getName());

        try (InputStream input = Files.newInputStream(file.toPath()); OutputStream os = fileItem.getOutputStream()) {
            IOUtils.copy(input, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }

        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);

        logger.info("=============" + uploadService.handleFileUpload(multipartFile));
    }
}
