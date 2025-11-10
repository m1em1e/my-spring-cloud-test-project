package org.genntii.article.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.genntii.article.mapper.ArticleMapper;
import org.genntii.domain.entity.Article;
import org.genntii.domain.param.IdParam;
import org.genntii.domain.vo.ArticleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/10 10:18
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public List<Article> selectListByUser(IdParam param) {
        return baseMapper.selectListByUser(param.getId());
    }

}
