package com.example.demo.product.domain.service;

import com.example.demo.product.domain.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(Long productId);
    //List<Product> getByCategoryId(Long categoryId);
    Product create(Product product);
    Product update(Long productId, Product product);
    Product delete(Long productId);
}
