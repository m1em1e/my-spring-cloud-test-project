package org.genntii.domain.entity;

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
 * @since 2025/11/10 10:00
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Article extends BaseEntity {
    private String title;
    private Long userId;
    private String content;
}
