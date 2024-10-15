package com.my.articles.dto;

import com.my.articles.entity.Article;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.ObjectUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false, length = 1000)
    private String content;

    // Entity -> DTO
    public static ArticleDTO fromEntity(Article article) {
        return new ArticleDTO(
                article.getId(),
                article.getTitle(),
                article.getContent()
        );
    }

    // DTO -> Entity
    public static Article fromDTO(ArticleDTO dto) {
        Article article = new Article();
        article.setId(dto.getId());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        return article;
    }
}