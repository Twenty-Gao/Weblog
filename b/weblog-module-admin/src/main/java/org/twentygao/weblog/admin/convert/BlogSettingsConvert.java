package org.twentygao.weblog.admin.convert;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.twentygao.weblog.admin.model.vo.blogsettings.FindBlogSettingsRspVO;
import org.twentygao.weblog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import org.twentygao.weblog.common.domain.dos.BlogSettingsDO;

@Mapper
public interface BlogSettingsConvert {

    BlogSettingsConvert INSTANCE = Mappers.getMapper(BlogSettingsConvert.class);

    BlogSettingsDO convertVO2DO(UpdateBlogSettingsReqVO bean);

    @Mapping(target = "githubHomepage", expression = "java(bean.getGithubHomepage() != null ? bean.getGithubHomepage() : \"\")")
    FindBlogSettingsRspVO convertDO2VO(BlogSettingsDO bean);

}