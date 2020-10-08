package com.almod.repo;

import com.almod.entity.Article;
import com.almod.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * Repository interface for {@link Product}
 */
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAllByProductName(String name);
    List<Product> findAllBySalary(Integer salary);
}
