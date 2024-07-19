package org.twentygao.weblog.web.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.twentygao.weblog.common.aspect.ApiOperationLog;
import org.twentygao.weblog.common.utils.Response;
import org.twentygao.weblog.web.model.vo.article.FindIndexArticlePageListReqVO;
import org.twentygao.weblog.web.service.ArticleService;
import org.twentygao.weblog.web.service.BlogSettingsService;

@RestController
@RequestMapping("/blog/settings")
@Api(tags = "博客设置")
public class BlogSettingsController {

    @Autowired
    private BlogSettingsService blogSettingsService;

    @PostMapping("/detail")
    @ApiOperation(value = "前台获取博客详情")
    @ApiOperationLog(description = "前台获取博客详情")
    public Response findDetail() {
        return blogSettingsService.findDetail();
    }

}