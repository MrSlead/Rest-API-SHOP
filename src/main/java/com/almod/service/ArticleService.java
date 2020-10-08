package com.almod.service;

import com.almod.entity.Article;
import java.util.List;
import java.util.Set;

public interface ArticleService {
    Article getById(Long id);

    List<Article> findAll();

    void save(Article product);

    void deleteById(Long id);

    Set<Article> findAllByProductId(Long id);
}
