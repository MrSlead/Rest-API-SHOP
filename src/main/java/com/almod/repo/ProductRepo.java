package com.almod.repo;

import com.almod.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for {@link Product}
 */
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAllByProductName(String name);

    List<Product> findAllBySalary(Integer salary);

    @Query(value = "SELECT * FROM product ORDER BY product_name", nativeQuery = true)
    List<Product> findAllByProductNameAsc();

    @Query(value = "SELECT * FROM product ORDER BY salary", nativeQuery = true)
    List<Product> findAllBySalaryAsc();
}
