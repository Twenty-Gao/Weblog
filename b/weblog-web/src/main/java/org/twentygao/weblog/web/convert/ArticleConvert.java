package org.twentygao.weblog.web.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.twentygao.weblog.common.domain.dos.ArticleDO;
import org.twentygao.weblog.web.model.vo.archive.FindArchiveArticleRspVO;
import org.twentygao.weblog.web.model.vo.article.FindIndexArticlePageListRspVO;
import org.twentygao.weblog.web.model.vo.category.FindCategoryArticlePageListRspVO;
import org.twentygao.weblog.web.model.vo.tag.FindTagArticlePageListRspVO;


@Mapper
public interface ArticleConvert {
    /**
     * 初始化 convert 实例
     */
    ArticleConvert INSTANCE = Mappers.getMapper(ArticleConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
//    @Mapping(target = "githubHomepage", expression = "java(bean.getGithubHomepage() != null ? bean.getGithubHomepage() : \"\")")
    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.from(bean.getCreateTime()))")
    FindIndexArticlePageListRspVO convertDO2VO(ArticleDO bean);
    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.from(bean.getCreateTime()))")
    @Mapping(target = "createMonth", expression = "java(java.time.YearMonth.from(bean.getCreateTime()))")
    FindArchiveArticleRspVO convertDO2ArchiveArticleVO(ArticleDO bean);

    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.from(bean.getCreateTime()))")
    FindCategoryArticlePageListRspVO convertDO2CategoryArticleVO(ArticleDO bean);
    @Mapping(target = "createDate", expression = "java(java.time.LocalDate.from(bean.getCreateTime()))")
    FindTagArticlePageListRspVO convertDO2TagArticleVO(ArticleDO bean);

}