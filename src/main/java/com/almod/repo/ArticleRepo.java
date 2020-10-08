package com.almod.repo;

import com.almod.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

/**
 * Repository interface for {@link Article}
 */
public interface ArticleRepo extends JpaRepository<Article, Long> {
    Set<Article> findAllByProductId(Long id);
}
