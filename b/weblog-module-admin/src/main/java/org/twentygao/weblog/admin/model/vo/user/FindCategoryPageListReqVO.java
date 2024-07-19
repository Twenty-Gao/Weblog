package org.twentygao.weblog.admin.model.vo.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.twentygao.weblog.common.model.BasePageQuery;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询分类分页数据入参")
public class FindCategoryPageListReqVO extends BasePageQuery {

    private String name;

    private LocalDate startDte;

    private LocalDate endDate;
}
