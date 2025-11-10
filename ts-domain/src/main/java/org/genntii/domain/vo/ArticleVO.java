package org.genntii.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.genntii.domain.BaseEntity;

/**
 *
 *
 *
 * @author mkdir
 * @since 2025/11/10 10:25
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO extends BaseEntity {
    private Long userId;
    private String username;
    private String title;
    private String content;
}
