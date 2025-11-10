package org.genntii.article.controller;

import org.genntii.article.service.ArticleService;
import org.genntii.domain.entity.Article;
import org.genntii.domain.param.IdParam;
import org.genntii.domain.vo.ArticleVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/10 10:19
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/getArticleByUser")
    public List<Article> getArticleByUser(@RequestParam IdParam param) {
        return articleService.selectListByUser(param);
    }

}
