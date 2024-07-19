package org.twentygao.weblog.admin.utils;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.twentygao.weblog.admin.config.MinioProperties;

import java.awt.font.MultipleMaster;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Component
@Slf4j

public class MinioUtil {
    @Autowired
    private MinioProperties minioProperties;

    @Autowired
    private MinioClient minioClient;

    public String upLoadFile(MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
    if(file == null|| file.getSize()==0){
        log.error("==>上传文件异常：文件大小为空。。。");
        throw new RuntimeException("文件大小不能为空");
    }
    String originalFileName = file.getOriginalFilename();
    String contentType = file.getContentType();

    String key = UUID.randomUUID().toString().replace("-","");

    String suffix = originalFileName.substring(originalFileName.lastIndexOf("."));

    String objectName = String.format("%S%S",key,suffix);

    log.info("==>开始上传文件至Minio,objectName:{}",objectName);

    minioClient.putObject(PutObjectArgs.builder()
            .bucket(minioProperties.getBucketName())
            .object(objectName).stream(file.getInputStream(),file.getSize(),-1)
            .contentType(contentType).build());


        // 返回文件的访问链接
        String url = String.format("%s/%s/%s", minioProperties.getEndpoint(), minioProperties.getBucketName(), objectName);
        log.info("==> 上传文件至 Minio 成功，访问路径: {}", url);
        return url;
    }
}
