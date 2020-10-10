package com.almod.service;

import com.almod.entity.Article;

import java.util.List;
import java.util.Set;

public interface ArticleService {
    Article getById(Long id);

    List<Article> findAll();

    List<Article> findAllByArticleNameAsc();

    List<Article> findAllByDateAsc();

    List<Article> findAllByProductProductName(String name);
    List<Article> findAllByArticleName(String name);

    void save(Article product);

    void deleteById(Long id);

    Set<Article> findAllByProductId(Long id);
}
