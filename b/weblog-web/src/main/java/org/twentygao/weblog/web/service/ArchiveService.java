package org.twentygao.weblog.web.service;

import org.twentygao.weblog.common.utils.Response;
import org.twentygao.weblog.web.model.vo.archive.FindArchiveArticlePageListReqVO;

public interface ArchiveService {

    Response findArchivePageList(FindArchiveArticlePageListReqVO findArchiveArticlePageListReqVO);
}
