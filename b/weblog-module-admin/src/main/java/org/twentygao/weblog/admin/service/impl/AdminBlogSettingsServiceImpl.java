package org.twentygao.weblog.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.twentygao.weblog.admin.model.vo.blogsettings.FindBlogSettingsRspVO;
import org.twentygao.weblog.admin.model.vo.blogsettings.UpdateBlogSettingsReqVO;
import org.twentygao.weblog.admin.convert.BlogSettingsConvert;
import org.twentygao.weblog.admin.service.AdminBlogSettingsService;
import org.twentygao.weblog.common.domain.dos.BlogSettingsDO;
import org.twentygao.weblog.common.domain.mapper.BlogSettingsMapper;
import org.twentygao.weblog.common.utils.Response;

@Service
public class AdminBlogSettingsServiceImpl extends ServiceImpl<BlogSettingsMapper, BlogSettingsDO> implements AdminBlogSettingsService {


    @Autowired
    private BlogSettingsMapper blogSettingsMapper;
    @Override
    public Response updateBlogSettings(UpdateBlogSettingsReqVO updateBlogSettingsReqVO) {
        // VO 转 DO
        BlogSettingsDO blogSettingsDO = BlogSettingsConvert.INSTANCE.convertVO2DO(updateBlogSettingsReqVO);
        blogSettingsDO.setId(1L);

        // 保存或更新（当数据库中存在 ID 为 1 的记录时，则执行更新操作，否则执行插入操作）
        saveOrUpdate(blogSettingsDO);
        return Response.success();
    }


    @Override
    public Response findDetail() {
        // 查询 ID 为 1 的记录
        BlogSettingsDO blogSettingsDO = blogSettingsMapper.selectById(1L);
        System.out.println("blogSettingsDO"+blogSettingsDO);

        // DO 转 VO
        FindBlogSettingsRspVO vo = BlogSettingsConvert.INSTANCE.convertDO2VO(blogSettingsDO);
        System.out.println("vo"+vo);
        return Response.success(vo);
    }
}
