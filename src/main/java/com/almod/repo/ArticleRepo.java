package com.almod.repo;

import com.almod.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * Repository interface for {@link Article}
 */
public interface ArticleRepo extends JpaRepository<Article, Long> {
    Set<Article> findAllByProductId(Long id);
    List<Article> findAllByProductProductName(String name);
    List<Article> findAllByArticleName(String name);

    @Query(value = "SELECT * FROM article ORDER BY article_name", nativeQuery = true)
    List<Article> findAllByArticleNameAsc();

    @Query(value = "SELECT * FROM article ORDER BY date", nativeQuery = true)
    List<Article> findAllByDateAsc();
}
