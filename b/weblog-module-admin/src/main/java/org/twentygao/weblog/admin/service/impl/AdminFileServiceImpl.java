package org.twentygao.weblog.admin.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.twentygao.weblog.admin.model.vo.file.UploadFileRspVO;
import org.twentygao.weblog.admin.service.AdminFileService;
import org.twentygao.weblog.admin.utils.MinioUtil;
import org.twentygao.weblog.common.enums.ResponseCodeEnum;
import org.twentygao.weblog.common.exceptation.BizException;
import org.twentygao.weblog.common.utils.Response;

@Service
@Slf4j
public class AdminFileServiceImpl implements AdminFileService {

    @Autowired
    private MinioUtil minioUtil;
    @Override
    public Response uploadFile(MultipartFile file) {
        try {
            // 上传文件
            String url = minioUtil.upLoadFile(file);

            // 构建成功返参，将图片的访问链接返回
            return Response.success(UploadFileRspVO.builder().url(url).build());
        } catch (Exception e) {
            log.error("==> 上传文件至 Minio 错误: ", e);
            // 手动抛出业务异常，提示 “文件上传失败”
            throw new BizException(ResponseCodeEnum.FILE_UPLOAD_FAILED);
        }
    }
    }
