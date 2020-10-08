package com.almod.service;

import com.almod.entity.Article;
import com.almod.entity.Product;

import java.util.List;
import java.util.Set;

public interface ProductService {
    Product getById(Long id);

    List<Product> findAllByProductName(String name);

    List<Product> findAllBySalary(Integer salary);

    List<Product> findAll();

    void save(Product product);

    void deleteById(Long id);
}
