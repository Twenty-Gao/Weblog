package org.twentygao.weblog.web.service;

import org.twentygao.weblog.common.utils.Response;
import org.twentygao.weblog.web.model.vo.tag.FindTagArticlePageListReqVO;

public interface TagService {

    Response findTagList();
    Response findTagPageList(FindTagArticlePageListReqVO findTagArticlePageListReqVO);

}
