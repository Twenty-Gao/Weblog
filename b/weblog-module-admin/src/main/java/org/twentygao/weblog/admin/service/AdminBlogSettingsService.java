package org.twentygao.weblog.admin.service;

import org.twentygao.weblog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import org.twentygao.weblog.common.utils.Response;

public interface AdminBlogSettingsService {
    Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO);
    Response findDetail();
}
