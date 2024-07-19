package org.twentygao.weblog.admin.service;

import org.twentygao.weblog.admin.model.vo.article.*;
import org.twentygao.weblog.common.utils.Response;

public interface AdminArticleService {
    /**
     * 发布文章
     * @param publishArticleReqVO
     * @return
     */
    Response publishArticle(PublishArticleReqVO publishArticleReqVO);

    Response deleteArticle(DeleteArticleReqVO deleteArticleReqVO);

    Response findArticlePageList(FindArticlePageListReqVO findArticlePageListReqVO);

    Response findArticleDetail(FindArticleDetailReqVO findArticleDetailReqVO);

    Response updateArticle(UpdateArticleReqVO updateArticleReqVO);
}