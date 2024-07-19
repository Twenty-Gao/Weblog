package org.twentygao.weblog.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.twentygao.weblog.admin.model.vo.category.AddCategoryReqVO;
import org.twentygao.weblog.admin.model.vo.category.DeleteCategoryReqVO;
import org.twentygao.weblog.admin.model.vo.user.FindCategoryPageListReqVO;
import org.twentygao.weblog.admin.model.vo.user.FindCategoryPageListRspVO;
import org.twentygao.weblog.admin.service.AdminCategoryService;
import org.twentygao.weblog.common.aspect.ApiOperationLog;
import org.twentygao.weblog.common.utils.Response;

@RestController
@RequestMapping("/admin")
@Api(tags = "Admin 分类模块")
public class AdminCategoryController {

    @Autowired
    private AdminCategoryService categoryService;

    @PostMapping("/catagory/add")
    @ApiOperation(value="添加分类")
    @ApiOperationLog(description = "添加分类")
    public Response addCategory(@RequestBody @Validated AddCategoryReqVO addCategoryReqVO){
        return categoryService.addCategory(addCategoryReqVO);
    }
    @PostMapping("/catagory/list")
    @ApiOperation(value="分类分页数据获取")
    @ApiOperationLog(description = "分类分页数据获取")
    public Response findListCategory(@RequestBody @Validated FindCategoryPageListReqVO findCategoryPageListReqVO){
        return categoryService.findCategoryList(findCategoryPageListReqVO);
    }


    @PostMapping("/category/delete")
    @ApiOperation(value = "删除分类")
    @ApiOperationLog(description = "删除分类")
    public Response deleteCategory(@RequestBody @Validated DeleteCategoryReqVO deleteCategoryReqVO) {
        return categoryService.deleteCategory(deleteCategoryReqVO);
    }

    @PostMapping("/category/select/list")
    @ApiOperation(value = "分类 Select 下拉列表数据获取")
    @ApiOperationLog(description = "分类 Select 下拉列表数据获取")
    public Response findCategorySelectList() {
        return categoryService.findCategorySelectList();
    }


}

