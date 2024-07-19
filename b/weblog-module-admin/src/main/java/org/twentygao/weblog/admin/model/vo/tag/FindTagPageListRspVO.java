package org.twentygao.weblog.admin.model.vo.tag;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "查询标签分页数据出参")
public class FindTagPageListRspVO {
//标签id
    private Long id;

    private String name;

    private LocalDateTime createTime;


}
