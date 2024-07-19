package org.twentygao.weblog.web.model.vo.archive;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import org.twentygao.weblog.common.model.BasePageQuery;

@Data
@Builder
@ApiModel(value = "文章归档分页 VO")
public class FindArchiveArticlePageListReqVO extends BasePageQuery {
}