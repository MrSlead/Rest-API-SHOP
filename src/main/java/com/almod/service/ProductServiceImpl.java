package com.almod.service;

import com.almod.entity.Product;
import com.almod.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    @Autowired
    public void setProductRepo(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @Override
    public Product getById(Long id) {

        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> findAllByProductName(String name) {
        return productRepo.findAllByProductName(name);
    }

    @Override
    public List<Product> findAllBySalary(Integer salary) {
        return productRepo.findAllBySalary(salary);
    }


    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

}
