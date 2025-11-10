package org.genntii.article.client;

import org.genntii.domain.param.IdParam;
import org.genntii.domain.vo.ArticleVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/10 10:21
 */
@FeignClient("article-service")
public interface ArticleClient {

    public static final String baseUrl = "/article";

    @GetMapping(baseUrl+"/getArticleByUser")
    List<ArticleVO> getArticleByUser(@RequestParam IdParam id);

}
