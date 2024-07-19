package org.twentygao.weblog.web.model.vo.article;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;
import org.twentygao.weblog.common.model.BasePageQuery;

@Data
@Builder
@ApiModel(value = "首页查询文章分页 VO")
public class FindIndexArticlePageListReqVO extends BasePageQuery {


}
