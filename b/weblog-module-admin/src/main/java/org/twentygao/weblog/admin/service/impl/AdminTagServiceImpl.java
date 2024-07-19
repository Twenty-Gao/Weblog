package org.twentygao.weblog.admin.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.twentygao.weblog.admin.model.vo.tag.*;
import org.twentygao.weblog.admin.service.AdminTagService;
import org.twentygao.weblog.common.domain.dos.ArticleTagRelDO;
import org.twentygao.weblog.common.domain.dos.TagDO;
import org.twentygao.weblog.common.domain.mapper.ArticleTagRelMapper;
import org.twentygao.weblog.common.domain.mapper.TagMapper;
import org.twentygao.weblog.common.enums.ResponseCodeEnum;
import org.twentygao.weblog.common.exceptation.BizException;
import org.twentygao.weblog.common.model.vo.SelectRspVO;
import org.twentygao.weblog.common.utils.PageResponse;
import org.twentygao.weblog.common.utils.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AdminTagServiceImpl extends ServiceImpl<TagMapper, TagDO> implements AdminTagService {

@Autowired
TagMapper tagMapper;
    @Override
    public Response addTag(AddTagReqVO addTagReqVO) {
        //vo转do
        List<TagDO> tagDOS = addTagReqVO.getTags().stream()
                .map(tagName -> TagDO.builder()
                        .name(tagName.trim())
                        .createTime(LocalDateTime.now())
                        .updateTime(LocalDateTime.now())
                        .build())
                .collect(Collectors.toList());
        //批量插入

        try{
            saveBatch(tagDOS);
        } catch (Exception e) {
           log.warn("该标签已存在",e);
        }
        return Response.success();
    }

    @Override
    public Response findTagList(FindTagPageListReqVO findTagPageListReqVO) {
        Long current = findTagPageListReqVO.getCurrent();
        Long size = findTagPageListReqVO.getSize();

        String name = findTagPageListReqVO.getName();
        LocalDate startDate = findTagPageListReqVO.getStartDte();
        LocalDate endDate = findTagPageListReqVO.getEndDate();


Page<TagDO> pages = tagMapper.selectPageList(current,size,name,startDate,endDate);
List<TagDO> records = pages.getRecords();
//do转vo

        List<FindTagPageListRspVO> vos = null;
        if(!CollectionUtils.isEmpty(records)){
            vos = records.stream().map(tagDO -> FindTagPageListRspVO.builder()
                    .id(tagDO.getId())
                    .name(tagDO.getName())
                    .createTime(tagDO.getCreateTime())
                    .build()).collect(Collectors.toList());


        }
        return PageResponse.success(pages,vos);

    }
    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;

    @Override
    public Response deleteTag(DeleteTagReqVO deleteTagReqVO) {
        Long tagId = deleteTagReqVO.getId();
        // 校验该标签下是否有关联的文章，若有，则不允许删除，提示用户需要先删除标签下的文章
        ArticleTagRelDO articleTagRelDO = articleTagRelMapper.selectOneByTagId(tagId);

        if (Objects.nonNull(articleTagRelDO)) {
            log.warn("==> 此标签下包含文章，无法删除，tagId: {}", tagId);
            throw new BizException(ResponseCodeEnum.TAG_CAN_NOT_DELETE);
        }

     int count =    tagMapper.deleteById(tagId);

        return count ==1?Response.success():Response.fail(ResponseCodeEnum.TAG_NOT_EXISTED);
    }

    @Override
    public Response searchTag(SearchTagReqVO searchTagReqVO) {
String key = searchTagReqVO.getKey();
      List<TagDO> tagDOS=  tagMapper.selectByKey(key);
//将do转成vo对象

        List<SelectRspVO> vos=null;
        if(!CollectionUtils.isEmpty(tagDOS)){
            vos = tagDOS.stream().map(tagDO -> SelectRspVO.builder()
                    .label(tagDO.getName())
                    .value(tagDO.getId())
                    .build()).collect(Collectors.toList());


        }
        return Response.success(vos);


    }

    @Override
    public Response findTagSelectList() {

        // 查询所有标签, Wrappers.emptyWrapper() 表示查询条件为空
        List<TagDO> tagDOS = tagMapper.selectList(Wrappers.emptyWrapper());

        // DO 转 VO
        List<SelectRspVO> vos = null;
        if (!CollectionUtils.isEmpty(tagDOS)) {
            vos = tagDOS.stream()
                    .map(tagDO -> SelectRspVO.builder()
                            .label(tagDO.getName())
                            .value(tagDO.getId())
                            .build())
                    .collect(Collectors.toList());
        }

        return Response.success(vos);
    }
}
