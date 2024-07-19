package org.twentygao.weblog.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.twentygao.weblog.admin.model.vo.category.AddCategoryReqVO;
import org.twentygao.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import org.twentygao.weblog.admin.model.vo.user.FindCategoryPageListReqVO;
import org.twentygao.weblog.admin.model.vo.user.FindCategoryPageListRspVO;
import org.twentygao.weblog.admin.service.AdminCategoryService;
import org.twentygao.weblog.common.domain.dos.ArticleCategoryRelDO;
import org.twentygao.weblog.common.domain.dos.CategoryDO;
import org.twentygao.weblog.common.domain.mapper.ArticleCategoryRelMapper;
import org.twentygao.weblog.common.domain.mapper.CategoryMapper;
import org.twentygao.weblog.common.enums.ResponseCodeEnum;
import org.twentygao.weblog.common.exceptation.BizException;
import org.twentygao.weblog.common.model.vo.SelectRspVO;
import org.twentygao.weblog.common.utils.PageResponse;
import org.twentygao.weblog.common.utils.Response;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Response addCategory(AddCategoryReqVO addCategoryReqVO) {
        String categoryName = addCategoryReqVO.getName();
        CategoryDO categoryDO = categoryMapper.sselectByName(categoryName);

        if(Objects.nonNull(categoryDO)){
            log.warn("分类名称：{}，此分类已存在",categoryName);
            throw new BizException(ResponseCodeEnum.CATEGORY_NAME_IS_EXISTED);

        }
        CategoryDO insertCategoryDo = CategoryDO.builder().name(addCategoryReqVO.getName().trim()).build();
    categoryMapper.insert(insertCategoryDo);
    return Response.success();

    }
    @Override
    public PageResponse findCategoryList(FindCategoryPageListReqVO findCategoryPageListReqVO) {
       Long current = findCategoryPageListReqVO.getCurrent();
       Long size = findCategoryPageListReqVO.getSize();
       String name = findCategoryPageListReqVO.getName();
       LocalDate startDate = findCategoryPageListReqVO.getStartDte();
       LocalDate endDate = findCategoryPageListReqVO.getEndDate();

       Page<CategoryDO> categoryDOPage = categoryMapper.selectPageList(current,size,name,startDate,endDate);
List<CategoryDO> categoryDOS = categoryDOPage.getRecords();
List<FindCategoryPageListRspVO> vos = null;
        if (!CollectionUtils.isEmpty(categoryDOS)) {
            vos = categoryDOS.stream()
                    .map(categoryDO -> FindCategoryPageListRspVO.builder()
                            .id(categoryDO.getId())
                            .name(categoryDO.getName())
                            .createTime(categoryDO.getCreateTime())
                            .build())
                    .collect(Collectors.toList());
        }
        return PageResponse.success(categoryDOPage,vos);
    }

    @Autowired
    ArticleCategoryRelMapper articleCategoryRelMapper;
    @Override
    public Response deleteCategory(DeleteCategoryReqVO deleteCategoryReqVO) {
        // 分类 ID
        Long categoryId = deleteCategoryReqVO.getId();
// 校验该分类下是否已经有文章，若有，则提示需要先删除分类下所有文章，才能删除

        ArticleCategoryRelDO articleCategoryRelDO = articleCategoryRelMapper.selectOneByCategoryId(categoryId);

        if (Objects.nonNull(articleCategoryRelDO)) {
            log.warn("==> 此分类下包含文章，无法删除，categoryId: {}", categoryId);
            throw new BizException(ResponseCodeEnum.CATEGORY_CAN_NOT_DELETE);
        }

        // 删除分类
        categoryMapper.deleteById(categoryId);

        return Response.success();
    }

    @Override
    public Response findCategorySelectList() {
        List<CategoryDO> categoryDOS = categoryMapper.selectList(null);

        List<SelectRspVO> selectRspVOS = null;
        if(!CollectionUtils.isEmpty(categoryDOS)){

            selectRspVOS = categoryDOS.stream()
                    .map(categoryDO -> SelectRspVO.builder()
                            .label(categoryDO.getName())
                            .value(categoryDO.getId())
                            .build())
                    .collect(Collectors.toList());
        }
        return Response.success(selectRspVOS);
    }
}
