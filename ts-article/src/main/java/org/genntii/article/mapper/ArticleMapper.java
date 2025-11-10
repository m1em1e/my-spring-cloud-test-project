package org.genntii.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.genntii.domain.entity.Article;

import java.util.List;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/10 10:17
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

    @Select("select * from article where user_id = #{userId}")
    List<Article> selectListByUser(@Param("userId") Long id);

}
