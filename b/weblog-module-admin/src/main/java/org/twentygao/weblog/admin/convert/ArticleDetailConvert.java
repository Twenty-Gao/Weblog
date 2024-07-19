package org.twentygao.weblog.admin.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.twentygao.weblog.admin.model.vo.article.FindArticleDetailRspVO;
import org.twentygao.weblog.common.domain.dos.ArticleDO;


@Mapper
public interface ArticleDetailConvert {
    /**
     * 初始化 convert 实例
     */
    ArticleDetailConvert INSTANCE = Mappers.getMapper(ArticleDetailConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
//    @Mapping(target = "githubHomepage", expression = "java(bean.getGithubHomepage() != null ? bean.getGithubHomepage() : \"\")")
    FindArticleDetailRspVO convertDO2VO(ArticleDO bean);

}
