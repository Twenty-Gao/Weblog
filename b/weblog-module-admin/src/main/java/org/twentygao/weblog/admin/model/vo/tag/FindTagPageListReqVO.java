package org.twentygao.weblog.admin.model.vo.tag;

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
@ApiModel(value = "查询标签分页数据入参")
public class FindTagPageListReqVO extends BasePageQuery {

    private String name;

    private LocalDate startDte;

    private LocalDate endDate;
}
