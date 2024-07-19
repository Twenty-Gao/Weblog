package org.twentygao.weblog.admin.service;


import org.twentygao.weblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import org.twentygao.weblog.common.utils.Response;
public interface AdminUserService{
Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO);

    Response findUserInfo();
}
