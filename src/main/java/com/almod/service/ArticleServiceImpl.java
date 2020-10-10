package com.almod.service;

import com.almod.entity.Article;
import com.almod.repo.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepo articleRepo;

    @Autowired
    public void setArticleRepo(ArticleRepo articleRepo){
        this.articleRepo = articleRepo;
    }

    @Override
    public Article getById(Long id) {
        return articleRepo.findById(id).get();
    }

    @Override
    public List<Article> findAll() {
        return articleRepo.findAll();
    }

    @Override
    public List<Article> findAllByArticleNameAsc() {
        return articleRepo.findAllByArticleNameAsc();
    }

    @Override
    public List<Article> findAllByDateAsc() {
        return articleRepo.findAllByDateAsc();
    }

    @Override
    public List<Article> findAllByProductProductName(String name) {
        return articleRepo.findAllByProductProductName(name);
    }

    @Override
    public List<Article> findAllByArticleName(String name) {
        return articleRepo.findAllByArticleName(name);
    }

    @Override
    public void save(Article article) {
        articleRepo.save(article);
    }

    @Override
    public void deleteById(Long id) {
        articleRepo.deleteById(id);
    }

    @Override
    public Set<Article> findAllByProductId(Long id) {
        return articleRepo.findAllByProductId(id);
    }
}
