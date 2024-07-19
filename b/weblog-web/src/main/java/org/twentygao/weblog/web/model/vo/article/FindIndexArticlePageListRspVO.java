package org.twentygao.weblog.web.model.vo.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.twentygao.weblog.web.model.vo.category.FindCategoryListRspVO;
import org.twentygao.weblog.web.model.vo.tag.FindTagListRspVO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindIndexArticlePageListRspVO {
    private Long id;
    private String cover;
    private String title;
    private LocalDate createDate;
    private String summary;
    /**
     * 文章分类
     */
    private FindCategoryListRspVO category;

    /**
     * 文章标签
     */
    private List<FindTagListRspVO> tags;
}