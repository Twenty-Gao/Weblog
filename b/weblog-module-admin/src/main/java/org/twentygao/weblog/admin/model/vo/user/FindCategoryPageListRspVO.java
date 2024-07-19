package org.twentygao.weblog.admin.model.vo.user;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询分类分页数据出参")
public class FindCategoryPageListRspVO {
//分类id
    private Long id;

    private String name;

    private LocalDateTime createTime;


}
