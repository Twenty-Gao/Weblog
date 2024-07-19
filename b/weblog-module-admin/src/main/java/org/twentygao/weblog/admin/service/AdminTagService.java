package org.twentygao.weblog.admin.service;

import org.twentygao.weblog.admin.model.vo.tag.AddTagReqVO;
import org.twentygao.weblog.admin.model.vo.tag.DeleteTagReqVO;
import org.twentygao.weblog.admin.model.vo.tag.FindTagPageListReqVO;
import org.twentygao.weblog.admin.model.vo.tag.SearchTagReqVO;
import org.twentygao.weblog.common.utils.Response;

public interface AdminTagService {
    Response addTag(AddTagReqVO addTagReqVO);

    Response findTagList(FindTagPageListReqVO findTagPageListReqVO);

Response deleteTag(DeleteTagReqVO deleteTagReqVO);

    Response searchTag(SearchTagReqVO searchTagReqVO);
    Response findTagSelectList();
}
