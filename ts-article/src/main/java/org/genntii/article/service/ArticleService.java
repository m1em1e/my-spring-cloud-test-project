package org.genntii.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.genntii.domain.entity.Article;
import org.genntii.domain.param.IdParam;
import org.genntii.domain.vo.ArticleVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/10 10:18
 */
public interface ArticleService extends IService<Article> {
    List<Article> selectListByUser(IdParam param);
}
