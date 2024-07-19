package org.twentygao.weblog.admin.service;

import org.springframework.web.multipart.MultipartFile;
import org.twentygao.weblog.common.utils.Response;

public interface AdminFileService {

    Response uploadFile(MultipartFile file);
}
