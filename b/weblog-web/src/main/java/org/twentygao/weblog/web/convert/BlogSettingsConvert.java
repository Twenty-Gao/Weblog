package org.twentygao.weblog.web.convert;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.twentygao.weblog.common.domain.dos.BlogSettingsDO;
import org.twentygao.weblog.web.model.vo.blogsettings.FindBlogSettingsDetailRspVO;

@Mapper
public interface BlogSettingsConvert {
    /**
     * 初始化 convert 实例
     */
    BlogSettingsConvert INSTANCE = Mappers.getMapper(BlogSettingsConvert.class);

    /**
     * 将 DO 转化为 VO
     * @param bean
     * @return
     */
    FindBlogSettingsDetailRspVO convertDO2VO(BlogSettingsDO bean);

}