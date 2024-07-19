package org.twentygao.weblog.web.service;

import org.twentygao.weblog.common.utils.Response;
import org.twentygao.weblog.web.model.vo.article.FindArticleDetailReqVO;
import org.twentygao.weblog.web.model.vo.article.FindIndexArticlePageListReqVO;

public interface ArticleService {

    Response findArticlePageList(FindIndexArticlePageListReqVO findIndexArticlePageListReqVO) ;

    Response findArticleDetail(FindArticleDetailReqVO findArticleDetailReqVO);

}
