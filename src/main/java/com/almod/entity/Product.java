package com.almod.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "product_name")
    private String productName;

    private String description;
    private int salary;

    @OneToMany
    private Set<Article> articles;

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id; }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSalary() { return salary; }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articleSet) {
        this.articles = articleSet;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", product_name='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", articles=" + articles +
                '}';
    }
}
