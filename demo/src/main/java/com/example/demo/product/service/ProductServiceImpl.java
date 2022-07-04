package com.example.demo.product.service;

import com.example.demo.product.domain.model.entity.Product;
import com.example.demo.product.domain.persistence.ProductRepository;
import com.example.demo.product.domain.service.ProductService;
import com.example.demo.shared.exception.ResourceNotFoundException;
import com.example.demo.shared.exception.ResourceValidationException;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final static  String ENTITY = "Product";

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, productId));
    }

    @Override
    public Product create(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while creating the product");
        }
    }

    @Override
    public Product update(Long productId, Product request) {
        try {
            return productRepository.findById(productId)
                    .map(product ->
                            productRepository.save(
                                    product.withName(request.getName())
                                            .withStock(request.getStock())
                                            .withPrice(request.getPrice())
                            )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, productId));
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while updating the product");
        }
    }

    @Override
    public Product delete(Long productId) {
        return productRepository.findById(productId)
                .map(product -> {
                    productRepository.delete(product);
                    return product;
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, productId));
    }
}

