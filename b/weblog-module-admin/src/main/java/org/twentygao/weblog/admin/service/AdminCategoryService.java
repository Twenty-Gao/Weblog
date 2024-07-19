package org.twentygao.weblog.admin.service;

import org.twentygao.weblog.admin.model.vo.category.AddCategoryReqVO;
import org.twentygao.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import org.twentygao.weblog.admin.model.vo.user.FindCategoryPageListReqVO;
import org.twentygao.weblog.common.utils.PageResponse;
import org.twentygao.weblog.common.utils.Response;

public interface AdminCategoryService {
    Response addCategory(AddCategoryReqVO addCategoryReqVO);
PageResponse findCategoryList(FindCategoryPageListReqVO findCategoryPageListReqVO);

    Response deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO);
    Response findCategorySelectList();
}
