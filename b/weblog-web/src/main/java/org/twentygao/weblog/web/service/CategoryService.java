package org.twentygao.weblog.web.service;

import org.twentygao.weblog.common.utils.Response;
import org.twentygao.weblog.web.model.vo.category.FindCategoryArticlePageListReqVO;

public interface CategoryService {

    Response findCategoryList();

    Response findCategoryArticlePageList(FindCategoryArticlePageListReqVO findCategoryArticlePageListReqVO);

}
